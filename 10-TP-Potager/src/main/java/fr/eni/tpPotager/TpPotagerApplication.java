package fr.eni.tpPotager;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.eni.tpPotager.bll.MonPotagerException;
import fr.eni.tpPotager.bll.MonPotagerManager;
import fr.eni.tpPotager.bo.Carre;
import fr.eni.tpPotager.bo.Plante;
import fr.eni.tpPotager.bo.PlanteDansCarre;
import fr.eni.tpPotager.bo.Potager;

/*
Nous allons créer une application de gestion de potagers permettant à un jardinier de savoir où sont ses légumes et ce qu’il a à faire. 
Cette application va permettre de gérer :
	des potagers
	des carrés de potagers dédiés à la culture d’une ou plusieurs plantes
	des plantes sous trois catégories (racine, feuille, fruits)
	des actions à faire (ex : 20/01 : planter mes pommes de terre)

Données
	Potager :
		localisation (chaine de caractère)	
		nom	
		surface	
		ville
	Carré : 	
		dans quel potager il se trouve	
		surface	
		type de sol (argileux etc.)	
		type d’exposition (soleil, ombre, mi ombre)
	Plante :	
		nom	
		type (racine, feuille, fruit)		
		variété	
		surface occupée par un plan (en cm2)
	Une plante dans un carré :
		quantité (nb de plan)	
		date de mise en place	
		date de récolte prévue
	Action 	
		date	
		événement	
		lieu (quel potager ou quel carré ou “serre” ou “autre”)

Fonctionnalités (Écrans ou WS)
	OK : CRUD potagers 
	OK : CRUD carrés
	OK : CRUD plantes (ici on ne gère pas un stock mais des types de plantes)
	ajouter des plantes dans le potager
	Visualiser le potager (avoir une vue d’ensemble)
	Ajouter des actions
	Visualiser les actions des 2 prochaines semaines
	Visualiser la localisation d’une plante (nom ou nom et variété) dans les potagers (potager, carré, quantité etc.)
	supprimer un plan du potager
	Web Service donnant l’ensemble des données d’un potager
	Web Service donnant l’ensemble des événement sur la serre
	afficher une page montrant la météo des différents potagers.
	Web service présentant les carrés inoccupés

Contraintes
	OK : La somme des tailles des carrés doit être inférieur à celle du potager
	La surface occupée par les plans ne peut être supérieure à celle du carré.
	Pas de doublon de plantes (nom, variété)
	On ne peut entrer une action que si la date est supérieur à la date du jour
	Pas plus de 3 plantes (du même nom) dans un carré
*/


@SpringBootApplication
public class TpPotagerApplication implements CommandLineRunner {

	@Autowired
	MonPotagerManager potagerManager;
	
	public static void main(String[] args) {
		SpringApplication.run(TpPotagerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		// Création des potagers
		Potager potager1 = new Potager("Localisation du potager 1","Potager 1", 100.0f, "Gouézec");
		Potager potager2 = new Potager("Localisation potager 2","Potager de Phileas", 100.0f, "Gouesnach");
		potagerManager.addPotager(potager1);
		potagerManager.addPotager(potager2);
		potagerManager.affichagePotager().forEach(System.out::println);
		
		// Création des Carres
		Carre carre1 = new Carre(50.0f,"Argileux","Ensoleillé");
		Carre carre2 = new Carre(100f,"Calcaire","Ombragé");
		potagerManager.addCarre(carre1);
		potagerManager.addCarre(carre2);
		potagerManager.affichageCarre().forEach(System.out::println);
	
		// Tests conditions
		System.out.println("//////  Condition La somme des tailles des carrés doit être inférieur à celle du potager  ///");
		
		System.out.println("// Test avec un premier carré de 50 pour un potager de 100");
		//potager1.doDependency(carre1);
		try {
			potagerManager.addCarreInPotager(carre1, potager1);
		} catch (MonPotagerException e) {
			System.out.println("ERROR : " + e);
		}
		potagerManager.affichagePotager().forEach(System.out::println);			
		
		System.out.println("// Test ajout d'un 2ème carre de 100 pour un potager de 100 contenant déja un carré de 50");
		//potager1.doDependency(carre2);
		try {
			potagerManager.addCarreInPotager(carre2, potager1);
		} catch (MonPotagerException e) {
			System.out.println("ERROR : " + e);
		}
		potagerManager.affichagePotager().forEach(System.out::println);
		
		// Création des plantes
		Plante plante1 = new Plante("Radis","Racine","radis Ovale Jaune d'Or ",2.0f);
		Plante plante2 = new Plante("Carotte","Racine","nantaise ",4.0f);
		potagerManager.addPlante(plante1);
		potagerManager.addPlante(plante2);
		
		PlanteDansCarre planteDansCarre1 = new PlanteDansCarre(20,LocalDate.of(2022, 1, 1),LocalDate.of(2022, 8, 21));
		planteDansCarre1.setIdPlanteDansCarre(plante1.getIdPlante());
		potagerManager.affichagePlante().forEach(System.out::println);
		
		
		
		potagerManager.affichageCarre().forEach(System.out::println);
}
}

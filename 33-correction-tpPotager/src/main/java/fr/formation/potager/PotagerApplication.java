package fr.formation.potager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.potager.bll.CarreManager;
import fr.formation.potager.bll.PlantationManager;
import fr.formation.potager.bll.PlanteManager;
import fr.formation.potager.bll.PotagerManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.Potager;

@SpringBootApplication
public class PotagerApplication implements CommandLineRunner{
	@Autowired
	PotagerManager potagerManager;

	@Autowired
	CarreManager carreManager;

	@Autowired
	PlanteManager planteManager;
	
	@Autowired
	PlantationManager plantationManager;
	
	public static void main(String[] args) {
		SpringApplication.run(PotagerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Potager bibi = new Potager("Ici", "Bibi", "Laval", 2000);
		Carre c1 = new Carre("Argileux", "Soleil", 100);
		Carre c2 = new Carre("Sableux", "Soleil", 500);
		c1.setPotager(bibi);
		c2.setPotager(bibi);
		
		potagerManager.add(bibi);
		carreManager.add(c1);
		carreManager.add(c2);
		potagerManager.add(bibi);
		
		Plante carotte = new Plante("Orange", "carotte","racine" , 10);
		Plante radis = new Plante("Rouge", "radis","racine" , 10);
		Plante salade = new Plante("Scarole", "salade","feuille" , 10);

		planteManager.add(carotte);
		planteManager.add(radis);
		planteManager.add(salade);
		
		plantationManager.plante(salade, c2, 3, 5);
		plantationManager.plante(salade, c1, 3, 10);
		plantationManager.plante(radis, c2, 1, 20);
		plantationManager.plante(carotte, c1, 5, 20);
		
		plantationManager.planteOfPotager(bibi).forEach(System.out::println);
	}

}

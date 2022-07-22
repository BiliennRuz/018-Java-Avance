package fr.formation.vote;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.vote.bll.VoteException;
import fr.formation.vote.bll.VoteManager;
import fr.formation.vote.bo.Candidat;
import fr.formation.vote.bo.Passion;
import fr.formation.vote.bo.Votant;
import fr.formation.vote.dal.CandidatDAO;

@SpringBootApplication
public class VoteApplication implements CommandLineRunner{
	@Autowired
	VoteManager manager;
	
	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Candidat gauche = new Candidat("Georges Marchais","PC");
		Candidat droite = new Candidat("Jacques Chirac","RPR");
		Candidat centre = new Candidat("Francois Bayrou","UDF");
		Candidat extGauche = new Candidat("Arlette Laguillet","LO");
		
		
		Votant v = new Votant("Terrieur", "Alain", 25, "Français", gauche);
		manager.addVote(v);
		
		manager.getListVotant().forEach(System.out::println);
		
		// Contrainte de l'age
		Votant v2 = new Votant("Lejeune","Kévin",15,"Français",droite);
		try {
			manager.addVote(v2);
		} catch (VoteException e) {
			System.out.println("Erreur !!!! : "+e.getMessage());
		}
		manager.getListVotant().forEach(System.out::println);
		
		// Contrainte de la nationalité
		Votant v3 = new Votant("Potter","Harry",25,"Anglais",extGauche);
		try {
			manager.addVote(v3);
		} catch (VoteException e) {
			System.out.println("Erreur !!!! : "+e.getMessage());
		}
		manager.getListVotant().forEach(System.out::println);
		
		// Qui a voté pour Bob L'éponge
		List<Votant> lst = manager.getAllVotantOf("Georges Marchais");
		lst.forEach(System.out::println);
		
		// Pour qui a voté Alain Terrieur
		Candidat candidat = manager.getCandidatOf("Terrieur","Alain");
		System.out.println(candidat);
		
		// création des passions
		Passion passion1 = new Passion("brassage");
		Passion passion2 = new Passion("informatique");
		Passion passion3 = new Passion("photo");
		
		droite.getListPassion().add(passion1);
		droite.getListPassion().add(passion2);
		centre.getListPassion().add(passion2);
		gauche.getListPassion().add(passion1);
		gauche.getListPassion().add(passion3);
		
		System.out.println("// affichage du candidat avec leurs passions //");
		Candidat candidatPassion = manager.getCandidatOf("Terrieur","Alain");
		System.out.println(candidatPassion);
		
		// Test contraite 25 carateres sur le nom
		Candidat extDroite = new Candidat("La fille du borgne de Saint clout","FN");
		Votant v4 = new Votant("Suispasfiere", "Jean", 22, "Français", extDroite);
		manager.addVote(v4);
		
		manager.getListVotant().forEach(System.out::println);
		// 
	}

}

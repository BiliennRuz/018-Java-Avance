package fr.formation.vote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.vote.bll.VoteException;
import fr.formation.vote.bll.VoteManager;
import fr.formation.vote.bo.Candidat;
import fr.formation.vote.bo.Votant;

@SpringBootApplication
public class VoteApplication implements CommandLineRunner{
	@Autowired
	VoteManager manager;
	
	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}

	@Override
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
	}

}

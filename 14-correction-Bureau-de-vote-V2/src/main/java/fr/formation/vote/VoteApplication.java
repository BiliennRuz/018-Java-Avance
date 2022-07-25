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
import fr.formation.vote.dal.VotantDAO;

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
		Passion noel = new Passion("pere noel", "capacité à croire au père noel");
		Passion lesgens = new Passion("les gens","capacité à aimer les gens");
		Passion argent = new Passion("l'argent","aimer l'argent");
		
		
		Candidat gauche = new Candidat("Georges Marchais","PC");
		Candidat droite = new Candidat("Jacques Chirac","RPR");
		Candidat centre = new Candidat("Francois Bayrou","UDF");
		Candidat extGauche = new Candidat("Arlette Laguillet","LO");
		extGauche.getLstPassions().add(argent);
		gauche.getLstPassions().add(noel);
		droite.getLstPassions().add(noel);
		centre.getLstPassions().add(noel);
		extGauche.getLstPassions().add(noel);
		
		
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
		
		// les personnes qui ont voté pour un candidat qui aime l'argent
		// Contrainte de la nationalité
		Votant vArgent = new Votant("Potter","Harry",25,"Français",extGauche);
		manager.addVote(vArgent);
		manager.getVotantsWhoVoteForCandidatWhoLove("l'argent").forEach(System.out::println);;
	
		List<Passion> lstPassions = manager.getPassionsCandidatVotant(vArgent);
	}

}

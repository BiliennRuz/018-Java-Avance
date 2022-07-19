package fr.eni.quimper.exo.Bureau.de.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.quimper.exo.Bureau.de.vote.bll.Vote;
import fr.eni.quimper.exo.Bureau.de.vote.bll.VoteException;
import fr.eni.quimper.exo.Bureau.de.vote.bo.Electeur;
import fr.eni.quimper.exo.Bureau.de.vote.dal.ElecteurDAO;

@SpringBootApplication
public class ExoBureauDeVoteApplication implements CommandLineRunner{
	@Autowired
	private ElecteurDAO dao;
	@Autowired
	private Vote vote;
	
	public static void main(String[] args) {
		SpringApplication.run(ExoBureauDeVoteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception, VoteException {		
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("//  Saisir un votant (et gérer l’exception ne peut pas voter) //");
		// Test si Il est majeur
		System.out.println("Test si Il est mineur :");
		Electeur votant1 = new Electeur("RAGE", "Jean", 16, "IT", "bleu");
		try {
			vote.addElecteur(votant1);
			System.out.println(votant1);
		} catch (VoteException e) {
			System.out.println(e.getMessage());
		}
		// Test si Il est majeur
		System.out.println("Test si Il est majeur :");
		Electeur votant2 = new Electeur("AMPS", "Dominique", 44, "FR", "blanc");
		try {
			vote.addElecteur(votant2);
			System.out.println(votant2);
		} catch (VoteException e) {
			System.out.println(e.getMessage());
		}
		// Test si pas De nationalité française
		System.out.println("Test si pas De nationalité française :");
		Electeur votant3 = new Electeur("VEUX", "Jean", 18, "DE", "bleu");
		try {
			vote.addElecteur(votant3);
			System.out.println(votant3);
		} catch (VoteException e) {
			System.out.println(e.getMessage());
		}
		// Test si De nationalité française
		System.out.println("Test si De nationalité française :");
		Electeur votant4 = new Electeur("VEUX", "Jean", 18, "FR", "bleu");
		try {
			vote.addElecteur(votant4);
			System.out.println(votant4);
		} catch (VoteException e) {
			System.out.println(e.getMessage());
		}
		// Test si N’a pas déjà voté
		System.out.println("Test si N’a pas déjà voté :");
		Electeur votant5 = new Electeur("MERDE", "Jean", 77, "FR", "rouge");
		try {
			vote.addElecteur(votant5);
			System.out.println(votant5);
		} catch (VoteException e) {
			System.out.println(e.getMessage());
		}
		// Test si a déjà voté
		System.out.println("Test si a déjà voté :");
		Electeur votant6 = new Electeur("MERDE", "Jean", 77, "FR", "rouge");
		try {
			vote.addElecteur(votant6);
			System.out.println(votant6);
		} catch (VoteException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("///////////////////////////////////");
		System.out.println("// Afficher la liste des votants //");
		System.out.println("///////////// Afficher la liste des votants : /////////////");
		vote.afficherVotants().forEach(System.out::println);
		//dao.findAll().forEach(System.out::println);
		
		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("// Afficher le candidat pour lequel a voté un votant en fonction de son nom et son prénom //");
		String nomElecteur = "AMPS";
		String prenomElecteur = "Dominique";
		Electeur rechercheElecteur = vote.searchCandidatToElecteur(nomElecteur, prenomElecteur);
		//Electeur rechercheElecteur = dao.findByNomAndPrenom(nomElecteur, prenomElecteur);
		System.out.println("Le candidat choisi par " + nomElecteur + " " + prenomElecteur + " est :");
		System.out.println(rechercheElecteur.getCandidat());
		
		System.out.println("////////////////////////////////////////////////////////////////////");
		System.out.println("// Afficher les votants qui ont voté pour un candidat particulier //");
		String candidat = "rouge";
		vote.searchElecteurToCandidat(candidat).forEach(System.out::println);

		System.out.println("//////////////////////////////////////////////////");
		System.out.println("// Afficher le nombre de vote pour un candidat. //");
		//String candidat = "rouge";
		Integer count = 0;
		vote.nbVoteToCanditat(candidat);
		
	}
	
}

/*
Faire un logiciel de vote. Le logiciel va gérer des votants

Un votant ne peut voter que si :
 Il est majeur
 De nationalité française
 N’a pas déjà voté

Le votant n’est inséré en base de données que s’il peut voter, sinon un exception est retournée indiquant que le votant ne peut pas voter.
 X Saisir un votant (et gérer l’exception ne peut pas voter)
 X Afficher la liste des votants
 X Afficher le candidat pour lequel a voté un votant en fonction de son nom et son prénom
 X Afficher les votants qui ont voté pour un candidat particulier
 Afficher le nombre de vote pour un candidat.
 Qui a gagné l’élection ?
 */

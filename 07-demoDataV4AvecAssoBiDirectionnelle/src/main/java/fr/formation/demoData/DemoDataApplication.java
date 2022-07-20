package fr.formation.demoData;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.demoData.bo.Contact;
import fr.formation.demoData.bo.Entreprise;
import fr.formation.demoData.dal.ContactDAO;
import fr.formation.demoData.dal.EntrepriseDAO;

@SpringBootApplication
public class DemoDataApplication implements CommandLineRunner {
	@Autowired
	private ContactDAO contactDao;
	
	@Autowired
	private EntrepriseDAO entrepriseDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoDataApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Entreprise entreprise = new Entreprise("Next2", 5);
//		entrepriseDao.save(entreprise); // dans ce cas il faut le cascade
		entrepriseDao.save(entreprise);
		Contact jean = new Contact("Cérien", "Jean", "000244");
		entreprise.addContact(jean);
		contactDao.save(jean);
		
		Contact contact = contactDao.findByNomAndPrenom("Cérien", "Jean");
		System.out.println(contact.getEntreprise().getEffectif());
		
		
		Integer effectif = contactDao.effectifOfEntrepriseOf("Cérien", "Jean");
		System.out.println("Effectif :"+effectif);
		
		
//		System.out.println(jean);
//		jean.setNom("Airienafaire");
//		dao.save(jean);
//		
//		Contact monContact = dao.findById(5).orElse(null);
//		System.out.println("mon contact "+ monContact);
//		
//		Contact recherche = dao.findByNomAndPrenom("Airienafaire","Jean");
//		System.out.println(recherche.getTel());
//		
//		String tel = dao.getTelFromNomAndPrenom("Airienafaire","Jean");
//		System.out.println("le telephone est "+tel);
//		dao.findAll().forEach(System.out::println);
		
		
		
	}

}

package fr.formation.demoWS.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.demoWS.bo.Adresse;
import fr.formation.demoWS.bo.Contact;
import fr.formation.demoWS.bo.Entreprise;
import fr.formation.demoWS.bo.Personne;
import fr.formation.demoWS.dal.ContactDAO;
import fr.formation.demoWS.dal.EntrepriseDAO;

@RestController
public class EssaiWS {
	@Autowired
	ContactDAO contactDao;
	@Autowired
	EntrepriseDAO entrepriseDao;
	
	@GetMapping("/hello")
	public String disHello() {
		return "Hello";
	}

	@GetMapping("/hello/{lang}")
	public String disHello2(@PathVariable("lang") String lang) {
		if("FR".equals(lang)) {
			return "Bonjour";
		}
		else {
			return "Hello";
		}
	}
	
	@GetMapping("/hello/age/{age}")
	public String disHello3(@PathVariable("age") Integer age) {
		if(age<18) {
			return "Whesh mec !!";
		}
		else {
			return "Bonjour monsieur";
		}
	}
	
	@GetMapping("/quiesttu")
	public Personne quiEstTu() {
		return new Personne("Cérien", "Jean", 34);
	}

	
	@GetMapping("/lstcontacts")
	public List<Contact> getAll(){
		Entreprise entreprise = new Entreprise("Next2", 5);
//		entrepriseDao.save(entreprise); // dans ce cas il faut le cascade
		entrepriseDao.save(entreprise);
		Contact jean = new Contact("Cérien", "Jean", "000244");
		Adresse a1 = new Adresse("Rue du Rosier", "Laval", "53000");
		Adresse a2 = new Adresse("Rue du Roseau", "Quimper", "29000");
		jean.getLstAdresse().add(a1);
		jean.getLstAdresse().add(a2);
		
		entreprise.addContact(jean);
		contactDao.save(jean);
		return (List<Contact>) contactDao.findAll();
	}
	
}

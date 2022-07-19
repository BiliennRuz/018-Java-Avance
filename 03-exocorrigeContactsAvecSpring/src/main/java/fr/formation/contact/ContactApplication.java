package fr.formation.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.contact.bll.ContactManager;
import fr.formation.contact.bo.Contact;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner{
	@Autowired
	private ContactManager manager;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manager.addContact(new Contact("Cérien","Jean","212457"));
		manager.getAllContact().forEach(System.out::println);
		manager.deleteFromNom("Cérien");
		manager.getAllContact().forEach(System.out::println);
	}

}

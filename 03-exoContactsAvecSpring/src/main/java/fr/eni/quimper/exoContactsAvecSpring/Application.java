package fr.eni.quimper.exoContactsAvecSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.quimper.exoContactsAvecSpring.bll.ContactException;
import fr.eni.quimper.exoContactsAvecSpring.bll.ContactManager;
import fr.eni.quimper.exoContactsAvecSpring.bo.Contact;

@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private Contact contact;
	private ContactManager manager;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//System.out.println(calculatrice.calculate(3, 2, "+"));
		
		Contact jean = new Contact("Cérien","Jean","015574487");
		manager.addContact(jean);
		manager.addContact(new Contact("Tim","Vincent","05487777"));
		manager.getAllContact().forEach(System.out::println);
		
		try {
			manager.addContact(new Contact("Dupont","Jean","1145757"));
		} catch (ContactException e) {
			System.out.println(e.getMessage());
		}
		
		manager.delContact(jean);
		manager.getAllContact().forEach(System.out::println);
		manager.addContact(jean);
		jean.setNom("Airienafaire");
		manager.updateContact(jean);
		manager.getAllContact().forEach(System.out::println);
		
		jean.setNom("Dupont");
		try {
			manager.updateContact(jean);
		} catch (ContactException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}

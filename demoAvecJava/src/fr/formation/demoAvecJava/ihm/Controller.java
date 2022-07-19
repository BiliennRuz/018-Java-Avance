package fr.formation.demoAvecJava.ihm;

import fr.formation.demoAvecJava.bll.ContactException;
import fr.formation.demoAvecJava.bll.ContactManager;
import fr.formation.demoAvecJava.bll.ContactManagerSingl;
import fr.formation.demoAvecJava.bo.Contact;

public class Controller {
	private static ContactManager manager = ContactManagerSingl.getInstance();
	public static void main(String[] args) throws ContactException {
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

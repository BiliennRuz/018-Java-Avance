package fr.formation.demoAvecJava.bll;

public class ContactManagerSingl {

	private static ContactManager instance;
	
	public static ContactManager getInstance() {
		if(instance == null) {
			instance = new ContactManagerImpl();
		}
		return instance;
	}
}

package fr.formation.demoAvecJava.dal;

import java.util.ArrayList;
import java.util.List;

import fr.formation.demoAvecJava.bo.Contact;

class ContactDAOMock implements ContactDAO {
	private List<Contact> lst = new ArrayList<>();
	

	@Override
	public void insert(Contact contact) {
		lst.add(contact);
	}

	@Override
	public List<Contact> getAll() {
		return lst;
	}

	@Override
	public void delete(Contact contact) {
		lst.remove(contact);
	}

	@Override
	public void update(Contact contact) {
		// rien à faire
	}

}

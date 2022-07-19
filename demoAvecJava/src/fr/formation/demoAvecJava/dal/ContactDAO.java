package fr.formation.demoAvecJava.dal;

import java.util.List;

import fr.formation.demoAvecJava.bo.Contact;

public interface ContactDAO {
	public void insert(Contact contact);
	public List<Contact> getAll();
	public void delete(Contact contact);
	public void update(Contact contact);
}

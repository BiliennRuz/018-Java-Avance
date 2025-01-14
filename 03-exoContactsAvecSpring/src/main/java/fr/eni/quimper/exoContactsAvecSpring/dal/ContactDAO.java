package fr.eni.quimper.exoContactsAvecSpring.dal;

import java.util.List;

import fr.eni.quimper.exoContactsAvecSpring.bo.Contact;

public interface ContactDAO {
	public void insert(Contact contact);
	public List<Contact> getAll();
	public void delete(Contact contact);
	public void update(Contact contact);
}

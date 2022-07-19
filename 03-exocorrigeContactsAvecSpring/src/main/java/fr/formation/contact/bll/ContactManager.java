package fr.formation.contact.bll;

import java.util.List;

import fr.formation.contact.bo.Contact;

public interface ContactManager {
	public void addContact(Contact contact);
	public List<Contact> getAllContact();
	public void deleteFromNom(String nom);
}

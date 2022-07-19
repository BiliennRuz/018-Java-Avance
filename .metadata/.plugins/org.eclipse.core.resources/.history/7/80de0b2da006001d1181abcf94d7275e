package fr.formation.demoAvecJava.bll;

import java.util.List;

import fr.formation.demoAvecJava.bo.Contact;

/**
 * Gestionnaire de contacts
 * CRUD sur les contacts avec exclusion des personnes
 * qui s'appelle Dupont
 * @author emalabry
 *
 */
public interface ContactManager {
	/**
	 * ajouter un contact
	 * CT001 : Pas de contact avec un nom Dupont
	 * @param contact
	 * @throws ContactException 
	 */
	public void addContact(Contact contact) throws ContactException;
	
	/**
	 * Liste de l'ensemble des contacts
	 * @return
	 */
	public List<Contact> getAllContact();

	public void delContact(Contact contact);

	public void updateContact(Contact contact) throws ContactException;
}

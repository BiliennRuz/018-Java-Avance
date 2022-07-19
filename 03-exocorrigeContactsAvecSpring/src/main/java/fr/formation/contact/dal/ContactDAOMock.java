package fr.formation.contact.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.formation.contact.bo.Contact;

@Repository
public class ContactDAOMock implements ContactDAO {
	List<Contact> lstContact = new ArrayList<>();
		
	@Override
	public void insert(Contact contact) {
		lstContact.add(contact);
	}

	@Override
	public List<Contact> getAll() {
		return lstContact;
	}

	@Override
	public Contact findContactByNom(String nom) {
		Contact result = null;
		
		for (Contact contact : lstContact) {
			if(contact.getNom().equals(nom)) {
				result= contact;
			}
		}
		
		return result;
	}

	@Override
	public void delete(Contact c) {
		lstContact.remove(c);
	}

}

package fr.formation.contact.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.contact.bo.Contact;
import fr.formation.contact.dal.ContactDAO;

@Service
public class ContactManagerImpl implements ContactManager {
	@Autowired
	private ContactDAO dao;
	
	@Override
	public void addContact(Contact contact) {
		dao.insert(contact);
	}

	@Override
	public List<Contact> getAllContact() {
		return dao.getAll();
	}

	@Override
	public void deleteFromNom(String nom) {
		Contact c = dao.findContactByNom(nom);
		dao.delete(c);
	}

}

package fr.formation.demoAvecJava.bll;

import java.util.List;

import fr.formation.demoAvecJava.bo.Contact;
import fr.formation.demoAvecJava.dal.ContactDAO;
import fr.formation.demoAvecJava.dal.DAOFact;

class ContactManagerImpl implements ContactManager {
	private ContactDAO dao = DAOFact.getContactDAO();
	
	@Override
	public void addContact(Contact contact) throws ContactException {
		// CT001 : Pas de Dupont
		if("Dupont".equals(contact.getNom())) {
			throw new ContactException("Pas de Dupont !!");
		}
		
		dao.insert(contact);
	}

	@Override
	public List<Contact> getAllContact() {
		return dao.getAll();
	}

	@Override
	public void delContact(Contact contact) {
		dao.delete(contact);
	}

	@Override
	public void updateContact(Contact contact) throws ContactException {
		// CT001 : Pas de Dupont
		if("Dupont".equals(contact.getNom())) {
			throw new ContactException("Pas de Dupont !!");
		}
		dao.update(contact);
	}

}

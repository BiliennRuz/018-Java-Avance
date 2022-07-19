package fr.eni.quimper.exoContactsAvecSpring.bll;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.eni.quimper.exoContactsAvecSpring.bo.Contact;
import fr.eni.quimper.exoContactsAvecSpring.dal.ContactDAO;
import fr.eni.quimper.exoContactsAvecSpring.dal.DAOFact;


@Component
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

package fr.formation.demoData.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.demoData.bo.Contact;

public interface ContactDAO extends CrudRepository<Contact, Integer>{

}

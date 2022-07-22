package fr.formation.demoData.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.demoData.bo.Entreprise;

public interface EntrepriseDAO extends CrudRepository<Entreprise, Integer>{

}

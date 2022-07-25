package fr.formation.demoWS.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.demoWS.bo.Entreprise;

public interface EntrepriseDAO extends CrudRepository<Entreprise, Integer>{

}

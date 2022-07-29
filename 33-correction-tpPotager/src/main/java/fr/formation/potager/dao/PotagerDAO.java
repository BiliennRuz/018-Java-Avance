package fr.formation.potager.dao;

import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bo.Potager;

public interface PotagerDAO extends CrudRepository<Potager, Integer>{

}

package fr.formation.potager.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Potager;

public interface CarreDAO extends CrudRepository<Carre, Integer>{

	List<Carre> findByPotager(Potager potager);

}

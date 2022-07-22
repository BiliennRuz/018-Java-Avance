package fr.formation.potager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.potager.bo.Plantation;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.Potager;

public interface PlantationDAO extends CrudRepository<Plantation, Integer>{

	
	@Query("SELECT p.plante FROM Plantation p WHERE p.carre.potager= :potager")
	List<Plante> plantesOfPotager(@Param("potager") Potager bibi);

}

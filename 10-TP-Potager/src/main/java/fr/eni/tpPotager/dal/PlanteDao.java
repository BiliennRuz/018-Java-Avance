package fr.eni.tpPotager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.tpPotager.bo.Plante;

public interface PlanteDao extends CrudRepository<Plante, Integer>{

}

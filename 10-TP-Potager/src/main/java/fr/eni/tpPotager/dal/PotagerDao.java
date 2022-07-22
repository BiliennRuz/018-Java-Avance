package fr.eni.tpPotager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.tpPotager.bo.Potager;

public interface PotagerDao extends CrudRepository<Potager, Integer>{

}

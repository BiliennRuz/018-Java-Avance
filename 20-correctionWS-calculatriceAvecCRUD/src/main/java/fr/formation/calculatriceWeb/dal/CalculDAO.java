package fr.formation.calculatriceWeb.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.calculatriceWeb.bo.Calcul;

public interface CalculDAO extends CrudRepository<Calcul, Integer>{

}

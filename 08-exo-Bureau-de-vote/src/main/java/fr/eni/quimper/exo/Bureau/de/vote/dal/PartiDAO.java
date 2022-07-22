package fr.eni.quimper.exo.Bureau.de.vote.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.quimper.exo.Bureau.de.vote.bo.Parti;

public interface PartiDAO extends CrudRepository<Parti, Integer> {

}

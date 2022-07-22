package fr.eni.quimper.exo.Bureau.de.vote.dal;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import fr.eni.quimper.exo.Bureau.de.vote.bo.Candidat;

public interface CandidatDAO extends CrudRepository<Candidat, Integer> {

}

package fr.eni.quimper.exo.Bureau.de.vote.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.quimper.exo.Bureau.de.vote.bo.Candidat;
import fr.eni.quimper.exo.Bureau.de.vote.bo.Electeur;

public interface ElecteurDAO  extends CrudRepository<Electeur, Integer>{

	Electeur findByNomAndPrenom(String nom, String prenom);

	Iterable<Electeur> findByCandidat(Candidat candidat);


}

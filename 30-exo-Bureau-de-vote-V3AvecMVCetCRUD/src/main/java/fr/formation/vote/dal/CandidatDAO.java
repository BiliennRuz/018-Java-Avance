package fr.formation.vote.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.vote.bo.Candidat;

public interface CandidatDAO extends CrudRepository<Candidat, Integer>{

	@Query("SELECT v.candidat FROM Votant v WHERE v.nom= :nom AND v.prenom= :prenom")
	Candidat findByNomAndPrenom(@Param("nom") String nom,@Param("prenom") String prenom);

}

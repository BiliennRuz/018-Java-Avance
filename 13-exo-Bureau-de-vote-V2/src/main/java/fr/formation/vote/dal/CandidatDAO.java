package fr.formation.vote.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.vote.bo.Candidat;

public interface CandidatDAO extends CrudRepository<Candidat, Integer>{

	@Query("SELECT v.candidat FROM Votant v WHERE v.nom= :nom AND v.prenom= :prenom")
	Candidat findByNomAndPrenom(@Param("nom") String nom,@Param("prenom") String prenom);

	@Query("SELECT p.nom FROM Candidat c JOIN c.listPassion p WHERE c= :candidat")
	List<String> findPassionOfCandidat(@Param("candidat") Candidat candidat);
}

package fr.formation.vote.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.vote.bo.Votant;

public interface VotantDAO extends CrudRepository<Votant, Integer> {

	@Query("FROM Votant v WHERE v.candidat.nom= :candidat")
	List<Votant> findByCandidat(@Param("candidat") String candidat);

}

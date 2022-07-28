package fr.formation.vote.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.vote.bo.Passion;
import fr.formation.vote.bo.Votant;

public interface VotantDAO extends CrudRepository<Votant, Integer> {

	@Query("FROM Votant v WHERE v.candidat.nom= :candidat")
	List<Votant> findByCandidat(@Param("candidat") String candidat);

	@Query("SELECT c.lstVotants FROM Candidat c JOIN c.lstPassions p WHERE p.nom= :nom")
	List<Votant> findByCandidatWhoLove(@Param("nom") String nomPassion);

//	@Query("""
//			SELECT p FROM Candidat c 
//			JOIN c.lstPassions p 
//			JOIN c.lstVotants v WHERE v = :votant 
//			""")
	@Query("SELECT p FROM Candidat c "
			+ "JOIN c.lstPassions p "
			+ "JOIN c.lstVotants v "
			+ "WHERE v = :votant")
	List<Passion> findPassionsCandidatVotant(@Param("votant") Votant votant);

}

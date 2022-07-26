package fr.eni.quimper.exoparking.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.quimper.exoparking.bo.Parking;
import fr.eni.quimper.exoparking.bo.Voiture;

public interface VoitureDAO extends CrudRepository<Voiture, Integer>{

	@Query("FROM Voiture v WHERE v.parking = :parking")
	List<String> findVoitureOfParking(@Param("parking") Parking parking);
	
}

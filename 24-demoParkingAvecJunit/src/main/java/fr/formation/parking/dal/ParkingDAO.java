package fr.formation.parking.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.parking.bo.Parking;

public interface ParkingDAO extends CrudRepository<Parking, Integer>{

	@Query("SELECT count(v) FROM Voiture v WHERE v.parking= :parking")
	Integer countVoitureInParking(@Param("parking") Parking parking);

}

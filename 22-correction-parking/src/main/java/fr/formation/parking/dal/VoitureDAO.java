package fr.formation.parking.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.parking.bo.Parking;
import fr.formation.parking.bo.Voiture;

public interface VoitureDAO extends CrudRepository<Voiture, Integer>{

	List<Voiture> findByParking(Parking parking);

	@Query("SELECT v.parking FROM Voiture v WHERE v= :voiture")
	Parking findVoiture(@Param("voiture") Voiture voiture);

}

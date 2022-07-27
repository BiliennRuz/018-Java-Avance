package fr.formation.parking.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.parking.bo.Parking;
import fr.formation.parking.bo.Voiture;
import fr.formation.parking.dal.ParkingDAO;
import fr.formation.parking.dal.VoitureDAO;

@Service
public class ParkingManagerImpl implements ParkingManager {
	@Autowired
	VoitureDAO voitureDAO;

	@Autowired
	ParkingDAO parkingDAO;


	@Override
	@Transactional
	public void entre(Voiture voiture, Parking parking) throws ParkingException {
		// ici on est obligé de sauver le parking avant le test
		// en effet la requête du test nécessite d'avoir un parking sauvegarder
		parkingDAO.save(parking); 
		if(parkingDAO.countVoitureInParking(parking)>=parking.getCapacite()) {
			throw new ParkingException("parking plein!");
		}
		parking.addVoiture(voiture);
		
		voitureDAO.save(voiture);
	}

	@Override
	@Transactional
	public void sort(Voiture voiture) {
		voiture.setParking(null);
		voitureDAO.save(voiture);
	}

	@Override
	public List<Voiture> getVoitureDansParking(Parking parking) {
		return voitureDAO.findByParking(parking);
	}

	@Override
	public Parking maisOuEstMaVoiture(Voiture voiture) {
		return voitureDAO.findVoiture(voiture);
	}

	@Override
	@Transactional
	public Parking addParking(Parking parking) {
		return parkingDAO.save(parking);
	}

	@Override
	public Voiture addVoiture(Voiture voiture) {
		return voitureDAO.save(voiture);
	}

	@Override
	public Voiture getVoitureById(Integer idVoiture) {
		return voitureDAO.findById(idVoiture).orElse(null);
	}

	@Override
	public Parking getParkingById(Integer idParking) {
		return parkingDAO.findById(idParking).orElse(null);
	}

}

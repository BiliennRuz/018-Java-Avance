package fr.eni.quimper.exoparking.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.quimper.exoparking.bo.Parking;
import fr.eni.quimper.exoparking.bo.Voiture;
import fr.eni.quimper.exoparking.dal.ParkingDAO;
import fr.eni.quimper.exoparking.dal.VoitureDAO;

@Service
public class ParkingManagerImpl implements ParkingManager {

	@Autowired
	VoitureDAO voitureDao;
	
	@Autowired
	ParkingDAO parkingDao;
	
	
	@Override
	public void addVoiture(Voiture voiture) {
		voitureDao.save(voiture);		
	}

	@Override
	public List<Voiture> displayVoiture() {
		return (List<Voiture>) voitureDao.findAll();
	}

	@Override
	public void updateVoiture(Voiture voiture) {
		voitureDao.save(voiture);		
	}
	
	@Override
	public void deleteVoiture(Voiture voiture) {
		voitureDao.delete(voiture);
	}
	
	@Override
	public void deleteVoitureById(Integer id) {
		voitureDao.deleteById(id);
	}
	
	@Override
	public Voiture getVoitureById(Integer id) {
		return voitureDao.findById(id).orElse(null);
	}
	
	
	
	@Override
	public void addParking(Parking parking) {
		parkingDao.save(parking);
	}

	@Override
	public List<Parking> displayParking() {
		return (List<Parking>) parkingDao.findAll();
	}

	@Override
	public void updateParking(Parking parking) {
		parkingDao.save(parking);
	}

	@Override
	public void deleteParking(Parking parking) {
		parkingDao.delete(parking);
	}

	@Override
	public Parking getParkingById(Integer id) {
		return parkingDao.findById(id).orElse(null);
	}

	@Override
	public void deleteParkingById(Integer id) {
		parkingDao.deleteById(id);
	}

	@Override
	public void entreVoitureToParking(Integer idVoiture, Integer idParking) {
		Voiture voiture = getVoitureById(idVoiture);
		Parking parking = getParkingById(idParking);
		voiture.setParking(parking);		
	}


}

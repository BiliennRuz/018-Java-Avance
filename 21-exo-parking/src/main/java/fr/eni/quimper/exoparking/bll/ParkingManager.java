package fr.eni.quimper.exoparking.bll;

import java.util.List;

import fr.eni.quimper.exoparking.bo.Parking;
import fr.eni.quimper.exoparking.bo.Voiture;

public interface ParkingManager {
	public void addVoiture(Voiture voiture);
	public List<Voiture> displayVoiture();
	public void updateVoiture(Voiture voiture);
	public void deleteVoiture(Voiture voiture);
	public void deleteVoitureById(Integer id);
	public Voiture getVoitureById(Integer id);

	public void addParking(Parking park1);
	public List<Parking> displayParking();
	public void updateParking(Parking parking);
	public void deleteParking(Parking parking);
	public Parking getParkingById(Integer id);
	public void deleteParkingById(Integer id);
	public void entreVoitureToParking(Integer idVoiture, Integer idParking);

}

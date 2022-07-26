package fr.formation.parking.bll;

import java.util.List;

import fr.formation.parking.bo.Parking;
import fr.formation.parking.bo.Voiture;

public interface ParkingManager {
	/**
	 * CT001 : une voiture peut entrer uniquement s'il y a de la place
	 * @param voiture
	 * @param parking
	 * @throws ParkingException car plein
	 */
	public void entre(Voiture voiture, Parking parking) throws ParkingException;
	public void sort(Voiture voiture);
	public List<Voiture> getVoitureDansParking(Parking parking);
	public Parking maisOuEstMaVoiture(Voiture voiture);
	public Parking addParking(Parking parking);
	public Voiture addVoiture(Voiture voiture);
	public Voiture getVoitureById(Integer idVoiture);
	public Parking getParkingById(Integer idParking);
}

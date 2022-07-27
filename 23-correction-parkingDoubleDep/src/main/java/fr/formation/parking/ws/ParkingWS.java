package fr.formation.parking.ws;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.parking.bll.ParkingException;
import fr.formation.parking.bll.ParkingManager;
import fr.formation.parking.bo.Parking;
import fr.formation.parking.bo.Voiture;

@RestController
public class ParkingWS {
	@Autowired
	ParkingManager manager;

	@PostMapping("/parking")
	public Parking addParking(@RequestBody Parking parking) {
		return manager.addParking(parking);
	}
	
	@PostMapping("/voiture")
	public Voiture addVoiture(@RequestBody Voiture voiture) {
		return manager.addVoiture(voiture);
	}
	
	@GetMapping("/entre/{idVoiture}/{idParking}")
	public ResponseEntity<String> entre(@PathVariable("idVoiture") Integer idVoiture, 
			@PathVariable("idParking") Integer idParking) {
		try {
			manager.entre(manager.getVoitureById(idVoiture), manager.getParkingById(idParking));
			return new ResponseEntity<String>("Le véhicule est entré",HttpStatus.OK);
		} catch (ParkingException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	@GetMapping("/sort/{idVoiture}")
	public void sort(@PathVariable("idVoiture") Integer idVoiture) {
		manager.sort(manager.getVoitureById(idVoiture));
	}
	
	@GetMapping("/voiture/{idParking}")
	public List<Voiture> getVoitureDansParking(@PathVariable("idParking") Integer idParking){
		return manager.getVoitureDansParking(manager.getParkingById(idParking));
	}
	
	@GetMapping("/ou/{idVoiture}")
	public Parking maisOuEstMaVoiture(@PathVariable("idVoiture") Integer idVoiture) {
		return manager.maisOuEstMaVoiture(manager.getVoitureById(idVoiture));
	}
}
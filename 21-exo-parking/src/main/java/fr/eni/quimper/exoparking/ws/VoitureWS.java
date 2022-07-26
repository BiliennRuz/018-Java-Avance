package fr.eni.quimper.exoparking.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.quimper.exoparking.bll.ParkingManager;
import fr.eni.quimper.exoparking.bo.Voiture;

@RestController
@RequestMapping("/voiture")
public class VoitureWS {

	@Autowired
	ParkingManager parkingManager;
	
	@GetMapping("/")
	public List<Voiture> displayVoiture() {
		return parkingManager.displayVoiture();		
	}
	
	@GetMapping("/{id}")
	public Voiture getById(@PathVariable("id") Integer id){
		return parkingManager.getVoitureById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id){
		parkingManager.deleteVoitureById(id);
	}
	
	@PostMapping("")
	public void addVoiture(@RequestBody Voiture voiture) {
		parkingManager.addVoiture(voiture);
	}
	
	@PutMapping("")
	public void modifyVoiture(@RequestBody Voiture voiture) {
		parkingManager.updateVoiture(voiture);
	}
	
	@PutMapping("/entre/{idVoiture}/{idParking}")
	public void entreVoiture(
			@PathVariable("idVoiture") Integer idVoiture,
			@PathVariable("idParking") Integer idParking) {
		parkingManager.entreVoitureToParking(idVoiture, idParking );
	}
		
}

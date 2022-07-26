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
import fr.eni.quimper.exoparking.bo.Parking;

@RestController
@RequestMapping("/parking")
public class ParkingWS {

	@Autowired
	ParkingManager parkingManager;
	
	@GetMapping("/")
	public List<Parking> displayParking() {
		return parkingManager.displayParking();		
	}
	
	@GetMapping("/{id}")
	public Parking getById(@PathVariable("id") Integer id){
		return parkingManager.getParkingById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id){
		parkingManager.deleteParkingById(id);
	}
	
	@PostMapping("")
	public void addParking(@RequestBody Parking parking) {
		parkingManager.addParking(parking);
	}
	
	@PutMapping("")
	public void updateParking(@RequestBody Parking parking) {
		parkingManager.updateParking(parking);
	}
		
}

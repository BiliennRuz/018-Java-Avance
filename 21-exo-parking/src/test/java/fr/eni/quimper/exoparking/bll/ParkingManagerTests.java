package fr.eni.quimper.exoparking.bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.quimper.exoparking.bo.Parking;
import fr.eni.quimper.exoparking.bo.Voiture;
import fr.eni.quimper.exoparking.dal.ParkingDAO;
import fr.eni.quimper.exoparking.dal.VoitureDAO;

@SpringBootTest
class ParkingManagerTests {

	@Autowired
	ParkingManager parkingManager;
	
	@Autowired
	VoitureDAO voitudeDAO;
	
	@Autowired
	ParkingDAO parkingDAO;
	
		Parking park1 = new Parking("Quimper Test",80);
		Voiture voit1 = new Voiture("Renault", "Bleuedd", "sd123fd");	
		
	
	@Test
	//@Transactional
	void addVoitureTest() {
		//Voiture voit1 = new Voiture("Renault", "Bleue", "sd123fd");
		parkingManager.addVoiture(voit1);
		Optional<Voiture> voit1Result = voitudeDAO.findById(voit1.getIdVoiture());
		assertNotNull(voit1Result);
	}
	
	@Test
	//@Transactional
	public void entreVoitureToParkingTest() {
		//Parking park1 = new Parking("Quimper Chapeau rouge",80);
		parkingDAO.save(park1);
		//Voiture voit1 = new Voiture("Renault", "Bleue", "sd123fd");
		voitudeDAO.save(voit1);
		Voiture voiture = voitudeDAO.findById(voit1.getIdVoiture()).orElse(null);
		Parking parking = parkingDAO.findById(park1.getIdParking()).orElse(null);
		voiture.setParking(parking);
		
		System.out.println("test: " + voiture.getParking());
		System.out.println("test: " + park1);
		assertEquals(park1.getIdParking(), voiture.getParking().getIdParking());
	}
	
	

}

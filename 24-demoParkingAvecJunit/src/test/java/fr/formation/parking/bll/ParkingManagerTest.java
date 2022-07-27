package fr.formation.parking.bll;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.formation.parking.bo.Parking;
import fr.formation.parking.bo.Voiture;
import fr.formation.parking.dal.VoitureDAO;

@SpringBootTest
class ParkingManagerTest {
	@Autowired
	ParkingManager manager;
	
	@Autowired
	VoitureDAO voitureDAO;
	
	@Test
	void entreTest() throws ParkingException {
		Voiture titine = new Voiture("titine", "niro", "kia");
		Parking parking = new Parking("Toto",10);
		manager.entre(titine, parking);
		Parking p = voitureDAO.findVoiture(titine);
		assertNotNull(p);
//		assertEquals(p.getNom(), parking.getNom());
	}
	
	@Test
	void entreCT001Test() {
		Voiture titine = new Voiture("titine", "niro", "kia");
		Parking parking = new Parking("Toto",0);
		assertThrows(ParkingException.class, ()-> {
			manager.entre(titine, parking);
		});
		
		
	}

}

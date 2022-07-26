package fr.eni.quimper.exoparking;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.quimper.exoparking.bll.ParkingManager;
import fr.eni.quimper.exoparking.bo.Parking;
import fr.eni.quimper.exoparking.bo.Voiture;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	ParkingManager parkingManager;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Parking park1 = new Parking("Quimper Chapeau rouge",80);
		parkingManager.addParking(park1);
		Voiture voit1 = new Voiture("Renault", "Bleue", "sd123fd");
		Voiture voit2 = new Voiture("Tesla", "Blanche", "fghg456qs");
		Voiture voit3 = new Voiture("Tata", "rouge", "pm789aq");
		
		voit1.setParking(park1);
		parkingManager.addVoiture(voit1);
		voit2.setParking(park1);
		parkingManager.addVoiture(voit2);		
		voit3.setParking(park1);
		parkingManager.addVoiture(voit3);	
		
		parkingManager.displayParking().forEach(System.out::println);
		parkingManager.displayVoiture().forEach(System.out::println);
		
	}

}

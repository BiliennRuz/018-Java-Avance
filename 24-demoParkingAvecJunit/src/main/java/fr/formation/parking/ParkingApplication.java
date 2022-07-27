package fr.formation.parking;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.parking.bll.ParkingException;
import fr.formation.parking.bll.ParkingManager;
import fr.formation.parking.bo.Parking;
import fr.formation.parking.bo.Voiture;

@SpringBootApplication
public class ParkingApplication implements CommandLineRunner{
	@Autowired
	ParkingManager manager;
	
	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Parking eni = new Parking("parking de l'ENI",10);
		Parking chezMoi = new Parking("chez moi",2);
		Voiture titine = new Voiture("titine","Niro","Kia");
		Voiture vroum = new Voiture("vroum","Testarosa","Ferrari");
		Voiture deudeuch = new Voiture("deudeuch","2ch","Citroen");
		
		manager.entre(deudeuch, chezMoi);
		manager.entre(vroum, chezMoi);
		manager.entre(titine, eni);
		
		System.out.println("les voitures qui sont chez moi");
		manager.getVoitureDansParking(chezMoi).forEach(System.out::println);;
		
		System.out.println("ma deudeuch est ici ");
		System.out.println(manager.maisOuEstMaVoiture(deudeuch));
		
		System.out.println("je sors ma deudeuch");
		manager.sort(deudeuch);
		
		System.out.println("les voitures qui sont chez moi");
		manager.getVoitureDansParking(chezMoi).forEach(System.out::println);;
		
		System.out.println("ma deudeuch est ici ");
		System.out.println(manager.maisOuEstMaVoiture(deudeuch));
		
		
		Voiture didi = new Voiture("didi","Diane","Citroen");
		manager.entre(deudeuch, chezMoi);
		try {
			manager.entre(didi, chezMoi);
		} catch (ParkingException e) {
			System.out.println(e.getMessage());
		}
	}

}

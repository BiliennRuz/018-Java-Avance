package fr.formation.potager;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plantation;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.Potager;
import fr.formation.potager.dao.CarreDAO;
import fr.formation.potager.dao.PlantationDAO;
import fr.formation.potager.dao.PlanteDAO;
import fr.formation.potager.dao.PotagerDAO;

@SpringBootApplication
public class PotagerApplication implements CommandLineRunner{
	@Autowired
	private PlanteDAO planteDAO;
	@Autowired
	private CarreDAO carreDAO;
	@Autowired
	private PlantationDAO plantationDAO;
	@Autowired
	private PotagerDAO potagerDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(PotagerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Potager bibi = new Potager("Ici", "Bibi", "Laval", 2000);
		Carre c1 = new Carre("Argileux", "Soleil", 100);
		Carre c2 = new Carre("Sableux", "Soleil", 500);
		c1.setPotager(bibi);
		c2.setPotager(bibi);
		
		potagerDAO.save(bibi);
		carreDAO.save(c1);
		carreDAO.save(c2);
		
		Plante carotte = new Plante("Orange", "carotte","racine" , 10);
		Plante radis = new Plante("Rouge", "radis","racine" , 10);
		Plante salade = new Plante("Scarole", "salade","feuille" , 10);
		
		planteDAO.save(carotte);
		planteDAO.save(radis);
		planteDAO.save(salade);
		
		Plantation p1 = new Plantation(salade, c2, LocalDate.now(), LocalDate.now().plusMonths(3), 2);
		Plantation p2 = new Plantation(salade, c1, LocalDate.now(), LocalDate.now().plusMonths(3), 2);
		Plantation p3 = new Plantation(radis, c1, LocalDate.now(), LocalDate.now().plusMonths(3), 2);
		plantationDAO.save(p1);
		plantationDAO.save(p2);
		plantationDAO.save(p3);
		
		plantationDAO.findAll().forEach(System.out::println);
		
		// plante plantées dans la potager bibi
		List<Plante> lst = plantationDAO.plantesOfPotager(bibi);
		lst.forEach(System.out::println);
	}

}

package fr.formation.calculatriceWeb;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.calculatriceWeb.bll.Calculatrice;

@SpringBootApplication
public class CalculatriceWebApplication implements CommandLineRunner{
	@Autowired
	Calculatrice calculatrice;
	
	public static void main(String[] args) {
		SpringApplication.run(CalculatriceWebApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		calculatrice.calculate(3, 1, "plus");
		calculatrice.calculate(3, 2, "moins");
		calculatrice.calculate(3, 1, "div");
		
		calculatrice.getAll().forEach(System.out::println);
	}

}

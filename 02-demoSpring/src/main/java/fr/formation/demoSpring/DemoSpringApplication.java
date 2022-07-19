package fr.formation.demoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.demoSpring.bll.Calculatrice;

@SpringBootApplication
public class DemoSpringApplication implements CommandLineRunner{
	@Autowired
//	@Qualifier("avril")
	private Calculatrice calculatrice;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(calculatrice.calculate(3, 2, "+"));
	}

}

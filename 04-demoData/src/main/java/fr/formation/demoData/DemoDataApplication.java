package fr.formation.demoData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.demoData.bo.Contact;
import fr.formation.demoData.dal.ContactDAO;

@SpringBootApplication
public class DemoDataApplication implements CommandLineRunner {
	@Autowired
	private ContactDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DemoDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Contact jean = new Contact("Cérien", "Jean", "000244");
		dao.save(jean);
		System.out.println(jean);
		
		dao.findAll().forEach(System.out::println);
		
	}

}

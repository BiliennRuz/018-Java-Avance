package fr.formation.calculatriceWeb.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.calculatriceWeb.bll.Calculatrice;
import fr.formation.calculatriceWeb.bo.Calcul;

@RestController
public class CalculatriceWS {
	@Autowired
	Calculatrice calculatrice;
	
	@GetMapping("/calculate/{a}/{op}/{b}")
	public Integer calculate(@PathVariable("a") Integer a,
			@PathVariable("b") Integer b,
			@PathVariable("op") String op) {
		return calculatrice.calculate(a, b, op);
	}
	
	@GetMapping("/list")
	public List<Calcul> getAll(){
		return calculatrice.getAll();
	}
}

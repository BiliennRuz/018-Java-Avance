package fr.formation.calculatriceWeb.ws;

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

import fr.formation.calculatriceWeb.bll.Calculatrice;
import fr.formation.calculatriceWeb.bo.Calcul;

@RestController
@RequestMapping("/calcul")
public class CalculCrudWS {
	@Autowired
	Calculatrice calculatrice;
	
	@GetMapping("")
	public List<Calcul> getAll(){
		return calculatrice.getAll();
	}
	
	@GetMapping("/{id}")
	public Calcul getById(@PathVariable("id") Integer id){
		return calculatrice.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id){
		calculatrice.deleteById(id);
	}
	
	@PostMapping("")
	public void addCalcul(@RequestBody Calcul calcul) {
		calculatrice.addCalcul(calcul);
	}
	
	@PutMapping("")
	public void modifyCalcul(@RequestBody Calcul calcul) {
		calculatrice.modifyCalcul(calcul);
	}
}

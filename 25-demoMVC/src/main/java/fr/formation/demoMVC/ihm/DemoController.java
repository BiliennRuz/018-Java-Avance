package fr.formation.demoMVC.ihm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.demoMVC.bo.Personne;

@Controller
@RequestMapping("/IHM")
public class DemoController {

	@GetMapping("/hello")
	public String affiche(Model model) {
		model.addAttribute("message","coucou");
		model.addAttribute("personne",new Personne("Cérien","jean"));
		return "hello";
	}
	
	@GetMapping("/list")
	public String liste(Model model) {
		List<Personne> lst = new ArrayList<>();
		lst.add(new Personne("Cérien","Jean"));
		lst.add(new Personne("Terrieur","Alain"));
		lst.add(new Personne("Terrieur","Alex"));
		lst.add(new Personne("Tim","Vincent"));
		model.addAttribute("list", lst);
		return "list";
	}
	
}

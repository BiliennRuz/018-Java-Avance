package fr.eni.quimper.exoformulaire.ihm;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.quimper.exoformulaire.bo.Voiture;

@Controller
@RequestMapping("/IHM")
public class ExoController {
	
	List<Voiture> lst = new ArrayList<>();
	
	@GetMapping("/list")
	public String liste(Model model) {
		if (lst.isEmpty()) {
			lst.add(new Voiture("4L","Renault"));			
		}
		model.addAttribute("list", lst);
		return "list";
	}

	@GetMapping("/form")
	public String form(Voiture voiture, Model model) {
		return "form";
	}
	
	@PostMapping("/form")
	public String validForm(@Valid Voiture voiture, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "form";
		}
		System.out.println(voiture);
		lst.add(voiture);
		return "redirect:/IHM/list";
	}
	
}

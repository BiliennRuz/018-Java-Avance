package fr.formation.demoMVC.ihm;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/**
	 * Initialisation du formulaire
	 * @param personne : il crée une un objet de type Personne qui est directement<br>
	 * mis en attribut du modele. Cette attribut s'appelle personne (le nom de la classe avec une minuscule
	 * @param model : le modele ATTENTION TOUJOURS LE METTRE EN DERNIER ARGUMENT
	 * @return le nom de la vue (le fichier html qui se trouve dans template)
	 */
	@GetMapping("/form")
	public String form(Personne personne, Model model) {
		return "form";
	}
	
	/**
	 * Validation du formulaire
	 * @param personne la personne qui a été crée par le formulaire qui est @Validee
	 * @param errors le container d'erreurs qui est alimenté par les validations
	 * @param model le model (TOUJOURS DERNIER ARGUMENT)
	 * @return vers le form (la vue form.html) ou rerection vers l'url /IHM/hello
	 */
	@PostMapping("/form")
	public String validForm(@Valid Personne personne, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "form";
		}
		System.out.println(personne);
		return "redirect:/IHM/hello";
	}
	
}

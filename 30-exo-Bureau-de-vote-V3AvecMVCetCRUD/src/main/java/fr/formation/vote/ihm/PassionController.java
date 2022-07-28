package fr.formation.vote.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.vote.bll.VoteException;
import fr.formation.vote.bll.VoteManager;
import fr.formation.vote.bo.Passion;

@Controller
@RequestMapping("/passion")
public class PassionController {
	@Autowired
	VoteManager voteManager;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("list",voteManager.getAllPassions());
		return "index";
	}
	
	@GetMapping("/add")
	public String iniAddForm(Passion passion, Model model) {
		return "add";
	}
	
	@PostMapping("/add")
	public String validAddForm(@Valid Passion passion, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "add";
		}
		try {
			voteManager.addPassion(passion);
		} catch (VoteException e) {
			errors.addError(new FieldError("passion","couleur",e.getMessage()));
			return "add";
		}
		return "redirect:/passion";
	}
	

	@GetMapping("/del/{id}")
	public String delBiere(@PathVariable("id") Integer id, Model model) {
		voteManager.delPassionById(id);
		return "redirect:/passion";
	}
	
	@GetMapping("/mod/{id}")
	public String modBiere(@PathVariable("id") Integer id, Model model) {
		Passion passion = voteManager.getPassionById(id);
		model.addAttribute("passion",passion);
		return "mod";
	}
	
	@PostMapping("/mod/{id}") 
	public String modeValidBiere(@PathVariable("id") Integer id,@Valid Passion passion, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "mod";
		}
		passion.setIdPassion(id);
		try {
			voteManager.addPassion(passion);
		} catch (VoteException e) {
			errors.addError(new FieldError("passion","couleur",e.getMessage()));
			return "add";
		}
		return "redirect:/passion";
	}
	
	
}

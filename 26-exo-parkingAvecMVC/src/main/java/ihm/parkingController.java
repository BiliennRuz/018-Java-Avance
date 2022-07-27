package ihm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.parking.bll.ParkingManager;
import fr.formation.parking.bo.Parking;
import fr.formation.parking.dal.ParkingDAO;

@Controller
@RequestMapping("/IHM")
public class parkingController {

	@Autowired
	ParkingManager parkingManager;
	
	@Autowired
	ParkingDAO parkingDAO;
	
	@GetMapping("/list")
	public String liste(Model model) {
		Iterable<Parking> lst = parkingDAO.findAll();
		model.addAttribute("list", lst);
		System.out.println("liste : " + lst);
		return "list";
	}
	
	@GetMapping("/hello")
	public String affiche(Model model) {
		model.addAttribute("message","coucou");
		model.addAttribute("personne",new Parking("parking de l'ENI",10));
		return "hello";
	}
	
}

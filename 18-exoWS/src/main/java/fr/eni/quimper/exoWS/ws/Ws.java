package fr.eni.quimper.exoWS.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.quimper.exoWS.bo.Interupteur;

@RestController
public class Ws {

	@GetMapping("/test")
	public String stausInter() {
		return "test OK";
	}
	
	@GetMapping("/inter/{status}")
	public String stateInter(@PathVariable("status") String status) {
		if("ON".equals(status)) {
			return "Lampe 1 ON";
		}
		else {
			return "Lampe 1 OFF";
		}
	}
	
//	@GetMapping("/volet/{percentOpen}")
//	public String ouvertureVolet(@PathVariable("percentOpen") Integer percentOpen) {
//		Integer initialPercent = 0;
//		Integer finalPercent = percentOpen;
//		while (initialPercent<finalPercent) {
//			percentOpen = 
//
//			return "ouverture du volet à " + toString(percentOpen);
//		}
//	}
	
	@GetMapping("/state")
	public Interupteur status() {
		return new Interupteur(false, true, 50);
	}
	
}

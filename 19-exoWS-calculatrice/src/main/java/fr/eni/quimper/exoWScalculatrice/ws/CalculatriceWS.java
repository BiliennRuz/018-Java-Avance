package fr.eni.quimper.exoWScalculatrice.ws;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatriceWS {

	@GetMapping("/{value1}/{operator}/{value2}")
	public String calculate(
			@PathVariable("value1") Integer value1,
			@PathVariable("operator") String operator,
			@PathVariable("value2") Integer value2)
	{
		Integer result=0;
		if("PLUS".equals(operator)) {
			result = value1 + value2;
		}
		else if("MOINS".equals(operator)) {
			result = value1 - value2;
		}
		else if("DIVISE".equals(operator)) {
			result = value1 / value2;
		}
		else if("MULTIPLIE".equals(operator)) {
			result = value1 * value2;
		}
		else
			result = 0;
		return "==> " + result.toString();
	}
	
}

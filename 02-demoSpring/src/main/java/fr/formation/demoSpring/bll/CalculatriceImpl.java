package fr.formation.demoSpring.bll;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //@Service
@Primary
class CalculatriceImpl implements Calculatrice {

	@Override
	public Integer calculate(Integer a, Integer b, String op) {
		return switch (op) {
		case "+" -> a+b;
		case "-" -> a-b;
		case "*" -> a*b;
		case "/" -> a/b;
		default -> 0;
		};
	}

}

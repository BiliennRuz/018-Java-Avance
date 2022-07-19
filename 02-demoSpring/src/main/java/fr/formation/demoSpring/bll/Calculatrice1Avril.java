package fr.formation.demoSpring.bll;

import org.springframework.stereotype.Component;

@Component("avril")
public class Calculatrice1Avril implements Calculatrice {

	@Override
	public Integer calculate(Integer a, Integer b, String op) {
		return 0;
	}

}

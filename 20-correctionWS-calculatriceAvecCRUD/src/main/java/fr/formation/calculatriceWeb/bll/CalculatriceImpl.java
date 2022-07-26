package fr.formation.calculatriceWeb.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.calculatriceWeb.bo.Calcul;
import fr.formation.calculatriceWeb.dal.CalculDAO;

@Service
public class CalculatriceImpl implements Calculatrice {
	@Autowired
	CalculDAO dao;

	@Override
	public Integer calculate(Integer a, Integer b, String op) {
		Integer res = 0;

		switch (op) {
		case "plus":
			res = a + b;
			break;
		case "moins":
			res = a - b;
			break;
		case "fois":
			res = a * b;
			break;
		case "div":
			res = a / b;
			break;

		default:
			break;
		}
		Calcul c = new Calcul(a, op, b);
		c.setRes(res);
		addCalcul(c);

		return res;
	}

	@Override
	public List<Calcul> getAll() {
		return (List<Calcul>) dao.findAll();
	}

	@Override
	public Calcul getById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public void addCalcul(Calcul calcul) {
		dao.save(calcul);
	}

	@Override
	public void modifyCalcul(Calcul calcul) {
		dao.save(calcul);
	}

}

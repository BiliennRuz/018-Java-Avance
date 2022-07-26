package fr.formation.calculatriceWeb.bll;

import java.util.List;

import fr.formation.calculatriceWeb.bo.Calcul;

public interface Calculatrice {
	public Integer calculate(Integer a, Integer b, String op);
	public List<Calcul> getAll();
	public Calcul getById(Integer id);
	public void deleteById(Integer id);
	public void addCalcul(Calcul calcul);
	public void modifyCalcul(Calcul calcul);
}

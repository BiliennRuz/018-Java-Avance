package fr.eni.tpPotager.bll;

import java.util.List;

import fr.eni.tpPotager.bo.Action;
import fr.eni.tpPotager.bo.Carre;
import fr.eni.tpPotager.bo.Plante;
import fr.eni.tpPotager.bo.Potager;

public interface MonPotagerManager {
	void addPotager(Potager potager);
	
	void addCarre(Carre carre);
	void addCarreInPotager(Carre carre, Potager potager) throws MonPotagerException;
	// FCT 4
	void addPlante(Plante plante);
	// FCT 5
	List<Potager> affichagePotager();
	
	List<Carre> affichageCarre();
	// FCT 6
	List<Plante> affichagePlante();
	
	void addAction(Action action);
	// FCT 7
	List<Action> affichageAction();	
	// FCT....
}

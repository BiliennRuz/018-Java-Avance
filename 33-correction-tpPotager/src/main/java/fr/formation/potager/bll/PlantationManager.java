package fr.formation.potager.bll;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plantation;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.Potager;
import fr.formation.potager.dao.PlantationDAO;

@Service
public class PlantationManager {
	@Autowired
	PlantationDAO dao;
	
	public void plante(Plante plante, Carre carre, Integer dansNbMois, Integer qte) {
		dao.save(new Plantation(plante, carre, LocalDate.now(), LocalDate.now().plusMonths(dansNbMois), qte));
	}

	public List<Plante> planteOfPotager(Potager bibi) {
		return dao.plantesOfPotager(bibi);
	}
}

package fr.formation.potager.bll;

import org.springframework.stereotype.Service;

import fr.formation.potager.bo.Plante;
import fr.formation.potager.dao.PlanteDAO;

@Service
public class PlanteManager extends CRUDManager<Plante, PlanteDAO> {

}

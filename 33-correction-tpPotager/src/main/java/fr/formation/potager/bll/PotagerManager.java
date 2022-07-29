package fr.formation.potager.bll;

import org.springframework.stereotype.Service;

import fr.formation.potager.bo.Potager;
import fr.formation.potager.dao.PotagerDAO;

@Service
public class PotagerManager extends CRUDManager<Potager, PotagerDAO> {

}

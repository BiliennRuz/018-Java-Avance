package fr.eni.tpPotager.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.tpPotager.bo.Action;
import fr.eni.tpPotager.bo.Carre;
import fr.eni.tpPotager.bo.Plante;
import fr.eni.tpPotager.bo.Potager;
import fr.eni.tpPotager.dal.CarreDao;
import fr.eni.tpPotager.dal.PlanteDao;
import fr.eni.tpPotager.dal.PotagerDao;

@Service
@Transactional
public class MonPotagerImpl implements MonPotagerManager {

	@Autowired
	PotagerDao potagerDao;
	
	@Autowired
	CarreDao carreDao;
	
	@Autowired
	PlanteDao planteDao;
	
	@Override
	public void addPotager(Potager potager) {
		
		potagerDao.save(potager);
	}
	
	@Override
	public void addCarre(Carre carre) {
		carreDao.save(carre);	
	}

	@Override
	public void addPlante(Plante plante) {
		planteDao.save(plante);
	}

	@Override
	public List<Potager> affichagePotager() {
		
		return (List<Potager>) potagerDao.findAll();
	}
	
	@Override
	public List<Carre> affichageCarre() {
		
		return (List<Carre>) carreDao.findAll();
	}

	@Override
	public List<Plante> affichagePlante() {
		
		return (List<Plante>) planteDao.findAll();
	}

	@Override
	public void addAction(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Action> affichageAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCarreInPotager(Carre carre, Potager potager) throws MonPotagerException {
		Float surfacePotager = potager.getSurfaceP();
		Float surfaceDejaUtilise =0f;
		for (Carre carreInPotager : potager.getListCarres()) {
			surfaceDejaUtilise += carreInPotager.getSurfaceC();
			System.out.println("surfaceDejaUtilise="+surfaceDejaUtilise);
		}
		Float surfaceNewCarre = carre.getSurfaceC();
		
		if ((surfacePotager - surfaceDejaUtilise) < surfaceNewCarre) {
			throw new MonPotagerException("Le carré dépasse la capacité du potager");
		}
		potager.doDependency(carre);
		
	}

	

}

package fr.formation.potager.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.dao.CarreDAO;

@Service
public class CarreManager extends CRUDManager<Carre, CarreDAO> {

	@Override
	@Transactional
	public Carre add(Carre entity) throws MonPotagerException {
		// CT001 : insert le carré si il y a de la place dans le potager
		// utilisation de stream pour montrer les streams
		if (entity.getPotager().getIdPotager() != null) { // si le potager est déja en base
			int surfaceUtilise = dao.findByPotager(entity.getPotager()).stream()
			.mapToInt(c -> c.getSurface())
			.sum();
			if(surfaceUtilise+entity.getSurface()>entity.getPotager().getSurface()) {
				throw new MonPotagerException("Un carre de "+entity.getSurface()+"m2 ne peut s'insérer "
						+ "dans un potager occupé dont "+surfaceUtilise+"m2 sont déjà utilisé sur "
						+entity.getPotager().getSurface()+"m2");
			}
		}
		return super.add(entity);
	}
}

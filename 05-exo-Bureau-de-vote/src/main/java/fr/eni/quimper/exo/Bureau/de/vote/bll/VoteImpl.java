package fr.eni.quimper.exo.Bureau.de.vote.bll;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.quimper.exo.Bureau.de.vote.bo.Electeur;
import fr.eni.quimper.exo.Bureau.de.vote.dal.ElecteurDAO;

@Component
class VoteImpl implements Vote{
	@Autowired
	private ElecteurDAO dao;
	
	@Override
	public void addElecteur(Electeur e) throws VoteException {
		if(e.getAge() < 18) {
			throw new VoteException("Vous n'avez pas l'âge !!");
		}
		if(e.getNationalite() != "FR") {
			throw new VoteException("Vous n'avez pas la nationalité française !!");
		}
		//FIXME ! pb sur le test
//		if(!"".equals(e.getCandidat())) {
//			throw new VoteException("Vous avez déja voté !!");
//		}
		dao.save(e);

		
	}

	@Override
	public Iterable<Electeur> afficherVotants() {
		Iterable<Electeur> listElecteur = new ArrayList<>();
		listElecteur = dao.findAll();
		return listElecteur;
	}

	@Override
	public Electeur searchCandidatToElecteur(String nom, String prenom) {
		Electeur rechercheElecteur = dao.findByNomAndPrenom(nom, prenom);
		return rechercheElecteur;
	}

	@Override
	public Iterable<Electeur> searchElecteurToCandidat(String candidat) {
		Iterable<Electeur> listElecteur = new ArrayList<>();
		listElecteur = dao.findByCandidat(candidat);
		return listElecteur;
	}

	@Override
	public Integer nbVoteToCanditat(String candidat) {
		Iterable<Electeur> listElecteur = new ArrayList<>();
		listElecteur = dao.findByCandidat(candidat);
		Long count = dao.count();
		System.out.println(count);

		return null;
	}

	@Override
	public String Winner() {
		// TODO Auto-generated method stub
		return null;
	}

}

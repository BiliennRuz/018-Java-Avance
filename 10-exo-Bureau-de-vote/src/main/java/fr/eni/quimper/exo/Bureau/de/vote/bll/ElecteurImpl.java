package fr.eni.quimper.exo.Bureau.de.vote.bll;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.quimper.exo.Bureau.de.vote.bo.Candidat;
import fr.eni.quimper.exo.Bureau.de.vote.bo.Electeur;
import fr.eni.quimper.exo.Bureau.de.vote.bo.Parti;
import fr.eni.quimper.exo.Bureau.de.vote.dal.CandidatDAO;
import fr.eni.quimper.exo.Bureau.de.vote.dal.ElecteurDAO;
import fr.eni.quimper.exo.Bureau.de.vote.dal.PartiDAO;

@Service
class ElecteurImpl implements ElecteurManager{
	@Autowired
	private ElecteurDAO electeurDao;
	
	@Autowired
	private CandidatDAO candidatDao;
	
	@Autowired
	private PartiDAO partiDao;
	
	@Override
	@Transactional
	public void addElecteur(Electeur e) throws ElecteurException {
		if(e.getAge() < 18) {
			throw new ElecteurException("Vous n'avez pas l'âge !!");
		}
		if(e.getNationalite() != "FR") {
			throw new ElecteurException("Vous n'avez pas la nationalité française !!");
		}
		//FIXME ! pb sur le test
//		if(!"".equals(e.getCandidat())) {
//			throw new VoteException("Vous avez déja voté !!");
//		}
		electeurDao.save(e);		
	}

	@Override
	@Transactional
	public Iterable<Electeur> afficherVotants() {
		Iterable<Electeur> listElecteur = new ArrayList<>();
		listElecteur = electeurDao.findAll();
		return listElecteur;
	}

	@Override
	@Transactional
	public Electeur searchCandidatToElecteur(String nom, String prenom) {
		Electeur rechercheElecteur = electeurDao.findByNomAndPrenom(nom, prenom);
		return rechercheElecteur;
	}

	@Override
	@Transactional
	public Iterable<Electeur> searchElecteurToCandidat(Candidat candidat) {
		Iterable<Electeur> listElecteur = new ArrayList<>();
		listElecteur = electeurDao.findByCandidat(candidat);
		return listElecteur;
	}

	@Override
	@Transactional
	public Integer nbVoteToCanditat(Candidat candidat) {
		Iterable<Electeur> listElecteur = new ArrayList<>();
		listElecteur = electeurDao.findByCandidat(candidat);
		Integer countVote = 0; 
		for (Electeur electeur : listElecteur) {
			countVote++;
		}
		return countVote;
	}

	@Override
	public Candidat Winner() {
		Iterable<Candidat> lisCandidat = afficherCandidats();
		Integer countVotesCandidat = 0;
		Integer saveCountVotesCandidat = 0;
		Candidat winCandidat = new Candidat();
		for (Candidat candidat : lisCandidat) {
			countVotesCandidat = nbVoteToCanditat(candidat);
			if (countVotesCandidat > saveCountVotesCandidat) {
				winCandidat = candidat;
				saveCountVotesCandidat = countVotesCandidat;
			}
		}
		return winCandidat;
	}

	@Override
	public void addCandidat(Candidat candidat) {		
		candidatDao.save(candidat);
	}

	@Override
	@Transactional
	public Iterable<Candidat> afficherCandidats() {
		List<Candidat> candidats = (List<Candidat>) candidatDao.findAll();
		return candidats;
	}

	@Override
	public Iterable<Parti> afficherPartis() {
		List<Parti> partis = (List<Parti>) partiDao.findAll();
		return partis;
	}

	@Override
	public void addParti(Parti parti) {
		partiDao.save(parti);
	}
	
}

package fr.formation.vote.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.vote.bo.Candidat;
import fr.formation.vote.bo.Passion;
import fr.formation.vote.bo.Votant;
import fr.formation.vote.dal.CandidatDAO;
import fr.formation.vote.dal.VotantDAO;

@Service
public class VoteManagerImpl implements VoteManager {
	@Autowired
	VotantDAO votantDao;

	@Autowired
	CandidatDAO candidatDao;
	
	@Override
	public void addVote(Votant votant) throws VoteException {
		if(votant.getAge()<18) {
			throw new VoteException("Tu es trop jeune retourne voir Disney chanel");
		}
		if(!"Français".equals(votant.getNation())) {
			throw new VoteException("Seul les personnes de nationalité française peuvent voter");
		}

		candidatDao.save(votant.getCandidat());
		votantDao.save(votant);
	}

	@Override
	public List<Votant> getListVotant() {
		return (List<Votant>) votantDao.findAll();
	}

	@Override
	public List<Votant> getAllVotantOf(String candidat) {
		return votantDao.findByCandidat(candidat);
	}

	@Override
	public Candidat getCandidatOf(String nom, String prenom) {
		return candidatDao.findByNomAndPrenom(nom,prenom);
	}

	@Override
	public List<Votant> getVotantsWhoVoteForCandidatWhoLove(String nomPassion) {
		return votantDao.findByCandidatWhoLove(nomPassion);
	}

	@Override
	public List<Passion> getPassionsCandidatVotant(Votant votant) {
		return votantDao.findPassionsCandidatVotant(votant);
	}

}

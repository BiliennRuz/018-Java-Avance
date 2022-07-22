package fr.formation.vote.bll;

import java.util.List;

import fr.formation.vote.bo.Candidat;
import fr.formation.vote.bo.Votant;

public interface VoteManager {
	public void addVote(Votant votant) throws VoteException;
	public List<Votant> getListVotant();
	public List<Votant> getAllVotantOf(String candidat);
	public Candidat getCandidatOf(String nom, String prenom);
}

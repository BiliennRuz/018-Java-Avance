package fr.formation.vote.bll;

import java.util.List;

import javax.validation.Valid;

import fr.formation.vote.bo.Candidat;
import fr.formation.vote.bo.Passion;
import fr.formation.vote.bo.Votant;

public interface VoteManager {
	public void addVote(Votant votant) throws VoteException;
	public List<Votant> getListVotant();
	public List<Votant> getAllVotantOf(String candidat);
	public Candidat getCandidatOf(String nom, String prenom);
	public List<Votant> getVotantsWhoVoteForCandidatWhoLove(String nomPassion);
	public List<Passion> getPassionsCandidatVotant(Votant votant);
	public Object getAllPassions();
	public void addPassion(@Valid Passion passion) throws VoteException;
	public void delPassionById(Integer id);
	public Passion getPassionById(Integer id);
}

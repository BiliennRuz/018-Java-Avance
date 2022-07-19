package fr.eni.quimper.exo.Bureau.de.vote.bll;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fr.eni.quimper.exo.Bureau.de.vote.bo.Electeur;

public interface Vote {
	public void addElecteur(Electeur e) throws VoteException;
	public Iterable<Electeur> afficherVotants();
	public Electeur searchCandidatToElecteur(String nom, String prenom);
	public Iterable<Electeur> searchElecteurToCandidat(String candidat);
	public Integer nbVoteToCanditat(String candidat);
	public String Winner();

}

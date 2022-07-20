package fr.eni.quimper.exo.Bureau.de.vote.bll;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fr.eni.quimper.exo.Bureau.de.vote.bo.Candidat;
import fr.eni.quimper.exo.Bureau.de.vote.bo.Electeur;

public interface ElecteurManager {
	public void addElecteur(Electeur e) throws ElecteurException;
	public Iterable<Electeur> afficherVotants();
	public Electeur searchCandidatToElecteur(String nom, String prenom);
	public Iterable<Electeur> searchElecteurToCandidat(Candidat candidat);
	public Integer nbVoteToCanditat(Candidat candidat);
	public Candidat Winner();
	
	public void addCandidat(Candidat candidat);
	public Iterable<Candidat> afficherCandidats();

}

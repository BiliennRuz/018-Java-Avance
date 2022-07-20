package fr.eni.quimper.exo.Bureau.de.vote.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Candidat {
	@Id
	@GeneratedValue
	private Integer idCandidat;
	private String nom;
	
	public Candidat() {

	}
	
	public Candidat(String nom) {
		super();
		this.nom = nom;
	}
	
	
}

package fr.formation.vote.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("OLD_CAND")
public class OldCandidat extends Candidat{
	private String popularite;

	public OldCandidat(String nom, String parti, String popularite) {
		super(nom, parti);
		this.popularite = popularite;
	}
	
	

}

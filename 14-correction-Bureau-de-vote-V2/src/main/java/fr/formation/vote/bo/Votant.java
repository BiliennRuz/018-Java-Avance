package fr.formation.vote.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Votant {
	@Id
	@GeneratedValue
	private Integer idVotant;

	private String nom;
	private String prenom;
	private Integer age;
	private String nation;
	
	@ManyToOne
	private Candidat candidat;

	public Votant(String nom, String prenom, Integer age, String nation, Candidat candidat) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nation = nation;
		candidat.doDependency(this);
	}

}

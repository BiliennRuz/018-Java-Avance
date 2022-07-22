package fr.formation.vote.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passion {
	@Id
	@GeneratedValue
	private Integer idPassion;
	private String nom;
	
	public Passion(String nom) {
		super();
		this.nom = nom;
	}

}

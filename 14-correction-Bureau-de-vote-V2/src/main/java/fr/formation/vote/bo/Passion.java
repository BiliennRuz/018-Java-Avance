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
	private String desc;

	public Passion(String nom, String desc) {
		super();
		this.nom = nom;
		this.desc = desc;
	}

}

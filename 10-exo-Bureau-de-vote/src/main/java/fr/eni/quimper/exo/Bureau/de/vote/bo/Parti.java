package fr.eni.quimper.exo.Bureau.de.vote.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Parti {
	@Id
	@GeneratedValue
	private Integer idParti;
	private String nom;

	public Parti(String nom) {
		super();
		this.nom = nom;
	}
		
}

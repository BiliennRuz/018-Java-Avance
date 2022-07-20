package fr.formation.demoData.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Entreprise {
	@Id
	@GeneratedValue
	private Integer idEntreprise;
	private String nom;
	private Integer effectif;

	public Entreprise(String nom, Integer effectif) {
		super();
		this.nom = nom;
		this.effectif = effectif;
	}

}

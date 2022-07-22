package fr.formation.potager.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Plante {
	@Id
	@GeneratedValue
	private Integer idPlante;
	private String nom;
	private String variete;
	private String tyPlante;
	private Integer surface;

//	@ManyToMany
//	private Set<Carre> lstCarres = new HashSet<>();
	
	public Plante(String nom, String variete, String tyPlante, Integer surface) {
		super();
		this.nom = nom;
		this.variete = variete;
		this.tyPlante = tyPlante;
		this.surface = surface;
	}

}

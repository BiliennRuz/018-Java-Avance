package fr.formation.potager.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "garden")
public class Potager {
	@Id
	@GeneratedValue
	private Integer idPotager;
	
	@Column(name = "loc",length = 5,nullable= false)
	private String localisation;
	private String nom;
	private String ville;
	private Integer surface;
//
//	@OneToMany(mappedBy = "potager")
//	private Set<Carre> lstCarres = new HashSet<>();
	
	public Potager(String localisation, String nom, String ville, Integer surface) {
		super();
		this.localisation = localisation;
		this.nom = nom;
		this.ville = ville;
		this.surface = surface;
	}

}

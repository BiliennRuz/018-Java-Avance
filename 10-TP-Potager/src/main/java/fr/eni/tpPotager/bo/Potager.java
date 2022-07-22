package fr.eni.tpPotager.bo;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Potager {
	@Id
	@GeneratedValue
	private Integer idPotager;
	private String localisation;
	private String nom;
	private Float surfaceP;
	private	String ville;
	
	@OneToMany(mappedBy = "potager")
	@ToString.Exclude
	private Set<Carre> listCarres = new HashSet<>();
	
	public Potager(String localisation, String nom, Float surfaceP, String ville) {
		super();
		this.localisation = localisation;
		this.nom = nom;
		this.surfaceP = surfaceP;
		this.ville = ville;
	}	
	
	public void doDependency(Carre carre) {
		carre.setPotager(this);
		listCarres.add(carre);
	}
	
}

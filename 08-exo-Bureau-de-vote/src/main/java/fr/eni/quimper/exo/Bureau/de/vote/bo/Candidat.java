package fr.eni.quimper.exo.Bureau.de.vote.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Data
@Getter 
@Setter
@ToString
@NoArgsConstructor
public class Candidat {
	@Id
	@GeneratedValue
	private Integer idCandidat;
	private String nom;
	
	@ManyToOne
	private Parti parti;
	
	@OneToMany(mappedBy = "candidat")
	private Set<Electeur> listElecteurs = new HashSet<>();
		
	public Candidat(String nom) {
		super();
		this.nom = nom;
	}
	
	public void addElecteur1(Electeur electeur) {
		listElecteurs.add(electeur);
		electeur.setCandidat(this);
	}
	
}

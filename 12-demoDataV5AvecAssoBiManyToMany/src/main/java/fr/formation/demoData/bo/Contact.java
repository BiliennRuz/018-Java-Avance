package fr.formation.demoData.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Contact {
	@Id
	@GeneratedValue
	private Integer idContact;
	private String nom;
	private String prenom;
	private String tel;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private Set<Adresse> lstAdresse = new HashSet<>();
	
//	@ManyToOne(cascade = CascadeType.PERSIST) // si pas de sauvegarde de l'entreprise
	@ManyToOne // il faudra une sauvegarde l'entreprise
	private Entreprise entreprise;

	public Contact(String nom, String prenom, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}

}

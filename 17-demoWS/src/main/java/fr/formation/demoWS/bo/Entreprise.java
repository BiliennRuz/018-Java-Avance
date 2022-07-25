package fr.formation.demoWS.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter 
@Setter
@ToString
@NoArgsConstructor
public class Entreprise {
	@Id
	@GeneratedValue
	private Integer idEntreprise;
	private String nom;
	private Integer effectif;
	
	@OneToMany(mappedBy = "entreprise")
	private Set<Contact> lstcontacts = new HashSet<>();

	public Entreprise(String nom, Integer effectif) {
		super();
		this.nom = nom;
		this.effectif = effectif;
	}
	
	public void addContact(Contact contact) {
		lstcontacts.add(contact);
		contact.setEntreprise(this);
	}

}

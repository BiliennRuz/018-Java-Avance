package fr.formation.demoData.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	public Contact(String nom, String prenom, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}

}

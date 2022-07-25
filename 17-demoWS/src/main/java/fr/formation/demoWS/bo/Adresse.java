package fr.formation.demoWS.bo;

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
public class Adresse {
	@Id
	@GeneratedValue
	private Integer idAdresse;
	private String rue;
	private String ville;
	private String cP;

//	@ManyToMany(mappedBy = "lstAdresse")
//	private Set<Contact> lstContacts = new HashSet<>();
	
	public Adresse(String rue, String ville, String cP) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.cP = cP;
	}

}

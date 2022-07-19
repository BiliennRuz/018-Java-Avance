package fr.eni.quimper.exo.Bureau.de.vote.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class Electeur {
	@Id
	@GeneratedValue
	private Integer idElecteur ;
	private String nom ;
	private String prenom ;
	private Integer age;
	private String nationalite;
	private String candidat;
	
	public Electeur() {
		
	}
	public Electeur(String nom, String prenom, Integer age, String nationalite, String candidat) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nationalite = nationalite;
		this.candidat = candidat;
	}
	@Override
	public String toString() {
		return "Electeur [idElecteur=" + idElecteur + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
				+ ", nationalite=" + nationalite + ", candidat=" + candidat + "]";
	} 
	
	
			
}

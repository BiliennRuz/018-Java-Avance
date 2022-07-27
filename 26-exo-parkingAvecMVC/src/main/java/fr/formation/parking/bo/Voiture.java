package fr.formation.parking.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Voiture {
	@Id
	@GeneratedValue
	private Integer idVoiture;
	private String nom;
	private String model;
	private String marque;
	
	@ManyToOne
	private Parking parking;

	public Voiture(String nom, String model, String marque) {
		super();
		this.nom = nom;
		this.model = model;
		this.marque = marque;
	}

}

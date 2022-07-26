package fr.formation.parking.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Parking {
	@Id
	@GeneratedValue
	private Integer idParking;
	private String nom;
	private Integer capacite;

	public Parking(String nom, Integer capacite) {
		super();
		this.nom = nom;
		this.capacite = capacite;
	}

}

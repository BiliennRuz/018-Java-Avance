package fr.eni.quimper.exoparking.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Parking {
	@Id
	@GeneratedValue
	private Integer idParking;
	private String lieu;
	private Integer nbPlace;
	
//	@ManyToOne
//	private Voiture voiture;
	
	public Parking(String lieu, Integer nbPlace) {
		super();
		this.lieu = lieu;
		this.nbPlace = nbPlace;
	}
	
}

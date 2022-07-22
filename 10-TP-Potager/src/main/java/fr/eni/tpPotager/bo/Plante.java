package fr.eni.tpPotager.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Plante {
	@Id
	@GeneratedValue
	private Integer IdPlante;
	private String nom;
	private String type;
	private String variete;
	private Float surface;
	
	@ManyToOne
	private PlanteDansCarre planteDansCarre;
	
	public Plante(String nom, String type, String variete, Float surface) {
		super();
		this.nom = nom;
		this.type = type;
		this.variete = variete;
		this.surface = surface;
	}
	
	

}

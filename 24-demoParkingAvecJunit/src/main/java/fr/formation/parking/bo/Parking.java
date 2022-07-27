package fr.formation.parking.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "idParking")
public class Parking {
	@Id
	@GeneratedValue
	private Integer idParking;
	private String nom;
	private Integer capacite;
	
	@OneToMany(mappedBy = "parking")
	@ToString.Exclude
//	@JsonIgnore
//	@JsonBackReference
	private Set<Voiture> lstVoitures = new HashSet<>();

	public Parking(String nom, Integer capacite) {
		super();
		this.nom = nom;
		this.capacite = capacite;
	}

	public void addVoiture(Voiture voiture) {
		this.getLstVoitures().add(voiture);
		voiture.setParking(this);
	}

}

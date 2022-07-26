package fr.eni.quimper.exoparking.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Voiture {
	@Id
	@GeneratedValue
	private Integer idVoiture;
	private String type;
	private String couleur;
	private String immat;
	
	@ManyToOne
	private Parking parking;
//	
//	@OneToMany(mappedBy = "voiture")
//	@ToString.Exclude
//	@JsonIgnore
//	private Set<Parking> listParkings = new HashSet<>();
	
	public Voiture(String type, String couleur, String immat) {
		super();
		this.type = type;
		this.couleur = couleur;
		this.immat = immat;
	}
	
//	public void addParking(Parking parking) {
//		listParkings.add(parking);
//		parking.setVoiture(this);
//	}
	
}

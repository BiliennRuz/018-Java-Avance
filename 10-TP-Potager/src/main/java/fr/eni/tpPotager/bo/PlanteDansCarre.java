package fr.eni.tpPotager.bo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class PlanteDansCarre {
	@Id
	@GeneratedValue
	private Integer idPlanteDansCarre;
	private Integer quantite;
	private LocalDate dateMiseEnPlace;
	private LocalDate dateRecolte;

public PlanteDansCarre(Integer quantite, LocalDate dateMiseEnPlace, LocalDate dateRecolte) {
	super();
	this.quantite = quantite;
	this.dateMiseEnPlace = dateMiseEnPlace;
	this.dateRecolte = dateRecolte;
}

}

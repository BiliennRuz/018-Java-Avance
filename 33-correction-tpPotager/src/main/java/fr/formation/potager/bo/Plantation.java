package fr.formation.potager.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Plantation {
	@Id
	@GeneratedValue
	private Integer idPlantation;
	
	@ManyToOne
	private Plante plante;
	
	@ManyToOne
	private Carre carre;
	
	private LocalDate dtPlantation;
	private LocalDate dtRecolte;
	private Integer qte;
	public Plantation(Plante plante, Carre carre, LocalDate dtPlantation, LocalDate dtRecolte, Integer qte) {
		super();
		this.plante = plante;
		this.carre = carre;
		this.dtPlantation = dtPlantation;
		this.dtRecolte = dtRecolte;
		this.qte = qte;
	}
	
	
}

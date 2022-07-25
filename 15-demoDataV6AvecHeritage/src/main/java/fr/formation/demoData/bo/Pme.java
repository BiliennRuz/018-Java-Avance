package fr.formation.demoData.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
//dans le cadre d'un SINGL TABLE
//@DiscriminatorValue("PME")
public class Pme extends Entreprise{
	private Integer cA;
}

package fr.eni.tpPotager.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Action {
	@Id
	@GeneratedValue
	private Integer idAction;
	private Date date;
	private String evenement;
	private String lieu;

public Action(Date date, String evenement, String lieu) {
	super();
	this.date = date;
	this.evenement = evenement;
	this.lieu = lieu;
}


}

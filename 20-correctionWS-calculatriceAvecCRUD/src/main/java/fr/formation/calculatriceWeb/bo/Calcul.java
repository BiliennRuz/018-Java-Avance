package fr.formation.calculatriceWeb.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Calcul {
	@Id
	@GeneratedValue
	private Integer idCalcul;
	private Integer a;
	private String op;
	private Integer b;
	private Integer res=0;
	public Calcul(Integer a, String op, Integer b) {
		super();
		this.a = a;
		this.op = op;
		this.b = b;
	}
	
	
}

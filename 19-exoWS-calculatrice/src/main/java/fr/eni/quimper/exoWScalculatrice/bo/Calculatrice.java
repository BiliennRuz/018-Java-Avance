package fr.eni.quimper.exoWScalculatrice.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Calculatrice {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer value1;
	private String operator;
	private Integer value2;
	
}

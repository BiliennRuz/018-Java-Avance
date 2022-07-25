package fr.eni.quimper.exoWS.bo;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Interupteur {
	@Id
	@GeneratedValue
	private Integer id;
	private Boolean lampe1;
	private Boolean lampe2;
	private Integer Volet1;
	
	public Interupteur(Boolean lampe1, Boolean lampe2, Integer volet1) {
		super();
		this.lampe1 = lampe1;
		this.lampe2 = lampe2;
		Volet1 = volet1;
	}
	
	
}



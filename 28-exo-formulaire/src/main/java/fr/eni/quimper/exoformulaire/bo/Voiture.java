package fr.eni.quimper.exoformulaire.bo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voiture {
	@NotBlank
	private String nom;
	@NotBlank
	private String marque;

}

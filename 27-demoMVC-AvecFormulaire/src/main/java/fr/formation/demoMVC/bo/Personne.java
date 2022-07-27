package fr.formation.demoMVC.bo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {
	@NotBlank(message="tu vas mettre un truc dans ce champs espèce de ....")
	private String nom;
	
	@NotBlank
	private String prenom;

}

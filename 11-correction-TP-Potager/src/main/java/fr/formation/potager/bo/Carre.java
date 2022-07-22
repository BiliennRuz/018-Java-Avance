package fr.formation.potager.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Carre {
	@Id
	@GeneratedValue
	private Integer idCarre;
	private String tySol;
	private String tyExpo;
	private Integer surface;
	
	@ManyToOne
	@JoinColumn(name = "id_potager")
	private Potager potager;
	
//	@ManyToMany(mappedBy = "lstCarres")
//	public Set<Plante> lstPlantes = new HashSet<>();

	public Carre(String tySol, String tyExpo, Integer surface) {
		super();
		this.tySol = tySol;
		this.tyExpo = tyExpo;
		this.surface = surface;
	}

}

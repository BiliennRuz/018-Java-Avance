package fr.eni.tpPotager.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Carre {
		@Id
		@GeneratedValue
		private Integer idCarre;
		private Float surfaceC;
		private String sol;
		private String exposition;
		
		@ManyToOne
		private Potager potager;

		public Carre(Float surfaceC, String sol, String exposition) {
			super();
			this.surfaceC = surfaceC;
			this.sol = sol;
			this.exposition = exposition;
		}
			
	}

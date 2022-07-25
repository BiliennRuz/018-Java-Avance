package fr.formation.vote.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typ_candidat", length = 5)
@DiscriminatorValue("CAND")
public class Candidat {
	@Id
	@GeneratedValue
	
	private Integer idCandidat;
	private String nom;
	private String parti;
	
	@OneToMany(mappedBy = "candidat")
	@ToString.Exclude
	private Set<Votant> lstVotants = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "cand_pass")
	private Set<Passion> lstPassions = new HashSet<>();
	
	public Candidat(String nom, String parti) {
		super();
		this.nom = nom;
		this.parti = parti;
	}
	
	public void doDependency(Votant votant) {
		votant.setCandidat(this);
		lstVotants.add(votant);
	}
	
}

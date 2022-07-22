package fr.formation.vote.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "candidate")
public class Candidat {
	@Id
	@GeneratedValue
	private Integer idCandidat;
	@Column(length=25)
	private String nom;
	private String parti;
	
	@OneToMany(mappedBy = "candidat")
	@ToString.Exclude
	private Set<Votant> lstVotants = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private Set<Passion> listPassion = new HashSet<>();
	
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

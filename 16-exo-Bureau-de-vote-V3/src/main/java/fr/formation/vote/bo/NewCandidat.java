package fr.formation.vote.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("NEW_CAND")
public class NewCandidat extends Candidat{

}

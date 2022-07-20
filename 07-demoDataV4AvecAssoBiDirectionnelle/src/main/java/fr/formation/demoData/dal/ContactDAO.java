package fr.formation.demoData.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.demoData.bo.Contact;

public interface ContactDAO extends CrudRepository<Contact, Integer>{

	Contact findByNomAndPrenom(String nom, String prenom);

	@Query("SELECT c.tel FROM Contact c WHERE c.nom= :nom AND c.prenom= :prenom")
	String getTelFromNomAndPrenom(@Param("nom") String nom, @Param("prenom")String prenom);

	@Query("SELECT c.entreprise.effectif FROM Contact c WHERE c.nom= :nom AND c.prenom= :prenom")
	Integer effectifOfEntrepriseOf(@Param("nom") String nom, @Param("prenom")String prenom);

}

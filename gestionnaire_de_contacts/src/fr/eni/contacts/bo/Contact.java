package fr.eni.contacts.bo;

public class Contact {
	
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String cp;
	private String ville;
	private String telephone;
	
	public Contact() {
		
	}
	
	public Contact(String nom, String prenom, String email, String adresse, String cp, String ville, String telephone) {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse + ", cp=" + cp
				+ ", ville=" + ville + ", telephone=" + telephone + "]";
	}

	
	
}

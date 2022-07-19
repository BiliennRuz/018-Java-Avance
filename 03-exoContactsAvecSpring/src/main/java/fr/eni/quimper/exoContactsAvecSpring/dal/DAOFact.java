package fr.eni.quimper.exoContactsAvecSpring.dal;

public class DAOFact {
	public static ContactDAO getContactDAO() {
		return new ContactDAOMock();
	}
}

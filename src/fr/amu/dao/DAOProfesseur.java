package fr.amu.dao;

import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.*;

public interface DAOProfesseur extends DAO<Professeur,Integer>{
	public List<Etudiant> getByNom(String nom) throws SQLException;
	public List<Etudiant> getByPrenom(String prenom) throws SQLException;

}

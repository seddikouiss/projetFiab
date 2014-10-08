package fr.amu.dao;

import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Etudiant;

public interface DaoEtudiant extends DAO <Etudiant,String>{
	
	public List<Etudiant> getByNom(String nom) throws SQLException;
	public List<Etudiant> getByPrenom(String prenom) throws SQLException;
}

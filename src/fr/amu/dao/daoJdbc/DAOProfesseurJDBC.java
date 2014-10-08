package fr.amu.dao.daoJdbc;

import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Etudiant;
import fr.amu.beans.Professeur;
import fr.amu.dao.DAOProfesseur;
import fr.amu.service.jdbc.interactBD;

public class DAOProfesseurJDBC implements DAOProfesseur {
	interactBD jdbc ;
	public DAOProfesseurJDBC (interactBD jdbc)
	{
		this.jdbc = jdbc;
	}

	@Override
	public boolean delete(Professeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Professeur> FindAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professeur getById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertion(Professeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Professeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Etudiant> getByNom(String nom) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Etudiant> getByPrenom(String prenom) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

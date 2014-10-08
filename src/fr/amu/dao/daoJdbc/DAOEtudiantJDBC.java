package fr.amu.dao.daoJdbc;

import java.util.List;
import java.sql.*;

import fr.amu.beans.*;
import fr.amu.dao.*;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToEtudiant;
import fr.amu.service.jdbc.interactBD;

public class DAOEtudiantJDBC implements DaoEtudiant {

	interactBD jdbc ;
	public DAOEtudiantJDBC (interactBD jdbc){
		this.jdbc = jdbc;
	}
	public boolean insertion(Etudiant obj){
		String query =  "insert into Etudiant values (?,?,?);";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getNumEtudiant() );
			reqPrep.setString(2,obj.getNom() );
			reqPrep.setString(3,obj.getPrenom() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}
	public boolean delete(Etudiant obj) {
		String query =  "delete from Etudiant where (idEtud= ? );";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getNumEtudiant() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}
	public boolean update(Etudiant obj) {
		
		String query =  "update Etudiant set nom= ? , prenom= ? where idEtud= ? ;";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getNom() );
			reqPrep.setString(2,obj.getPrenom() );
			reqPrep.setString(3,obj.getNumEtudiant() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}
	public Etudiant getById(String id) throws SQLException {
		String query =  "select * from Etudiant where idEtud= ? ;";
		PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
		reqPrep.setString(1,id);
		return jdbc.findBean(reqPrep,new ResultSetToEtudiant());
	}
	public List<Etudiant> FindAll() throws SQLException {
		String query =  "select * from Etudiant;";
		PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
		return jdbc.findBeans(reqPrep,new ResultSetToEtudiant());
	}
	public List<Etudiant> getByNom(String nom) throws SQLException {
		String query =  "select * from Etudiant where nom= ? ;";
		PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
		reqPrep.setString(1,nom);
		return jdbc.findBeans(reqPrep,new ResultSetToEtudiant());
	}
	public List<Etudiant> getByPrenom(String prenom) throws SQLException {
		String query =  "select * from Etudiant where prenom= ? ;";
		PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
		reqPrep.setString(1,prenom);
		return jdbc.findBeans(reqPrep,new ResultSetToEtudiant());
	}
}
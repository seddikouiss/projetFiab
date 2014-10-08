package fr.amu.dao.daoJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Etudiant;
import fr.amu.beans.Noter;
import fr.amu.beans.NoterID;
import fr.amu.beans.UE;
import fr.amu.dao.DAONoter;
import fr.amu.service.jdbc.interactBD;

public class DAONoterJdbc implements DAONoter {

	interactBD jdbc ;
	public DAONoterJdbc (interactBD jdbc)
	{
		this.jdbc = jdbc;
	}

	@Override
	public boolean delete(Noter obj) {
		return false;
	}

	@Override
	public List<Noter> FindAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Noter getById(NoterID id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertion(Noter obj) {
		String query =  "insert into Noter values (?,?,?);";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getEtudiant().getNumEtudiant() );
			reqPrep.setString(2,obj.getEu().getId() );
			reqPrep.setInt(3,obj.getNote() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		
		return true;
	}

	public boolean update(Noter obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Noter> getByEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Noter> getByUE(UE ue) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Noter> getBynote(int note) {
		// TODO Auto-generated method stub
		return null;
	}

}

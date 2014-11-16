
/*
 *    Membres du Groupe 
 *    -----------------
 *
 *    AMRANI    Chibla   
 *    BEN NASR  Meriem
 *    BRUNET    Pierre
 *    OUISS     Seddik
 * 
 */
/**
 *  represente la classe DAONoterJdbc qui dérive de DAONoter et qui permet un accée au données(Noter) via jdbc
 */
package fr.amu.dao.daoJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Etudiant;
import fr.amu.beans.Noter;
import fr.amu.beans.NoterID;
import fr.amu.beans.Professeur;
import fr.amu.beans.UE;
import fr.amu.dao.DAONoter;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToEtudiant;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToNoter;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToUE;
import fr.amu.service.jdbc.interactBD;

public class DAONoterJdbc implements DAONoter {

	interactBD jdbc ;
	public DAONoterJdbc (interactBD jdbc)
	{
		this.jdbc = jdbc;
	}

	public boolean insertion(Noter obj) {
		String query =  "insert into NOTER values (?,?,?);";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getEtudiant().getNumEtudiant() );
			reqPrep.setString(2,obj.getUe().getId() );
			reqPrep.setInt(3,obj.getNote() ); 
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		
		return true;
	}

	public boolean update(Noter obj) {

		String query =  "update NOTER set note= ? where (id_Etudiant= ? AND id_UE= ?);";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setInt(1,obj.getNote() );
			reqPrep.setString(2,obj.getEtudiant().getNumEtudiant());
			reqPrep.setString(3,obj.getUe().getId());
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}

	@Override
	public boolean delete(Noter obj) {
		String query =  "delete from NOTER where (id_Etudiant= ? AND id_UE= ?);";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getEtudiant().getNumEtudiant());
			reqPrep.setString(2,obj.getUe().getId());
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}
	@Override
	public List<Noter> FindAll() throws SQLException {
		String query =  "select * from NOTER  ;";
		PreparedStatement reqPrep = null;
		try {
			reqPrep = jdbc.connect().prepareStatement(query);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return jdbc.findBeans(reqPrep,new ResultSetToNoter());
	}

	public Noter getById(NoterID id) throws SQLException {
		String query =  "select * from NOTER where id_Etudiant= ? and id_Ue=?;";
		PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
		reqPrep.setString(1,id.getEtudiant());
		reqPrep.setString(2,id.getUe());
		return jdbc.findBean(reqPrep,new ResultSetToNoter());
	}

	public List<Noter> getByEtudiant(Etudiant e) throws SQLException {
		String query =  "select * from NOTER where id_Etudiant= ? ;";
		PreparedStatement reqPrep = null;
		try {
			reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,e.getNumEtudiant());

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return jdbc.findBeans(reqPrep,new ResultSetToNoter());
	}

	public List<Noter> getByUE(UE ue) {
		return null;
	}

	public List<Noter> getBynote(int note) {
		return null;
	}
	

}
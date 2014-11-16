
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
 *  represente la classe DAOProfesseurJDBC qui dérive de DAOProfesseur et qui permet un accée au données(Professeur) via jdbc
 */
package fr.amu.dao.daoJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Etudiant;
import fr.amu.beans.Professeur;
import fr.amu.dao.DAOProfesseur;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToProfesseur;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToUE;
import fr.amu.service.jdbc.interactBD;

public class DAOProfesseurJDBC implements DAOProfesseur {
	interactBD jdbc ;
	public DAOProfesseurJDBC (interactBD jdbc)
	{
		this.jdbc = jdbc;
	}

	@Override
	public boolean delete(Professeur obj) {
		String query =  "delete from PROF where (idUniv= ? );";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setInt(1,obj.getIdentifiant());
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}

	@Override
	public List<Professeur> FindAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professeur getById(Integer id) throws SQLException {
		String query =  "select * from PROF where idUniv= ? ;";
		PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
		reqPrep.setInt(1,id);
		return jdbc.findBean(reqPrep,new ResultSetToProfesseur());
	}

	@Override
	public boolean insertion(Professeur obj){
		String query =  "insert into PROF values (?,?,?);";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setInt(1,obj.getIdentifiant() );
			reqPrep.setString(2,obj.getNom() );
			reqPrep.setString(3,obj.getPrenom() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	} 

	@Override
	public boolean update(Professeur obj) {
		
		String query =  "update PROF set nom= ? , prenom= ? where idUniv= ? ;";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getNom() );
			reqPrep.setString(2,obj.getPrenom() );
			reqPrep.setInt(3,obj.getIdentifiant() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
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
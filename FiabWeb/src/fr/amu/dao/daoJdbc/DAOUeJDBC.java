
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
 *  represente la classe DAOUeJDBC qui dérive de DAOUe et qui permet un accée au données(UE) via jdbc
 */
package fr.amu.dao.daoJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Etudiant;
import fr.amu.beans.UE;
import fr.amu.dao.DAOUe;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToEtudiant;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToUE;
import fr.amu.service.jdbc.interactBD;

public class DAOUeJDBC implements DAOUe{

	interactBD jdbc ;
	public DAOUeJDBC (interactBD jdbc){
		this.jdbc = jdbc;
	}
	@Override
	public boolean insertion(UE obj) {
			String query =  "insert into UE values (?);";
			try {
				PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
				reqPrep.setString(1,obj.getId());
				jdbc.executeUpdate(reqPrep);
			}
			catch(SQLException e){ return false; }
			return true;
		}
	
	@Override
	public boolean update(UE obj) {
		return false;	//ne sert à rien içi	
	}

	
	@Override
	public boolean delete(UE obj){
		String query =  "delete from UE where (nom= ? );";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getId() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}

	@Override
	public List<UE> FindAll() throws SQLException {
		return null;
	}

	@Override
	public UE getById(String id) throws SQLException {
		String query =  "select * from UE where nom= ? ;";
		PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
		reqPrep.setString(1,id);
		return jdbc.findBean(reqPrep,new ResultSetToUE());
	}
	
}

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
 *  represente la classe DAOEnseignerJDBC qui dérive de DAOEnseigner et qui permet un accée au données(Enseigner) via jdbc
 */

package fr.amu.dao.daoJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Enseigner;
import fr.amu.beans.EnseignerID;
import fr.amu.beans.Professeur;
import fr.amu.beans.UE;
import fr.amu.dao.DAOEnseigner;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToEnseigner;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToNoter;
import fr.amu.service.jdbc.interactBD;

public class DAOEnseignerJDBC implements DAOEnseigner{
	
	interactBD jdbc ;
	public DAOEnseignerJDBC (interactBD jdbc){
		this.jdbc = jdbc;
	}

	@Override
	public boolean delete(Enseigner obj) {
		String query =  "delete from ENSEIGNER where (id_Ue = ? and id_Prof = ?);";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getUe().getId() );
			reqPrep.setInt(2,obj.getProf().getIdentifiant() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}

	@Override
	public List<Enseigner> FindAll() throws SQLException {
		return null;
	}

	@Override
	public Enseigner getById(EnseignerID id) throws SQLException {
		String query =  "select * from ENSEIGNER where id_Ue= ? and id_Prof=?;";
		PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
		reqPrep.setString(1,id.getUe());
		reqPrep.setInt(2,id.getProf());
		return jdbc.findBean(reqPrep,new ResultSetToEnseigner());
	}

	@Override
	public boolean insertion(Enseigner obj){
		String query =  "insert into ENSEIGNER values (?,?);";
		try {
			PreparedStatement reqPrep = jdbc.connect().prepareStatement(query);
			reqPrep.setString(1,obj.getUe().getId() );
			reqPrep.setInt(2,obj.getProf().getIdentifiant() );
			jdbc.executeUpdate(reqPrep);
		}
		catch(SQLException e){ return false; }
		return true;
	}

	@Override
	public boolean update(Enseigner obj) {
		return false;
	}

	@Override
	public List<Enseigner> getByProf(Professeur prof) throws SQLException {
		return null;
	}

	@Override
	public List<Enseigner> getByUe(UE ue) throws SQLException {
		return null;
	}

}
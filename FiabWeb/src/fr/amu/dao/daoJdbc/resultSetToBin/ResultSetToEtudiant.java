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
 *  represente la classe qui  construit un bean de type Etudiant à partir d'un ResultSet
 */
package fr.amu.dao.daoJdbc.resultSetToBin;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.amu.beans.Etudiant;
import fr.amu.service.jdbc.interactBD;

public class ResultSetToEtudiant implements ResultSetToBean<Etudiant>{

	public Etudiant toBean(ResultSet rs,interactBD jdbc) throws SQLException {
		Etudiant e = null;
		e = new Etudiant();
		e.setNumEtudiant(rs.getString(1)) ;
		e.setNom(rs.getString(2)) ;
		e.setPrenom(rs.getString(3)) ;
		return e;
	}
}

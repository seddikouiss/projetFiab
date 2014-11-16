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
 *  represente la classe qui  construit un bean de type UE à partir d'un ResultSet
 */
package fr.amu.dao.daoJdbc.resultSetToBin;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.amu.beans.UE;
import fr.amu.service.jdbc.interactBD;


public class ResultSetToUE  implements ResultSetToBean<UE>{

	@Override
	public UE toBean(ResultSet rs,interactBD jdbc) throws SQLException {
		UE e = new UE();
		e.setId(rs.getString(1)) ;
		return e;
	}

}



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
 *  represente l'interface qui  construit un bean de type T à partir d'un ResultSet
 */
package fr.amu.dao.daoJdbc.resultSetToBin;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.amu.service.jdbc.interactBD;

//construire un bean de type T à partir d'un ResultSet
public interface ResultSetToBean<T> {
	T toBean(ResultSet rs,interactBD jdbc) throws SQLException;
}
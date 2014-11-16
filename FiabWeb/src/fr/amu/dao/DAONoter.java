
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
 *  represente l'interface DAONoter qui dérive de DAO
 */
package fr.amu.dao;
import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.*;

public interface DAONoter extends DAO<Noter,NoterID> {

	public List<Noter> getByEtudiant(Etudiant e) throws SQLException;
	public List<Noter> getByUE(UE ue);
	public List<Noter> getBynote(int note);
}

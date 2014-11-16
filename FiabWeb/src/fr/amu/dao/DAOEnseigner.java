
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
 *  represente l'interface DAOEnseigner qui dérive de DAO
 */
package fr.amu.dao;

import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Enseigner;
import fr.amu.beans.EnseignerID;
import fr.amu.beans.Professeur;
import fr.amu.beans.UE;

public interface DAOEnseigner extends DAO<Enseigner,EnseignerID>{
	public List<Enseigner> getByProf(Professeur prof) throws SQLException;
	public List<Enseigner> getByUe(UE ue) throws SQLException;
}


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
 *  Classe qui génére un fichier XML à partir de notre test pour nous servir de base pour nos test avec DBUnit
 */


package fr.amu.dao.daoJdbc.daoDBUnitTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import fr.amu.service.jdbc.interactBD;

public class genererDatasetFromBDD {
	  public  genererDatasetFromBDD() throws Exception {
		  IDatabaseConnection connection = new DatabaseConnection(new interactBD().connect());
	      QueryDataSet fullDataSet = new QueryDataSet(connection);
	      fullDataSet.addTable("UE", "SELECT * FROM UE");
	      fullDataSet.addTable("PROF", "SELECT * FROM PROF");
	      fullDataSet.addTable("ETUDIANT", "SELECT * FROM ETUDIANT");
	      fullDataSet.addTable("NOTER", "SELECT * FROM NOTER");
	      fullDataSet.addTable("ENSEIGNER", "SELECT * FROM ENSEIGNER");
	      FlatXmlDataSet.write(fullDataSet, new FileOutputStream("dataset.xml")); 
	  }
	public static void main(String[] args) throws SQLException, DatabaseUnitException, FileNotFoundException, IOException {
		
			try {
				new genererDatasetFromBDD();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}


}

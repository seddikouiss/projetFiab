
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
 *  represente la classe de test de DAOuJDBC (les tests sont effectuer avec DBUnit) 
 */

package fr.amu.dao.daoJdbc.daoDBUnitTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.UE;
import fr.amu.config.Config;
import fr.amu.dao.daoJdbc.DAOUeJDBC;
import fr.amu.service.jdbc.interactBD;

public class daoUETestDbUnit {
	
  private IDataSet readDataSet() throws Exception {
      return new FlatXmlDataSet(new File("dataset.xml"));
  }
  /*On écrase les données de la base en y inserant des données se trouvant dans dataset.xml
   * (que l'on a au préalable generer avec la classe genererDatasetFromBDD se trouvant dans le même package)*/
  
	private void insertionCleanFromXMLFlat(IDataSet dataSet) throws Exception {
	      IDatabaseTester databaseTester = new JdbcDatabaseTester(Config.PILOTE, Config.URL , Config.ID, Config.PASS);
	      databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
	      databaseTester.setDataSet(dataSet);

	      databaseTester.onSetup();
	} 
	// Avnt chaque test, on re-initialise la base(on ne reiplemente pas la fct getSetUpOperation)-> testJUnit classique
	@Before
	public void setUp() throws Exception
	{
	  insertionCleanFromXMLFlat(readDataSet());
	}
	
	// Retourne le jeu de données chargé dans la base de données.
	protected QueryDataSet getDatabaseDataSet(String tableName) throws Exception {
		  QueryDataSet loadedDataSet = new QueryDataSet
	    		  (new JdbcDatabaseTester(Config.PILOTE, Config.URL , Config.ID, Config.PASS).getConnection());
	      loadedDataSet.addTable(tableName);
	
	      return loadedDataSet;
	}
	@Test
	public void testDaoInsertion() throws Exception{
		DAOUeJDBC dao = new DAOUeJDBC(new interactBD());
		dao.insertion(new UE("ZnewUE"));
				
		IDataSet expds = new FlatXmlDataSet((new FileInputStream("ueAttenduApresInsert.xml")));
		ITable expectedTable = expds.getTable("UE");
		
		IDatabaseConnection connection =
				new JdbcDatabaseTester(Config.PILOTE, Config.URL , Config.ID, Config.PASS)
							.getConnection();
		IDataSet databaseDataSet = connection.createDataSet();
		ITable actualTable = databaseDataSet.getTable("UE");
		Assertion.assertEquals(expectedTable, actualTable);	
	}

	@Test
	public void testDaoDelete() throws Exception{
		DAOUeJDBC dao = new DAOUeJDBC(new interactBD());
		dao.delete(new UE("XXX"));
				
		IDataSet expds = new FlatXmlDataSet((new FileInputStream("ueAttenduApresDelete.xml")));
		ITable expectedTable = expds.getTable("UE");
		
		IDatabaseConnection connection =
				new JdbcDatabaseTester(Config.PILOTE, Config.URL , Config.ID, Config.PASS)
							.getConnection();
		IDataSet databaseDataSet = connection.createDataSet();
		ITable actualTable = databaseDataSet.getTable("UE");
		Assertion.assertEquals(expectedTable, actualTable);	
	}
}
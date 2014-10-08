package fr.amu.service.jdbc.serviceTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import fr.amu.config.Config;
import fr.amu.service.jdbc.interactBD;

public class interactBDTest {

	interactBD i1,i2;
	
	@Before
	public void init(){
		i1 = new interactBD();
		i2 = new interactBD(Config.PILOTE, Config.URL, Config.ID, Config.PASS);
	}
	@Test
	public void testInit() throws ClassNotFoundException {
		i1.init();
	}
	@Test
	public void testClose()  {
		i1.close();
	}

	@Test
	public void testIsConnected() throws SQLException  {
		assertTrue(i1.isConnected(i1.connect()));
	}
	//
	@Test
	public void testDeconnect() throws SQLException  {
		i1.deconnect(i1.connect());
	}
	@Test
	public void testExecuteUpdate() throws SQLException  {
		String queryInsert =
				"insert into Etudiant values ('M35XXSSSDSDSDSD','ouiss','seddik');";
		String queryDelete =
				"delete from Etudiant where idEtud='M35XXSSSDSDSDSD';";
		i1.executeUpdate(queryInsert);
		i1.executeUpdate(queryDelete);
	}

}

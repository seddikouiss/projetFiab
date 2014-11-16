
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
 *  represente la classe de test de DAOUeJDBC (les tests sont effectuer avec JUnit seulement) 
 */
package fr.amu.dao.daoJdbc.daoJdbcTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.UE;
import fr.amu.dao.daoJdbc.DAOUeJDBC;
import fr.amu.service.jdbc.interactBD;

public class DAOUeJDBCTest {

	DAOUeJDBC dao;
	UE U1,U2;
	@Before
	public void init (){
		interactBD jdbc = new interactBD(); 
		try {
			jdbc.init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 dao= new DAOUeJDBC(jdbc);
		 
		 U1 = new UE("Securite2");
		 U2 = new UE("Réseau");
	}
	@Test
	public void testDelete() {
		assertTrue(dao.delete(U1));
	}
	@Test
	public void testGetById() throws SQLException {
		dao.insertion(U2);
		assertNotNull(dao.getById(U2.getId()));
		dao.delete(U2);
	}
	@Test
	public void testInsertion() {
		assertTrue(dao.insertion(U1));
	}
	
	@Test
	public void testUpdate() {
		U1.setId("Fiabilité2");
		assertTrue(dao.update(U1));
	}
	
	
}

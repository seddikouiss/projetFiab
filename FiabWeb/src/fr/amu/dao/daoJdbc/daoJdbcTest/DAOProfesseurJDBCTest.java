
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
 *  represente la classe de test de DAOProfesseurJDBC (les tests sont effectuer avec JUnit seulement) 
 */
package fr.amu.dao.daoJdbc.daoJdbcTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.Professeur;
import fr.amu.dao.daoJdbc.DAOProfesseurJDBC;
import fr.amu.service.jdbc.interactBD;

public class DAOProfesseurJDBCTest {

	DAOProfesseurJDBC dao;
	Professeur p1,p2;
	@Before
	public void init (){
		interactBD jdbc = new interactBD(); 
		try {
			jdbc.init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 dao= new DAOProfesseurJDBC(jdbc);
		 
		 p1 = new Professeur("Laurent","Brun",6);
		 p2 = new Professeur("Viviane","deleste",6);
	}

	@Test
	public void testDelete() {
		assertTrue(dao.delete(p1));
	}
	@Test
	public void testGetById() throws SQLException {
		dao.insertion(p2);
		assertNotNull(dao.getById(p2.getIdentifiant()));
		dao.delete(p2);
	}
	@Test
	public void testInsertion() {
		assertTrue(dao.insertion(p1));
	}
	
	@Test
	public void testUpdate() {
		p1.setPrenom("Peter");
		assertTrue(dao.update(p1));
	}
	
	
}

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
 *  represente la classe de test de DAOEtudiantJDBC (les tests sont effectuer avec JUnit seulement) 
 */
package fr.amu.dao.daoJdbc.daoJdbcTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.Etudiant;
import fr.amu.dao.daoJdbc.DAOEtudiantJDBC;
import fr.amu.service.jdbc.interactBD;

public class DAOEtudiantJDBCTest {

	DAOEtudiantJDBC dao;
	Etudiant e1,e2;
	@Before
	public void init (){
		interactBD jdbc = new interactBD(); 
		try {
			jdbc.init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 dao= new DAOEtudiantJDBC(jdbc);
		 
		 e1 = new Etudiant("BROH","RICHARD","R6");
		 e2 = new Etudiant("XXXXX","YYYYY","FFFFFF");
	}
	
	@Test
	public void testInsertion() {
		assertTrue(dao.insertion(e1));
	}
	
	@Test
	public void testUpdate() {
		e1.setPrenom("kllss"); 
		assertTrue(dao.update(e1));
	}
	
	@Test
	public void testDelete() {
		assertTrue(dao.delete(e1));
	}
	@Test
	public void testGetByIdAndFindAll() throws SQLException {
		List<Etudiant> l = dao.FindAll();
		for(int i =0;i < l.size();++i)dao.getById(l.get(i).getNumEtudiant());
	}

}

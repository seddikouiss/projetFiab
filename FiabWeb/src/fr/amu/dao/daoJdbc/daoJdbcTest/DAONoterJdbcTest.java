
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
 *  represente la classe de test de DAONoterJDBC (les tests sont effectuer avec JUnit seulement) 
 */
package fr.amu.dao.daoJdbc.daoJdbcTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.EnseignerID;
import fr.amu.beans.Etudiant;
import fr.amu.beans.Noter;
import fr.amu.beans.NoterID;
import fr.amu.beans.UE;
import fr.amu.dao.DAO;
import fr.amu.dao.daoJdbc.DAOEtudiantJDBC;
import fr.amu.dao.daoJdbc.DAONoterJdbc;
import fr.amu.dao.daoJdbc.DAOUeJDBC;
import fr.amu.service.jdbc.interactBD;

public class DAONoterJdbcTest {
	
	DAO daoNoter,daoEtud,daoUe;
	Noter n1,n2;
	UE U3,U4;
	Etudiant e3,e4;
	
	@Before
	public void init (){
	
		interactBD jdbc = new interactBD(); 
		try {
			jdbc.init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		daoNoter= new DAONoterJdbc(jdbc);
		daoEtud = new DAOEtudiantJDBC(jdbc);
		daoUe   = new DAOUeJDBC(jdbc);
		
		U3 = new UE("JEE");
		U4 = new UE("Sécurité");
		e3 = new Etudiant("ROI","Irène","c6");
		e4 = new Etudiant("Gilbert","louis","cc");
		n1 = new Noter(e3, U3, 15);
		n2 = new Noter(e4, U4, 16);
	}

	@Test
	public void testDelete() {
		assertTrue(daoNoter.delete(n1));
	}
	@Test
	public void testGetById() throws SQLException {
		daoEtud.insertion(e4);
		daoUe.insertion(U4);
		daoNoter.insertion(n2) ;
		assertNotNull(daoNoter.getById
					(new NoterID(e4.getNumEtudiant(),U4.getId())));
		daoNoter.delete(n2);
		daoEtud.delete(e4);
		daoUe.delete(U4);

	}
	@Test
	public void testInsertion() {
		daoUe.insertion(U3);
		daoEtud.insertion(e3);
		assertTrue(daoNoter.insertion(n1));
	}
	
	@Test
	public void testUpdate() {
		n1.setNote(18);
		assertTrue(daoNoter.update(n1));
	}
	
	
}
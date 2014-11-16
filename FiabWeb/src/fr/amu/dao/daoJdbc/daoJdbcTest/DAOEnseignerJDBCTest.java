
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
 *  represente la classe de test de DAOEnseignerJDBC (les tests sont effectuer avec JUnit seulement) 
 */
package fr.amu.dao.daoJdbc.daoJdbcTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.Enseigner;
import fr.amu.beans.EnseignerID;
import fr.amu.beans.Professeur;
import fr.amu.beans.UE;
import fr.amu.dao.daoJdbc.DAOEnseignerJDBC;
import fr.amu.dao.daoJdbc.DAOProfesseurJDBC;
import fr.amu.dao.daoJdbc.DAOUeJDBC;
import fr.amu.service.jdbc.interactBD;

public class DAOEnseignerJDBCTest {

	DAOEnseignerJDBC daoEseigner;
	DAOProfesseurJDBC  daoProf ;
	DAOUeJDBC  daoUe ;
	UE U5,U6;
	Professeur p5,p6;
	
	Enseigner en1,en2;
	@Before
	public void init (){
		interactBD jdbc = new interactBD(); 
		try {
			jdbc.init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		daoEseigner= new DAOEnseignerJDBC(jdbc);
		daoProf = new DAOProfesseurJDBC(jdbc);
		daoUe = new DAOUeJDBC(jdbc);
			
		U5 = new UE("Securite2");
		U6 = new UE("Réseau");
		
		p5 = new Professeur("Laurent","Brun",2);
		p6 = new Professeur("Viviane","deleste",3);
		
		en1 = new Enseigner(p5,U5);
		en2 = new Enseigner(p6,U6);
	}
	@Test
	public void testDelete() {
		assertTrue(daoEseigner.delete(en1));
	}
	@Test
	public void testGetByID() throws SQLException {
		daoProf.insertion(p6);
		daoUe.insertion(U6);
		daoEseigner.insertion(en2) ;
		assertNotNull(daoEseigner.getById
					(new EnseignerID(p6.getIdentifiant(),U6.getId())));
		daoEseigner.delete(en2);
		daoProf.delete(p6);
		daoUe.delete(U6);
	}


}
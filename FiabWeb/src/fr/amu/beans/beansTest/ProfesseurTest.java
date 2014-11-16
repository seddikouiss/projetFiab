
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
 *  represente la classe de test de la classe métier Professeur
 */
package fr.amu.beans.beansTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.Professeur;
import fr.amu.beans.UE;

public class ProfesseurTest {
	
	Professeur prof;
	List <UE> ue;
	UE fiabilite;
    private List<UE> allUE ;

	@Before 
	public void init() 
	{
		prof = new Professeur();
		prof.setNom("lugiez");
		prof.setPrenom("denis");
		prof.setIdentifiant(1);
		
		UE fiab=new UE("fiabilite");
        allUE = new ArrayList<UE>();
        allUE.add(fiab);
		prof.setAllUE(allUE);
		
	}
	@Test
	public void getNomTest() {
		assertEquals(prof.getNom(), "lugiez");
	}
	@Test
	public void getPrenom() {
		assertEquals(prof.getPrenom(), "denis");
	}
	@Test
	public void getIdentifiantTest() {
		assertEquals(prof.getIdentifiant(), 1);
	}
	@Test
	public void setNomTest() {
		prof.setNom("LUGIEZ");
		assertEquals(prof.getNom(), "LUGIEZ");
	}
	@Test
	public void setPrenom() {
		prof.setPrenom("DENIS");
		assertEquals(prof.getPrenom(), "DENIS");
	}
	@Test
	public void setIdentifiantTest() {
		prof.setIdentifiant(2);
		assertEquals(prof.getIdentifiant(), 2);
	}
	@Test
	public void getAllUETest() {
		assertEquals(prof.getAllUE(),allUE );
	}
	   
		
}
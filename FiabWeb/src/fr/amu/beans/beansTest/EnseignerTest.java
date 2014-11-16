
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
 *  represente la classe de test de la classe métier Enseigner
 */
package fr.amu.beans.beansTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.Enseigner;
import fr.amu.beans.Professeur;
import fr.amu.beans.UE;

public class EnseignerTest {
	Professeur prof;
	UE ue ;
	Enseigner enseigner;
	
	@Before
	public void init()
	{
		enseigner = new Enseigner();
		prof=new Professeur("lugiez","denis",1);
		ue=new UE("fiabilite");
		enseigner.setProf(prof);
		enseigner.setUe(ue);
	}
	
	@Test
	public void getProfTest() {
		assertEquals(enseigner.getProf(),prof);
	}

	@Test
	public void getUeTest() {
		assertEquals(enseigner.getUe(),ue);
	}

}
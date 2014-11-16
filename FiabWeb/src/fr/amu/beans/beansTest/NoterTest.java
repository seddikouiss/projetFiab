
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
 *  represente la classe de test de la classe métier Noter
 */
package fr.amu.beans.beansTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.Etudiant;
import fr.amu.beans.Noter;
import fr.amu.beans.UE;

public class NoterTest {
	Etudiant etudiant;
	UE ue ;
	int note;
	Noter noteUe;
	
	@Before
	public void init()
	{
		note=13;
		etudiant=new Etudiant("amrani","chibla","C1");
		ue=new UE("fiabilite");
		noteUe=new Noter();
		noteUe.setEtudiant(etudiant);
		noteUe.setUe(ue);
		noteUe.setNote(note);
		
	}
	
	@Test
	public void getNoteTest() {
		assertEquals(noteUe.getNote(),note);
	}
	@Test
	public void getEtudiantTest() {
		assertEquals(noteUe.getEtudiant(),etudiant);
	}
	@Test
	public void getEuTest() {
		assertEquals(noteUe.getUe(),ue);
	}
	

}
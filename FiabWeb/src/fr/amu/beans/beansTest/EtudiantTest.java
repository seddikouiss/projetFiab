
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
 *  represente la classe de test de la classe métier Etudiant
 */
package fr.amu.beans.beansTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import fr.amu.beans.*;

public class EtudiantTest {
	
	Etudiant e;
	List <UE> ue;
	UE fiabilite;
	UE jee;
	List <Noter> notes ;

	@Before 
	public void init() 
	{
		e = new Etudiant("AMRANI","CHIBLA","C1");
		
        UE fiab=new UE("fiabilite");
        UE jee=new UE("jee");
		ue = new ArrayList<UE>();
		ue.add(fiab);
		ue.add(jee);
		e.setUEsInscris(ue);
		

		Noter noteUe=new Noter();
		noteUe.setEtudiant(e);
		noteUe.setUe(fiab);
		noteUe.setNote(15);
		notes= new  ArrayList<Noter>();
		notes.add(noteUe);
		e.setNotes(notes);
		
	
	}
	@Test
	public void getNomTest() {
		assertEquals(e.getNom(), "AMRANI");
	}
	@Test
	public void getPrenom() {
		assertEquals(e.getPrenom(), "CHIBLA");
	}
	@Test
	public void getNumEtudiantTest() {
		assertEquals(e.getNumEtudiant(), "C1");
	}
	@Test
	public void setNomTest() {
		e.setNom("ben nasr");
		assertEquals(e.getNom(), "ben nasr");
	}
	@Test
	public void setPrenom() {
		e.setPrenom("meriem");
		assertEquals(e.getPrenom(), "meriem");
	}
	@Test
	public void setNumEtudiantTest() {
		e.setNumEtudiant("M1");
		assertEquals(e.getNumEtudiant(), "M1");
	}
	
	@Test
	public void getNotesTest() {
		assertEquals(e.getNotes(), notes);
	}
	
	@Test
	public void getUEsInscrisTest() {
		
		assertEquals(e.getUEsInscris(), ue);
	}

	
}
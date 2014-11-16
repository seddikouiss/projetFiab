
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
 *  represente la classe de test de la classe métier UE
 */
package fr.amu.beans.beansTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.amu.beans.UE;

public class UETest {
  UE  ue;
  
  @Before 
	public void init() 
	{
	  ue=new UE("fiabilite");
	}
  @Test
  public void getIdTest() {
		assertEquals(ue.getId(),"fiabilite" );
	}
  @Test
	public void setIdTest() {
		ue.setId("jee");
		assertEquals(ue.getId(),"jee" );
		
	}

}
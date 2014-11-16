
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
 * class represente la classe métier UE(unité d'enseignement)
 */
package fr.amu.beans;


public class UE {
	String id;	
	
	public UE(String nom) {
		this.id = nom;
	}

	public UE(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

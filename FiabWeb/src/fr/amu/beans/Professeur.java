
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
 * class represente la classe métier Professeur
 */
package fr.amu.beans;

import java.util.List;


public class Professeur {

    private String nom;
    private String prenom;
    private int identifiant;

    private List<UE> allUE ;
    
	public Professeur() {}

    
    public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public List<UE> getAllUE() {
		return allUE;
	}
	public void setAllUE(List<UE> allUE) {
		this.allUE = allUE;
	}    
    public Professeur(String nom, String prenom, int num) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = num;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}

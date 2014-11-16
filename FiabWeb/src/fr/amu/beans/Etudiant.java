
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
 * class represente la classe métier Etudiant
 */
package fr.amu.beans;

import java.util.List;


public class Etudiant {
	String numEtudiant;
	String nom;
	String prenom;
	
	List <UE>  UEsInscris;
	List <Noter> notes ;
	
	public List<Noter> getNotes() {
		return notes;
	}

	public void setNotes(List<Noter> notes) {
		this.notes = notes;
	}

	public Etudiant(){}
    public Etudiant(String nom,String prenom, String num) {
        this.nom = nom;
        this.prenom = prenom;
        this.numEtudiant = num;
    }

	
	public String getNumEtudiant() {
		return numEtudiant;
	}

	public void setNumEtudiant(String numEtudiant) {
		this.numEtudiant = numEtudiant;
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

	public List<UE> getUEsInscris() {
		return UEsInscris;
	}

	public void setUEsInscris(List<UE> uEsInscris) {
		UEsInscris = uEsInscris;
	}
}


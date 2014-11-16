
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
 * class represente la classe métier Noter
 */
package fr.amu.beans;


public class Noter {
	Etudiant etudiant;
	UE ue ;
	int note;

	public Noter(Etudiant etudiant, UE ue, int note) {
		super();
		this.etudiant = etudiant;
		this.ue = ue;
		this.note = note;
	}
	
	public Noter(){} 
	
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public UE getUe() {
		return ue;
	}
	public void setUe(UE ue) {
		this.ue = ue;
	}
	
}
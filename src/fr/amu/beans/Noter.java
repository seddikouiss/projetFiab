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
	public UE getEu() {
		return ue;
	}
	public void setEu(UE ue) {
		this.ue = ue;
	}
	
}
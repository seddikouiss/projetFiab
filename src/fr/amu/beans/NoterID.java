package fr.amu.beans;

public class NoterID {
	
	String etudiant;
	String ue ;
	
	public NoterID(String etudiant, String ue) {
		super();
		this.etudiant = etudiant;
		this.ue = ue;
	}
	
	public String getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(String etudiant) {
		this.etudiant = etudiant;
	}
	public String getUe() {
		return ue;
	}
	public void setUe(String ue) {
		this.ue = ue;
	}

}

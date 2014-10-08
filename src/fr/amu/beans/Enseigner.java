package fr.amu.beans;

public class Enseigner {
	
	Professeur prof;
	UE ue ;
	
	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public UE getUe() {
		return ue;
	}

	public void setUe(UE ue) {
		this.ue = ue;
	}

	public Enseigner(){}

}

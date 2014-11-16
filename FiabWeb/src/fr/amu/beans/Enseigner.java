
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
 * class represente la classe métier Enseigner
 */
package fr.amu.beans;

public class Enseigner {
	

	Professeur prof;
	UE ue ;
	
	public Enseigner(Professeur prof, UE ue) {
		this.prof = prof;
		this.ue = ue;
	}
	public Enseigner(){}

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


}

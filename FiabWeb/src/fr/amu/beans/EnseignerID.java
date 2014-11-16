

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
 * class representant l'identifiant de Enseigner(car identifiant composer de Professeur et UE)
 */
package fr.amu.beans;

public class EnseignerID {
	int prof;
	String ue ;
	
	public EnseignerID(int prof, String ue) {
		super();
		this.prof = prof;
		this.ue = ue;
	}
	
	public int getProf() {
		return prof;
	}

	public void setProf(int prof) {
		this.prof = prof;
	}

	public String getUe() {
		return ue;
	}

	public void setUe(String ue) {
		this.ue = ue;
	}


}

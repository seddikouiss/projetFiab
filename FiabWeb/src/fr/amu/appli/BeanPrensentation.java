package fr.amu.appli;

public class BeanPrensentation {
	
	String id = "";
	String nom = "";
	String prenom = "";
	
	public BeanPrensentation() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String num) {
		this.id = num;
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
	public void reInit(){
		id = "";
		nom = "";
		prenom = "";
	}


}

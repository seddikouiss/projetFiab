package fr.amu.dao;
import java.util.List;

import fr.amu.beans.*;

public interface DAONoter extends DAO<Noter,NoterID> {

	public List<Noter> getByEtudiant(Etudiant e);
	public List<Noter> getByUE(UE ue);
	public List<Noter> getBynote(int note);
}

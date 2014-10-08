package fr.amu.dao.daoJdbc;

import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.Enseigner;
import fr.amu.beans.EnseignerID;
import fr.amu.beans.Professeur;
import fr.amu.beans.UE;
import fr.amu.dao.DAOEnseigner;

public class DAOEnseignerJDBC implements DAOEnseigner{

	@Override
	public boolean delete(Enseigner obj) {
		return false;
	}

	@Override
	public List<Enseigner> FindAll() throws SQLException {
		return null;
	}

	@Override
	public Enseigner getById(EnseignerID id) throws SQLException {
		return null;
	}

	@Override
	public boolean insertion(Enseigner obj) {
		return false;
	}

	@Override
	public boolean update(Enseigner obj) {
		return false;
	}

	@Override
	public List<Enseigner> getByProf(Professeur prof) throws SQLException {
		return null;
	}

	@Override
	public List<Enseigner> getByUe(UE ue) throws SQLException {
		return null;
	}

}

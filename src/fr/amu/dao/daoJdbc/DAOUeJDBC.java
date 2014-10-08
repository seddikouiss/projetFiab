package fr.amu.dao.daoJdbc;

import java.sql.SQLException;
import java.util.List;

import fr.amu.beans.UE;
import fr.amu.dao.DAOUe;
import fr.amu.service.jdbc.interactBD;

public class DAOUeJDBC implements DAOUe{

	interactBD jdbc ;
	public DAOUeJDBC (interactBD jdbc){
		this.jdbc = jdbc;
	}

	@Override
	public boolean delete(UE obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UE> FindAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UE getById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertion(UE obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UE obj) {
		// TODO Auto-generated method stub
		return false;
	}

}

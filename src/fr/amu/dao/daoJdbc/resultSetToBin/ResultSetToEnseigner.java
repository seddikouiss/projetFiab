package fr.amu.dao.daoJdbc.resultSetToBin;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.amu.beans.Enseigner;
import fr.amu.dao.daoJdbc.DAOProfesseurJDBC;
import fr.amu.dao.daoJdbc.DAOUeJDBC;
import fr.amu.service.jdbc.interactBD;

public class ResultSetToEnseigner  implements ResultSetToBean<Enseigner>{

	@Override
	public Enseigner toBean(ResultSet rs,interactBD jdbc) throws SQLException {
		Enseigner e = null;
		e = new Enseigner();
		e.setUe(new DAOUeJDBC(jdbc).getById(rs.getString(1))) ;
		e.setProf(new DAOProfesseurJDBC(jdbc).getById(rs.getInt(2))) ;
		return e;
	}

}

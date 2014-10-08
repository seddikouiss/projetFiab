package fr.amu.dao.daoJdbc.resultSetToBin;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.amu.beans.Noter;
import fr.amu.dao.daoJdbc.DAOEtudiantJDBC;
import fr.amu.dao.daoJdbc.DAOUeJDBC;
import fr.amu.service.jdbc.interactBD;


public class ResultSetToNoter  implements ResultSetToBean<Noter>{

	@Override
	public Noter toBean(ResultSet rs,interactBD jdbc) throws SQLException {
		Noter e = null;
		e = new Noter();
		e.setEtudiant(new DAOEtudiantJDBC(jdbc).getById(rs.getString(1))) ;
		e.setEu(new DAOUeJDBC(jdbc).getById(rs.getString(2))) ;
		e.setNote(rs.getInt(3)) ;
		return e;
	}

}

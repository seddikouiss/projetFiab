package fr.amu.dao.daoJdbc.resultSetToBin;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.amu.beans.UE;
import fr.amu.service.jdbc.interactBD;


public class ResultSetToUE  implements ResultSetToBean<UE>{

	@Override
	public UE toBean(ResultSet rs,interactBD jdbc) throws SQLException {
		UE e = new UE();
		e.setId(rs.getString(1)) ;
		return e;
	}

}

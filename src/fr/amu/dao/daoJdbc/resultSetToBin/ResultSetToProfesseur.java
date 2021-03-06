package fr.amu.dao.daoJdbc.resultSetToBin;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.amu.beans.Professeur;
import fr.amu.service.jdbc.interactBD;

public class ResultSetToProfesseur  implements ResultSetToBean<Professeur> {

	public Professeur toBean(ResultSet rs,interactBD jdbc) throws SQLException {
		Professeur e = new Professeur();
		e.setIdentifiant(rs.getInt(1)) ;
		e.setNom(rs.getString(2)) ;
		e.setPrenom(rs.getString(3)) ;
		return e;
	}

}

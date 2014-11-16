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
 *  represente la classe qui implemente le service jdbc
 */
package fr.amu.service.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.amu.config.Config;
import fr.amu.dao.daoJdbc.resultSetToBin.ResultSetToBean;


public class interactBD {
	String nomPilote;
	String URLconnexion;
	String identifiant;
	String password;

	// Connexion par defaut

	public interactBD(String nomPilote, String URLconnexion, String identifiant, String password) {
		this.nomPilote = nomPilote;
		this.URLconnexion = URLconnexion;
		this.identifiant = identifiant;
		this.password = password;
	}
	public interactBD() {
		this(Config.PILOTE, Config.URL, Config.ID, Config.PASS);
	}

	public void init() throws ClassNotFoundException {
		loadDriver();
	}

	public void close() {

	}

	void loadDriver() throws ClassNotFoundException {
		Class.forName(nomPilote);
	}

	public Connection connect() throws SQLException {
		Connection conn =
			DriverManager.getConnection(URLconnexion, identifiant, password);
		return conn;
	}

	public boolean isConnected(Connection conn){
		if (conn != null){
			return true;
		}
		return false;
	}
	/*deconnection silentieuse*/
	public void deconnect(Connection conn)  {
		if (isConnected(conn)) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	/* insertion, deletion, update requete _NON_ preparer*/
	public int executeUpdate(String query) throws SQLException {
		 // créer une connexion
		 try (Connection conn = connect()){
			 
		 // préparer l'instruction 
			 Statement st = conn.createStatement();
		 
		 // exécuter l'instruction 
			 return st.executeUpdate(query);
		 
		 } catch (SQLException e) { throw e; } // renvoyer cette exception
		 
	 }
	/* insertion, deletion, update : requete preparer*/
	public int executeUpdate(PreparedStatement query) throws SQLException  {
		 // exécuter l'instruction 
			return query.executeUpdate();
	 }
	
	/*prend en parametre une requete preparer et renvoie une liste d'objet correspondant au ligne de la base*/
	public <T> List<T> findBeans(PreparedStatement query, ResultSetToBean<T> mapper) throws SQLException{
		List<T> l = new ArrayList<T>();
		ResultSet rs = query.executeQuery();
		while(rs.next())
			l.add(mapper.toBean(rs,this));
		return l;
	}
	/*prend en parametre une requete preparer et renvoie un objet correspondant au ligne de la base*/
	public <T> T findBean(PreparedStatement query, ResultSetToBean<T> mapper) throws SQLException{
		ResultSet rs = query.executeQuery();
		if(rs.next())
			return mapper.toBean(rs,this);
		return null;
	}

	// Getters
	public String getNomPilote() {return nomPilote;}
	public String getURLconnexion() {return URLconnexion;}
	public String getIdentifiant() {return identifiant;}
	public String getPassword() {return password;}

	// Setters
	public void setNomPilote(String saisie) {nomPilote = saisie;}
	public void setURLconnexion(String saisie) {URLconnexion = saisie;}
	public void setIdentifiant(String saisie) {identifiant = saisie;}
	public void setPassword(String saisie) {password = saisie;}

}
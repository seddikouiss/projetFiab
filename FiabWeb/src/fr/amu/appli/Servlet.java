package fr.amu.appli;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import fr.amu.beans.EnseignerID;
import fr.amu.beans.Etudiant;
import fr.amu.beans.Noter;
import fr.amu.beans.Professeur;
import fr.amu.beans.UE;
import fr.amu.config.Config;
import fr.amu.dao.DAOEnseigner;
import fr.amu.dao.DAONoter;
import fr.amu.dao.DAOProfesseur;
import fr.amu.dao.DAOUe;
import fr.amu.dao.DaoEtudiant;
import fr.amu.dao.daoJdbc.DAOEnseignerJDBC;
import fr.amu.dao.daoJdbc.DAOEtudiantJDBC;
import fr.amu.dao.daoJdbc.DAONoterJdbc;
import fr.amu.dao.daoJdbc.DAOProfesseurJDBC;
import fr.amu.dao.daoJdbc.DAOUeJDBC;
import fr.amu.service.jdbc.interactBD;

/**
 * Servlet implementation class Servlet
 */
//@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    boolean error(BeanPrensentation b, BeanPrensentation err) throws ServletException, IOException{
    	boolean ret = false;

    	if(b.getId().isEmpty()){
    		err.setId("error ID ");
    		ret =true;
    	}
    	if(b.getNom().isEmpty()){
    		err.setNom("error NOM ");
    		ret =true;
    	}
    	if(b.getPrenom().isEmpty()){
    		err.setPrenom("error PRENOM ");
    		ret =true;
    	}
    	return ret;
    }
    private void newEtud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BeanPrensentation bEtud ;
		BeanPrensentation bEtudErr;
		BeanString  insertionEtudMessage;
		
		if(request.getSession().getAttribute("etud") != null){
			bEtud = (BeanPrensentation) request.getSession().getAttribute("etud");
		}
		else{
			bEtud = new BeanPrensentation();
		}
		if(request.getSession().getAttribute("etudErr") != null){
			bEtudErr = (BeanPrensentation) request.getSession().getAttribute("etudErr");
			bEtudErr.reInit();
		}
		else{
			bEtudErr = new BeanPrensentation();
		}
		if(request.getSession().getAttribute("insertionEtudMessage") != null){
			insertionEtudMessage = (BeanString) request.getSession().getAttribute("insertionEtudMessage");
			insertionEtudMessage.setVal("");
		} else {
			insertionEtudMessage = new BeanString();
		}

		if(request.getParameter("identEtud")!=null) bEtud.setId(request.getParameter("identEtud"));
		if(request.getParameter("nomEtud")!=null) bEtud.setNom(request.getParameter("nomEtud"));
		if(request.getParameter("prenomEtud")!=null) bEtud.setPrenom(request.getParameter("prenomEtud"));
		
		if(error(bEtud, bEtudErr)){
			request.getSession().setAttribute("etud", bEtud);
			request.getSession().setAttribute("etudErr", bEtudErr);
			request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
		} else{
			interactBD bd = new interactBD();
			DaoEtudiant dao = new DAOEtudiantJDBC(bd);
			if(dao.insertion(new Etudiant(bEtud.getNom(), bEtud.getPrenom(), bEtud.getId()))){
				request.getSession().setAttribute("insertionEtud", new BeanBoolean(true));
				insertionEtudMessage.setVal("Insertion réussie");
				request.getSession().setAttribute("insertionEtudMessage", insertionEtudMessage);
				bEtudErr.reInit();
				bEtud.reInit();
			} else{
				request.getSession().setAttribute("insertionEtud", new BeanBoolean(false));
				insertionEtudMessage.setVal("Insertion échec");
				request.getSession().setAttribute("insertionEtudMessage", insertionEtudMessage);

			}
			
			request.getSession().setAttribute("etud", bEtud);
			request.getSession().setAttribute("etudErr", bEtudErr);
			request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
		}
    }
    private void newProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BeanPrensentation bProf ;
		BeanPrensentation bProfErr;
		BeanString  insertionProfMessage;
		
		if(request.getSession().getAttribute("prof") != null){
			bProf = (BeanPrensentation) request.getSession().getAttribute("prof");
		}
		else{
			bProf = new BeanPrensentation();
		}
		if(request.getSession().getAttribute("profErr") != null){
			bProfErr = (BeanPrensentation) request.getSession().getAttribute("profErr");
			bProfErr.reInit();
		}
		else{
			bProfErr = new BeanPrensentation();
		}
		if(request.getSession().getAttribute("insertionProfMessage") != null){
			insertionProfMessage = (BeanString) request.getSession().getAttribute("insertionProfMessage");
			insertionProfMessage.setVal("");
		} else {
			insertionProfMessage = new BeanString();
		}

		if(request.getParameter("identProf")!=null) bProf.setId(request.getParameter("identProf"));
		if(request.getParameter("nomProf")!=null) bProf.setNom(request.getParameter("nomProf"));
		if(request.getParameter("prenomProf")!=null) bProf.setPrenom(request.getParameter("prenomProf"));
		
		if(error(bProf, bProfErr)){
			request.getSession().setAttribute("prof", bProf);
			request.getSession().setAttribute("profErr", bProfErr);
			request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
		} else{
			int idProf = -1;
			try{
				idProf = Integer.parseInt(bProf.getId());
			} catch (NumberFormatException e){
				bProfErr.setId("ID Professeur must be an integer");
				request.getSession().setAttribute("prof", bProf);
				request.getSession().setAttribute("profErr", bProfErr);
				request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
				return ;
			}
			interactBD bd = new interactBD();
			DAOProfesseur dao = new DAOProfesseurJDBC(bd);
			if(dao.insertion(new Professeur(bProf.getNom(), bProf.getPrenom(),idProf))){
				request.getSession().setAttribute("insertionProf", new BeanBoolean(true));
				insertionProfMessage.setVal("Insertion réussie");
				request.getSession().setAttribute("insertionProfMessage", insertionProfMessage);
				bProfErr.reInit();
				bProf.reInit();
			} else{
				request.getSession().setAttribute("insertionProf", new BeanBoolean(false));
				insertionProfMessage.setVal("Insertion échec");
				request.getSession().setAttribute("insertionProfMessage", insertionProfMessage);
			}
			request.getSession().setAttribute("prof", bProf);
			request.getSession().setAttribute("profErr", bProfErr);
			request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
		}
    }
    private void newUE(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BeanPrensentation bUe ;
		BeanPrensentation bUeErr;
		BeanString  insertionUeMessage;
		
		if(request.getSession().getAttribute("ue") != null){
			bUe = (BeanPrensentation) request.getSession().getAttribute("ue");
		}
		else{
			bUe = new BeanPrensentation();
		}
		if(request.getSession().getAttribute("ueErr") != null){
			bUeErr = (BeanPrensentation) request.getSession().getAttribute("ueErr");
			bUeErr.reInit();
		}
		else{
			bUeErr = new BeanPrensentation();
		}
		if(request.getSession().getAttribute("insertionUeMessage") != null){
			insertionUeMessage = (BeanString) request.getSession().getAttribute("insertionUeMessage");
			insertionUeMessage.setVal("");
		} else {
			insertionUeMessage = new BeanString();
		}

		if(request.getParameter("numUe")!=null) bUe.setId(request.getParameter("numUe"));
		
		if(bUe.getId().isEmpty()){
			bUeErr.setId("Error ID");
			request.getSession().setAttribute("ue", bUe);
			request.getSession().setAttribute("ueErr", bUeErr);
			request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
		} else{
			interactBD bd = new interactBD();
			DAOUe dao = new DAOUeJDBC(bd);
			if(dao.insertion(new UE(bUe.getId()))){
				request.getSession().setAttribute("insertionUe", new BeanBoolean(true));
				insertionUeMessage.setVal("Insertion réussie");
				request.getSession().setAttribute("insertionUeMessage", insertionUeMessage);
				bUe.reInit();
				bUe.reInit();
			} else{
				request.getSession().setAttribute("insertionUe", new BeanBoolean(false));
				insertionUeMessage.setVal("Insertion échec");
				request.getSession().setAttribute("insertionUeMessage", insertionUeMessage);
			}
			request.getSession().setAttribute("ue", bUe);
			request.getSession().setAttribute("ueErr", bUeErr);
			request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
		}
    }
    private void modifierNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int note;
		if( request.getParameter("note")!= null){
			try{
				 note = Integer.parseInt(request.getParameter("note")) ;
			}catch(NumberFormatException e){
				DAONoter dao = new DAONoterJdbc(new interactBD());
				List<Noter> l = null ;
				try {
					l = dao.FindAll() ;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				request.getSession().setAttribute("toutesLesNotes", l);
				request.getSession().setAttribute("msgRet", new BeanString("Mauvais format note"));
				request.getRequestDispatcher("pageProf.jsp").forward(request, response);
				return;
			}
		}else{
			DAONoter dao = new DAONoterJdbc(new interactBD());
			List<Noter> l = null ;
			try {
				l = dao.FindAll() ;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			request.getSession().setAttribute("toutesLesNotes", l);

			request.getSession().setAttribute("msgRet", new BeanString("Note null"));
			request.getRequestDispatcher("pageProf.jsp").forward(request, response);
			return;
		}
		int numProf ;
		if( request.getParameter("numProf")!= null){
			try{
				numProf = Integer.parseInt(request.getParameter("numProf")) ;
			}catch(NumberFormatException e){
				DAONoter dao = new DAONoterJdbc(new interactBD());
				List<Noter> l = null ;
				try {
					l = dao.FindAll() ;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				request.getSession().setAttribute("toutesLesNotes", l);

				request.getSession().setAttribute("msgRet", new BeanString("Num Prof n'est pas un nombre"));
				request.getRequestDispatcher("pageProf.jsp").forward(request, response);
				return;
			}
		} else {
			DAONoter dao = new DAONoterJdbc(new interactBD());
			List<Noter> l = null ;
			try {
				l = dao.FindAll() ;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			request.getSession().setAttribute("toutesLesNotes", l);

			request.getSession().setAttribute("msgRet", new BeanString("Num Prof null"));
			request.getRequestDispatcher("pageProf.jsp").forward(request, response);
			return;
		}
		String ue ;
		if( request.getParameter("numUe")!= null){
			ue = request.getParameter("numUe") ;
		}else {
			DAONoter dao = new DAONoterJdbc(new interactBD());
			List<Noter> l = null ;
			try {
				l = dao.FindAll() ;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			request.getSession().setAttribute("toutesLesNotes", l);

			request.getSession().setAttribute("msgRet", new BeanString("Num ue null"));
			request.getRequestDispatcher("pageProf.jsp").forward(request, response);
			return;
		}
		String etud ="" ;
		if( request.getParameter("numEtud")!= null){
			etud = request.getParameter("numEtud") ;
		}else {
			DAONoter dao = new DAONoterJdbc(new interactBD());
			List<Noter> l = null ;
			try {
				l = dao.FindAll() ;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			request.getSession().setAttribute("toutesLesNotes", l);

			request.getSession().setAttribute("msgRet", new BeanString("Num etud null"));
			request.getRequestDispatcher("pageProf.jsp").forward(request, response);
			return;
		}
		interactBD bd = new interactBD();
		DAOEnseigner daoEnseigner = new DAOEnseignerJDBC((bd)) ;
		try {
			if (daoEnseigner.getById(new EnseignerID(numProf, ue)) == null){
				DAONoter dao = new DAONoterJdbc(new interactBD());
				List<Noter> l = null ;
				try {
					l = dao.FindAll() ;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				request.getSession().setAttribute("toutesLesNotes", l);

				request.getSession().setAttribute("msgRet", new BeanString("Vous n'avez le droit de modifier cette note"));
				request.getRequestDispatcher("pageProf.jsp").forward(request, response);
				return;
				
			}
			DAONoter daoNoter = new DAONoterJdbc(bd);
			if (daoNoter.update(new Noter(new Etudiant("", "", etud), new UE(ue), note))){
				
				DAONoter dao = new DAONoterJdbc(new interactBD());
				List<Noter> l = null ;
				try {
					l = dao.FindAll() ;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				request.getSession().setAttribute("toutesLesNotes", l);

				request.getSession().setAttribute("msgRet", new BeanString("Modification réussie"));
				request.getRequestDispatcher("pageProf.jsp").forward(request, response);
				return;
			}else {
				DAONoter dao = new DAONoterJdbc(new interactBD());
				List<Noter> l = null ;
				try {
					l = dao.FindAll() ;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				request.getSession().setAttribute("toutesLesNotes", l);

				request.getSession().setAttribute("msgRet", new BeanString("Modification échec"));
				request.getRequestDispatcher("pageProf.jsp").forward(request, response);
				return;
			}
			
		} catch (SQLException e) {
			DAONoter dao = new DAONoterJdbc(new interactBD());
			List<Noter> l = null ;
			try {
				l = dao.FindAll() ;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			request.getSession().setAttribute("toutesLesNotes", l);

			request.getSession().setAttribute("msgRet", new BeanString("DB erreur"));
			request.getRequestDispatcher("pageProf.jsp").forward(request, response);
			return;
		}
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("/newEtud".equals(request.getServletPath())){//nouvel étudiant
			if(request.getSession().getAttribute("session") == null){
			 	response.sendRedirect( request.getContextPath() + "/auth.jsp" );
		    	return ;			}

			newEtud(request,response);
		}
		else if("/newProf".equals(request.getServletPath())){//nouveau prof
			if(request.getSession().getAttribute("session") == null){
			 	response.sendRedirect( request.getContextPath() + "/auth.jsp" );
		    	return ;			}
			newProf(request,response);
		}
		else if("/newUE".equals(request.getServletPath())){//nouvel UE
			if(request.getSession().getAttribute("session") == null){
			 	response.sendRedirect( request.getContextPath() + "/auth.jsp" );
		    	return ;
		    }
			newUE(request,response);
		}
		else if("/modifierNote".equals(request.getServletPath())){
			modifierNote(request, response);
		}
		else{
			request.getRequestDispatcher("auth.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		interactBD bd = new interactBD();
		try {
			bd.init();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		DaoEtudiant daoEtud = new DAOEtudiantJDBC(bd);
		DAONoter daoNoter = new DAONoterJdbc(bd);
		DAOUeJDBC daoUe = new DAOUeJDBC(new interactBD());
		DAOProfesseur daoProf = new DAOProfesseurJDBC(bd);
		DAOEnseigner daoEns = new DAOEnseignerJDBC(bd);

		if(request.getParameter("nature")==null ||
		   (!request.getParameter("nature").equals("admin") && 
		    !request.getParameter("nature").equals("prof")&&
		    !request.getParameter("nature").equals("etud")))
		{
			request.getRequestDispatcher("auth.jsp").forward(request, response);
			return;
		}
		if(request.getParameter("nature").equals("admin")){
			if(request.getParameter("mdp")!= null &&
			   request.getParameter("mdp").equals(Config.PASSADMIN_APPLI)){
				request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
				request.getSession().setAttribute("session", new Object());
			}
			else{
				request.getRequestDispatcher("auth.jsp").forward(request, response);
			}
		}
		else if(request.getParameter("nature").equals("prof")){
			int numProf= -1 ;
			try{
				if(request.getParameter("mdp")!= null){
					numProf= Integer.parseInt(request.getParameter("mdp"));
				}
			}
			catch(NumberFormatException e){
				e.printStackTrace();
			}
			Professeur prof = null ;
			try {
				if((prof=daoProf.getById(numProf)) != null){
					DAONoter dao = new DAONoterJdbc(new interactBD());
					List<Noter> l = dao.FindAll() ;
					request.getSession().setAttribute("toutesLesNotes", l);
					request.getSession().setAttribute("prof", prof);
					request.getRequestDispatcher("pageProf.jsp").forward(request, response);
				}
				else request.getRequestDispatcher("auth.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{ //etud
			Etudiant et ;
			try {
				if(request.getParameter("mdp")!= null &&
				   (et = daoEtud.getById(request.getParameter("mdp"))) != null){
					DAONoter dao = new DAONoterJdbc(new interactBD());
					List<Noter> l = dao.getByEtudiant(et) ;
					request.getSession().setAttribute("etudiant", et);
					request.getSession().setAttribute("lstNote", l);
					request.getRequestDispatcher("pageEtud.jsp").forward(request, response);
				}
				else request.getRequestDispatcher("auth.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

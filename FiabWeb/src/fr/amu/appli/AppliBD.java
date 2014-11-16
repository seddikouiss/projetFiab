
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
 *  represente la classe principal de l'Application
 */
package fr.amu.appli;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.dbunit.DatabaseUnitException;

import fr.amu.beans.Enseigner;
import fr.amu.beans.EnseignerID;
import fr.amu.beans.Etudiant;
import fr.amu.beans.Noter;
import fr.amu.beans.NoterID;
import fr.amu.beans.Professeur;
import fr.amu.beans.UE;
import fr.amu.config.Config;
import fr.amu.dao.daoJdbc.DAOEnseignerJDBC;
import fr.amu.dao.daoJdbc.DAOEtudiantJDBC;
import fr.amu.dao.daoJdbc.DAONoterJdbc;
import fr.amu.dao.daoJdbc.DAOProfesseurJDBC;
import fr.amu.dao.daoJdbc.DAOUeJDBC;
import fr.amu.service.jdbc.interactBD;

public class AppliBD {
	public static void afficherChoixPrincipal()
	{
		
		System.out.println("\n\n1 : Etudiant");
		System.out.println("2 :Prof");
		System.out.println("3 :admin");
		System.out.println("4 :exit");
		System.out.println("\nChoix : ");

	}
	static void menu() throws SQLException
	{
		int nbr ;
		String str1,str2,str3;
		Scanner clavier = new Scanner(System.in);
		DAOEtudiantJDBC daoEtud = new DAOEtudiantJDBC(new interactBD());
		DAONoterJdbc daoNoter = new DAONoterJdbc(new interactBD());
		DAOUeJDBC daoUe = new DAOUeJDBC(new interactBD());
		DAOProfesseurJDBC daoProf = new DAOProfesseurJDBC(new interactBD());
		DAOEnseignerJDBC daoEns = new DAOEnseignerJDBC(new interactBD());
		
		interactBD jdbc = new interactBD();
		while(true){
			afficherChoixPrincipal();
			try{
				nbr = Integer.parseInt(clavier.nextLine());
			}
			catch(NumberFormatException e){//Si mauvaite entrer du clavier  on réaffiche le menu
				System.err.println("Saisie incorrect!!!");
				continue;
			}
			catch (NoSuchElementException x){
				continue ;
			}
			if(nbr == 4){
				return ;
			}
			if(nbr == 1){
				System.out.println("Entrer votre numero Etudiant: ");
				str1 = clavier.nextLine();
				if(daoEtud.getById(str1) == null){
					System.err.println("Numero étudiant incorrect!!!");
					continue;
				}
				System.out.println("Entrer le num de l'UE dont vous voullez consulter la note: ");
				str2 = clavier.nextLine();
				if(daoUe.getById(str2) == null){
					System.err.println("Numero UE incorrect!!!");
					continue;
				}
				Noter n = daoNoter.getById(new NoterID(str1, str2));
				if(n  == null){
					System.err.println("pas de note pour l'etudiant :"+str1+" dans l'ue :"+str2);
					continue;
				}
				System.out.println("Note pour l'etudiant :"+str1+" dans l'ue :"+str2+ "->>  " + n.getNote());

			}
			if(nbr == 2){
				System.out.println("Entrer votre numero universitaire: ");
				str1 = clavier.nextLine();
				try{
					nbr = Integer.parseInt(str1);
				}
				catch(NumberFormatException e){//Si mauvaite entrer du clavier  on réaffiche le menu
					System.err.println("Saisie incorrect!!!");
					continue;
				}
				if(daoProf.getById(Integer.parseInt(str1)) == null){
					System.err.println("numero universitaire incorrect!!!");
					continue;
				}
				System.out.println("Voulez-vous ? ");
				System.out.println("1 : Consulter une note ");
				System.out.println("2 : Modifier une note  ");
				try{
					nbr = Integer.parseInt(clavier.nextLine());
				}
				catch(NumberFormatException e){//Si mauvaite entrer du clavier  on réaffiche le menu
					System.err.println("Saisie incorrect!!!");
					continue;
				}
				if(nbr == 1){
					System.out.println("Entrer le numero Etudiant dont voulez consulter la note: ");
					try{
						str1 = clavier.nextLine();
					}
					catch (NoSuchElementException x){
						continue ;
					}

					if(daoEtud.getById(str1) == null){
						System.err.println("Numero étudiant incorrect!!!");
						continue;
					}
					System.out.println("Entrer le num de l'UE dont vous voullez consulter la note: ");
					str2 = clavier.nextLine();
					if(daoUe.getById(str2) == null){
						System.err.println("Numero UE incorrect!!!");
						continue;
					}
					Noter n = daoNoter.getById(new NoterID(str1, str2));
					if(n  == null){
						System.err.println("pas de note pour l'etudiant :"+str1+" dans l'ue :"+str2);
						continue;
					}
					System.out.println("Note pour l'etudiant :"+str1+" dans l'ue :"+str2+ "->>  " + n.getNote());
				}
				else if(nbr == 2){
					System.out.println("Entrer le numero Etudiant dont vous voulez modifier la note: ");
					try{
						str2 = clavier.nextLine();
					}
					catch (NoSuchElementException x){
						continue ;
					}

					if(daoEtud.getById(str2) == null){
						System.err.println("Numero étudiant incorrect!!!");
						continue;
					}
					System.out.println("Entrer le num de l'UE dont vous voullez modifier la note: ");
					str3 = clavier.nextLine();
					if(daoUe.getById(str3) == null){
						System.err.println("Numero UE incorrect!!!");
						continue;
					}
					Enseigner e = daoEns.getById(new EnseignerID(Integer.parseInt(str1), str3));
					if(e  == null){
						System.err.println("Vous n'enseigner pas l'UE pour lequel vous voulez modifier la note!!!");
						continue;
					}
					Noter n = daoNoter.getById(new NoterID(str2, str3));
					if(n  == null){
						System.err.println("L'etudiant("+str2+") n'est pas affecter à cette UE("+ str3+")");
						continue;
					}
					System.out.println("Entrer la nouvelle note (ancienne note = " + n.getNote() +") : ");
					try{
						nbr = Integer.parseInt(clavier.nextLine());
					}
					catch(NumberFormatException ex){//Si mauvaite entrer du clavier  on réaffiche le menu
						System.err.println("Mauvaise entree!!!");
						continue;
					}
					n.setNote(nbr); ;
					if (daoNoter.update(n)) System.out.println("la nouvelle note a été mise  jour avec succé");
					else System.err.println("la nouvelle note n' a pas été mise  jour");
				}
			}
			else if(nbr == 3){
				System.out.println("Entrer votre mot de passe : ");
				str1 = clavier.nextLine() ;
				if( !str1.equals(Config.PASSADMIN_APPLI)){
					continue ;
				}
				System.out.println("Voulez vous creer :");
				System.out.println("1 : Etudiant");
				System.out.println("2 : Professeur");
				System.out.println("3 : UE");
				try{
					nbr = Integer.parseInt(clavier.nextLine());
				}
				catch(NumberFormatException e){//Si mauvaite entrer du clavier  on réaffiche le menu
					System.err.println("Saisie incorrect!!!");
					continue;
				}
				catch (NoSuchElementException x){
					continue ;
				}
				if(nbr == 1){
					System.out.println("Entrez le numero étudiant : ");
					str1 = clavier.nextLine();
					System.out.println("Entrez le nom de l' étudiant : ");
					str2 = clavier.nextLine();
					System.out.println("Entrez le prenom de l' étudiant : ");
					str3 = clavier.nextLine();
					if(daoEtud.insertion(new Etudiant(str2, str3, str1))){
						System.out.println("Insertion avec succée!!");
					}
					else{
						System.out.println("Echec d'insertion!!!");
					}
				}
				else if(nbr == 2){
					System.out.println("Entrez le numero universitaire du prof : ");
					str1 = clavier.nextLine();
					try{
						nbr = Integer.parseInt(str1) ;
					}
					catch(NumberFormatException e){
						System.err.println("Saisie incorrect!!!");
						continue;
					}
					System.out.println("Entrez le nom du prof : ");
					str2 = clavier.nextLine();
					System.out.println("Entrez le prenom du prof : ");
					str3 = clavier.nextLine();
					if(daoProf.insertion(new Professeur(str2, str3, nbr))){
						System.out.println("Insertion avec succée!!");
					}
					else{
						System.out.println("Echec d'insertion!!!");
					}
				}
				else if(nbr == 3){
					System.out.println("Entrez le nom de l'UE(Identifiant) : ");
					str1 = clavier.nextLine();
					if(daoUe.insertion(new UE(str1))){
						System.out.println("Insertion avec succée!!");
					}
					else{
						System.out.println("Echec d'insertion!!!");
					}
				}
			}
		}
	}
	public static void main(String[] args) throws SQLException, DatabaseUnitException, FileNotFoundException, IOException {
		
		try {
			menu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

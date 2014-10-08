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

package fr.amu.beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Administrateur {

	private String password;
	
	public Administrateur() {
		generatePassword();
	}


	public String getPassword() {
		return password;
	}
	
	public String generatePassword() {
		String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer randStr = new StringBuffer();
		int randomInt = 0;
		for (int i = 0; i < 5; i++) {
			Random randomGenerator = new Random();
			randomInt = randomGenerator.nextInt(CHAR_LIST.length());
			if (randomInt - 1 != -1)
				randomInt = randomInt - 1;
			char ch = CHAR_LIST.charAt(randomInt);
			randStr.append(ch);
		}
		password = randStr.toString();
		System.out.println("Attention ! Notez votre mot de passe : "
				+ randStr.toString());
		return randStr.toString();
	}

}
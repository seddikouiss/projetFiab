<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Authentification</title>
</head>
<body>
	<h3>Site consultation/modification des notes</h3>
	
	<form  id="formulaire" autocomplete='off' method="post" action="Servlet" >
		<label >Nature : </label>
		<input type="radio" id="Administrateur" name="nature" checked value="admin"/><label for="Administrateur">Administrateur </label>
		<input type="radio" id="Professeur" name="nature" value="prof"/><label for="Professeur">Professeur </label>
		<input type="radio" id="Etudiant" name="nature" value="etud"/><label for="Etudiant">Etudiant </label>
		<br/>
		<input id="mdp" name="mdp" type="password"  placeholder="Authentifiant (*)" required autocomplete="off"/>
		<input name="sub" type="submit"  value="connect" /> 
	</form>
	<br/><br/>
	<p > (*)Pour l'administrateur, c'est son mot de passe. </p>
	<p > (*)Pour un étudiant, c'est son numéro étudiant. </p>
	<p > (*)Pour un professeur, c'est son identifiant univérsitaire. </p>
  </body>
</body>
</html>
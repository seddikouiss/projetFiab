<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- controle, iterations, tests, variables -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- traitement XML -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!-- formattage des donnees -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- SQL/JDBC -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Admin</title>
</head>
<body>

	<jsp:useBean id="insertionEtud" scope="session" class="fr.amu.appli.BeanBoolean" />
	<jsp:useBean id="insertionEtudMessage" scope="session" class="fr.amu.appli.BeanString" />
	
	<jsp:useBean id="etud" scope="session" class="fr.amu.appli.BeanPrensentation"/>
	<jsp:useBean id="etudErr" scope="session" class="fr.amu.appli.BeanPrensentation"/>

	<jsp:useBean id="insertionProf" scope="session" class="fr.amu.appli.BeanBoolean" />
	<jsp:useBean id="insertionProfMessage" scope="session" class="fr.amu.appli.BeanString" />

	<jsp:useBean id="prof" scope="session" class="fr.amu.appli.BeanPrensentation"/>
	<jsp:useBean id="profErr" scope="session" class="fr.amu.appli.BeanPrensentation"/>

	<jsp:useBean id="insertionUe" scope="session" class="fr.amu.appli.BeanBoolean" />
	<jsp:useBean id="insertionUeMessage" scope="session" class="fr.amu.appli.BeanString" />

	<jsp:useBean id="ue" scope="session" class="fr.amu.appli.BeanPrensentation"/>
	<jsp:useBean id="ueErr" scope="session" class="fr.amu.appli.BeanPrensentation"/>


	<h3>Créer un nouveau compte Etudiant</h3>
	<form  id="formEtud" autocomplete='off' method="get" action="newEtud" >
		<input id="identEtud" name="identEtud" type="input"  placeholder="Numéro étudiant" value="<c:out value="${etud.id}" />" required autocomplete="off"/>
		<span style="color : red;"><c:out value="${etudErr.id}"/></span> <br/>	
		<input id="nomEtud" name="nomEtud" type="input"  placeholder="Nom étudiant" value="<c:out value="${etud.nom}" />" required autocomplete="off"/>
		<span style="color : red;"><c:out value="${etudErr.nom}"/></span> <br/>	
		<input id="prenomEtud" name="prenomEtud" type="input"  placeholder="Prénom étudiant" value="<c:out value="${etud.prenom}" />" required autocomplete="off"/>
		<span style="color : red;"><c:out value="${etudErr.prenom}"/></span>
		</br>
		<input name="sub" type="submit"  value="ajouter" />
		<c:choose>
			<c:when test="${insertionEtud.val}">
				<span style="color : green;"><c:out value="${insertionEtudMessage.val}"/></span>
			</c:when>
			<c:otherwise >
				<span style="color : red;"><c:out value="${insertionEtudMessage.val}"/></span>
			</c:otherwise>
		</c:choose>
		
		
	</form>
	<h3>Créer un nouveau compte professeur</h3>
	<form  id="formProf" autocomplete='off' method="get" action="newProf" >
		<input id="identProf" name="identProf" type="input"  placeholder="Numéro Professeur" value="<c:out value="${prof.id}" />" required autocomplete="off"/>
		<span style="color : red;"><c:out value="${profErr.id}"/></span> <br/>	
		<input id="nomProf" name="nomProf" type="input"  placeholder="Nom Professeur" value="<c:out value="${prof.nom}" />" required autocomplete="off"/>
		<span style="color : red;"><c:out value="${profErr.nom}"/></span> <br/>	
		<input id="prenomProf" name="prenomProf" type="input"  placeholder="Prénom Professeur" value="<c:out value="${prof.prenom}" />" required autocomplete="off"/>
		<span style="color : red;"><c:out value="${profErr.prenom}"/></span>
		</br>
		<input name="sub" type="submit"  value="ajouter" />
		<c:choose>
			<c:when test="${insertionProf.val}">
				<span style="color : green;"><c:out value="${insertionProfMessage.val}"/></span>
			</c:when>
			<c:otherwise >
				<span style="color : red;"><c:out value="${insertionProfMessage.val}"/></span>
			</c:otherwise>
		</c:choose>
	</form>

	<h3>Créer un nouvel UE</h3>
	<form  id="formUe" autocomplete='off' method="get" action="newUE" >
		<input id="numUe" name="numUe" type="input"  placeholder="Numéro UE" value="<c:out value="${ue.id}" />" required autocomplete="off"/>
		<span style="color : red;"><c:out value="${ueErr.id}"/></span> <br/>
		<input name="subUe" type="submit"  value="ajouter" />
		<c:choose>
			<c:when test="${insertionUe.val}">
				<span style="color : green;"><c:out value="${insertionUeMessage.val}"/></span>
			</c:when>
			<c:otherwise >
				<span style="color : red;"><c:out value="${insertionUeMessage.val}"/></span>
			</c:otherwise>
		</c:choose>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="toutesLesNotes" scope="session" type="java.util.List"/>
	<jsp:useBean id="prof" scope="session" class="fr.amu.beans.Professeur"/>
	<jsp:useBean id="msgRet" scope="session" class="fr.amu.appli.BeanString" />
	

	<h3> Toutes les notes consultables et éventuellement modifiables(professeur : <c:out value="${prof.nom}"/> )</h3>
	<TABLE BORDER="1">
		 <CAPTION> Toutes les notes </CAPTION>
		 <thead>
		 	<TR>
		 		<th>Numéro étudiant</th>
		 		<th>Nom étudiant</th>
				<th>UE</th>
				<th>Note</th>
				<th></th>
		 	</TR>
		 <tbody>
		 <c:forEach items="${toutesLesNotes}" var="item">
		 	 <form  autocomplete='off' method="get" action="modifierNote" >
		 	 	<input name="numEtud" type="hidden" value="<c:out value="${item.etudiant.numEtudiant}"/>"/>
		 	 	<input name="numUe" type="hidden" value="<c:out value="${item.ue.id}"/>"/>
		 	 	<input name="numProf" type="hidden" value="<c:out value="${prof.identifiant}"/>"/>
		 		<tr>
				 	<td><c:out value="${item.etudiant.numEtudiant}"/></td>
				 	<td><c:out value="${item.etudiant.nom}"/></td>
				 	<td><c:out value="${item.ue.id}"/></td>
				 	<td><input name="note" type="input" value="<c:out value="${item.note}"/>"/></td>
				 	<td><input name="submit" type="submit" value="Modifier"/></td>
		 		</tr>
		 	</form>
			</c:forEach>
		</tbody>
	</TABLE>
	<span style="color : red ;"><c:out value="${msgRet.val}"/></span>
	</body>
</html>
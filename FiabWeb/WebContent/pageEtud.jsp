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
<title>Note Etudiant </title>
</head>
<body>
	<jsp:useBean id="lstNote" scope="session" type="java.util.List"/>
	<jsp:useBean id="etudiant" scope="session" class="fr.amu.beans.Etudiant"/>

	<h3> <c:out value="Note de l'etudiant '${etudiant.nom }'" /></h3>
		<TABLE BORDER="1">
		 <CAPTION> Note </CAPTION>
		 <thead>
		 	<TR>
				<th>UE</th>
				<th>Note</th>
		 	</TR>
		 <tbody>
		 <c:forEach items="${lstNote}" var="item">
			 <tr>
			 	<td><c:out value="${item.ue.id}"/></td>
			 	<td><c:out value="${item.note}"/></td>
			 </tr>
		</c:forEach>
		</tbody>
	</TABLE>
	</body>
</html>
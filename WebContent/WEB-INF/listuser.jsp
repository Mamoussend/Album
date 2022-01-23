<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="<c:url value='style/list.css'/>">
<link href='https://fonts.googleapis.com/css?family=Vollkorn:400,700' rel='stylesheet' type='text/css'>
<title>Insert title here</title>
</head>
<body>
<h1 id="titre-principal">Liste des utilisateurs</h1>
<c:choose>
  <c:when test="${ empty user}">
     <p>Aucun utilsateur pour le moment</p>
  </c:when>
  <c:otherwise>
  

<table>
  <tr>
           <th>id</th>
   	      <th>nom</th>
	      <th>prenom</th>
	      <th>type</th>
	      <th colspan="2">Ajouter Action</th>
  </tr>
  
  <c:forEach var="albums" items="${ requestScope.user }">
  <tr>
<td> <c:out  value=" ${ albums.id }"></c:out></td>
	<td><c:out   value=" ${ albums.nom}"></c:out> </td>
	<td><c:out   value=" ${ albums.prenom}"></c:out> </td>
	<td><c:out value=" ${ albums.type} "></c:out></td>

 <td><a href="<c:url  value='/supprimer?id=${ albums.id} '/>">supprimer</a></td>
  <td><a href="<c:url  value='/modifier?id=${ albums.id} '/>">modifier</a></td>
  
    

  </tr>

	</c:forEach>
	 
</table>

 </c:otherwise>
</c:choose>
</body>
</html>
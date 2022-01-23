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
  <c:when test="${ empty album}">
     <p>Aucun utilsateur pour le moment</p>
  </c:when>
  <c:otherwise>
  

<table>
  <tr>
   	      <th>nom</th>
	      <th>theme</th>
	      <th>type</th>
	      <th colspan="4">Action</th>
  </tr>
  <c:forEach var="albums" items="${ requestScope.album }">
  <tr>
<td> <c:out  value=" ${ albums.nom }"></c:out></td>
	<td><c:out   value=" ${ albums.theme }"></c:out> </td>
	<td><c:out value=" ${ albums.type} "></c:out></td>
    <td><a href="<c:url  value='/permission?id=${ albums.idproprietaire} '/>">Ajouter permission</a></td>
     <td><a href="<c:url  value='/modif?id=${ albums.idproprietaire} '/>">modifier Album</a></td>
       <td><a href="<c:url  value='/images?idal=${ albums.idproprietaire} '/>">Ajouter photos </a></td>
   <td><a href="<c:url  value='/supprimer?id=${ albums.idproprietaire }'/>" onclick="return ConfSup()">supprimer</a></td>
  </tr>

	</c:forEach>
</table>

 </c:otherwise>
</c:choose>
</body>
</html>
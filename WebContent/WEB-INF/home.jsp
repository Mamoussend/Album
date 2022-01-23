<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/entete.jsp"></c:import>
<div class="main">

<c:choose>
  <c:when test="${ empty image}">
     <p>Aucun utilsateur pour le moment</p>
  </c:when>
  <c:otherwise>
  
 <!--cards -->
  <c:forEach var="images" items="${ requestScope.image}">
<div class="card">

<div class="image">
   <img src="${ images.chemin }">
</div>
<div class="title">
 <h1>
${ images.titre }</h1>
</div>
<div class="des">
 <p>${ images.description}</p>

</div>
</div>
</c:forEach>

 </c:otherwise>
 
</c:choose>
</div>
</body>
</html>
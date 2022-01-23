<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="<c:url value='style/designs.css'/>">
<title>Insert title here</title>
</head>
<body>
 <div class="img" >
       <img alt="logo" src="assets/images.jpg" height="200px" >
       
       </div>

<div class="form">

<p>S'inscrire c'est facile et rapide</p>
  <form method="post" action="#">
       <input  id="type" placeholder="type" name="type"   value="${   user.type}" type="text" readonly>
     <input id="nom" placeholder="nom" name="nom"   value="${   user.nom }" type="text">
      <span class="erreur">${ form.erreurs.nom }</span>
     <input id="prenom" placeholder="prenom" name="prenom"   value="${   user.prenom }" type="text">
     <input id="mail" placeholder="mail" name="mail"   value="${   user.mail}" type="text">
     <input  id="datnais" placeholder="date de naissance" name="datnais"   value="${   user.date_naiss} "type="text">
     <input id="password" placeholder="password" name="password" type="password">
     <input id="password_bis" placeholder="password_bis" name="password_bis" type="password">
     <input value="S'inscrire" type="submit">
  </form>
  <h5> En appuyant sur S’inscrire, vous acceptez nos Conditions générales, notre Politique d’utilisation des données et
   notre Politique d’utilisation des cookies. Vous recevrez peut-être des notifications par texto de notre part et vous 
   pouvez à tout moment vous désabonner. <h5>

 </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"  href="<c:url value='style/design.css'/>">
<title>Home</title>
</head>
<body>
<div class="img" >
       <img alt="logo" src="assets/images.jpg" height="200px" >
       
       </div>

<div class="form">

<p> Connectez-Vous a votre compter!!</p>
  <form method="post" action="#">
       <input  id="datnais" placeholder="login" name="login" type="text">
     <input id="mail" placeholder="mot de passe" name="password" type="password">
      <input value="Se connecter" type="submit">
  </form>
  <h5> En appuyant sur S’inscrire, vous acceptez nos Conditions générales, notre Politique d’utilisation des données et
   notre Politique d’utilisation des cookies. Vous recevrez peut-être des notifications par texto de notre part et vous 
   pouvez à tout moment vous désabonner. <h5>

 </div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link href="/gesalbum/style/style.css" rel="stylesheet">

<script src="/WebContent/js/script.js"></script>
<meta charset="ISO-8859-1">
<title>AlbumSheet</title>
</head>
<body>

      <c:choose>
         
 <c:when test = "${ empty type}">
   <nav class="nav">
  <div class="wrapper">

<div class="logo" style="padding-top: 8px; padding-right: 250px;">Album</div>

<div class="icons">

<div><i class='bx bx-home'></i></div>


<div class="btn">

<a href="/gesalbum/connection" class="btn1">Connexion</a>
<a href="/gesalbum/inscription" class="btn2">S'inscrire</a>

</div>



</div>
</div>

</nav>
          
 </c:when>
 <c:when test = "${ type.equals(\"utilisateur\")}">
  <nav class="nav">
  <div class="wrapper">
<div class="logo" style="padding-top: 8px; padding-right: 50px;"><a href="/gesalbum/listAlbum">Album</a></div>
<div class="logo" style="padding-top: 8px; padding-right: 50px;"><a href="addalbum">Ajouter un nouveau album</a></div>


<div class="icons">

<div><i class='bx bx-home' style='width: 25px'></i></div>
<div><i class='bx bx-heart'></i></div>


<div class="btn">

<a href="/gesalbum/connection" class="btn1"> ${ prenom }  ${ nom }</a>
<a href="/gesalbum/deconnection" class="btn2">Deconnection</a>


</div>



</div>
</div>

</nav>
          
s </c:when>
         
         
         
   <c:otherwise>
           <nav class="nav">

<div class="wrapper">

<div class="logo" style="padding-top: 8px; padding-right: 50px;"><a href="/gesalbum/listAlbum">Album</a></div>
<div class="logo" style="padding-top: 8px; padding-right: 50px;"><a href="/gesalbum/addalbum">Ajouter un nouveau album</a></div>
<div class="logo" style="padding-top: 8px; padding-right: 50px;"><a href="/gesalbum/listUsers">Utilisateurs</a></div>
<div class="logo" style="padding-top: 8px; padding-right: 50px;"><a href="/gesalbum/addadmin">creer un nouveau Admin</a></div>


<div class="icons">

<div><i class='bx bx-heart'></i></div>
<div><i class='bx bx-user'></i></div>

<div class="btn">

<a href="/gesalbum/connection" class="btn1">${ prenom }  ${ nom }</a>
<a href="/gesalbum/deconnection" class="btn2">Deconnection</a>


</div>



</div>
</div>

</nav>
         </c:otherwise>
      </c:choose>

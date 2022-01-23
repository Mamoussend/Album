<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="<c:url value='style/design.css'/>">
<title>Insert title here</title>
</head>
<body>


<h1 style="color:red" align="center">ADD IMAGE DETAIL</h1>
<div align="center">

<form action="" method="post" enctype="multipart/form-data">
<input id="nom" type="text" name="titre" placeholder="entrer le nom du titre"><br>
<input id="prenom" type="text" name="description" placeholder="faire une description"><br>
<input id="datenais" type="text" name="mots_cles" placeholder="entrer les mots cles separe par des virgules">
   Select Image :
   <input type="file" name="image">
   <input type="submit" value="Add Image">
</form>
</div>
</body>
</html>
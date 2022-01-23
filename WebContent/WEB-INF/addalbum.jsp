<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/gesalbum/style/styles.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<img alt="logo" src="assets/photos.png">
  <p>Creer votre Album </p>
<div class="forme">
    
     <form method="post" >
        <div class="formItem">
     <input id="nom" placeholder="nom" name="nom" type="text">
     </div>
        <div class="formItem">
     <input id="theme" placeholder="theme" name="theme" type="text">
        </div>
              <label >Choisir le type d'album:</label>
        <div class="formItem">

      <select  id="type"  name="type">
               <option value="public">public</option>
               <option value="prive">prive</option>
      </select>
      </div>
        <div class="formItem">
     <input value="Creer Album" type="submit">
     </div>
  </form>
</div>  
</body>
</html>
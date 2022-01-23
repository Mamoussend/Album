<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <meta charset="UTF-8">
        <title>Veuillez choisir les images à uploader.</title>
        
        <script type="text/javascript">
            /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img height="150" src="' + event.target.result + '" />';
                        imageList.appendChild( span );
                    });

                    reader.readAsDataURL( file );
                }
            }
        </script>
        <link rel="stylesheet"  href="<c:url value='style/design.css'/>">
    </head>
    <body style="text-align: center">
        
  <header>
            <h1>Veuillez choisir les images à uploader.</h1>
        </header>
        
        <form method="post" action="img" enctype="multipart/form-data">
            Fichiers sélectionnés : 
            <input     type="file" name="image" accept="image/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /> <br/>
            <input type="submit" value="Upload" /> <br/>        
         </form>
            <div id="list"></div>  
         </body>
</html>
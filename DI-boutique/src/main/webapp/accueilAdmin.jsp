<%-- 
    Document   : accueilAdmin
    Created on : May 20, 2020, 3:52:36 PM
    Author     : dlunhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de Admin</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h2>Bienvenue Admin</h2>
        <div id="products-container">
            <div class="products">
                <img src="img/homme1.jpg" class="logo" alt="homme1">
                <h3>Pour Lui</h3>
                <h6><a href='controler?idCategorie=1' >Voir catalogue</a></h6>
                <!--if admin : ajouter bouton modifier--> <h6><a href='controler?idCategorie=1' >Modifier catalogue</a></h6>
            </div>
            <div class="products">
                <img src="img/femme1.jpg" class="logo" alt="femme1">
                <h3>Pour Elle</h3>
                <h6><a href='controler?idCategorie=2' >Voir catalogue</a></h6>
                <!--if admin : ajouter bouton modifier--> <h6><a href='controler?idCategorie=2' >Modifier catalogue</a></h6>
            </div>
            <div class="products">
                <img src="img/enfant1.jpg" class="logo" alt="enfant1">
                <h3>Enfant</h3>
                <h6><a href='controler?idCategorie=3' >Voir catalogue</a></h6>
                <!--if admin : ajouter bouton modifier--> <h6><a href='controler?idCategorie=3' >Modifier catalogue</a></h6>
            </div>
            <div class="products">
                <img src="img/accessoire1.jpg" class="logo" alt="accessoire1">
                <h3>Accessoire</h3>
                <h6><a href='controler?idCategorie=4' >Voir catalogue</a></h6>
               <!--if admin : ajouter bouton modifier-->  <h6><a href='controler?idCategorie=3' >Modifier catalogue</a></h6>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

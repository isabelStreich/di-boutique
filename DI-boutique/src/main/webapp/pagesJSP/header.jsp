<%-- 
    Document   : accueil.jsp
    Created on : May 18, 2020, 8:43:22 AM
    Author     : dlunhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/css.css" />
        <title>Header</title>
    </head>
    <body>
        <div id="wrapper">
            <header>  
                <div>
                    <h1>DI - Boutique</h1>
                </div>
                <div id="search">
                    <div>  
                        <form action="actionController" method="post">
                            <input id="search"  type="search" placeholder="Rechercher" aria-label="Search"> 
                            <input type="text" name="controller" value="recherche" hidden>
                        </form>
                    </div>
                    <div>
                        <input type="submit" value="chercher">                        
                    </div>
                    <div>
                        <input type="submit" action="/action........." value="Mon Panier">
                    </div>
                </div> 
            </header> 
        </div>
        <!--Menu/nav-->
        <nav>
            <ul>
                <li><a class="active" href="accueil.jsp">Accueil</a></li>
                <li><a href="produits.jsp">Categorie</a></li>
                <li><a href="produit.jsp">Produit</a></li>
                <li><a href="login.jsp">S'inscrire</a></li>
            </ul>
        </nav>
    </body>
</html>

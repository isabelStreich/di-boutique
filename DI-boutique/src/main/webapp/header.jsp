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
                    <h1 class="logo" style="color:gray">DI - Boutique &reg;</h1>
                    <h2 style="color: blue">Bienvenue 
                        <%Cookie ck[] = request.getCookies();
                            if (ck != null) {
                                String user = ck[0].getValue();
                                if (!user.equals("") || user != null) {
                                    out.println("" + user);
                                }
                            }%>!!!</h2>
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
                        <input type="submit" action="/controler......" value="Mon Panier">
                    </div>
                </div> 
            </header> 
        </div>
        <!--Menu/nav-->
        <nav>
            <ul>
                <li><a class="active" href="accueil.jsp">Accueil</a></li>
                <li><a href='controler?idCategorie=1' >HOMME</a><li>
                <li><a href='controler?idCategorie=2' >FEMME</a><li>
                <li><a href='controler?idCategorie=3' >ENFANT</a><li>
                <li><a href='controler?idCategorie=4' >ACCESSOIRE</a><li>
                <li><a href="login.jsp">S'inscrire</a></li>                 
            </ul>
        </nav>
    </body>
</html>

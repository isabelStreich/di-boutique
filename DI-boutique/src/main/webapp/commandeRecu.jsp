<%-- 
    Document   : commandeRecu
    Created on : May 21, 2020, 5:28:11 PM
    Author     : istreich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <%@include file="header.jsp" %>
        <div>
            <fieldset>
                <h1>Merci pour votre achat!</h1>
                <h1>Votre commande a été enregistrée. </h1>
                <a href="accueil.jsp" style="color: black"><h5> Voulez-vous revenir à la page d'accueil?</h5></a>
            </fieldset>
        </div>


       

        <%@include file="footer.jsp" %>
    </body>
</html>

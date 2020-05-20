<%-- 
    Document   : accueil.jsp
    Created on : May 18, 2020, 12:51:11 PM
    Author     : dlunhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="pagesJSP/header.jsp" %>
        <div id="products-container">
            <div class="products">
                <img src="img/homme1.jpg" class="logo" alt="homme1">
                <h3>Pour Lui</h3>
                <a href="">Savoir plus</a>
            </div>
            <div class="products">
                <img src="img/femme1.jpg" class="logo" alt="femme1">
                <h3>Pour Elle</h3>
                <a href="">Savoir plus</a>
            </div>
            <div class="products">
                <img src="img/enfant1.jpg" class="logo" alt="enfant1">
                <h3>Enfant</h3>
                <a href="">Savoir plus</a>
            </div>
            <div class="products">
                <img src="img/accessoire1.jpg" class="logo" alt="accessoire1">
                <h3>Accessoire</h3>
                <a href="">Savoir plus</a>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

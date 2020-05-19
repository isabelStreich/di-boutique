<%-- 
    Document   : login.jsp
    Created on : May 18, 2020, 10:30:00 AM
    Author     : dlunhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/css.css" />
        <title>Login</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="Connexion" style="width: 75%;">

            <h2>Se connecter</h2> <br/> 

            <form action="actionController" method="post">
                <div style="margin: 50px;">
                    <% if (request.getParameter("authentification") != null && request.getParameter("authentification").equals("incorrecte")) {%>
                    <p style="color: red;text-align: left;">Attention! Votre email ou password n'est pas correcte.</p>
                    <%}%>
                    <% if (request.getParameter("authentification") != null && request.getParameter("authentification").equals("unchecked")) {%>
                    <p style="color: red;">Attention! Votre email ou password n'est pas valide.</p>
                    <%}%>

                    <div>
                        <input type="email" name="email" value="dlunhu@gmail.com" required /><br/>
                    </div>
                    <div>
                        <input type="password" name="password" value="dl" required/><br/>
                    </div>
                    <div>
                        <input type="submit" name="controller" value="login" style="background-color: #696969;"/>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

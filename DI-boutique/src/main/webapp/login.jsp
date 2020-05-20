<%-- 
    Document   : login.jsp
    Created on : May 18, 2020, 10:30:00 AM
    Author     : dlunhu
--%>
<%
    boolean isAdmin = true;
    String nom = "admin";
%>
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

            <form action="loginServlet" method="post">
                <div style="margin: 50px;">

                    <input type="hidden" name="page" value="login-form">
                    <h4>Login : </h4> <br> 
                    <input type="email" name="email" placeholder="Login" required /><br/>

                    <h4>Password : </h4> <br>                  
                    <input type="password" name="password" placeholder="Password" required/><br/>

                    <input type="submit" name="loginServlet" value="Se connecter" style="background-color: #696969;"/>
                    <div>
                    <a href="loginServlet" style="color:gray">S'inscrire</a>
                    </div>
                    <br>

                </div>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>




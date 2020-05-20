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

            <form action="produitController" method="post">
                <div style="margin: 50px;">

                    <input type="hidden" name="page" value="login-form">
                    <h4>Login : </h4> <br>
                    <input type="email" name="email" placeholder="Login" value="dlunhu@gmail.com" required /><br/>

                    <h4>Password : </h4> <br>                  
                    <input type="password" name="password" laceholder="Password" value="dl" required/><br/>

                    <input type="submit" name="controller" value="Se connecter" style="background-color: #696969;"/>
                    <br>

                    <h4><a href="produitController?page=logout" style="color: #696969;">Se déconnecter</a></h4>

                    <!--<h4> <a href="controllerServlet?page=sign-up" value="Créer un compte" style="color:#696969;"> Click here for new user</a> </h4>-->

                    <!--<h4><%=(isAdmin ? "Bonjour " + nom : "")%></h4>-->
                </div>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>




<%-- 
    Document   : login.jsp
    Created on : May 18, 2020, 10:30:00 AM
    Author     : dlunhu
--%>
<%@page import="entities.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.management.relation.Role"%>
<%@page import="java.lang.String"%>


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
        <div id="products-container">       
            <form action="loginServlet" method="post">
                <input type="hidden" name="page" value="login-form">
                <div class="products">

                    <fieldset> 
                        <legend><h2>Connexion</h2></legend>
                        <h4>Login : </h4> 
                        <input type="email" name="email" placeholder="Login" required /><br/>
                        <h4>Password : </h4>               
                        <input type="password" name="password" placeholder="Password" required/><br/>
                        
                        <h4><input type="submit" name="loginServlet" value="Connexion" style="background-color: #696969;"/></h4>
                       
                        <h4><a href="formulaire.jsp" style="background-color: #696969;"/>FOR NEW USER</a></h4>
                    </fieldset>
                </div>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>




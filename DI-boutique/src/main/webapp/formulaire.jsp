<%-- 
    Document   : formulaire
    Created on : May 20, 2020, 11:04:06 AM
    Author     : istreich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulaire</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div id="products-container"> 
            <form action="loginServlet" method="post">
                <div class="products">
                    <input type="hidden" name="page" value="login-form">
                    <fieldset> 
                        <legend><h2>Formulaire</h2></legend>
                        <label> Nom : <input type="text" name="nomUser"></label><br><br>
                        <label> Email :<input type="text" name="email"></label> <br><br>
                        <label> Password :<input type="text" name="password"></label><br><br>
                        <select name='idRole'>
                            <option disabled required>Faire le choix :</option>
                            <option value="1">Admin</option>
                            <option value="2">User</option>
                        </select>
                        <h4><input type="submit" name="loginServlet" value="Soumettre" style="background-color: #696969;"/></h4>
                    </fieldset>
                </div>
            </form> 
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

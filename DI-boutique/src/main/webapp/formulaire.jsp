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
                        <input type="text" name="nomUser" placeholder="Nom" required><br><br>
                        <input type="text" name="email" placeholder="Email" required><br><br>
                        <input type="text" name="password"placeholder="Password"required><br><br>
                        Vous êtes :
                        <select name='idRole'required>
                            <option value="2">User</option>
                            <option value="1">Admin</option>                           
                        </select>
                        <h4><input type="submit" name="loginServlet" value="Soumettre" style="background-color: #696969;"/></h4>
                    </fieldset>
                </div>
            </form> 
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

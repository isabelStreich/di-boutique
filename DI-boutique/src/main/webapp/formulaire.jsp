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
        <title>JSP Page</title>
    </head>
    <body>
<!--         private int idUser;
    private String nomUser;
    private String email;
    private String password;
    private int idRole;-->

<form action="loginServlet" method='post'>
    <label> Nom : <input type="text" name="nomUser"></label> 
<label> Email :<input type="text" name="email"><label> 
<label> Password :<input type="text" name="password"><label> 
<select name='idRole'>
    <option value="1">Admin</option>
    <option value="2">User</option>
    
</select>
</form>

    </body>
</html>

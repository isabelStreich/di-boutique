<%-- 
    Document   : logout
    Created on : May 22, 2020, 7:13:34 AM
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
        <form>
            <fieldset>
                <input type="hidden" name="page" value="logout">
                <h2>LogOut Fait!</h2>
            </fieldset>
        </form>



        <%@include file="footer.jsp" %>
    </body>
</html>

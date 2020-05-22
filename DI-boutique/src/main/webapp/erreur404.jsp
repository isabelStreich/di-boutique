<%-- 
    Document   : erreur404
    Created on : May 20, 2020, 12:54:11 AM
    Author     : dlunhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur 404</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <fieldset>
            <div>
                <h1 style="color:red">...Oops....erreur HTTP 404</h1>
                <h1 style="color:gray">Désolé. Page non trouvé!</h1>
            </div>
        </fieldset>

        <%@include file="footer.jsp" %>
    </body>
</html>

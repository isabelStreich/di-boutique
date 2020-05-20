<%-- 
    Document   : produit
    Created on : May 19, 2020, 5:50:50 PM
    Author     : istreich
--%>

<%@page import="manager.ProduitManager"%>
<%@page import="entities.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String produitId = request.getParameter("idProduit");
    Produit produit = ProduitManager.getById(Integer.parseInt(produitId));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1> <%= produit.getNomProduit()%></h1>
            <div>
                <img src='img/<%=produit.getImageProduit()%>'/>
                <h2> <</h2>
                <fieldset>
                    <p>Description: <%=produit.getDescriptionProduit()%></p>
                </fieldset>
            </div>
        </div>
    </body>
</html>

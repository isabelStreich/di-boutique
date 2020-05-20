<%-- 
    Document   : categorie
    Created on : May 19, 2020, 4:38:37 PM
    Author     : istreich
--%>

<%@page import="manager.ProduitManager"%>
<%@page import="entities.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% String categorieId = request.getParameter("idCategorie");
            ArrayList<Produit> produits = ProduitManager.getByCategorie(Integer.parseInt(categorieId));
        %>
        <div id="products-container">
            <div class="" style="width: 50%; display: flex;">
                <!--affichage de tous les produits de la categorie-->
                <%for (Produit p : produits) {%>
                <h1><%= p.getNomProduit()%></h1>
                <h3><%= p.getDescriptionProduit()%></h3>
                <img src='img/<%=p.getImageProduit()%> '/> 
                <h3><%=p.getPrixProduit()%></h3>
                <h3><%= p.getIdProduit()%></h3>
                <%}%>
            </div>
            <%@include file="footer.jsp" %>
    </body>
</html>

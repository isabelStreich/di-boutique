<%-- 
    Document   : produit
    Created on : May 19, 2020, 5:50:50 PM
    Author     : istreich
--%>

<%@page import="entities.Categorie"%>
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
        <title>Detail du produit</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div id="products-container">
            <div class="products" style="width:40%;">
                <h2> <%= produit.getNomProduit()%></h2>
                <img src='img/<%=produit.getImageProduit()%>'/>
                <h3>Description: <%=produit.getDescriptionProduit()%></h3>
                <h2> Prix : <%=produit.getPrixProduit()%> CAD</h2>
                <a href='accueil.jsp' type="submit">RETOUR</a>   
                <a href='controler' >Ajouter au panier</a>
                <!--if admin : ajouter bouton modifier-->
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

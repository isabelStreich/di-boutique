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
        <title>Catalogue</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% String categorieId = request.getParameter("idCategorie");
            ArrayList<Produit> produits = ProduitManager.getByCategorie(Integer.parseInt(categorieId));
        %>
        <div id="products-container">
            <div class="products" style="width:40%;">
                <!--affichage de tous les produits de la categorie-->
                <h1 style=" font-family: Verdana, Geneva, Tahoma, sans-serif; color: grey;"> CATALOGUE DES PRODUITS</h1>
                <%for (Produit p : produits) {%>               
                <h2><%= p.getNomProduit()%></h2> <br>
                <img src='img/<%=p.getImageProduit()%>' class="logo"/>  <br>               
                <a href='produit.jsp<%=(request.getParameter("produitId") == null ? "?idProduit=" + p.getIdProduit() : "")%>'><%=(request.getParameter("produitId") == null ? "Detail du produit" : "Retour")%></a>
                <a href="panierController?page=debutPanier&idProduit=<%=p.getIdProduit()%>">Ajouter au panier</a>                
                <br><br><br><br>                
                <%}%>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

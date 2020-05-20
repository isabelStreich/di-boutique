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
        <% String categorieId = request.getParameter("idCategorie");
            ArrayList<Produit> produits = ProduitManager.getByCategorie(Integer.parseInt(categorieId));
        %>

        <%
            //affichage de tous les produits de la categorie
            for (Produit p : produits) {
                out.println("<tr>");
                out.println("<td>" + p.getNomProduit() + "</td>");
                out.println("<td>" + p.getDescriptionProduit() + "</td>");
                out.println("<td><img src='img/" + p.getImageProduit() + "'/></td>");
                out.println("<td>" + p.getPrixProduit() + "</td>");
                out.println("<td>" + p.getIdProduit() + "</td>");
                out.println("</tr>");
            }
        %>
    </body>
</html>

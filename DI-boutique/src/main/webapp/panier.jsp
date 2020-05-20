<%-- 
    Document   : panier
    Created on : May 20, 2020, 4:54:43 PM
    Author     : istreich
--%>

<%@page import="entities.DetailCommande"%>
<%@page import="manager.ProduitManager"%>
<%@page import="entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Produit p = new Produit();
    DetailCommande detailCommande = new DetailCommande();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div>
            <input type="hidden" name="page" value="debutPanier">
            <table>
                <tr>
                    <th> Produit </th>  
                    <th> Quantité </th> 
                    <th> Enlever </th>
                    <th> Ajouter </th> 
                    <th> Prix </th>  
                </tr>
                <tr>
                    <td><%p.getNomProduit();%></td>
                    <td><%detailCommande.getQuantite();%></td>
                    <td><input type="submit" value="-">  </td>
                    <td><input type="submit" value="+"> </td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
                   <input type="hidden" name="page" value="FinPanier">
        <%@include file="footer.jsp" %>
    </body>
</html>

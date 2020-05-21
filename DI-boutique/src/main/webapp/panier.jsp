<%-- 
    Document   : panier
    Created on : May 20, 2020, 4:54:43 PM
    Author     : istreich
--%>

<%@page import="manager.PanierManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Commande"%>
<%@page import="manager.SessionManager"%>
<%@page import="entities.DetailCommande"%>
<%@page import="manager.ProduitManager"%>
<%@page import="entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Commande c = (Commande) SessionManager.getByKey(request, false, "panier");
    ArrayList<DetailCommande> dcs = PanierManager.getPanierDetail(c.getIdCommande());
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
           
            <form action="panierController" method="post">
                
                <table>
                    <tr>
                        <th> Produit </th>  
                        <th> Quantité </th> 
                        <th> Enlever </th>
                        <th> Ajouter </th> 
                        <th> Prix </th>  
                    </tr>
                    <%for (DetailCommande dc : dcs){%>
                    <tr>
                        <td><%= dc.getIdProduit()%></td>
                        <td><%= dc.getQuantite()%></td>
                        <td><input type="submit" value="-"></td>
                        <td><input type="submit" value="+"></td>
                        <td><%= dc.getPrixProduit()%></td>
                    </tr>
                    <%}%>
                    <tr>
                        <td> </td>
                        <td> </td>
                        <td> </td>
                        <td>Total : </td>
                        <td><%= PanierManager.getByPrixCommande(c.getIdCommande()) %> </td>
                    </tr>
                    
                </table>
                    <input type="hidden" name="page" value="finPanier">
                        <input type="submit" value="Soumettre">
                </div>
            </form>

            
            </body>
            <%@include file="footer.jsp" %>
            </html>

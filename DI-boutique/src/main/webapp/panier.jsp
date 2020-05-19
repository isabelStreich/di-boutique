<%-- 
    Document   : panier.jsp
    Created on : May 18, 2020, 11:30:19 AM
    Author     : dlunhu
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div>   

            <% if (request.getAttribute("panier") != null) {
                    HashMap<Produit, Integer> listePanier = (HashMap<Produit, Integer>) request.getAttribute("panier");
                    Iterator listeDesProduitPanier = listePanier.keySet().iterator();%>    

            <div style="width: 60%; background-color: white; text-align: center;">
                <%while (listeDesProduitPanier.hasNext()) {
                        Produit produit = (Produit) listeDesProduitPanier.next();
                %>
                <div>
                    <h4><%= produit.getNomProduit()%></h4>
                    <h4><%= listePanier.get(produit)%></h4>
                    <h4><%= listePanier.get(produit) * produit.getPrixProduit()%>$</h4>

                    <h4>
                        <a href="actionController?controller=panier&action=remove&id_produit=<%= produit.getIdProduit()%>">
                            <img src="img/remove_icon.png" alt="enlever produit" style="width:42px; height: 31px; "/>
                        </a>
                    </h4>
                </div>
                <%}%>
            </div>

            <%}%>

        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>

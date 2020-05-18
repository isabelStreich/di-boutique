<%-- 
    Document   : produits.jsp
    Created on : May 18, 2020, 5:05:28 PM
    Author     : dlunhu
--%>

<%@page import="java.util.HashMap"%>
<%@page import="entities.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Produit"%>

<%
    Produit produit = (Produit) request.getAttribute("produit");
    ArrayList<Categorie> categorie = (ArrayList<Categorie>) request.getAttribute("listCategorie");
    HashMap<String, Integer> nbJaime = (HashMap<String, Integer>) request.getAttribute("nbJaime");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produits</title>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <ul>
            <li><a href='produitControler' ></a></li>
                <% for (Categorie cat : categorie) {%>
            <li> <a href='produitControler?idCategorie=<%=cat.getImageCategorie()%>' ><%=cat.getNomCategorie()%></a>                
            </li> 
            <%}%>
        </ul>            

        <!--afficher les produits-->

        <h2>Liste des produits</h2>
        <section>
            <%for (Produit produit : produits) {%>
            <%@include file="includes/produitItems.jsp" %>
            <%}%>
        </section>
        <%@include file="footer.jsp" %>
    </body>
</html>  


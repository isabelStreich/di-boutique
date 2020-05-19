<%-- 
    Document   : animals
    Created on : May 6, 2020, 12:31:26 p.m.
    Author     : jlidou
--%>

<%@page import="managers.JaimeAnimalManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javabean.Animal"%>
<%@page import="javabean.Categorie"%>
<%
    Animal animal = (Animal) request.getAttribute("animal");
    ArrayList<Categorie> categorie = (ArrayList<Categorie>) request.getAttribute("listCategorie");
    HashMap<String, Integer> nbJaime = (HashMap<String, Integer>) request.getAttribute("nbJaime");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <%@include file="header.jsp" %>
        <!--afficher les categorie-->
        <nav>
            <ul>
                <li><a href='animalControler' >Catalogue</a></li>
                    <% for (Categorie cat : categorie) {%>
                <li>
                    <a href='animalControler?idCat=<%=cat.getId()%>' ><%=cat.getNom()%></a>                
                </li>
                <%}%>
            </ul>            
        </nav>
        <!--//afficher les animaux-->
        <section>
            <!--<h1>Liste des animaux</h1>-->            
            <%@include file="includes/animalItems.jsp" %> 

        </section>
        <%@include file="footer.jsp" %>
    </body>
</html>
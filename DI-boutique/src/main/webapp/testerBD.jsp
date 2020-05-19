<%-- 
    Document   : testerBD
    Created on : May 19, 2020, 9:12:12 AM
    Author     : istreich
--%>

<%@page import="manager.ProduitManager"%>
<%@page import="manager.CategorieManager"%>
<%@page import="action.ProduitAction"%>
<%@page import="entities.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//     Produit produit = (Produit) request.getAttribute("produit");
//     ProduitAction.afficherTousLesProduit(request);
//   
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   
        
        
    </head>
    <body>
           <%
//ArrayList<Categorie> categorie = CategorieManager.getAllCategorie();
//for (int i=0;i<categorie.size();i++)
//{
//   out.println("<tr>");
//   out.println("<td>"+categorie.get(i).getIdCategorie()+"</td>");
//   out.println("<td>"+categorie.get(i).getNomCategorie()+"</td>");
//   out.println("<td><img src='img/"+categorie.get(i).getImageCategorie()+"'/></td>");
//  
//   out.println("</tr>");
//}

//
//ArrayList<Produit> produit =ProduitManager.getAll();
//for (int i=0; i<produit.size();i++){
//     out.println("<tr>");
//   out.println("<td>"+produit.get(i).getNomProduit()+"</td>");
//   out.println("<td>"+produit.get(i).getDescriptionProduit()+"</td>");
//   out.println("<td><img src='img/"+produit.get(i).getImageProduit()+"'/></td>");
//   out.println("<td>"+produit.get(i).getPrixProduit()+"</td>");
//   out.println("<td>"+produit.get(i).getIdProduit()+"</td>");
// 
//   out.println("</tr>");
//    
//    
//}

Produit prod = ProduitManager.getById(1);
   out.println("<tr>");
   out.println("<td>"+prod.getNomProduit()+"</td>");
   out.println("<td>"+prod.getDescriptionProduit()+"</td>");
   out.println("<td><img src='img/"+prod.getImageProduit()+"'/></td>");
   out.println("<td>"+prod.getPrixProduit()+"</td>");
   out.println("<td>"+prod.getIdProduit()+"</td>");
 
   out.println("</tr>");

%>
    </body>
</html>

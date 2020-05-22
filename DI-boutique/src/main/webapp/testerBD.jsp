<%-- 
    Document   : testerBD
    Created on : May 19, 2020, 9:12:12 AM
    Author     : istreich
--%>

<%@page import="entities.DetailCommande"%>
<%@page import="java.time.Instant"%>
<%@page import="java.util.Date"%>
<%@page import="entities.Commande"%>
<%@page import="manager.PanierManager"%>
<%@page import="entities.User"%>
<%@page import="manager.UserManager"%>
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
//
//Produit prod = ProduitManager.getById(1);
//   out.println("<tr>");
//   out.println("<td>"+prod.getNomProduit()+"</td>");
//   out.println("<td>"+prod.getDescriptionProduit()+"</td>");
//   out.println("<td><img src='img/"+prod.getImageProduit()+"'/></td>");
//   out.println("<td>"+prod.getPrixProduit()+"</td>");
//   out.println("<td>"+prod.getIdProduit()+"</td>");
// 
//   out.println("</tr>");

//User user = UserManager.getUser("admin@gmail.com");
//
//
//   out.println("<tr>");
//   out.println("<td>"+user.getEmail()+"</td>");
//   out.println("<td>"+user.getNomUser()+"</td>");
//   out.println("<td>"+user.getIdRole()+"</td>");
//   out.println("<td>"+UserManager.authenticateUser("admin@gmail.com", "admin")+"</td>");
//   out.println("</tr>");
//PanierManager.createdPanier(1, 5000);
//ArrayList<Commande> comandes = PanierManager.getAllPanier(1);
//
//for(Commande c :comandes){
//    out.println("<tr>");
//   out.println("<td>"+c.getIdCommande()+"</td>");
//   out.println("<td>"+c.getIdUser()+"</td>");
//   out.println("<td>"+c.getMontantCommande()+"</td>");
//  
//   out.println("<td>"+c.isIsOpenPanier()+"</td>");
//   out.println("</tr>");
//}
//DetailCommande dc = new DetailCommande();
//dc.setIdCommande(1);
//dc.setIdProduit(1);
//dc.setPrixProduit(100);
//dc.setQuantite(2);
//PanierManager.AddTOPanier(dc);
//ArrayList<DetailCommande> dcs = PanierManager.getPanierDetail(dc.getIdCommande());
//
//for(DetailCommande dc1 : dcs){
//    out.println("<h1>Detalle de la commande </h1>");
//   out.println("<tr>");
//   out.println("<td>"+dc1.getIdCommande()+"</td>");
//   out.println("<td>"+dc1.getIdProduit()+"</td>");
//   out.println("<td>"+dc1.getPrixProduit()+"</td>");
//   out.println("<td>"+dc1.getQuantite()+"</td>");
//   out.println("</tr>");
//}
User isa = UserManager.getUser("isabelstreich@gmail.com");
    out.println("<h1>Detalle isa </h1>");
   out.println("<tr>");
   out.println("<td>"+isa.getEmail()+"</td>");
   out.println("<td>"+isa.getNomUser()+"</td>");
   out.println("<td>"+isa.getPassword()+"</td>");
   out.println("</tr>");
%>




    </body>
</html>

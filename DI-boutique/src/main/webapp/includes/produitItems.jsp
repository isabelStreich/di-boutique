<div>    
    <h2><%=produit.getNom()%></h2>       
    <img src='img/<%=produit.getImgName()%>' />              
    <a href='animalControler<%=(request.getParameter("id") == null ? "?id=" + produit.getId() : "")%>'><%=(request.getParameter("id") == null ? "Afficher" : "Retour")%></a><br />
    <!--//dans le nb j aime recupere le nombre-->
    <!--jaime ?-->
    <%

        Integer valueJaime = 0;
        if (nbJaime.containsKey(produit.getNom())) {
            valueJaime = nbJaime.get(produit.getNom());
        }

    %>

    Nombre de J'Aimee : <%=valueJaime%> <a href="produitControler?id=<%=produit.getId()%>&action=jaime">j'aime</a>
    <!-- // ==  < % =    dans le code de dessous-->
    <!--Nombre de J aime : //(nbJaime.containsKey(animal.getNom()) ? nbJaime.get(animal.getNom()) : "0"  )// <a href="animalControler?id=//animal.getId()//&action=jaime">j aime</a>--> 


</div>   
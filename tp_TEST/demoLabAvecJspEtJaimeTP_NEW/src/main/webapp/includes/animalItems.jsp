<div class="animal">    
    <h1><%=animal.getNom()%></h2>       
        <img src='img/<%=animal.getImgName()%> '/> 
        <h2><a href='animalControler<%=(request.getParameter("id") == null ? "?id=" + animal.getId() : "")%>'><%=(request.getParameter("id") == null ? "Afficher" : "Retour")%></a></h2>

        <h2><a href='animalControler' >Ajouter au panier</a></h2>
        <!--//dans le nb j aime recupere le nombre-->
        <!--jaime ?-->
        <%

            Integer valueJaime = 0;
            if (nbJaime.containsKey(animal.getNom())) {
                valueJaime = nbJaime.get(animal.getNom());
            }

        %>

        <h3><%=valueJaime%> <a href="animalControler?id=<%=animal.getId()%>&action=jaime">j'aime</a></h3>
        <!-- // ==  < % =    dans le code de dessous-->
        <!--Nombre de J aime : //(nbJaime.containsKey(animal.getNom()) ? nbJaime.get(animal.getNom()) : "0"  )// <a href="animalControler?id=//animal.getId()//&action=jaime">j aime</a>--> 


</div>   
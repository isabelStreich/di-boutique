/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import static controler.LoginServlet.getCookie;
import entities.Commande;
import entities.DetailCommande;
import entities.Produit;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.PanierManager;
import manager.ProduitManager;
import manager.SessionManager;
import manager.UserManager;

/**
 *
 * @author istreich
 */
@WebServlet(name = "PanierController", urlPatterns = {"/panierController"})
public class PanierControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String page = request.getParameter("page");
        
        if (page.equals("debutPanier")) {
            //        ***********************************************************************
            //recuperar idProduit
            String produitId = request.getParameter("idProduit");
            
            int idProduit = Integer.parseInt(produitId);
            
            String email = getCookie("user", request.getCookies()).getValue();
            User userLoggedIn = UserManager.getUser(email);
            
            ArrayList<Commande> commandes = PanierManager.getAllPanier(userLoggedIn.getIdUser());

            boolean panierFound = false;
            Commande maCommande = null;
            for (Commande c : commandes) {
                if (c.isIsOpenPanier()) {
                    panierFound = true;
                    maCommande = c;
                    break;
                }
            }
            
            if (!panierFound) {
                // no hay que crear un panier siempre...
                int commandeCreated = PanierManager.createdPanier(userLoggedIn.getIdUser(), 0);
                 maCommande = PanierManager.getByIdCommande(commandeCreated);
            }

            Produit p = ProduitManager.getById(idProduit);
            
            //mettre le panier dans la session
            SessionManager.add(request, true, "panier", maCommande);
            DetailCommande detailCommande = new DetailCommande();
            detailCommande.setIdCommande(maCommande.getIdCommande());
            detailCommande.setIdProduit(idProduit);
            detailCommande.setQuantite(1);
            detailCommande.setPrixProduit(p.getPrixProduit());
            PanierManager.AddTOPanier(detailCommande);
            request.getRequestDispatcher("panier.jsp").forward(request, response);
        }
        
        if(page.equals("finPanier")){
            //fermer le panier et apeller a PAnierManager
            Commande panier = (Commande) SessionManager.getByKey(request, false, "panier");
            PanierManager.closePanier(panier.getIdCommande());
            //sacar el panier de session y poner uno nuevo
//            Commande panierNew = new Commande ();
//            panierNew
            //redirectionar a una pag en la cual affiche el mensaje de: commande recu
             request.getRequestDispatcher("commandeRecu.jsp").forward(request, response);
        }
        
        
        
        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PanierControler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PanierControler at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

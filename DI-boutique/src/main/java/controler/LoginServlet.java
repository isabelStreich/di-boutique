/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import action.UserAction;
import entities.Commande;
import entities.DetailCommande;
import entities.Produit;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manager.PanierManager;
import manager.ProduitManager;
import manager.SessionManager;
import manager.UserManager;

/**
 *
 * @author istreich
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //verification

        String page = request.getParameter("page");

        User userToCheck = null;

        if (page.equals("login-form")) {
            // borrar el cookie
            if (request.getParameter("email") == null && page.equals("login-form")) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            userToCheck = UserManager.getUser(email);

            if (UserManager.authenticateUser(email, password)) {

                Cookie c = new Cookie("user", userToCheck.getEmail());
                c.setMaxAge(60 * 60 * 24 * 365);
                response.addCookie(c);
                if (userToCheck.getIdRole() == 1) {
                    request.getRequestDispatcher("accueilAdmin.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("accueil.jsp").forward(request, response);
                }

            } else {
                request.getRequestDispatcher("formulaire.jsp").forward(request, response);
                return;
            }
        }

        if (page.equals("debutPanier")) {
            //        ***********************************************************************
            //recuperar idProduit
            String produitId = request.getParameter("idProduit");
            
            int idProduit = Integer.parseInt(produitId);
            
            String email = getCookie("user", request.getCookies()).getValue();
            User userLoggedIn = UserManager.getUser(email);
            
            // no hay que crear un panier siempre...
            PanierManager.createdPanier(userLoggedIn.getIdUser(), 0);
            
            ArrayList<Commande> commandes = PanierManager.getAllPanier(userLoggedIn.getIdUser());

            Commande maCommande = null;
            for (Commande c : commandes) {
                if (c.isIsOpenPanier()) {
                    maCommande = c;
                    break;
                }
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

//        ***********************************************************************
////            FORMULAIRE
// if (page.equals("inscription")){
//        String nomUser = request.getParameter("nomUser");
////        String idRole = request.getParameter("idRole");
//        String action = request.getParameter("action");
//
//        if (action != null && action.equals("add")) {
//            UserAction.addUser(request, new User(-1, nomUser, email, password, 2));
//
//        }
// }
//        email
//        password
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public static Cookie getCookie(String name, Cookie[] cookies) {
        for (Cookie c : cookies) {
            if(c.getName().equals(name)) {
                return c;
            }
        }
        return null;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

<<<<<<< HEAD
import entities.User;
import java.io.IOException;
=======
import action.UserAction;
import entities.Commande;
import entities.DetailCommande;
import entities.Produit;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
>>>>>>> 9fa45615bdae3dab6fdcf12f3edd0141ff71c982
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;
import manager.PanierManager;
import manager.ProduitManager;
>>>>>>> 9fa45615bdae3dab6fdcf12f3edd0141ff71c982
import manager.SessionManager;
import manager.UserManager;
import static manager.UserManager.addUser;
import service.ConnectionBD;

/**
 *
 * @author istreich
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //verification
<<<<<<< HEAD
        // borrar el cookie
        //getParam
        String url = "login.jsp";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nomUser = request.getParameter("nomUser");
        String idRole = request.getParameter("idRole");

        //Traitement
        //
//        if ((email.equals("email")) && (password.equals("password")) && (idRole.equals("idRole"))) {
//            url = "accueilAdmin.jsp";
//        } else if ((email.equals("email")) && (password.equals("password"))) {
//            url = "accueil.jsp";
//        }
//        if ((email.equals("email")) && (password.equals("password")) && (nomUser.equals("nomUser")) && (idRole.equals("idRole"))) {
//            User u = new User();
//            u.setNomUser(nomUser);
//            u.setEmail(email);
//            u.setPassword(password);
//            u.setIdRole(Integer.parseInt(idRole));
//           // SessionManager.add(request, true, url, u);
//            request.getRequestDispatcher("accueil.jsp").forward(request, response);
//        }
        if (UserManager.authenticateUser(email, password)) {
            User userToCheck = UserManager.getUser(email);
            Cookie c = new Cookie("user", userToCheck.getEmail());
            c.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(c);
            if (userToCheck.getIdRole() == 1) {
                url = "accueilAdmin.jsp";
            } else {
                url = "accueil.jsp";
            }
        } else {
            url = "formulaire.jsp";
=======

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

//        ***********************************************************************
////            FORMULAIRE
 if (page.equals("inscription")){
        String nomUser = request.getParameter("nomUser");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String idRole = request.getParameter("idRole");
        String action = request.getParameter("action");
        
        User newUser= new User ();
        newUser.setNomUser(nomUser);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setIdRole(Integer.parseInt(idRole));
        
        if (action != null && action.equals("add")) {

            UserManager.addUser(newUser);
       

        }
 }
//        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenue " + request.getContextPath() + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
>>>>>>> 9fa45615bdae3dab6fdcf12f3edd0141ff71c982
        }
        //Redirect
        request.getRequestDispatcher(url).forward(request, response);
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

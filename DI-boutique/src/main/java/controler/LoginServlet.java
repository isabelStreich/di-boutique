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

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            userToCheck = UserManager.getUser(email);

            if (UserManager.authenticateUser(email, password)) {

                Cookie c = new Cookie("user", userToCheck.getEmail());
                c.setMaxAge(60 * 60 * 24 * 60);
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
        if (page.equals("logout")) {

            Cookie ck = getCookie("user", request.getCookies());
            ck.setMaxAge(0);
            response.addCookie(ck);
            request.getRequestDispatcher("logout.jsp").forward(request, response);
        }
////            FORMULAIRE
        if (page.equals("inscription")) {
            String nomUser = request.getParameter("nomUser");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String idRole = request.getParameter("idRole");
            String action = request.getParameter("action");

            User newUser = new User();
            newUser.setNomUser(nomUser);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setIdRole(Integer.parseInt(idRole));
            UserManager.addUser(newUser);
            //agregar el cookie
            Cookie userCookie = new Cookie("user", email);
            response.addCookie(userCookie);
            request.getRequestDispatcher("accueil.jsp").forward(request, response);
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
        }
    }

    public static Cookie getCookie(String name, Cookie[] cookies) {
        for (Cookie c : cookies) {
            if (c.getName().equals(name)) {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.SessionManager;
import manager.UserManager;

/**
 *
 * @author istreich
 */
@WebServlet(name = "Controler", urlPatterns = {"/controler"})
public class Controler extends HttpServlet {

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

        request.getRequestDispatcher("categorie.jsp").forward(request, response);

        //LOGOUT TRAITEMENT
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String action = request.getParameter("action");

        String urlRedirection = "erreur404.jsp";

        //traitement
        if (action != null && action.equals("logout")) {
            SessionManager.destroy(request, false);

        } else if (action != null && action.equals("email")) {
            User uToCheckUser = new User(email, password, "");
            User ufromManager = UserManager.checkUser(uToCheckUser);
            if (ufromManager != null) {
                SessionManager.add(request, true, "user", ufromManager);
                urlRedirection = "accueil.jsp";
            }
        }
        //redirection
        //request.getRequestDispatcher(urlRedirection).forward(request, response);
    }

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

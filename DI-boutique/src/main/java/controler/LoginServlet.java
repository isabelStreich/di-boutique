/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        }
        //Redirect
        request.getRequestDispatcher(url).forward(request, response);
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

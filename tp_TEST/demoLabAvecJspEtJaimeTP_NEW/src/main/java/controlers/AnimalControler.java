/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javabean.Animal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.AnimalManager;
import managers.CategorieManager;
import managers.JaimeAnimalManager;

/**
 *
 * @author jlidou
 */
@WebServlet(name = "AnimalControler", urlPatterns = {"/animalControler"})
public class AnimalControler extends HttpServlet {

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

        String url = "";
        // 1 recuperation
        String idCat = request.getParameter("idCat");
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        //2 traitement
        if (idCat != null) { // affiche les animaux par categorie
            ArrayList<Animal> animals = AnimalManager.getByIdCat(Integer.parseInt(idCat));
            request.setAttribute("listAnimal", animals);
            url = "animals.jsp";
        } else if (id != null) { //affiche un animal par id
            int idAnimal = Integer.parseInt(id);
            Animal animal = AnimalManager.getById(idAnimal);
            if (action != null) {
                //ajouter un j aime au manager
                    //recuperer l animal par son iid
                    //j aoute un j aime pour cet animal qui cet Id
                JaimeAnimalManager.add(animal.getNom());
            }            
            request.setAttribute("animal", animal);
            url = "animal.jsp";
        } else { // affiche tous les animaux
            ArrayList<Animal> animals = AnimalManager.getAll();
            request.setAttribute("listAnimal", animals);
            url = "animals.jsp";
        }
        //ajouter les categories dans la requette
        request.setAttribute("listCategorie", CategorieManager.getAll());
        //doit ajouter le hashMapde jaime a la requette
        request.setAttribute("nbJaime", JaimeAnimalManager.getNombreDeJaime());

        //3 redirection
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

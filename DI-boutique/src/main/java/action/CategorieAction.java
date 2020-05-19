/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import entities.Categorie;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import manager.CategorieManager;

/**
 *
 * @author istreich
 */
public class CategorieAction {
    
    public static final String listeCategorie = "liste_Categorie";
    
    public static void afficherTousLesCategories (HttpServletRequest request){
       ArrayList<Categorie>liste_Categorie = CategorieManager.getAllCategorie();
        
       request.setAttribute(listeCategorie,liste_Categorie);
       
    }
    public static void affichierCategoriesById (HttpServletRequest request, int categorieId){
        ArrayList<Categorie>liste_Categorie = CategorieManager.getByIdCategorie(categorieId);
        
        request.setAttribute(listeCategorie, liste_Categorie);
    }
   
    
    }

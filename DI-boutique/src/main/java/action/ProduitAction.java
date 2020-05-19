/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import entities.Produit;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import manager.ProduitManager;

/**
 *
 * @author dlunhu
 */
public class ProduitAction {

    public static final String listeDeProduit = "attributListeDeProduit";

    public static void afficherTousLesProduit(HttpServletRequest request) {
        //1 appele manager
        ArrayList<Produit> produit = ProduitManager.getAll();
        // ajouter a la requette
        request.setAttribute(listeDeProduit, produit);
    }

    public static void afficherLesProduitparIdCategorie(HttpServletRequest request, int IdCategorie) {
        //1 appeler manager
        ArrayList<Produit> produit = ProduitManager.getByIdCat(IdCategorie);
        // ajouter a la requette
        request.setAttribute(listeDeProduit, produit);
    }

    public static void ajouterUnProduitEtAfficherTousLesProduit(HttpServletRequest request, Produit produitToAdd) {
        //1 appeler manager
        ProduitManager.add(produitToAdd);

        //afficher tous les produits
        afficherTousLesProduit(request);
    }

    public static void supprimerUnProduitEtTousLesAfficher(HttpServletRequest request, int idProduitSuppr) {
        // 1 appel manager
        ProduitManager.delete(idProduitSuppr);
        afficherTousLesProduit(request);
    }

}

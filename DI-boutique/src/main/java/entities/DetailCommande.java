/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author istreich
 */
public class DetailCommande {
    
    private int idCommande;
    private Produit idProduit;
    private Produit prixProduit;
    private Produit quantityProduit;

    private DetailCommande() {
    }

    private DetailCommande(int idCommande, Produit idProduit, Produit prixProduit, Produit quantityProduit) {
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.prixProduit = prixProduit;
        this.quantityProduit = quantityProduit;
    }

    private int getIdCommande() {
        return idCommande;
    }

    private void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    private Produit getIdProduit() {
        return idProduit;
    }

    private void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    private Produit getPrixProduit() {
        return prixProduit;
    }

    private void setPrixProduit(Produit prixProduit) {
        this.prixProduit = prixProduit;
    }

    private Produit getQuantityProduit() {
        return quantityProduit;
    }

    private void setQuantityProduit(Produit quantityProduit) {
        this.quantityProduit = quantityProduit;
    }
    
    
}

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
public class Produit {
    private int idProduit;
    private String nomProduit;
    private Categorie idCategorie;
    private String imageProduit;
    private String descriptionProduit;
    private int prixProduit;
    private int quantityProduit;

    private Produit() {
    }

    
    private Produit(int idProduit, String nomProduit, Categorie idCategorie, String imageProduit, String descriptionProduit, int prixProduit, int quantityProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.idCategorie = idCategorie;
        this.imageProduit = imageProduit;
        this.descriptionProduit = descriptionProduit;
        this.prixProduit = prixProduit;
        this.quantityProduit = quantityProduit;
    }

    private int getIdProduit() {
        return idProduit;
    }

    private void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    private String getNomProduit() {
        return nomProduit;
    }

    private void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    private Categorie getIdCategorie() {
        return idCategorie;
    }

    private void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }

    private String getImageProduit() {
        return imageProduit;
    }

    private void setImageProduit(String imageProduit) {
        this.imageProduit = imageProduit;
    }

    private String getDescriptionProduit() {
        return descriptionProduit;
    }

    private void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    private int getPrixProduit() {
        return prixProduit;
    }

    private void setPrixProduit(int prixProduit) {
        this.prixProduit = prixProduit;
    }

    private int getQuantityProduit() {
        return quantityProduit;
    }

    private void setQuantityProduit(int quantityProduit) {
        this.quantityProduit = quantityProduit;
    }
    
    
    
}

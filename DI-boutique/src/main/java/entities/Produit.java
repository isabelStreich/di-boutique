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
    private int idCategorie;
    private String imageProduit;
    private String descriptionProduit;
    private double prixProduit;
   

    public Produit() {
    }

    public Produit(int idProduit, String nomProduit, int idCategorie, String imageProduit, String descriptionProduit, double prixProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.idCategorie = idCategorie;
        this.imageProduit = imageProduit;
        this.descriptionProduit = descriptionProduit;
        this.prixProduit = prixProduit;
       
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getImageProduit() {
        return imageProduit;
    }

    public void setImageProduit(String imageProduit) {
        this.imageProduit = imageProduit;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    

    
}

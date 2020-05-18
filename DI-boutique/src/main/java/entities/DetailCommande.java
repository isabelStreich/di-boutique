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
    private int idProduit;
    private double prixProduit;

    private DetailCommande() {
    }

    private DetailCommande(int idCommande, int idProduit, double prixProduit) {
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.prixProduit = prixProduit;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author istreich
 */
public class Commande {

    private int idCommande;
    private int idUser;
    private double montantCommande;
    private boolean isOpenPanier;

    public Commande() {
    }

    public Commande(int idCommande, int idUser, double montantCommande, boolean isOpenPanier) {
        this.idCommande = idCommande;
        this.idUser = idUser;
        this.montantCommande = montantCommande;
        this.isOpenPanier = isOpenPanier;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(double montantCommande) {
        this.montantCommande = montantCommande;
    }

    public boolean isIsOpenPanier() {
        return isOpenPanier;
    }

    public void setIsOpenPanier(boolean isOpenPanier) {
        this.isOpenPanier = isOpenPanier;
    }

    

    
}

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
    private Date dateCommande;
    private boolean isopenpanier;

    public Commande() {
    }

    public Commande(int idCommande, int idUser, double montantCommande, Date dateCommande, boolean isopenpanier) {
        this.idCommande = idCommande;
        this.idUser = idUser;
        this.montantCommande = montantCommande;
        this.dateCommande = dateCommande;
        this.isopenpanier = isopenpanier;
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

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public boolean isIsopenpanier() {
        return isopenpanier;
    }

    public void setIsopenpanier(boolean isopenpanier) {
        this.isopenpanier = isopenpanier;
    }

   

    
}

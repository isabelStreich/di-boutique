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
    private int montantCommande;
    private Date dateCommande;

    public Commande() {
    }

    public Commande(int idCommande, int idUser, int montantCommande, Date dateCommande) {
        this.idCommande = idCommande;
        this.idUser = idUser;
        this.montantCommande = montantCommande;
        this.dateCommande = dateCommande;
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

    public int getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(int montantCommande) {
        this.montantCommande = montantCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    

}

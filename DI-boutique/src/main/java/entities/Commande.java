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
    private Client idClient;
    private int montantCommande;
    private int quantityCommande;
    private Date dateCommande;

    public Commande() {
    }

    public Commande(int idCommande, Client idClient, int montantCommande, int quantityCommande, Date dateCommande) {
        this.idCommande = idCommande;
        this.idClient = idClient;
        this.montantCommande = montantCommande;
        this.quantityCommande = quantityCommande;
        this.dateCommande = dateCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public int getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(int montantCommande) {
        this.montantCommande = montantCommande;
    }

    public int getQuantityCommande() {
        return quantityCommande;
    }

    public void setQuantityCommande(int quantityCommande) {
        this.quantityCommande = quantityCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    
    
    
}

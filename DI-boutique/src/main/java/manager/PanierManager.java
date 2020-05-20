/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entities.Commande;
import entities.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConnectionBD;

/**
 *
 * @author istreich
 */
public class PanierManager {

    private static String queryGetAllPanier = "select * from commande where idUser = ? and isopenpanier=1";
    private static String queryCreatedPanier = "insert into commande (idUser,montantCommande,dateCommande,isopenpanier) values (?,?,?,1)";
    private static String queryDeleteTOPanier = "Delete from commande where idCommande=?";
    private static String queryAddTOPanier = "insert into DetailCommande (idCommande,idProduit,prixProduit,quantite) values (???";
    private static String queryClosePanier = "Update isopenpanier = 0 from commande where idUser=?";

    public static ArrayList<Commande> getAllPanier(int idUser) {
        ArrayList<Commande> commandes = new ArrayList<Commande>();
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryGetAllPanier);
            ps.setInt(1, idUser);

            ResultSet result = ps.executeQuery();

            if (result.isBeforeFirst()) {
                commandes = new ArrayList<>();
                while (result.next()) {
                    Commande c = new Commande();
                    c.setIdCommande(result.getInt("idCommande"));
                    c.setIdUser(result.getInt("idUser"));
                    c.setMontantCommande(result.getDouble("montantCommande"));
                    c.setDateCommande(result.getDate("dateCommande"));
                    c.setIsopenpanier(result.getBoolean("isopenpanier"));
                    commandes.add(c);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return commandes;
    }
    
    public static void createdPanier(int idUser, double montantCommande, java.sql.Date dateCommande){
        
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryCreatedPanier);
            ps.setInt(1, idUser);
            ps.setDouble(2, montantCommande);
            ps.setDate(3, dateCommande);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PanierManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return;
    }

}

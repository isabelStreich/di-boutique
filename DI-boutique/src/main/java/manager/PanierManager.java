/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entities.Commande;
import entities.DetailCommande;
import entities.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConnectionBD;

/**
 *
 * @author istreich
 */
public class PanierManager {

    private static String queryGetAllPanier = "select * from commande where idUser = ? and isOpenPanier=1";
    private static String queryCreatedPanier = "insert into commande (idUser, montantCommande,isOpenPanier) values (?,?,1)";
    private static String queryAddTOPanier = "insert into detailCommande (idCommande,idProduit,prixProduit,quantite) values (?,?,?,?)";
    private static String queryDeleteTOPanier = "Delete from commande where idCommande=?";
    private static String queryClosePanier = "UPDATE commande SET isOpenPanier = 0 WHERE idCommande=?";
    private static String queryGetPanierDetail = "select * from detailCommande where idCommande=?";
    private static String queryGetByIdCommande = "select * from commande where idCommande=?";

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
                    
                    c.setIsOpenPanier(result.getBoolean("isOpenPanier"));
                    commandes.add(c);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return commandes;
    }
    
    public static int createdPanier(int idUser, double montantCommande){
        
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryCreatedPanier);
            ps.setInt(1, idUser);
            ps.setDouble(2, montantCommande);
                      
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()){
             return rs.getInt(1);
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(PanierManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         ConnectionBD.close();
        return -1;
    }
    
    public static Commande getByIdCommande(int idCommande){
        Commande resultCommande= null;
         
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryGetByIdCommande);
            ps.setInt(1, idCommande);
           
            ResultSet result = ps.executeQuery();
            
            if (result.isBeforeFirst()) {
                
                while (result.next()) {
                    Commande c = new Commande();
                    c.setIdCommande(result.getInt("idCommande"));
                    c.setIdUser(result.getInt("idUser"));
                    c.setMontantCommande(result.getDouble("montantCommande"));
                    c.setIsOpenPanier(result.getBoolean("isOpenPanier"));
                    resultCommande= c;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PanierManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         ConnectionBD.close();
        
        return resultCommande;
    }

    public static int AddTOPanier (DetailCommande commandeToAdd){
        int creerComande=0;
           
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryAddTOPanier);
            ps.setInt(1, commandeToAdd.getIdCommande());
            ps.setInt(2, commandeToAdd.getIdProduit());
            ps.setDouble(3, commandeToAdd.getPrixProduit());
            ps.setInt(4, commandeToAdd.getQuantite());
            
           creerComande= ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PanierManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConnectionBD.close();
        return creerComande;
    }
     public static boolean deleteToPanier(int idToDelete) {
        int nbModDansBd = 0;
          
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryDeleteTOPanier);
            ps.setInt(1, idToDelete);
            nbModDansBd = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PanierManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        ConnectionBD.close();
        return nbModDansBd > 0;
    }
    
    public static int closePanier (int idCommande){
        
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryClosePanier);
            ps.setInt(1, idCommande);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PanierManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         ConnectionBD.close();
         return 0;
    }
    
    public static ArrayList<DetailCommande> getPanierDetail (int idCommande){
        ArrayList<DetailCommande>detailCommandes = new ArrayList<DetailCommande>();
        
        
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryGetPanierDetail);
            ps.setInt(1,idCommande);
            ResultSet result = ps.executeQuery();
            
            if (result.isBeforeFirst()) {
                detailCommandes = new ArrayList<>();
                while (result.next()) {
                    DetailCommande  dc = new DetailCommande();
                    dc.setIdCommande(result.getInt("idCommande"));
                    dc.setIdProduit(result.getInt("idProduit"));
                    dc.setPrixProduit(result.getDouble("prixProduit"));
                    dc.setQuantite(result.getInt("quantite"));
                    detailCommandes.add(dc);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PanierManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return detailCommandes;
    }
    public static double getByPrixCommande(int idComande)
    {
        double total = 0;
        ArrayList<DetailCommande> listCommande = getPanierDetail(idComande);
        
        for(DetailCommande dc : listCommande)
        {
            total += (double) (dc.getQuantite() * dc.getPrixProduit());
        }
        
        return total;
    }
}

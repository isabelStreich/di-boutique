/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entities.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConnectionBD;

/**
 *
 * @author istreich
 */
public class ProduitManager {

<<<<<<< HEAD
    private static String queryGetAll = "select * from produit";
    private static String queryGetbyId="select * from produit where produitId = ?";
    private static String queryGetbyCategorie="select * from produit where categorie = ?";            
    private static String queryAdd = "insert into produit (nomProduit,idCategorie,imageProduit,descriptionProduit,prixProduit) values (?,?,?,?,?)";
    private static String queryUpdate="UPDATE produits ...";
    private static final String queryDelete = "delete produit fruit where id = ?";
=======
//Dmytro debut
    public static ArrayList<Produit> getByIdCat(int idCat) {
        ArrayList<Produit> retour = new ArrayList<>();
        Iterable<Produit> produits = null;
        for (Produit produit : produits) {
            if (produit.getIdCategorie() == idCat) {
                retour.add(produit);
            }
        }
        return retour;
    }
//Dmytro fin

    private static String queryGetAll = "select * from produit";
>>>>>>> b85b68a20780e7804a656ca250713f2bc154427d

    public static ArrayList<Produit> getAll() {

        ArrayList<Produit> retour = null;
<<<<<<< HEAD
        
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryGetAll);
            ResultSet result = ps.executeQuery();

            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {
                    Produit p = new Produit();

                    p.setIdProduit(result.getInt("idProduit"));
                    p.setNomProduit(result.getString("nomProduit"));
                    p.setIdCategorie(result.getInt("idCategorie"));
                    p.setDescriptionProduit(result.getString("descriptionProduit"));
                    p.setImageProduit(result.getString("imageProduit"));
                    p.setPrixProduit(result.getDouble("prixProduit"));
                    retour.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return retour;
    }
    public static ArrayList<Produit> update(int idProduit,String nomProduit,int idCategorie, String imageProduit,String descriptionProduit,double prixProduit){
         ArrayList<Produit> retour = null;
         
         PreparedStatement ps = ConnectionBD.getPs(queryUpdate);
        try {
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         return retour;
    }
    public static ArrayList<Produit> getById(int idProduit){
        ArrayList<Produit> retour = null;
        
=======

        PreparedStatement ps = ConnectionBD.getPs(queryGetAll);

>>>>>>> b85b68a20780e7804a656ca250713f2bc154427d
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryGetbyId);
            ps.setInt(1, idProduit);
            ResultSet result = ps.executeQuery();
<<<<<<< HEAD
            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {
                    Produit p = new Produit();

                    p.setIdProduit(result.getInt("idProduit"));
                    p.setNomProduit(result.getString("nomProduit"));
                    p.setIdCategorie(result.getInt("idCategorie"));
                    p.setDescriptionProduit(result.getString("descriptionProduit"));
                    p.setImageProduit(result.getString("imageProduit"));
                    p.setPrixProduit(result.getDouble("prixProduit"));
                    retour.add(p);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }

    public static ArrayList<Produit> getByCategorie(int idCategorie){
        ArrayList<Produit> retour = null;
         
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryGetbyCategorie);
            ps.setInt(1, idCategorie);
            ResultSet result = ps.executeQuery();
            
            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {
                    Produit p = new Produit();

                    p.setIdProduit(result.getInt("idProduit"));
                    p.setNomProduit(result.getString("nomProduit"));
                    p.setIdCategorie(result.getInt("idCategorie"));
                    p.setDescriptionProduit(result.getString("descriptionProduit"));
                    p.setImageProduit(result.getString("imageProduit"));
                    p.setPrixProduit(result.getDouble("prixProduit"));
                    retour.add(p);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retour;
    }
    public static boolean add(Produit produitToAdd) {
        int nbproduitToAdd = 0;

        
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryAdd);
            ps.setInt(1, produitToAdd.getIdProduit());
            ps.setString(2, produitToAdd.getNomProduit());
            ps.setInt(3, produitToAdd.getIdCategorie());
            ps.setString(4, produitToAdd.getImageProduit());
            ps.setString(5, produitToAdd.getDescriptionProduit());
            ps.setDouble(6, produitToAdd.getPrixProduit());

        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return nbproduitToAdd > 0;
    }
    
    public static boolean delete(int idToDelete){
        int nbProduitTODelete =0;
                
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryAdd);
            ps.setInt(1, idToDelete);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConnectionBD.close();
       return  nbProduitTODelete>0;
    }
=======

            if (result.isBeforeFirst()) {
                retour = new ArrayList<>();
                while (result.next()) {
//                 Produit p = new Produit();
//                 p.setIdProduit(result.getInt("idProduit"));
//                 p.setNomProduit(result.getString("nomProduit"));
//                 p.setIdCategorie(result.getString("idCategorie"));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnectionBD.close();
        return retour;
    }

    private static String queryAdd = "insert into produit (nomProduit,imageProduit,descriptionProduit, prixProduit) values (?,?,?,?)";

    public static boolean add(Produit produitToAdd) {
        int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = ConnectionBD.getPs(queryAdd);
            preparedStatement.setString(1, produitToAdd.getNomProduit());
            preparedStatement.setString(2, produitToAdd.getImageProduit());
            preparedStatement.setString(3, produitToAdd.getDescriptionProduit());
            preparedStatement.setDouble(4, produitToAdd.getPrixProduit());
            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return nbModDansBd > 0;
    }

    private static final String queryDelete = "delete from roduit where id = ?";

    public static boolean delete(int idToDelete) {
        int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = ConnectionBD.getPs(queryDelete);
            preparedStatement.setInt(1, idToDelete);
            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return nbModDansBd > 0;
    }

>>>>>>> b85b68a20780e7804a656ca250713f2bc154427d
}

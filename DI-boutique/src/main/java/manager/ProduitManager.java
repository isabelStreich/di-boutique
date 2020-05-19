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

    public static ArrayList<Produit> getAll() {

        ArrayList<Produit> retour = null;

        PreparedStatement ps = ConnectionBD.getPs(queryGetAll);

        try {
            ResultSet result = ps.executeQuery();

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

}

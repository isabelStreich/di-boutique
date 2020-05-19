/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entities.Categorie;
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
public class CategorieManager {
    public static String queryGetAllCategorie = "select * from categorie ;";
    public static String queryGetByIdCategorie = "select *from categorie by idCategorie";
    public static String queryAddCategorie = "INSERT INTO categorie idCategorie = ?";
    private static final String queryDelete = "delete categorie where id = ?";

    public static ArrayList<Categorie> getAllCategorie() {
        ArrayList<Categorie> listeCategorie = null;

        try {
            PreparedStatement ps = ConnectionBD.getPs(queryGetAllCategorie);
            ResultSet result = ps.executeQuery();

            if (result.isBeforeFirst()) {
                listeCategorie = new ArrayList<>();
                while (result.next()) {
                    Categorie c = new Categorie();
                    c.setIdCategorie(result.getInt("idCategorie"));
                    c.setNomCategorie(result.getString("nomCategorie"));
                    c.setImageCategorie(result.getString("imageCategorie"));
                    listeCategorie.add(c);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategorieManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return listeCategorie;
    }
//     ====================================================

    public static ArrayList<Categorie> getByIdCategorie(int idCategorie) {
        ArrayList<Categorie> listeCategorie = null;

        try {
            PreparedStatement ps = ConnectionBD.getPs(queryGetByIdCategorie);
            ps.setInt(1, idCategorie);
            ResultSet result = ps.executeQuery();

            if (result.isBeforeFirst()) {
                listeCategorie = new ArrayList();

                while (result.next()) {
                    Categorie c = new Categorie();
                    c.setIdCategorie(result.getInt("idCategorie"));
                    c.setNomCategorie(result.getString("nomCategorie"));
                    c.setImageCategorie(result.getString("imageCategorie"));
                    listeCategorie.add(c);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategorieManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return listeCategorie;
    }

    public static boolean addCategorie (Categorie categorieToAdd) {
        int nbcategorieToAdd = 0;

        PreparedStatement ps = ConnectionBD.getPs(queryAddCategorie);
        try {
            ps.setInt(1, categorieToAdd.getIdCategorie());
            ps.setString(2, categorieToAdd.getNomCategorie());
            ps.setString(2, categorieToAdd.getImageCategorie());

            nbcategorieToAdd = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return nbcategorieToAdd > 0;
    }

    public static boolean delete(int idToDelete) {
        int nbCategorieTODelete = 0;
        
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryDelete);
            ps.setInt(1, idToDelete);
            
            nbCategorieTODelete= ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return nbCategorieTODelete > 0;
    }
}

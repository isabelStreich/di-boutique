/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entities.Role;
import entities.User;
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
public class UserManager {

    private static ArrayList<User> listeUser = new ArrayList<>();

    //faire la requette- VERIFIER SI SONT CORRECTS!!!!!!!
    private static String queryGetAll = "select * from user";
    private static String queryGetCheckTypeUser = "select * from user where email = ?";
    private static String queryGetLoginUser = "select * from user where email=? and password=?";
    private static String querryAddUser = "insert into user (nomUser,email,password,idRole) values (?,?,?,2)";
    private static String queryDeleteUser = "delete from fruit where id = ?";

    public static ArrayList<User> getAll() {
        ArrayList<User> listeUser = null;
        PreparedStatement ps = ConnectionBD.getPs(queryGetAll);
        try {
            ResultSet result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                listeUser = new ArrayList<>();
                while (result.next()) {//pour parcourir le resultset
                    User u = new User();
                    u.setIdUser(result.getInt("idUser"));
                    u.setNomUser(result.getString("nomUser"));
                    u.setEmail(result.getString("email"));
                    u.setPassword(result.getString("password"));
                    u.setIdRole(result.getInt("idRole"));

                    listeUser.add(u);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();

        return listeUser;
    }

    public static User getUser(String emailToCheck) {
        User user = new User();

        PreparedStatement ps = ConnectionBD.getPs(queryGetCheckTypeUser);
        try {
            ps.setString(1, emailToCheck);
            ResultSet result = ps.executeQuery();

            if (result.isBeforeFirst()) {

                while (result.next()) {
                    User u = new User();

                    u.setIdUser(result.getInt("idUser"));
                    u.setNomUser(result.getString("nomUser"));
                    u.setEmail(result.getString("email"));
                    u.setPassword(result.getString("password"));
                    u.setIdRole(result.getInt("idRole"));
                    user = u;

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnectionBD.close();

        return user;
    }

    public static boolean authenticateUser(String email, String password) {

        PreparedStatement ps = ConnectionBD.getPs(queryGetLoginUser);

        try {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();

            if (result.isBeforeFirst()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static boolean addUser(User userToAdd) {
        int creerUser = 0;

        try {
            PreparedStatement ps = ConnectionBD.getPs(querryAddUser);

            ps.setInt(1, userToAdd.getIdUser());
            ps.setString(2, userToAdd.getNomUser());
            ps.setString(3, userToAdd.getEmail());
            ps.setString(4, userToAdd.getPassword());
            ps.setInt(5, userToAdd.getIdRole());

            creerUser = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return creerUser > 0;
    }

    public static boolean deleteUser(int idToDelete) {
        int nbModDansBd = 0;
        try {
            PreparedStatement ps = ConnectionBD.getPs(queryDeleteUser);
            ps.setInt(1, idToDelete);
            nbModDansBd = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionBD.close();
        return nbModDansBd > 0;
    }

//    private static User user = new User("etudiant", "isi", "toto");
//    private static ArrayList<User> listeUser = new ArrayList<>();
    /**
     *
     * @param uToCheck utilisateur a verifier
     * @return retour null si pas bon login ou pwd ou retourne le user
     */
    public static User checkUser(User uToCheck) {
        User retour = null;
        User user = null;
        if (uToCheck.getEmail().equals(user.getEmail()) && uToCheck.getPassword().equals(user.getPassword())) {
            retour = user;
        }
        return retour;
    }
}

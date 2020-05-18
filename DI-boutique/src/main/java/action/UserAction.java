/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import entities.User;
import javax.servlet.http.HttpServletRequest;
import manager.UserManager;

/**
 *
 * @author istreich
 */
public class UserAction {
    
     public static final String listeDeUser = "attributListeDeUser";
     
     
     public static void addUser (HttpServletRequest request, User userToAdd){
         UserManager.addUser(userToAdd);
     }
    
}

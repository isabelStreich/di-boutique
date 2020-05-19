/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import com.sun.org.apache.xml.internal.utils.AttList;
import java.util.ArrayList;
import javabean.Categorie;

/**
 *
 * @author jlidou
 */
public class CategorieManager {

    private static ArrayList<Categorie> categories;

    static {
        init();
    }

    private static void init() {
        categories = new ArrayList<>();
        categories.add(new Categorie(0, "homme"));
        categories.add(new Categorie(1, "femme"));
        categories.add(new Categorie(2, "enfant"));
        categories.add(new Categorie(3, "accessoire"));
    }

    public static ArrayList<Categorie> getAll() {
        return categories;
    }
}

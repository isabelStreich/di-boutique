/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author istreich
 */
public class Categorie {

    public int idCategorie;
    public String nomCategorie;
    public String imageCategorie;

    public Categorie() {
    }

    public Categorie(int idCategorie, String nomCategorie, String imageCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.imageCategorie = imageCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getImageCategorie() {
        return imageCategorie;
    }

    public void setImageCategorie(String imageCategorie) {
        this.imageCategorie = imageCategorie;
    }
}

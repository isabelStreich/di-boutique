/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.util.ArrayList;
import java.util.HashMap;
import javabean.Animal;

/**
 *
 * @author jlidou
 */
public class AnimalManager {

    private static ArrayList<Animal> animals;

    static {
        init();
    }

    private static void init() {
        animals = new ArrayList<>();
        animals.add(new Animal(0, "toutou1", "homme1.jpg", 0));
        animals.add(new Animal(1, "bambou", "homme2.jpg", 0));
        animals.add(new Animal(1, "bambou", "homme3.jpg", 0));
        animals.add(new Animal(1, "bambou", "homme4.jpg", 0));
        animals.add(new Animal(0, "toutou1", "femme1.jpg", 1));
        animals.add(new Animal(0, "toutou1", "femme2.jpg", 1));
        animals.add(new Animal(0, "toutou1", "femme3.jpg", 1));
        animals.add(new Animal(0, "toutou1", "femme4.jpg", 1));
        animals.add(new Animal(0, "toutou1", "enfant1.jpg", 2));
        animals.add(new Animal(0, "toutou1", "enfant2.jpg", 2));
        animals.add(new Animal(0, "toutou1", "enfant3.jpg", 2));
        animals.add(new Animal(0, "toutou1", "enfant4.jpg", 2));
        animals.add(new Animal(0, "toutou1", "accessoire1.jpg", 3));
        animals.add(new Animal(0, "toutou1", "accessoire2.jpg", 3));
        animals.add(new Animal(0, "toutou1", "accessoire3.jpg", 3));
        animals.add(new Animal(0, "toutou1", "accessoire4.jpg", 3));
    }

    public static ArrayList<Animal> getAll() {
        return animals;
    }

    public static ArrayList<Animal> getByIdCat(int idCat) {
        ArrayList<Animal> retour = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getIdCategorie() == idCat) {
                retour.add(animal);
            }
        }
        return retour;
    }

    /**
     *
     * @param id de l animal que je cherche
     * @return null ou l animal trouvé
     */
    public static Animal getById(int id) {
        Animal retour = null;
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                retour = animal;
                break;
            }
        }
        return retour;
    }

}

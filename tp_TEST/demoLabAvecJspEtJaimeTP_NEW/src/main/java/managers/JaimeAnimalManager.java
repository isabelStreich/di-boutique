/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.util.HashMap;

/**
 *
 * @author jlidou
 */
public class JaimeAnimalManager {

    private static HashMap<String, Integer> nombreDeJaime;

    static {
        nombreDeJaime = new HashMap<>();
    }

    //methode add j aime
    public static void add(String nomAnimalToAddJaime) {
        // 1 deja un j aime pour cet animal ou nom
        if (nombreDeJaime.containsKey(nomAnimalToAddJaime)) {  // si oui je vais incrementer la qte  
            Integer value = nombreDeJaime.get(nomAnimalToAddJaime);
            value += 1;
            nombreDeJaime.replace(nomAnimalToAddJaime, value);
        } else {// si non je creer une nouvelle ligne dans mon hashmap et met la qte a 1
            nombreDeJaime.put(nomAnimalToAddJaime, 1);
        }
    }

    
    //getter pour pouvoir afficher plus tard
    public static HashMap<String, Integer> getNombreDeJaime() {
        return nombreDeJaime;
    }
}

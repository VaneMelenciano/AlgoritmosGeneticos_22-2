/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionSimple;

import java.util.Random;
import objetos.Individuo;

/**
 *
 * @author Vanessa
 */
public class Muta {
    public static void muta(Individuo i){
        //int[] gen = i.getGenotipo().clone();
        Random r = new Random();
        int pos = r.nextInt(i.getGenotipo().length); //elige una posición entre el genotipo del individuo, al azar
        i.getGenotipo()[pos] = (i.getGenotipo()[pos]==0) ? 1 : 0; //si es 0, lo pone en 1 y viseversa
        i.actualizar(); //actualiza el firtness y genotipo del individuo
    }
}

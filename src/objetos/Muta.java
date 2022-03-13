/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import TSP.IndividuoTSP;
import funcionSimple.IndividuoBinario;
import java.util.Random;

/**
 *
 * @author Vanessa
 */
public class Muta {
    public static void muta(IndividuoBinario i){
        //int[] gen = i.getGenotipo().clone();
        Random r = new Random();
        int pos = r.nextInt(i.getGenotipo().length); //elige una posición entre el genotipo del individuo, al azar
        i.getGenotipo()[pos] = (i.getGenotipo()[pos]==0) ? 1 : 0; //si es 0, lo pone en 1 y viseversa
        i.actualizar(); //actualiza el firtness y genotipo del individuo
    }

    public static boolean muta(double probMuta) {
        return Math.random()<=probMuta;
    }
    public static void muta(IndividuoTSP i){
        int pos = calcularAleatorio(i.getGenotipo().length); //r.nextInt(i.getGenotipo().length-1)+1; //elige una posición entre el genotipo del individuo, al azar
        int pos2 = calcularAleatorio(i.getGenotipo().length);
        while(pos==pos2) pos2=calcularAleatorio(i.getGenotipo().length);
        int aux = i.getGenotipo()[pos];
        i.getGenotipo()[pos] = i.getGenotipo()[pos2]; //si es 0, lo pone en 1 y viseversa
        i.getGenotipo()[pos2] = aux; //si es 0, lo pone en 1 y viseversa
        i.actualizar(); //actualiza el firtness y genotipo del individuo
    }
    private static int calcularAleatorio(int n){
        Random r = new Random();
        return r.nextInt(n-1)+1;
    }
}

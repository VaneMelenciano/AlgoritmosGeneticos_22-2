/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import TSP.IndividuoTSP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Vanessa
 */
public class Muestreo {
    //Ordenamiento
    private static ArrayList<IndividuoTSP> ordenar(ArrayList<IndividuoTSP> pob){
        pob.sort(Comparator.comparingInt(i -> i.getFitness()));
        //ordena de menor a mayor los individuos según su fitness porque entre menor este numero, mejor camino
        //Collections.sort(pob, new Comparator<IndividuoTSP>() {
        //    @Override
         //   public int compare(IndividuoTSP i1, IndividuoTSP i2) {
         //       return new Integer(i1.getFitness()).compareTo(new Integer(i2.getFitness()));
         //   }
        //});
        return pob;
    }
    //TORNES -> LOS MEJORES N
    public static ArrayList<IndividuoTSP> torneo(ArrayList<IndividuoTSP> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<IndividuoTSP> nuevaPob = new ArrayList<IndividuoTSP>();
        //int cantidad = porcentaje*pob.size()/100;
        pob = ordenar((ArrayList<IndividuoTSP>) pob.clone());
        for(int i=0; i<porcentaje; i++){
            nuevaPob.add(pob.get(i));
        }
        return nuevaPob;
    }
    // % mejores / % peores
    public static ArrayList<IndividuoTSP> mitad(ArrayList<IndividuoTSP> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<IndividuoTSP> nuevaPob = new ArrayList<IndividuoTSP>();
        //int cantidad = porcentaje*pob.size()/100;
        pob = ordenar((ArrayList<IndividuoTSP>) pob.clone());
        int mitad1 = porcentaje/2, mitad2 = porcentaje-mitad1;
        for(int i=0; i<mitad1; i++){
           nuevaPob.add(pob.get(i)); 
        }
        for(int j=mitad1; j<mitad2; j++){
           nuevaPob.add(pob.get(j)); 
        }
        return nuevaPob;
    }
    // aleatorio
    public static ArrayList<IndividuoTSP> aleatorio(ArrayList<IndividuoTSP> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<IndividuoTSP> nuevaPob = new ArrayList<IndividuoTSP>();
        //int cantidad = porcentaje*pob.size()/100;
        for(int i=0; i<porcentaje; i++){
             Random r = new Random();
            int pos = r.nextInt(pob.size());
            nuevaPob.add(pob.get(pos));
        }
        return nuevaPob;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Individuos.Individuo;
import Individuos.IndividuoReinas;
import Individuos.IndividuoTSP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Vanessa
 */
public class Muestreo {
    //Ordenamiento
    /*private static ArrayList<IndividuoTSP> ordenar(ArrayList<IndividuoTSP> pob){
        pob.sort(Comparator.comparingInt(i -> i.getFitness()));
        return pob;
    }
    private static ArrayList<IndividuoReinas> ordenarReinas(ArrayList<IndividuoReinas> pob){
        pob.sort(Comparator.comparingInt(i -> i.getFitness()));
        return pob;
    }*/
     private static ArrayList<Individuo> ordenar(ArrayList<Individuo> pob){
        pob.sort(Comparator.comparingInt(i -> i.getFitness()));
        return pob;
    }
    //TORNES -> LOS MEJORES N
    /*public static ArrayList<IndividuoTSP> torneo(ArrayList<IndividuoTSP> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<IndividuoTSP> nuevaPob = new ArrayList<IndividuoTSP>();
        //int cantidad = porcentaje*pob.size()/100;
        pob = ordenar((ArrayList<IndividuoTSP>) pob.clone());
        for(int i=0; i<porcentaje; i++){
            nuevaPob.add(pob.get(i));
        }
        return nuevaPob;
    }
    public static ArrayList<IndividuoReinas> torneoReinas(ArrayList<IndividuoReinas> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<IndividuoReinas> nuevaPob = new ArrayList<IndividuoReinas>();
        //int cantidad = porcentaje*pob.size()/100;
        pob = ordenarReinas((ArrayList<IndividuoReinas>) pob.clone());
        for(int i=0; i<porcentaje; i++){
            nuevaPob.add(pob.get(i));
        }
        return nuevaPob;
    }*/
    public static ArrayList<Individuo> torneo(ArrayList<Individuo> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<Individuo> nuevaPob = new ArrayList<Individuo>();
        //int cantidad = porcentaje*pob.size()/100;
        pob = ordenar((ArrayList<Individuo>) pob.clone());
        for(int i=0; i<porcentaje; i++){
            nuevaPob.add(pob.get(i));
        }
        return nuevaPob;
    }
    // % mejores / % peores
    /*public static ArrayList<IndividuoTSP> mitad(ArrayList<IndividuoTSP> pob, int porcentaje){
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
    }*/
    public static ArrayList<Individuo> mitad(ArrayList<Individuo> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<Individuo> nuevaPob = new ArrayList<Individuo>();
        //int cantidad = porcentaje*pob.size()/100;
        pob = ordenar((ArrayList<Individuo>) pob.clone());
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
    /*public static ArrayList<IndividuoTSP> aleatorio(ArrayList<IndividuoTSP> pob, int porcentaje){
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
    public static ArrayList<IndividuoReinas> aleatorioReinas(ArrayList<IndividuoReinas> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<IndividuoReinas> nuevaPob = new ArrayList<IndividuoReinas>();
        //int cantidad = porcentaje*pob.size()/100;
        for(int i=0; i<porcentaje; i++){
             Random r = new Random();
            int pos = r.nextInt(pob.size());
            nuevaPob.add(pob.get(pos));
        }
        return nuevaPob;
    }*/
    public static ArrayList<Individuo> aleatorio(ArrayList<Individuo> pob, int porcentaje){
        //solo toma % de los mejores
        ArrayList<Individuo> nuevaPob = new ArrayList<Individuo>();
        //int cantidad = porcentaje*pob.size()/100;
        for(int i=0; i<porcentaje; i++){
             Random r = new Random();
            int pos = r.nextInt(pob.size());
            nuevaPob.add(pob.get(pos));
            
            //System.out.println(pos+ " " + pob.size());
                //System.out.println(Arrays.toString(nuevaPob.get(pos).genotipo) + " " + nuevaPob.get(pos).fitness + " " + nuevaPob.get(pos).fenotipo);
        
        
        }
        return nuevaPob;
    }
}

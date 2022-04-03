/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Individuos.Individuo;
import Individuos.IndividuoReinas;
import Individuos.IndividuoTSP;
import Individuos.IndividuoBinario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Vanessa
 */
public class Seleccion {
    
    //selecciona al individuo con mejor fitness en la población
    /*public static IndividuoBinario seleccionTorneo(ArrayList<IndividuoBinario> poblacion){
       //recorrer la poblacción
       IndividuoBinario mejor = poblacion.get(0);
       for(IndividuoBinario i: poblacion){
           if(i.getFitness()>mejor.getFitness()) //maximizando
               mejor = i;
       }
       return (new IndividuoBinario(mejor.getGenotipo()));
    }
    public static IndividuoTSP seleccionTorneoTSP(ArrayList<IndividuoTSP> poblacion){
       //recorrer la poblacción
       IndividuoTSP mejor = poblacion.get(0);
       for(IndividuoTSP i: poblacion){
           if(i.getFitness()<mejor.getFitness()) //minimizar
               mejor = i;
       }
       return (new IndividuoTSP(mejor.getGenotipo()));
    }
    public static IndividuoReinas seleccionTorneoReinas(ArrayList<IndividuoReinas> poblacion){
       //recorrer la poblacción
       IndividuoReinas mejor = poblacion.get(0);
       for(IndividuoReinas i: poblacion){
           if(i.getFitness()<mejor.getFitness()) //minimizar
               mejor = i;
       }
       return (new IndividuoReinas(mejor.getGenotipo()));
    }*/
    public static Individuo torneoMenor(ArrayList<Individuo> poblacion){
       //recorrer la poblacción
       //System.out.println("\t\tTORNEO");
       Individuo mejor = poblacion.get(0);
       //System.out.println(Arrays.toString(mejor.genotipo) + " " + mejor.getFitness()); 
       for(Individuo i: poblacion){
           //System.out.println("\t\t\t " + i.getFitness()+" "+mejor.getFitness());
           if(i.getFitness()<mejor.getFitness()){
               //minimizar
               mejor = i;
         //       System.out.println(Arrays.toString(mejor.genotipo)); 
           }
       }
       return (new Individuo(mejor.getGenotipo()));
    }
    
    public static Individuo torneoMayor(ArrayList<Individuo> poblacion){
       //recorrer la poblacción
       //System.out.println("TORNEO");
       Individuo mejor = poblacion.get(0);
       //System.out.println(Arrays.toString(mejor.genotipo)); 
       for(Individuo i: poblacion){
           if(i.getFitness()>mejor.getFitness()){
               //minimizar
               mejor = i;
         //       System.out.println(Arrays.toString(mejor.genotipo)); 
           }
       }
       return (new Individuo(mejor.getGenotipo()));
    }
    
    //seleccion aleatoria
    /*public static IndividuoBinario seleccionAleatoria(ArrayList<IndividuoBinario> poblacion){
       //recorrer la poblacción
       Random r = new Random();
       int pos = r.nextInt(poblacion.size());
       return new IndividuoBinario(poblacion.get(pos).getGenotipo());
    }
    public static IndividuoTSP seleccionAleatoriaTSP(ArrayList<IndividuoTSP> poblacion){
       //recorrer la poblacción
       Random r = new Random();
       int pos = r.nextInt(poblacion.size());
       return new IndividuoTSP(poblacion.get(pos).getGenotipo());
    }
    public static IndividuoReinas seleccionAleatoriaReinas(ArrayList<IndividuoReinas> poblacion){
       //recorrer la poblacción
       Random r = new Random();
       int pos = r.nextInt(poblacion.size());
       return new IndividuoReinas(poblacion.get(pos).getGenotipo());
    }*/
    public static Individuo aleatoria(ArrayList<Individuo> poblacion){
       //recorrer la poblacción
       Random r = new Random();
       int pos = r.nextInt(poblacion.size());
       return new Individuo(poblacion.get(pos).getGenotipo());
    }

    public static IndividuoReinas torneoMenorR(ArrayList<IndividuoReinas> poblacion) {
        //System.out.println("\tTORNEO");
       IndividuoReinas mejor = poblacion.get(0);
       //System.out.println(Arrays.toString(mejor.genotipo) + " " + mejor.getFitness()); 
       for(IndividuoReinas i: poblacion){
           //System.out.println("\t\t\t " + i.getFitness()+" "+mejor.getFitness());
           if(i.getFitness()<mejor.getFitness()){
               //minimizar
               mejor = i;
                //System.out.println( " " + Arrays.toString(mejor.genotipo) + " " + mejor.fitness); 
           }
       }
       return (new IndividuoReinas(mejor.getGenotipo()));
    }
    private static Random ran  = new Random();
    
    /*public static IndividuoReinas aleatoriaR(ArrayList<IndividuoReinas> pob) {
        //ran = new Random();
       int pos = ran.nextInt(pob.size());
       //System.out.println("Aleato: " + pos + " " + Arrays.toString(pob.get(pos).getGenotipo()) + " " + pob.get(pos).fitness);
       return new IndividuoReinas(pob.get(pos).getGenotipo());
    }*/
    
    public static IndividuoReinas aleatoriaR(ArrayList<IndividuoReinas> pob) {
        //ran = new Random();
       int pos = ran.nextInt(pob.size());  //ran.nextInt((int) DateTime.Now.Ticks & 0x0000FFFF);//ran((int) DateTime.Now.Ticks & 0x0000FFFF).Next(pob.size());//ran.nextInt(pob.size());
       //System.out.println("Aleato: " + pos + " " + Arrays.toString(pob.get(pos).getGenotipo()) + " " + pob.get(pos).fitness);
       return new IndividuoReinas(pob.get(pos).getGenotipo());
    }
    
}

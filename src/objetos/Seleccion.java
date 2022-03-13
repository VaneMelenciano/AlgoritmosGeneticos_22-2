/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import TSP.IndividuoTSP;
import funcionSimple.IndividuoBinario;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Vanessa
 */
public class Seleccion {
    
    //selecciona al individuo con mejor fitness en la población
    public static IndividuoBinario seleccionTorneo(ArrayList<IndividuoBinario> poblacion){
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
    
    //seleccion aleatoria
    public static IndividuoBinario seleccionAleatoria(ArrayList<IndividuoBinario> poblacion){
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
    
}

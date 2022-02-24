/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionSimple;

import java.util.ArrayList;
import java.util.Random;
import objetos.Individuo;

/**
 *
 * @author Vanessa
 */
public class Seleccion {
    
    //selecciona al individuo con mejor fitness en la población
    public static Individuo seleccionTorneo(ArrayList<Individuo> poblacion){
       //recorrer la poblacción
       Individuo mejor = poblacion.get(0);
       for(Individuo i: poblacion){
           if(i.getFitness()>mejor.getFitness()) //maximizando
               mejor = i;
       }
       return (new Individuo(mejor.getGenotipo()));
    }
    
    //seleccion aleatoria
    public static Individuo seleccionAleatoria(ArrayList<Individuo> poblacion){
       //recorrer la poblacción
       Random r = new Random();
       int pos = r.nextInt(poblacion.size());
       return new Individuo(poblacion.get(pos).getGenotipo());
    }
    
}

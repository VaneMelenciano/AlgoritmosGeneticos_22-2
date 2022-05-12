/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Individuos.IndividuoBinario;
import Individuos.IndividuoReinas;
import Individuos.IndividuoSAT;
import Individuos.IndividuoTSP;
import geneticos.GeneticoBinario;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Vanessa
 */
public class Seleccion {
    //selecciona al individuo con mejor fitness en la población
    public static IndividuoBinario seleccionTorneoBinario(ArrayList<IndividuoBinario> poblacion){
       //recorrer la poblacción
       IndividuoBinario mejor = poblacion.get(0);
       if(GeneticoBinario.banderaUsarClasificador){
           for(IndividuoBinario i: poblacion){
                if(i.getFitnessDecimal()>mejor.getFitnessDecimal()) //maximizando
                    mejor = i;
            } 
       }else{
            for(IndividuoBinario i: poblacion){
                if(i.getFitness()>mejor.getFitness()) //maximizando
                    mejor = i;
            } 
       }
       return (new IndividuoBinario(mejor.getGenotipo()));
    }
    public static IndividuoSAT seleccionTorneoSAT(ArrayList<IndividuoSAT> poblacion){
       //recorrer la poblacción
       IndividuoSAT mejor = poblacion.get(0);
       for(IndividuoSAT i: poblacion){
           if(i.getFitness()>mejor.getFitness()) //maximizando
               mejor = i;
       }
       return (new IndividuoSAT(mejor.getGenotipo()));
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
    }
    
    //seleccion aleatoria
    public static IndividuoBinario seleccionAleatoriaBinario(ArrayList<IndividuoBinario> poblacion){
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
    public static IndividuoReinas seleccionAleatoriaReinas(ArrayList<IndividuoReinas> poblacion) {
       Random r = new Random();
       int pos = r.nextInt(poblacion.size());
       return new IndividuoReinas(poblacion.get(pos).getGenotipo());
    }
    private static Random r = new Random();
    public static IndividuoSAT seleccionAleatoriaSAT(ArrayList<IndividuoSAT> poblacion){
       //recorrer la poblacción
       r = new Random(System.currentTimeMillis());
       int pos = r.nextInt(poblacion.size());
       //System.out.println("\t " + pos);
       return new IndividuoSAT(poblacion.get(pos).getGenotipo());
    }
    
    //Ruleta
    public static IndividuoTSP seleccionRuletaTSP(ArrayList<IndividuoTSP> poblacion){
        poblacion = Muestreo.ordenar(poblacion);
        r = new Random(System.currentTimeMillis());
        int pos = r.nextInt(poblacion.size());
        return new IndividuoTSP(poblacion.get(pos).getGenotipo());
    }
    
    
}

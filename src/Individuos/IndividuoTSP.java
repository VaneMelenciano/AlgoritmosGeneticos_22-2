/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import objetos.Herramientas;
import Individuos.Individuo;
import java.util.Arrays;
import objetos.MatrizDistancia;

/**
 *
 * @author Vanessa
 */
public class IndividuoTSP extends Individuo{
    
    //aleatoria 
    public IndividuoTSP(int ci, int nc){ //cuidad inicial, número de cuidades
        /*this.genotipo = Herramientas.generarArreglo(ci, nc);
        actualizar();*/
        super(ci, nc);
    }
    //ceación aleatoria
    /*public IndividuoTSP(){
        this.genotipo = Herramientas.generarArreglo(fitness, fitness);
        //hacer los calculos de fenotipo/fitness
        actualizar();
    }*/
    public IndividuoTSP(int[] genotipo){
        //this.genotipo = genotipo.clone();
        //hacer los calculos de fenotipo/fitness
        //actualizar();
        
        super(genotipo);
    }
    public IndividuoTSP(){
        super();
    }

    public IndividuoTSP(Individuo aux) {
        super(aux);
    }

    @Override
    public void calcularFitness() {
        //System.out.println(Arrays.toString(genotipo));
        //genotipo es el arreglo aleatorio de la ruta
      //recorrer el genotipo y consultar la matriz de distancias
      for(int i=0; i<this.genotipo.length-1; i++){
          this.fitness += MatrizDistancia.matriz[this.genotipo[i]][this.genotipo[i+1]];
      }
      //ultima ruta hacia la iniciar (de regreso)
      this.fitness +=MatrizDistancia.matriz[this.genotipo[this.genotipo.length-1]][this.genotipo[0]];
      //System.out.println("F: " + this.fitness);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import objetos.Herramientas;
import objetos.Matriz;

/**
 *
 * @author Vanessa
 */
public class IndividuoTSP extends Individuo{
    
    //aleatoria 
    public IndividuoTSP(int ci, int nc){ //cuidad inicial, número de cuidades
        setGenotipo(Herramientas.generarArreglo(ci, nc));
        actualizar();
    }
    public IndividuoTSP(int[] genotipo){
        setGenotipo(genotipo.clone());
        //hacer los calculos de fenotipo/fitness
        actualizar();
    }

    private void calcularFitness() {
        //genotipo es el arreglo aleatorio de la ruta
      //recorrer el genotipo y consultar la matriz de distancias
      for(int i=0; i<getGenotipo().length-1; i++){
          setFitness( getFitness() + Matriz.matriz[getGenotipo()[i]][getGenotipo()[i+1]]);
      }
      //ultima ruta hacia la iniciar (de regreso)
      setFitness( getFitness() + Matriz.matriz[getGenotipo()[getGenotipo().length-1]][getGenotipo()[0]]);
      
    }

    public void actualizar() {
        calcularFitness();
    }
}

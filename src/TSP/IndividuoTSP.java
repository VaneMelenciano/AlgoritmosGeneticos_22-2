/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import objetos.Herramientas;

/**
 *
 * @author Vanessa
 */
public class IndividuoTSP {
    private int[] genotipo;
    private int fenotipo, fitness;
    
    //aleatoria 
    public IndividuoTSP(int ci, int nc){ //cuidad inicial, número de cuidades
        this.genotipo = Herramientas.generarArreglo(ci, nc);
        actualizar();
    }
    //ceación aleatoria
    /*public IndividuoTSP(){
        this.genotipo = Herramientas.generarArreglo(fitness, fitness);
        //hacer los calculos de fenotipo/fitness
        actualizar();
    }*/
    public IndividuoTSP(int[] genotipo){
        this.genotipo = genotipo.clone();
        //hacer los calculos de fenotipo/fitness
        actualizar();
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @return the fenotipo
     */
    public int getFenotipo() {
        return fenotipo;
    }

    /**
     * @return the firness
     */
    public int getFitness() {
        return fitness;
    }

    private void calcularFenotipo() {
        //hacer un corrimiento del arreglo y pasar a entero los bits
        for(int i=0, j=this.genotipo.length-1; i<this.genotipo.length && j>=0; i++, j--){
            if(this.genotipo[i]==1){ //si es 0 no tiene caso
                this.fenotipo+=Math.pow(2, j);
            }
        }
    }

    private void calcularFitness() {
        //genotipo es el arreglo aleatorio de la ruta
      //recorrer el genotipo y consultar la matriz de distancias
      for(int i=0; i<this.genotipo.length-1; i++){
          this.fitness += MatrizDistancia.matriz[this.genotipo[i]][this.genotipo[i+1]];
      }
      //ultima ruta hacia la iniciar (de regreso)
      this.fitness +=MatrizDistancia.matriz[this.genotipo[this.genotipo.length-1]][this.genotipo[0]];
      
    }

    public void actualizar() {
        calcularFenotipo();
        calcularFitness();
    }
    
}

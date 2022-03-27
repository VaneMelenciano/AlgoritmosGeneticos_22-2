/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import Geneticos.SeleccionG;
import objetos.Herramientas;

/**
 *
 * @author Vanessa
 */
public class Individuo {
    public int[] genotipo;
    public int fenotipo;
    public int fitness;
    
    //aleatoria 
    public Individuo(int ci, int nc){ //cuidad inicial, número de cuidades
        this.genotipo = Herramientas.generarArreglo(ci, nc);
        actualizar();
    }
    //ceación aleatoria
    /*public IndividuoTSP(){
        this.genotipo = Herramientas.generarArreglo(fitness, fitness);
        //hacer los calculos de fenotipo/fitness
        actualizar();
    }*/
    public Individuo(int n){ //Binario
        this.genotipo = Herramientas.generarArreglo(n);
        actualizar();
        //this.genotipo = Herramientas.generarArregloReinas(n);
        //actualizar();
    }
    public Individuo(int n, SeleccionG g){
        if(g.equals(SeleccionG.Reinas)){
           this.genotipo = Herramientas.generarArregloReinas(n); //Reinas
        }else{
            this.genotipo = Herramientas.generarArreglo(n); //Binario
        }
        actualizar();
        //this.genotipo = Herramientas.generarArregloReinas(n);
        //actualizar();
    }
    public Individuo(){
        
    }
    public Individuo(int[] genotipo){
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

    public void calcularFenotipo() { //para binario
        //hacer un corrimiento del arreglo y pasar a entero los bits
        for(int i=0, j=this.genotipo.length-1; i<this.genotipo.length && j>=0; i++, j--){
            if(this.genotipo[i]==1){ //si es 0 no tiene caso
                this.fenotipo+=Math.pow(2, j);
            }
        }
    }

    public void calcularFitness() {
    }

    public void actualizar() {
        calcularFenotipo();
        calcularFitness();
    }
}

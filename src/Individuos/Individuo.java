/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import objetos.Herramientas;

/**
 *
 * @author Vanessa
 */
public class Individuo {
    private int[] genotipo;
    private int fitness;

    public Individuo(){ //para binario
        
    }
    public Individuo(int[] gen){ //TSP y binario
        setGenotipo(gen.clone());
        actualizar();
    }
    public Individuo(int ci, int nc){ //cuidad inicial, número de cuidades TSP
        setGenotipo(Herramientas.generarArreglo(ci, nc));
        actualizar();
    }
    
    public void actualizar(){
    }
    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }

    /**
     * @param genotipo the genotipo to set
     */
    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    /**
     * @param fitness the fitness to set
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    
}

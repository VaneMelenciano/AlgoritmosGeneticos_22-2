/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import objetos.Herramientas;
import Individuos.Individuo;

/**
 *
 * @author Vanessa
 */
public class IndividuoBinario extends Individuo{
    //private int[] genotipo;
    //private int fenotipo, fitness;
    
    //aleatoria
    public IndividuoBinario(){
        super(24);
    }
    //ceación aleatoria
    public IndividuoBinario(int[] genotipo){
        super(genotipo);
    }

    @Override
    public void calcularFenotipo() {
        //hacer un corrimiento del arreglo y pasar a entero los bits
        for(int i=0, j=this.genotipo.length-1; i<this.genotipo.length && j>=0; i++, j--){
            if(this.genotipo[i]==1){ //si es 0 no tiene caso
                this.fenotipo+=Math.pow(2, j);
            }
        }
    }

    @Override
    public void calcularFitness() {
      this.fitness = 2*(this.fenotipo);
    }
    
}

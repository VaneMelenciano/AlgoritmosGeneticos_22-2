/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Vanessa
 */
public class Individuo {
    private int[] genotipo;
    private int fenotipo, fitness;
    
    //aleatoria
    public Individuo(){
        this.genotipo = Herramientas.generarArreglo(24);
        actualizar();
    }
    //ceación aleatoria
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

    private void calcularFenotipo() {
        //hacer un corrimiento del arreglo y pasar a entero los bits
        for(int i=0, j=this.genotipo.length-1; i<this.genotipo.length && j>=0; i++, j--){
            if(this.genotipo[i]==1){ //si es 0 no tiene caso
                this.fenotipo+=Math.pow(2, j);
            }
        }
    }

    private void calcularFitness() {
      this.fitness = 2*(this.fenotipo);
    }

    public void actualizar() {
        calcularFenotipo();
        calcularFitness();
    }
    
}

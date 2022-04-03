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
public class IndividuoBinario extends Individuo{
    //private int[] getGenotipo();
    private int fenotipo;
    //private int fenotipo, fitness;
    
    //aleatoria
    /*public IndividuoBinario(){
        setGenotipo(Herramientas.generarArregloBinario(24));
        actualizar();
    }
    //ceación aleatoria
    public IndividuoBinario(int[] gen){
        setGenotipo(gen.clone());
        //hacer los calculos de fenotipo/fitness
        actualizar();
    }*/
    
    public IndividuoBinario(){
        setGenotipo(Herramientas.generarArregloBinario(24));
        actualizar();
    }
    //ceación aleatoria
    public IndividuoBinario(int[] gen){
        super(gen);
    }

    private void calcularFitness() {
      setFitness(2*(getFenotipo()));
    }

    @Override
    public void actualizar() {
        calcularFitness();
    }

    /**
     * @return the fenotipo
     */
    public int getFenotipo() {
        return fenotipo;
    }

    /**
     * @param fenotipo the fenotipo to set
     */
    public void setFenotipo(int fenotipo) {
        this.fenotipo = fenotipo;
    }
    
}

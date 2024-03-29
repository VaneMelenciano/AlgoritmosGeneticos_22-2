/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;
import geneticos.GeneticoBinario;
import objetos.Herramientas;

/**
 *
 * @author Vanessa
 */
public final class IndividuoBinario extends Individuo{
    private int fenotipo;
    
    public IndividuoBinario(){
        setGenotipo(Herramientas.generarArregloBinario(24));
        actualizar();
    }
    public IndividuoBinario(int numeroAtributos){
        setGenotipo(Herramientas.generarArregloBinario(numeroAtributos));
        actualizar();
    }
    //ceación aleatoria
    public IndividuoBinario(int[] gen){
        super(gen);
    }

    public void calcularFenotipo() {
        //hacer un corrimiento del arreglo y pasar a entero los bits
        for(int i=0, j=getGenotipo().length-1; i<getGenotipo().length && j>=0; i++, j--){
            if(getGenotipo()[i]==1){ //si es 0 no tiene caso
                this.fenotipo+=Math.pow(2, j);
            }
        }
    }

    public void calcularFitness() {
      if(GeneticoBinario.banderaUsarClasificador){
          setFitnessDecimal(GeneticoBinario.clasificador.clasificar(this.getGenotipo()));
      }
      else setFitness(2*this.fenotipo);
    }

    @Override
    public void actualizar() {
        calcularFitness();
        calcularFenotipo();
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

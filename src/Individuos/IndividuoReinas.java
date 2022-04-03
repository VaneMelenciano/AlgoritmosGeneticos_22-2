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
public class IndividuoReinas extends Individuo{
   //private int[] genotipo;
    //private int fenotipo, fitness;
    
    //aleatoria 
    public IndividuoReinas(int n){ 
        super();
        setGenotipo(Herramientas.generarArregloReinas(n));
        actualizar();
    }
    public IndividuoReinas(int[] g){
        super(g);
    }
    public IndividuoReinas(){
        super();
    }

    public void calcularFitness() {
      setFitness(conflictos());// + conflictosH();
    }
    
    private int conflictos(){
       int confli = 0;
       for(int i=0; i<getGenotipo().length; i++){
           for(int j=0; j<getGenotipo().length; j++){
               if(j!=i){
                int r1 = Math.abs(getGenotipo()[i]-getGenotipo()[j]);
                int r2 = Math.abs(i-j);
                if(r1==r2){
                    confli++;
                }  
                if(getGenotipo()[i]==getGenotipo()[j]){
                    confli++;
                }
               }
           }
       }
       return confli;
    }
    @Override
    public void actualizar(){
      //calcularFitness();  
      setFitness(conflictos());
    } 
}

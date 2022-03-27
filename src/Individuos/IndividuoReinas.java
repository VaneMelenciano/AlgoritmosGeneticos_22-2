/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import Geneticos.SeleccionG;
import objetos.MatrizDistancia;
import java.util.LinkedHashSet;
import objetos.Herramientas;
import Individuos.Individuo;

/**
 *
 * @author Vanessa
 */
public class IndividuoReinas extends Individuo{
    //private int[] genotipo;
    //private int fenotipo, fitness;
    
    //aleatoria 
    /*public IndividuoReinas(int n){ 
        super();
        this.genotipo = Herramientas.generarArregloReinas(n);
        actualizar();
    }*/
    public IndividuoReinas(int n, SeleccionG g){
        super(n, g);
    }
    public IndividuoReinas(int[] g){
        //this.genotipo = g.clone();
        /*if(this.genotipo.length!=8){
            throw new RuntimeException(this.genotipo.length+" "+ "error");
        }*/
        //hacer los calculos de fenotipo/fitness
        //actualizar();
        super(g);
    }
    public IndividuoReinas(){
        super();
    }

    @Override
    public void calcularFitness() {
      this.fitness = conflictos();// + conflictosH();
    }
    
    private int conflictos(){
       int confli = 0;
       for(int i=0; i<this.genotipo.length; i++){
           for(int j=0; j<this.genotipo.length; j++){
               if(j!=i){
                int r1 = Math.abs(this.genotipo[i]-this.genotipo[j]);
                int r2 = Math.abs(i-j);
                if(r1==r2){
                    confli++;
                }  
                if(this.genotipo[i]==this.genotipo[j]){
                    confli++;
                }
               }
           }
       }
       return confli;
    }
    
    /*private int conflictosH(){
       LinkedHashSet<Integer> li = new LinkedHashSet<>();
       for(int i=0; i<this.genotipo.length; i++){
           li.add(this.genotipo[i]);
       }
       return (this.genotipo.length - li.size())*2;
    }*/
    
}

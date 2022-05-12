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
public final class IndividuoTSP extends Individuo{
    private boolean banderUsarElevaciones = false;
    private float porcentajeDistancia;
    private float porcentajeElevacion;
    //aleatoria 
    public IndividuoTSP(int ci, int nc){ //cuidad inicial, número de cuidades
        setGenotipo(Herramientas.generarArreglo(ci, nc));
        actualizar();
    }
    public IndividuoTSP(int ci, int nc, float porcentajeDistancia, float porcentajeElevacion){ //cuidad inicial, número de cuidades
        setGenotipo(Herramientas.generarArreglo(ci, nc));
        this.porcentajeDistancia= porcentajeDistancia;
        this.porcentajeElevacion = porcentajeElevacion;
        this.banderUsarElevaciones=true;
        actualizar();
    }
    public IndividuoTSP(int[] genotipo){
        setGenotipo(genotipo.clone());
        //hacer los calculos de fenotipo/fitness
        actualizar();
    }
    public IndividuoTSP(int[] genotipo, float porcentajeDistancia, float porcentajeElevacion){
        setGenotipo(genotipo.clone());
        this.banderUsarElevaciones=true;
        this.porcentajeDistancia= porcentajeDistancia;
        this.porcentajeElevacion = porcentajeElevacion;
        //hacer los calculos de fenotipo/fitness
        actualizar();
    }
     private void calcularFitness() {
        if(this.banderUsarElevaciones){
            float auxDistancia=0, auxDesgaste=0;
            for(int i=0; i<getGenotipo().length-1; i++){
                auxDistancia += Matriz.matriz[getGenotipo()[i]][getGenotipo()[i+1]];
                auxDesgaste += Matriz.matrizDesgaste[getGenotipo()[i]][getGenotipo()[i+1]];
            }
              auxDistancia += (Matriz.matriz[getGenotipo()[getGenotipo().length-1]][getGenotipo()[0]]);
              auxDesgaste += (Matriz.matrizDesgaste[getGenotipo()[getGenotipo().length-1]][getGenotipo()[0]]);
              int aux = Math.round((this.porcentajeDistancia*auxDistancia)+(this.porcentajeElevacion*auxDesgaste));
              this.setFitness(aux);
        }else{
          //genotipo es el arreglo aleatorio de la ruta
          //recorrer el genotipo y consultar la matriz de distancias
          for(int i=0; i<getGenotipo().length-1; i++){
              setFitness( getFitness() + Matriz.matriz[getGenotipo()[i]][getGenotipo()[i+1]]);
          }
          //ultima ruta hacia la iniciar (de regreso)
          setFitness( getFitness() + Matriz.matriz[getGenotipo()[getGenotipo().length-1]][getGenotipo()[0]]);
        }
        
    }
    /*private void calcularFitness() {
        if(this.banderUsarElevaciones){
            float auxDistancia=0, auxElevacion=0;
            for(int i=0; i<getGenotipo().length-1; i++){
                auxDistancia += Matriz.matriz[getGenotipo()[i]][getGenotipo()[i+1]];
                auxElevacion += Matriz.matrizElevaciones[getGenotipo()[i]][getGenotipo()[i+1]];
            }
              auxDistancia += (Matriz.matriz[getGenotipo()[getGenotipo().length-1]][getGenotipo()[0]]);
              auxElevacion += (Matriz.matrizElevaciones[getGenotipo()[getGenotipo().length-1]][getGenotipo()[0]]);
              int aux = Math.round((this.porcentajeDistancia*auxDistancia)+(this.porcentajeElevacion*auxElevacion));
              this.setFitness(aux);
        }else{
          //genotipo es el arreglo aleatorio de la ruta
          //recorrer el genotipo y consultar la matriz de distancias
          for(int i=0; i<getGenotipo().length-1; i++){
              setFitness( getFitness() + Matriz.matriz[getGenotipo()[i]][getGenotipo()[i+1]]);
          }
          //ultima ruta hacia la iniciar (de regreso)
          setFitness( getFitness() + Matriz.matriz[getGenotipo()[getGenotipo().length-1]][getGenotipo()[0]]);
        }
        
    }*/

    @Override
    public void actualizar() {
        calcularFitness();
    }
    
    public void setPorcentajes(float porcentajeDistancia, float porcentajeElevacion) {
        this.porcentajeDistancia= porcentajeDistancia;
        this.porcentajeElevacion = porcentajeElevacion;
        this.banderUsarElevaciones=true;
        this.actualizar();
    }
}

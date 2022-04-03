/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import java.util.ArrayList;

/**
 *
 * @author Vanessa
 */
public class Genetico {
    private int tamanioPoblacion; //numero de cuidades
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta

    public Genetico(int t, int n, double p){ //para TSP y binario
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        generarPoblacionInicial();
    }
    public Genetico(int t, int n, double p, int cI){ //para TSP y binario
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        generarPoblacionInicial(cI);
    }
    
    public void generarPoblacionInicial(){
        
    }
    public void generarPoblacionInicial(int n){
        
    }
    public void evolucionar(){
        
    }
     public void evolucionar(float porcentaje){
         
     }
    /**
     * @return the tamanioPoblacion
     */
    public int getTamanioPoblacion() {
        return tamanioPoblacion;
    }

    /**
     * @param tamanioPoblacion the tamanioPoblacion to set
     */
    public void setTamanioPoblacion(int tamanioPoblacion) {
        this.tamanioPoblacion = tamanioPoblacion;
    }

    /**
     * @return the numGeneraciones
     */
    public int getNumGeneraciones() {
        return numGeneraciones;
    }

    /**
     * @param numGeneraciones the numGeneraciones to set
     */
    public void setNumGeneraciones(int numGeneraciones) {
        this.numGeneraciones = numGeneraciones;
    }

    /**
     * @return the probMuta
     */
    public double getProbMuta() {
        return probMuta;
    }

    /**
     * @param probMuta the probMuta to set
     */
    public void setProbMuta(double probMuta) {
        this.probMuta = probMuta;
    }
    
}

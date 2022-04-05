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
    private int tamanioPoblacion;
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta
    public int n; //tamaño del tablero para Reinas

    private int seleccionM, seleccionP; // 0: torneo, 1: aleatorios
    private int muestreo; //tipo de muestreo-> 0: torneo, 1: aleatorio
    public Genetico(int t, int n, double p){ //para TSP y binario
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        generarPoblacionInicial();
    }
    public Genetico(int t, int n, double p, int cI){ //para TSP, binario y Reinas
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        this.n = cI;
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

    /**
     * @return the seleccionM
     */
    public int getSeleccionM() {
        return seleccionM;
    }

    /**
     * @param seleccionM the seleccionM to set
     */
    public void setSeleccionM(int seleccionM) {
        this.seleccionM = seleccionM;
    }

    /**
     * @return the seleccionP
     */
    public int getSeleccionP() {
        return seleccionP;
    }

    /**
     * @param seleccionP the seleccionP to set
     */
    public void setSeleccionP(int seleccionP) {
        this.seleccionP = seleccionP;
    }

    /**
     * @return the muestreo
     */
    public int getMuestreo() {
        return muestreo;
    }

    /**
     * @param muestreo the muestreo to set
     */
    public void setMuestreo(int muestreo) {
        this.muestreo = muestreo;
    }
    
    
}

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
public class Genetico implements Runnable{
    private int tamanioPoblacion;
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta
    private int n; //tamaño del tablero para Reinas //Numero más grande en instancias de prueba para SAT
    private int seleM; //0 es aleatorio, 1 es torneo
    private int seleP; //tipo de seleccion para padre y madre
    private int mueT; //tipo de muestreo-> 0: aleatorio, 1: torneo
    private float muestreo; //0.1 = 100% //tamaño de muestreo
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
    public Genetico(int t, int n, double p, int seleM, int seleP, int mueT, float mue){ //para TSP, binario y Reinas
        //tamaño de pobleación, num Generaciones, cuidad inicial o tamaño de tabl, 
        //prob Muta, seleccion para madre y padre, tipo de muestreo y tamaño de muestreo
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        this.seleM = seleM;
        this.seleP = seleP;
        this.mueT = mueT;
        this.muestreo = mue;
        //generarPoblacionInicial();
    }
    public Genetico(int t, int n, double p, int seleM, int seleP, int mueT, float mue, int nn){ //para TSP, binario y Reinas
        //tamaño de pobleación, num Generaciones, cuidad inicial o tamaño de tabl, 
        //prob Muta, seleccion para madre y padre, tipo de muestreo y tamaño de muestreo
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        this.seleM = seleM;
        this.seleP = seleP;
        this.mueT = mueT;
        this.muestreo = mue;
        this.n=nn; //numero de instancias para SAT
        //generarPoblacionInicial();
    }
    
    public void generarPoblacionInicial(){
        
    }
    public void generarPoblacionInicial(int n){
        
    }
    public void evolucionar(){
        
    }
     /*public void evolucionar(float porcentaje){
         
     }*/
     @Override
    public void run(){
        evolucionar();
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
     * @return the seleM
     */
    public int getSeleM() {
        return seleM;
    }

    /**
     * @param seleM the seleM to set
     */
    public void setSeleM(int seleM) {
        this.seleM = seleM;
    }

    /**
     * @return the seleP
     */
    public int getSeleP() {
        return seleP;
    }

    /**
     * @param seleP the seleP to set
     */
    public void setSeleP(int seleP) {
        this.seleP = seleP;
    }

    /**
     * @return the mueT
     */
    public int getMueT() {
        return mueT;
    }

    /**
     * @param mueT the mueT to set
     */
    public void setMueT(int mueT) {
        this.mueT = mueT;
    }

    /**
     * @return the muestreo
     */
    public float getMuestreo() {
        return muestreo;
    }

    /**
     * @param muestreo the muestreo to set
     */
    public void setMuestreo(float muestreo) {
        this.muestreo = muestreo;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }
    
}

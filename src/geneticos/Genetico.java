/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import geneticosParalelos.Consola;
import java.util.ArrayList;

/**
 *
 * @author Vanessa
 */
public class Genetico implements Runnable{
    public Consola consola;
    private int tamanioPoblacion;
    private int numeroGeneraciones;
    private double probabilidadMuta; //probabilidad de muta
    private int n; //tamaño del tablero para Reinas //Numero más grande en instancias de prueba para SAT
    private int seleccionMadre; //0 es aleatorio, 1 es torneo
    private int seleccionPadre; //tipo de seleccion para padre y madre
    private int tipoMuestreo; //tipo de porcentajeMuestreo-> 0: aleatorio, 1: torneo
    private float porcentajeMuestreo; //0.1 = 100% //tamaño de porcentajeMuestreo
    private boolean insertarMejorIndividuo;
    private boolean usarGeneticosParalelos;
    
    public Genetico(int t, int n, double p){ //para TSP y binario
        this.tamanioPoblacion=t;
        this.probabilidadMuta=p;
        this.numeroGeneraciones=n;
        this.insertarMejorIndividuo=false;
        this.usarGeneticosParalelos=false;
        generarPoblacionInicial();
    }
    public Genetico(int t, int n, double p, int cI){ //para TSP, binario y Reinas
        this.tamanioPoblacion=t;
        this.probabilidadMuta=p;
        this.numeroGeneraciones=n;
        this.n = cI;
        this.insertarMejorIndividuo=false;
        this.usarGeneticosParalelos=false;
        generarPoblacionInicial(cI);
    }
    public Genetico(int t, int n, double p, int seleM, int seleP, int mueT, float mue){ //para TSP, binario y Reinas
        //tamaño de pobleación, num Generaciones, cuidad inicial o tamaño de tabl, 
        //prob Muta, seleccion para madre y padre, tipo de porcentajeMuestreo y tamaño de porcentajeMuestreo
        this.tamanioPoblacion=t;
        this.probabilidadMuta=p;
        this.numeroGeneraciones=n;
        this.seleccionMadre = seleM;
        this.seleccionPadre = seleP;
        this.tipoMuestreo = mueT;
        this.porcentajeMuestreo = mue;
        this.insertarMejorIndividuo=false;
        this.usarGeneticosParalelos=false;
        //generarPoblacionInicial();
    }
    public Genetico(int t, int n, double p, int seleM, int seleP, int mueT, float mue, int nn){ //para TSP, binario y Reinas
        //tamaño de pobleación, num Generaciones, cuidad inicial o tamaño de tabl, 
        //prob Muta, seleccion para madre y padre, tipo de porcentajeMuestreo y tamaño de porcentajeMuestreo
        this.tamanioPoblacion=t;
        this.probabilidadMuta=p;
        this.numeroGeneraciones=n;
        this.seleccionMadre = seleM;
        this.seleccionPadre = seleP;
        this.tipoMuestreo = mueT;
        this.porcentajeMuestreo = mue;
        this.insertarMejorIndividuo=false;
        this.n=nn; //numero de instancias para SAT
        this.usarGeneticosParalelos=false;
        //generarPoblacionInicial();
    }
    public Genetico(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, int seleM, int seleP, int mueT, float mue, int nn, Consola consola){ //para TSP, binario y Reinas
        //tamaño de pobleación, num Generaciones, cuidad inicial o tamaño de tabl, 
        //prob Muta, seleccion para madre y padre, tipo de porcentajeMuestreo y tamaño de porcentajeMuestreo
        this.tamanioPoblacion=tamanioPoblacion;
        this.probabilidadMuta=probabilidadMuta;
        this.numeroGeneraciones=numeroGeneraciones;
        this.seleccionMadre = seleM;
        this.seleccionPadre = seleP;
        this.tipoMuestreo = mueT;
        this.porcentajeMuestreo = mue;
        this.n=nn; //numero de instancias para SAT
        this.consola=consola;
        this.insertarMejorIndividuo=false;
        this.usarGeneticosParalelos=true;
        //generarPoblacionInicial();
    }
    public void cambiarParametros(int tamanioPoblacion, double probabilidadMuta, int seleccionM, int seleccionP, int tipoMuestreo, float muestreo){
       //this.tamanioPoblacion = tamanioPoblacion;
       this.probabilidadMuta = probabilidadMuta;
       this.seleccionMadre = seleccionM;
       this.seleccionPadre = seleccionP;
       this.tipoMuestreo = tipoMuestreo;
       this.porcentajeMuestreo = muestreo;
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
        if(this.getUsarGeneticosParalelos())this.consola.setVisible(true);
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
     * @return the numeroGeneraciones
     */
    public int getNumeroGeneraciones() {
        return numeroGeneraciones;
    }

    /**
     * @param numeroGeneraciones the numeroGeneraciones to set
     */
    public void setNumeroGeneraciones(int numeroGeneraciones) {
        this.numeroGeneraciones = numeroGeneraciones;
    }

    /**
     * @return the probabilidadMuta
     */
    public double getProbabilidadMuta() {
        return probabilidadMuta;
    }

    /**
     * @param probabilidadMuta the probabilidadMuta to set
     */
    public void setProbabilidadMuta(double probabilidadMuta) {
        this.probabilidadMuta = probabilidadMuta;
    }

    /**
     * @return the seleccionMadre
     */
    public int getSeleccionMadre() {
        return seleccionMadre;
    }

    /**
     * @param seleccionMadre the seleccionMadre to set
     */
    public void setSeleccionMadre(int seleccionMadre) {
        this.seleccionMadre = seleccionMadre;
    }

    /**
     * @return the seleccionPadre
     */
    public int getSeleccionPadre() {
        return seleccionPadre;
    }

    /**
     * @param seleccionPadre the seleccionPadre to set
     */
    public void setSeleccionPadre(int seleccionPadre) {
        this.seleccionPadre = seleccionPadre;
    }

    /**
     * @return the tipoMuestreo
     */
    public int getTipoMuestreo() {
        return tipoMuestreo;
    }

    /**
     * @param tipoMuestreo the tipoMuestreo to set
     */
    public void setTipoMuestreo(int tipoMuestreo) {
        this.tipoMuestreo = tipoMuestreo;
    }

    /**
     * @return the porcentajeMuestreo
     */
    public float getPorcentajeMuestreo() {
        return porcentajeMuestreo;
    }

    /**
     * @param porcentajeMuestreo the porcentajeMuestreo to set
     */
    public void setPorcentajeMuestreo(float porcentajeMuestreo) {
        this.porcentajeMuestreo = porcentajeMuestreo;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @return the insertarMejorIndividuo
     */
    public boolean getInsertarMejorIndividuo() {
        return insertarMejorIndividuo;
    }

    /**
     * @param insertarMejorIndividuo the insertarMejorIndividuo to set
     */
    public void setInsertarMejorIndividuo(boolean insertarMejorIndividuo) {
        this.insertarMejorIndividuo = insertarMejorIndividuo;
    }

    /**
     * @return the usarGeneticosParalelos
     */
    public boolean getUsarGeneticosParalelos() {
        return usarGeneticosParalelos;
    }

    /**
     * @param usarGeneticosParalelos the usarGeneticosParalelos to set
     */
    public void setUsarGeneticosParalelos(boolean usarGeneticosParalelos) {
        this.usarGeneticosParalelos = usarGeneticosParalelos;
    }
    
    
}

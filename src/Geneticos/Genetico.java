/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geneticos;

import Individuos.Individuo;
import Individuos.IndividuoReinas;
import objetos.MatrizDistancia;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Vanessa
 */
public class Genetico {
    public int tamanioPoblacion; //numero de cuidades
    public int numGeneraciones;
    public double probMuta; //probabilidad de muta
    public  ArrayList<Individuo> poblacion;
    public SeleccionG g;
    //N-REINAS
    public int n; //tamaño del tablero y para TSP es cuidad inicial
    public Genetico(int t, int num, double p, int n, SeleccionG g){ //reinas y TSP
        
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=num;
        this.poblacion = new ArrayList<>();
        this.n=n;
        this.g=g;
        generarPoblacionInicial(n);
    }
    public Genetico(int t, int num, double p, SeleccionG g){ //Binario y TSP
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=num;
        this.poblacion = new ArrayList<>();
        if(g.equals(SeleccionG.TSP)){
            generarPoblacionInicialTSP();
        }
        else{ //Binario
            generarPoblacionInicial();
        }
        generarPoblacionInicial();
    }
    
    public Genetico(){
        
    }
    /*public Genetico(int t, int num, double p, int ci){ //TSP con cuidad inicial
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=num;
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial(ci);
    }*/

    public void generarPoblacionInicial(int n) {
         if(g.equals(SeleccionG.TSP)){
             for(int i=0; i<this.tamanioPoblacion; i++){
                Individuo in = new Individuo(n, MatrizDistancia.matriz.length);
                this.poblacion.add(in);
             }
         }
         else{ //TESP y Reinas
            for(int i=0; i<this.tamanioPoblacion; i++)
            this.poblacion.add(new Individuo(n, g)); 
         }
    }
    public void generarPoblacionInicial() {
        //se genere de manera aleatoria
        for(int i=0; i<this.tamanioPoblacion; i++)
            this.poblacion.add(new Individuo());
    }
    
    public void generarPoblacionInicialTSP() {
        //se genere de manera aleatoria
        Random r = new Random();
        int n = r.nextInt(MatrizDistancia.matriz.length);
        for(int i=0; i<this.tamanioPoblacion; i++)
            this.poblacion.add(new Individuo(n, MatrizDistancia.matriz.length));
    }
    
    public void actualizarPoblacion(ArrayList<Individuo> pobAux) {
        this.poblacion = new ArrayList<>();
        for(int i=0; i<pobAux.size(); i++){
            //System.out.println(pobAux.get(i).fitness);
            this.poblacion.add(new Individuo(pobAux.get(i).getGenotipo()));
            //this.poblacion.get(i).actualizar();
            //System.out.println(this.poblacion.get(i).fitness);
        }
        //for(int i=0; i<this.poblacion.size(); i++){
        //    System.out.println(this.poblacion.get(i).fitness);
        //}
    }
    public void evolucionar(float porcentaje){
        
    }
    public void evolucionar(){
        
    }
}

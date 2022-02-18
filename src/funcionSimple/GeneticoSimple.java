/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionSimple;

import java.util.ArrayList;
import objetos.Individuo;

/**
 *
 * @author Vanessa
 */
public class GeneticoSimple {
    private int tamanioPoblacion;
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta
    private ArrayList<Individuo> poblacion;
    
    public GeneticoSimple(int t, int n, double p){
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        this.poblacion = new ArrayList<>();
        generarPoblacionIniciatal();
    }
    public void evolucionar(){
        
    }

    private void generarPoblacionIniciatal() {
        //se genere de manera aleatoria
        for(int i=0; i<this.tamanioPoblacion; i++)
            this.poblacion.add(new Individuo());
        
    }
}

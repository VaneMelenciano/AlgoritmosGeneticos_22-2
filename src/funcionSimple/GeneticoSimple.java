/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionSimple;

import objetos.Muta;
import objetos.Seleccion;
import objetos.Cruza;
import java.util.ArrayList;
import objetos.Herramientas;

/**
 *
 * @author Vanessa
 */
public class GeneticoSimple {
    private int tamanioPoblacion;
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta
    private ArrayList<IndividuoBinario> poblacion;
    
        public GeneticoSimple(int t, int n, double p){
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        this.poblacion = new ArrayList<>();
        generarPoblacionIniciatal();
    }
    public void evolucionar(){
        ArrayList<IndividuoBinario> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara = Herramientas.generarArreglo(24);
        //someter a la poblacion a un proceso evolutivo
       for(int i=0; i<this.numGeneraciones; i++){
           //crear una población nueva
           pobAux = new ArrayList<>();
           for(int j=0; j<this.tamanioPoblacion; j++){
               //muestreo y/o selección
               //torneo
               IndividuoBinario madre = Seleccion.seleccionTorneo(poblacion);
               IndividuoBinario padre = Seleccion.seleccionAleatoria(poblacion);
               //cruza
               IndividuoBinario hijo = Cruza.cruzaMascara(madre, padre, mascara);
               //evaluar la posibilidad de muta
               if(Muta.muta(this.probMuta)){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           acualizarPoblacion(pobAux);
           
           IndividuoBinario mejor = Seleccion.seleccionTorneo(this.poblacion);
           if(mejor.getFenotipo()<16777215){
           System.out.print("\nGeneración :"+(i+1)+"\n\tFenotipo: "+mejor.getFenotipo() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           for(int m : mejor.getGenotipo()) 
               System.out.print(m);
           System.out.println();}
       }
    }

    private void generarPoblacionIniciatal() {
        //se genere de manera aleatoria
        for(int i=0; i<this.tamanioPoblacion; i++)
            this.poblacion.add(new IndividuoBinario());
        
    }

    private void acualizarPoblacion(ArrayList<IndividuoBinario> pobAux) {
        this.poblacion = new ArrayList<>();
        for(IndividuoBinario i : pobAux){
            this.poblacion.add(new IndividuoBinario(i.getGenotipo()));
        }
    }
}

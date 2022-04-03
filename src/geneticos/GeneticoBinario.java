/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.IndividuoBinario;
import java.util.ArrayList;
import objetos.Cruza;
import objetos.Herramientas;
import objetos.Muta;
import objetos.Seleccion;

/**
 *
 * @author Vanessa
 */
public class GeneticoBinario extends Genetico{
    /*private int tamanioPoblacion; //numero de cuidades
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta*/
    private ArrayList<IndividuoBinario> poblacion;
    
    public GeneticoBinario(int t, int n, double p){ //24, 20, 0.2
        super(t, n, p);
    }
    public void evolucionarBinario(){
        ArrayList<IndividuoBinario> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara = Herramientas.generarArregloBinario(24);
        //someter a la poblacion a un proceso evolutivo
       for(int i=0; i<getNumGeneraciones(); i++){
           //crear una población nueva
           pobAux = new ArrayList<>();
           for(int j=0; j<getTamanioPoblacion(); j++){
               //muestreo y/o selección
               //torneo
               IndividuoBinario madre = Seleccion.seleccionTorneoBinario(poblacion);
               IndividuoBinario padre = Seleccion.seleccionAleatoriaBinario(poblacion);
               //cruza
               IndividuoBinario hijo = Cruza.cruzaMascara(madre, padre, mascara);
               //evaluar la posibilidad de muta
               if(Muta.muta(getProbMuta())){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           actualizarPoblacion(pobAux);
           
           IndividuoBinario mejor = Seleccion.seleccionTorneoBinario(this.poblacion);
           if(mejor.getFenotipo()<16777215){
           System.out.print("\nGeneración :"+(i+1)+"\n\tFenotipo: "+mejor.getFenotipo() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           for(int m : mejor.getGenotipo()) 
               System.out.print(m);
           System.out.println();}
       }
    }
    
    @Override
    public void generarPoblacionInicial() {
        this.poblacion = new ArrayList<>();
        //se genere de manera aleatoria
        for(int i=0; i<getTamanioPoblacion(); i++)
            this.poblacion.add(new IndividuoBinario());
        
    }
    
     private void actualizarPoblacion(ArrayList<IndividuoBinario> pobAux) {
        this.poblacion = new ArrayList<>();
        for(IndividuoBinario i : pobAux){
            this.poblacion.add(new IndividuoBinario(i.getGenotipo()));
        }
    }
}

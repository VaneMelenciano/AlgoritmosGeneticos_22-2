/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geneticos;

import Individuos.Individuo;
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
    
    public GeneticoBinario(int t, int n, double p){ //24, 20, 0.2
        super(t, n, p, SeleccionG.Binario);
    }
    
    @Override
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
               IndividuoBinario madre = (IndividuoBinario) Seleccion.torneo(poblacion);
               IndividuoBinario padre = (IndividuoBinario) Seleccion.aleatoria(poblacion);
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
           actualizarPoblacion(cambiarIndividuo(pobAux));
           
           IndividuoBinario mejor = (IndividuoBinario) Seleccion.torneo(this.poblacion);
           if(mejor.getFenotipo()<16777215){
           System.out.print("\nGeneración :"+(i+1)+"\n\tFenotipo: "+mejor.getFenotipo() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           for(int m : mejor.getGenotipo()) 
               System.out.print(m);
           System.out.println();}
       }
    }
    public ArrayList<Individuo> cambiarIndividuo(ArrayList<IndividuoBinario> pob) {
        ArrayList<Individuo> pobAux = new ArrayList<>();
        for (IndividuoBinario aux111 : pob) {
                pobAux.add(aux111);
        }
        return pobAux;
    }
}

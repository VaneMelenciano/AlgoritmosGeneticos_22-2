/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geneticos;

import Individuos.Individuo;
import Individuos.IndividuoReinas;
import java.util.ArrayList;
import objetos.Cruza;
import objetos.Herramientas;
import objetos.Muestreo;
import objetos.Muta;
import objetos.Seleccion;

/**
 *
 * @author Vanessa
 */
public class GeneticoReina extends Genetico{
    //private int tamanioPoblacion; //numero de cuidades
    //private int numGeneraciones;
    //private double probMuta; //probabilidad de muta
    //private ArrayList<IndividuoReinas> poblacion;
    //private int n; //tamaño del tablero
    //private ArrayList<IndividuoTSP> poblacionTSP;
    
    public GeneticoReina(int t, int num, double p, int n){ //24, 20, 0.2
        /*this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=num;
        this.poblacion = new ArrayList<>();*/
        //this.n=n;
        //generarPoblacionInicial();
        super(t, num, p, n, SeleccionG.Reinas);
    }
    public void evolucionar(float porcentaje){
        ArrayList<IndividuoReinas> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara = Herramientas.generarArreglo(this.n);
        //someter a la poblacion a un proceso evolutivo
       for(int i=0; i<this.numGeneraciones; i++){
           //crear una población nueva
           pobAux = new ArrayList<>();
           
           int cantidad = Math.round(porcentaje*this.poblacion.size());
           //AAAHHHH
           //ArrayList<Individuo> aux11 = Muestreo.torneo(this.poblacion, cantidad);
           //ArrayList<Individuo> aux11 = Muestreo.aleatorio(this.poblacion, cantidad);
           /*for (Individuo aux111 : aux11) {
                pobAux.add((IndividuoReinas) aux111);
            }*/
           //MUESTREO
           pobAux = cambiarIndividuo(Muestreo.torneo(this.poblacion, cantidad));
           //pobAux = cambiarIndividuo(Muestreo.aleatorio(this.poblacion, cantidad));
           
           for(int j=0; j<this.tamanioPoblacion; j++){
               //muestreo y/o selección
               //torneo
               IndividuoReinas madre = (IndividuoReinas) Seleccion.torneo(poblacion);
               IndividuoReinas padre = (IndividuoReinas) Seleccion.aleatoria(poblacion);
               //cruza
               //IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, mascara); //CHECAR
               IndividuoReinas hijo = Cruza.cruzaReinas(madre, padre); //CHECAR
               //evaluar la posibilidad de muta
               if(Muta.muta(this.probMuta)){
                   Muta.muta(hijo); //CHECAR
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           actualizarPoblacion(cambiarIndividuo1(pobAux));
           
           IndividuoReinas mejor = (IndividuoReinas) Seleccion.torneo(this.poblacion);
           //if(mejor.getFenotipo()<16777215){
           System.out.print("\nGeneración :"+(i+1)+"\n\tFitness: "+mejor.getFitness() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           for(int m : mejor.getGenotipo()) 
               System.out.print(m);
           System.out.println();//}
       }
    }
    
    /*public void generarPoblacionInicial() {
        //se genere de manera aleatoria
        for(int i=0; i<this.tamanioPoblacion; i++)
            this.poblacion.add(new IndividuoReinas(n));
        
    }
    private void actualizarPoblacion(ArrayList<IndividuoReinas> pobAux) {
        this.poblacion = new ArrayList<>();
        for(IndividuoReinas i : pobAux){
            this.poblacion.add(new IndividuoReinas(i.getGenotipo()));
        }
    }*/

    public ArrayList<IndividuoReinas> cambiarIndividuo(ArrayList<Individuo> pob) {
        ArrayList<IndividuoReinas> pobAux = new ArrayList<>();
        for (Individuo aux111 : pob) {
                pobAux.add((IndividuoReinas) aux111);
        }
        return pobAux;
    }
    public ArrayList<Individuo> cambiarIndividuo1(ArrayList<IndividuoReinas> pob) {
        ArrayList<Individuo> pobAux = new ArrayList<>();
        for (IndividuoReinas aux111 : pob) {
                pobAux.add(aux111);
        }
        return pobAux;
    }
}

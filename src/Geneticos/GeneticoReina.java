/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geneticos;

import Individuos.Individuo;
import Individuos.IndividuoReinas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
    private ArrayList<IndividuoReinas> pob;
    //private int n; //tamaño del tablero
    //private ArrayList<IndividuoTSP> poblacionTSP;
    
    public GeneticoReina(int t, int num, double p, int n){ //24, 20, 0.2
        /*this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=num;
        this.poblacion = new ArrayList<>();*/
        //this.n=n;
        //generarPoblacionInicial();
        //super();
        super(t, num, p, n, SeleccionG.Reinas);
        generarPoblacionInicialReina();
    }
    Random r = new Random();
    
    public void evolucionar(float porcentaje){
        ArrayList<IndividuoReinas> pobAux;
        //una sola mascara para todo el proceso evolutivo
        //int[] mascara = Herramientas.generarArreglo(this.n);
        //someter a la poblacion a un proceso evolutivo
        IndividuoReinas madre = Seleccion.torneoMenorR(pob);
       for(int i=0; i<this.numGeneraciones; i++){
           int[] mascara = Herramientas.generarArreglo(this.n);
           
           System.out.println("\nGeneración :"+(i+1));
           //System.out.println("Mascara" + Arrays.toString(mascara));
           //crear una población nueva
           pobAux = new ArrayList<>();
           
           int cantidad = Math.round(porcentaje*this.pob.size());
           //AAAHHHH
           //ArrayList<Individuo> aux11 = Muestreo.torneo(this.poblacion, cantidad);
           //ArrayList<Individuo> aux11 = Muestreo.aleatorio(this.poblacion, cantidad);
           /*for (Individuo aux111 : aux11) {
                pobAux.add((IndividuoReinas) aux111);
            }*/
           //MUESTREO
           //pobAux = cambiarIndividuo(Muestreo.torneo(this.poblacion, cantidad));
           //pobAux = cambiarIndividuo(Muestreo.aleatorio(this.poblacion, cantidad));
            //IndividuoReinas madre = Seleccion.torneoMenorR(pob);//(IndividuoReinas) Seleccion.torneo(poblacion);
            if(i%2==0){
                   r = new Random(System.currentTimeMillis());
               }  
           for(int j=0; j<this.tamanioPoblacion; j++){
           //for(int j=0; j<this.tamanioPoblacion-cantidad; j++){
               //muestreo y/o selección
               //torneo
               //IndividuoReinas madre = new IndividuoReinas(Seleccion.torneoMenor(poblacion));//(IndividuoReinas) Seleccion.torneo(poblacion);
               //IndividuoReinas madre = Seleccion.torneoMenorR(pob);//(IndividuoReinas) Seleccion.torneo(poblacion);
               //IndividuoReinas padre = Seleccion.aleatoriaR(pob);//(IndividuoReinas) Seleccion.aleatoria(poblacion);
               //Random r = new Random();
               
       int pos = r.nextInt(pob.size());
       //System.out.println("Aleatorio: " + pos + " " + Arrays.toString(pob.get(pos).getGenotipo()) + " " + pob.get(pos).fitness);
       IndividuoReinas padre = new IndividuoReinas(pob.get(pos).getGenotipo());
       


                //cruza
               //IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, mascara); //CHECAR
               //IndividuoReinas hijo = Cruza.cruzaReinas(madre, padre); //CHECAR
               IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, mascara); //CHECAR
               //evaluar la posibilidad de muta
               if(Muta.muta(this.probMuta)){
                   Muta.muta(hijo); //CHECAR
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
               //System.out.println("Mama: " + Arrays.toString(madre.genotipo) + "  Papa: " + Arrays.toString(padre.genotipo) + "    Hijo: " + Arrays.toString(hijo.genotipo) + " " + hijo.fitness);
               
           }
           //for(int x=0; x<this.poblacion.size(); x++){
           //    System.out.println(this.poblacion.get(x).fitness);
           //}
           //se tiene que acualizar la población
           actualizarPoblacion(cambiarIndividuo1(pobAux));
           actualizarPoblacionReina(pobAux);
           /*for(int x=0; x<this.poblacion.size(); x++){
               System.out.println(this.poblacion.get(x).fitness);
           }*/
           IndividuoReinas mejor = Seleccion.torneoMenorR(this.pob);
           //if(mejor.getFenotipo()<16777215){
           System.out.print("\n\tFitness: "+mejor.getFitness() + "  Genotipo: " + Arrays.toString(mejor.getGenotipo())); //con 24, el mayor puede ser -> 16,777,215
           //System.out.print("\nGeneración :"+(i+1)+"\n\tFitness: "+mejor.getFitness() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           System.out.println();//}
           madre = mejor;
       }
    }
    
    /*public void evolucionar(float porcentaje){
        ArrayList<IndividuoReinas> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara = Herramientas.generarArreglo(this.n);
        //someter a la poblacion a un proceso evolutivo
       for(int i=0; i<this.numGeneraciones; i++){
           System.out.println("\nGeneración :"+(i+1));
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
           //pobAux = cambiarIndividuo(Muestreo.torneo(this.poblacion, cantidad));
           //pobAux = cambiarIndividuo(Muestreo.aleatorio(this.poblacion, cantidad));
           
           /*for(int j=0; j<this.tamanioPoblacion; j++){
           //for(int j=0; j<this.tamanioPoblacion-cantidad; j++){
               //muestreo y/o selección
               //torneo
               IndividuoReinas madre = new IndividuoReinas(Seleccion.torneoMenor(poblacion));//(IndividuoReinas) Seleccion.torneo(poblacion);
               IndividuoReinas padre = new IndividuoReinas(Seleccion.aleatoria(poblacion));//(IndividuoReinas) Seleccion.aleatoria(poblacion);
               //cruza
               //IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, mascara); //CHECAR
               //IndividuoReinas hijo = Cruza.cruzaReinas(madre, padre); //CHECAR
               IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, Herramientas.generarArregloReinas(padre.getGenotipo().length)); //CHECAR
               //evaluar la posibilidad de muta
               if(Muta.muta(this.probMuta)){
                   Muta.muta(hijo); //CHECAR
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
               System.out.println("Mama: " + Arrays.toString(madre.genotipo) + "  Papa: " + Arrays.toString(padre.genotipo) + "    Hijo: " + Arrays.toString(hijo.genotipo) + " " + hijo.fitness);
               
           }
           //for(int x=0; x<this.poblacion.size(); x++){
           //    System.out.println(this.poblacion.get(x).fitness);
           //}
           //se tiene que acualizar la población
           actualizarPoblacion(cambiarIndividuo1(pobAux));
           /*for(int x=0; x<this.poblacion.size(); x++){
               System.out.println(this.poblacion.get(x).fitness);
           }*/
           /*IndividuoReinas mejor = new IndividuoReinas(Seleccion.torneoMenor(this.poblacion));
           //if(mejor.getFenotipo()<16777215){
           System.out.print("\n\tFitness: "+mejor.getFitness() + "  Genotipo: " + Arrays.toString(mejor.getGenotipo())); //con 24, el mayor puede ser -> 16,777,215
           //System.out.print("\nGeneración :"+(i+1)+"\n\tFitness: "+mejor.getFitness() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           System.out.println();//}
       }
    }*/
    
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
        for (Individuo aux : pob) {
            pobAux.add(new IndividuoReinas(aux));
        }
        return pobAux;
    }
    public ArrayList<Individuo> cambiarIndividuo1(ArrayList<IndividuoReinas> pob) {
        ArrayList<Individuo> pobAux = new ArrayList<>();
        for (IndividuoReinas aux111 : pob) {
                pobAux.add(aux111);
                //System.out.println(aux111.fitness);
        }
        return pobAux;
    }

    private void generarPoblacionInicialReina() {
        this.pob = new ArrayList<>();
        for(int i=0; i<this.tamanioPoblacion; i++)
            this.pob.add(new IndividuoReinas(n)); 

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actualizarPoblacionReina(ArrayList<IndividuoReinas> pobAux) {
         this.pob = new ArrayList<>();
        for(int i=0; i<pobAux.size(); i++){
            //System.out.println(pobAux.get(i).fitness);
            this.pob.add(new IndividuoReinas(pobAux.get(i).getGenotipo()));
            //this.poblacion.get(i).actualizar();
            //System.out.println(this.poblacion.get(i).fitness);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

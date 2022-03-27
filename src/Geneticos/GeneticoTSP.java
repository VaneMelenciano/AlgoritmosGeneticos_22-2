/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geneticos;

import Individuos.Individuo;
import Individuos.IndividuoTSP;
import java.util.ArrayList;
import java.util.Arrays;
import objetos.Cruza;
import objetos.MatrizDistancia;
import objetos.Muestreo;
import objetos.Muta;
import objetos.Seleccion;

/**
 *
 * @author Vanessa
 */
public class GeneticoTSP extends Genetico{
    
    public GeneticoTSP(int t, int n, double p){ //24, 20, 0.2 //sin ciudad inicial
        super(t, n, p, SeleccionG.TSP);
    }
    public GeneticoTSP(int t, int n, double p, int cuidadI){ //24, 20, 0.2
        /*this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        this.poblacionTSP = new ArrayList<>();
        generarPoblacionInicialTSP(cuidadI);*/
        super(t, n, p, cuidadI);
    }
    
    public void evolucionarTSP(){
        //String [][] matrizRes = new String[this.numGeneraciones+1][this.poblacionTSP.get(0).getGenotipo().length+2];
        ArrayList<IndividuoTSP> pobAux;
        //someter a la poblacion a un proceso evolutivo
        int mejorRes=0, genRes=0;
       for(int i=0; i<this.numGeneraciones; i++){
           //System.out.println("GENERACIÓN: " + i);
           //crear una población nueva           
           pobAux = new ArrayList<>();
           for(int j=0; j<this.tamanioPoblacion; j++){
               IndividuoTSP madre = (IndividuoTSP) Seleccion.torneo(poblacion);
               
               /*System.out.println("MADRE: ");
               System.out.println(Arrays.toString(madre.getGenotipo()) + " " + madre.getFitness());*/
               /**/
               IndividuoTSP padre = (IndividuoTSP) Seleccion.aleatoria(poblacion);
               //System.out.println("PADRE: ");
               //System.out.println(Arrays.toString(padre.getGenotipo()) + " " + padre.getFitness());
               //cruza
               IndividuoTSP hijo = Cruza.cruzaTSP(madre, padre);
               /*System.out.println("HIJO: ");
               System.out.println(Arrays.toString(hijo.getGenotipo()) + " " + hijo.getFitness());*/
               /**/
               //evaluar la posibilidad de muta
               if(Muta.muta(this.probMuta)){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           actualizarPoblacion(cambiarIndividuo1(pobAux));
           
           IndividuoTSP mejor = (IndividuoTSP) Seleccion.torneo(this.poblacion);
           //System.out.println("\nGeneración :"+(i+1) + "\n  mejor individuo: ");
           /*System.out.println("\n  Mejor individuo: ");
           for(int k=0; k<mejor.getGenotipo().length-1; k++){
               System.out.print(mejor.getGenotipo()[k] + ", ");
            }System.out.print(mejor.getGenotipo()[mejor.getGenotipo().length-1]);
            System.out.println("\n\tFitness: "+mejor.getFitness()+"\n");*/
            
            //AGREGAR MEJOR INDIVIDUO A TXT
            /*matrizRes[i][0] = "g" + i;
            for(int k=0; k<mejor.getGenotipo().length ; k++){
               matrizRes[i][k+1] = "\t" +mejor.getGenotipo()[k] + "\t"; //imprime camino de mejor individuo
            } matrizRes[i][mejor.getGenotipo().length+1] = "" + mejor.getFitness(); */
            //VER CUAL ES EL MEJOR RESULTADO ENTRE TODAS LAS GENERACIONES
            if(i==0){
                mejorRes = mejor.getFitness();
                genRes=i;
                System.out.println("Generacion: " + genRes + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            
            } 
            else if(mejorRes>mejor.getFitness()){
                mejorRes = mejor.getFitness();
                genRes=i;
                System.out.println("Generacion: " + genRes + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            
            }
       }
       /*matrizRes[this.numGeneraciones][0] = "Mejor resultado:";
       matrizRes[this.numGeneraciones][1] = "\t" + mejorRes;
       matrizRes[this.numGeneraciones][2] = "\tGeneracion:";
       matrizRes[this.numGeneraciones][3] = "\t" + genRes;
       
       System.out.println("Mejor resultado: " + mejorRes + "  Generacin: " + genRes);
       for(int i=4; i<this.poblacionTSP.get(0).getGenotipo().length+1; i++) matrizRes[this.numGeneraciones][i] = "";
       //MatrizDistancia.guardarArchivo(matrizRes);*/
    }
    
    public void evolucionarTSP(float porcentaje){
        String [][] matrizRes = new String[this.numGeneraciones+1][this.poblacion.get(0).getGenotipo().length+2];
        ArrayList<IndividuoTSP> pobAux;
        
        //someter a la poblacion a un proceso evolutivo
        int mejorRes=0, genRes=0;
       for(int i=0; i<this.numGeneraciones; i++){
           pobAux = new ArrayList<>();
           //crear una población nueva
           ///MUESTREO
                    //Torneo, aleatorio y 50/50
           int cantidad = Math.round(porcentaje*this.poblacion.size());
           //pobAux = Muestreo.torneo(this.poblacionTSP, cantidad);
           pobAux = cambiarIndividuo(Muestreo.aleatorio(this.poblacion, cantidad));
           //pobAux = Muestreo.mitad(this.poblacionTSP, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.aleatorio(this.poblacionTSP, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.mitad(this.poblacionTSP, cantidad);
           
           //crear una población nueva   
           for(int j=0; j<this.tamanioPoblacion-cantidad; j++){
               IndividuoTSP madre = (IndividuoTSP) Seleccion.torneo(poblacion);
               
               /*System.out.println("MADRE: ");
               System.out.println(Arrays.toString(madre.getGenotipo()) + " " + madre.getFitness());*/
               /**/
               IndividuoTSP padre = (IndividuoTSP) Seleccion.aleatoria(poblacion);
               //System.out.println("PADRE: ");
               //System.out.println(Arrays.toString(padre.getGenotipo()) + " " + padre.getFitness());
               //cruza
               IndividuoTSP hijo = Cruza.cruzaTSP(madre, padre);
               /*System.out.println("HIJO: ");
               System.out.println(Arrays.toString(hijo.getGenotipo()) + " " + hijo.getFitness());*/
               /**/
               //evaluar la posibilidad de muta
               if(Muta.muta(this.probMuta)){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           actualizarPoblacion(cambiarIndividuo1(pobAux));
           
           IndividuoTSP mejor = (IndividuoTSP) Seleccion.torneo(this.poblacion);
           //System.out.println("\nGeneración :"+(i+1) + "\n  mejor individuo: ");
           /*System.out.println("\n  Mejor individuo: ");
           for(int k=0; k<mejor.getGenotipo().length-1; k++){
               System.out.print(mejor.getGenotipo()[k] + ", ");
            }System.out.print(mejor.getGenotipo()[mejor.getGenotipo().length-1]);
            System.out.println("\n\tFitness: "+mejor.getFitness()+"\n");*/
            
            //AGREGAR MEJOR INDIVIDUO A TXT
            matrizRes[i][0] = "g" + i;
            for(int k=0; k<mejor.getGenotipo().length ; k++){
               matrizRes[i][k+1] = "\t" +mejor.getGenotipo()[k] + "\t"; //imprime camino de mejor individuo
            } matrizRes[i][mejor.getGenotipo().length+1] = "" + mejor.getFitness(); 
            //VER CUAL ES EL MEJOR RESULTADO ENTRE TODAS LAS GENERACIONES
            if(i==0){
                mejorRes = mejor.getFitness();
                genRes=i;
                System.out.println("Generacion: " + genRes + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            } 
            else if(mejorRes>mejor.getFitness()){
                mejorRes = mejor.getFitness();
                genRes=i;
                System.out.println("Generacion: " + genRes + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            }
       }
       matrizRes[this.numGeneraciones][0] = "Mejor resultado:";
       matrizRes[this.numGeneraciones][1] = "\t" + mejorRes;
       matrizRes[this.numGeneraciones][2] = "\tGeneracion:";
       matrizRes[this.numGeneraciones][3] = "\t" + genRes;
       
       //System.out.println("Mejor resultado: " + mejorRes + "  Generacin: " + genRes);
       for(int i=4; i<this.poblacion.get(0).getGenotipo().length+1; i++) matrizRes[this.numGeneraciones][i] = "";
       MatrizDistancia.guardarArchivo(matrizRes);
    }
    
    public void evolucionarTSP(int porcentaje){ //porcentaje que se va a tomar de muestreo
        String [][] matrizRes = new String[this.numGeneraciones+1][this.tamanioPoblacion+1];
        
        ArrayList<IndividuoTSP> pobAux;
        //someter a la poblacion a un proceso evolutivo
        int mejorRes=0, genRes=0;
       for(int i=0; i<this.numGeneraciones; i++){
           pobAux = new ArrayList<>();
           //crear una población nueva
           ///MUESTREO
                    //Torneo, aleatorio y 50/50
           int cantidad = Math.round(porcentaje*this.poblacion.size());
           ArrayList<IndividuoTSP> nueAux = cambiarIndividuo(Muestreo.torneo(this.poblacion, cantidad));
           //ArrayList<IndividuoTSP> nueAux = Muestreo.aleatorio(this.poblacionTSP, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.mitad(this.poblacionTSP, cantidad);

           for(int j=0; j<this.tamanioPoblacion/*-cantidad*/; j++){
               //selección:
               //torneo
               IndividuoTSP madre = (IndividuoTSP) Seleccion.torneo(poblacion);
               IndividuoTSP padre = (IndividuoTSP) Seleccion.aleatoria(poblacion);
               //cruza
               IndividuoTSP hijo = Cruza.cruzaTSP(madre, padre);
               //evaluar la posibilidad de muta
               if(Muta.muta(this.probMuta)){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se agrega la muestra de poblacion a pobAux
           //for(int p=0; p<nueAux.size(); p++) pobAux.add(nueAux.get(p));
           //se tiene que acualizar la población
           actualizarPoblacion(cambiarIndividuo1(pobAux));
           
           IndividuoTSP mejor = (IndividuoTSP) Seleccion.torneo(this.poblacion);
           /*System.out.println("\nGeneración :"+(i+1) + "\n  mejor individuo: ");
           for(int k=0; k<mejor.getGenotipo().length-1; k++){
               System.out.print(mejor.getGenotipo()[k] + ", ");
            }System.out.print(mejor.getGenotipo()[mejor.getGenotipo().length-1]);
            System.out.println("\n\tFitness: "+mejor.getFitness());*/
            
           //System.out.print("\r" + Arrays.toString(mejor.getGenotipo()) + " " + mejor.getFitness() + " " + (i + 1));
           
           
            //AGREGAR MEJOR INDIVIDUO A TXT
            matrizRes[i][0] = "g" + (i+1);
            for(int k=0, l=1; k<mejor.getGenotipo().length && l<mejor.getGenotipo().length+1; k++, l++){
               matrizRes[i][l] =  "\t" +mejor.getGenotipo()[k] + "\t"; 
            } matrizRes[i][mejor.getGenotipo().length] = "" + mejor.getFitness(); 
            //VER CUAL ES EL MEJOR RESULTADO ENTRE TODAS LAS GENERACIONES
            if(i==0){
                mejorRes = mejor.getFitness();
                genRes=i;
                System.out.print( Arrays.toString(mejor.getGenotipo()) + " " + mejor.getFitness() + " " + (i + 1));
            } 
            else if(mejorRes>mejor.getFitness()){
                mejorRes = mejor.getFitness();
                genRes=i;
                System.out.print("\r" + Arrays.toString(mejor.getGenotipo()) + " " + mejor.getFitness() + " " + (i + 1));
            }
       }
       matrizRes[this.numGeneraciones][0] = "Mejor resultado:";
       matrizRes[this.numGeneraciones][1] = "\t" + mejorRes;
       matrizRes[this.numGeneraciones][2] = "\tGeneracion:";
       matrizRes[this.numGeneraciones][3] = "\t" + genRes;
       for(int i=4; i<this.tamanioPoblacion+1; i++) matrizRes[this.numGeneraciones][i] = "";
       MatrizDistancia.guardarArchivo(matrizRes);
    } //CON MUESTREO

    public ArrayList<IndividuoTSP> cambiarIndividuo(ArrayList<Individuo> pob) {
        ArrayList<IndividuoTSP> pobAux = new ArrayList<>();
        for (Individuo aux111 : pob) {
                pobAux.add((IndividuoTSP) aux111);
        }
        return pobAux;
    }
    public ArrayList<Individuo> cambiarIndividuo1(ArrayList<IndividuoTSP> pob) {
        ArrayList<Individuo> pobAux = new ArrayList<>();
        for (IndividuoTSP aux111 : pob) {
                pobAux.add(aux111);
        }
        return pobAux;
    }
}


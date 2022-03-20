/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionSimple;

import TSP.IndividuoTSP;
import TSP.MatrizDistancia;
import objetos.Muta;
import objetos.Seleccion;
import objetos.Cruza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import objetos.Herramientas;
import objetos.Muestreo;

/**
 *
 * @author Vanessa
 */
public class GeneticoSimple {
    private int tamanioPoblacion; //numero de cuidades
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta
    private ArrayList<IndividuoBinario> poblacion;
    public ArrayList<IndividuoTSP> poblacionTSP;
    //private ArrayList<IndividuoTSP> poblacionTSP;
    
    public GeneticoSimple(int t, int n, double p){ //24, 20, 0.2
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        this.poblacion = new ArrayList<>();
        this.poblacionTSP = new ArrayList<>();
        generarPoblacionInicial();
        generarPoblacionInicialTSP();
    }
    public GeneticoSimple(int t, int n, double p, int cuidadI){ //24, 20, 0.2
        this.tamanioPoblacion=t;
        this.probMuta=p;
        this.numGeneraciones=n;
        this.poblacionTSP = new ArrayList<>();
        generarPoblacionInicialTSP(cuidadI);
    }
    public void evolucionarBinario(){
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
           actualizarPoblacion(pobAux);
           
           IndividuoBinario mejor = Seleccion.seleccionTorneo(this.poblacion);
           if(mejor.getFenotipo()<16777215){
           System.out.print("\nGeneración :"+(i+1)+"\n\tFenotipo: "+mejor.getFenotipo() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           for(int m : mejor.getGenotipo()) 
               System.out.print(m);
           System.out.println();}
       }
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
               IndividuoTSP madre = Seleccion.seleccionTorneoTSP(poblacionTSP);
               
               /*System.out.println("MADRE: ");
               System.out.println(Arrays.toString(madre.getGenotipo()) + " " + madre.getFitness());*/
               /**/
               IndividuoTSP padre = Seleccion.seleccionAleatoriaTSP(poblacionTSP);
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
           actualizarPoblacionTSP(pobAux);
           
           IndividuoTSP mejor = Seleccion.seleccionTorneoTSP(this.poblacionTSP);
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
        String [][] matrizRes = new String[this.numGeneraciones+1][this.poblacionTSP.get(0).getGenotipo().length+2];
        ArrayList<IndividuoTSP> pobAux;
        
        //someter a la poblacion a un proceso evolutivo
        int mejorRes=0, genRes=0;
       for(int i=0; i<this.numGeneraciones; i++){
           pobAux = new ArrayList<>();
           //crear una población nueva
           ///MUESTREO
                    //Torneo, aleatorio y 50/50
           int cantidad = Math.round(porcentaje*this.poblacionTSP.size());
           pobAux = Muestreo.torneo(this.poblacionTSP, cantidad);
           //pobAux = Muestreo.aleatorio(this.poblacionTSP, cantidad);
           //pobAux = Muestreo.mitad(this.poblacionTSP, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.aleatorio(this.poblacionTSP, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.mitad(this.poblacionTSP, cantidad);
           
           //crear una población nueva   
           for(int j=0; j<this.tamanioPoblacion-cantidad; j++){
               IndividuoTSP madre = Seleccion.seleccionTorneoTSP(poblacionTSP);
               
               /*System.out.println("MADRE: ");
               System.out.println(Arrays.toString(madre.getGenotipo()) + " " + madre.getFitness());*/
               /**/
               IndividuoTSP padre = Seleccion.seleccionAleatoriaTSP(poblacionTSP);
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
           actualizarPoblacionTSP(pobAux);
           
           IndividuoTSP mejor = Seleccion.seleccionTorneoTSP(this.poblacionTSP);
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
       for(int i=4; i<this.poblacionTSP.get(0).getGenotipo().length+1; i++) matrizRes[this.numGeneraciones][i] = "";
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
           int cantidad = Math.round(porcentaje*this.poblacionTSP.size());
           ArrayList<IndividuoTSP> nueAux = Muestreo.torneo(this.poblacionTSP, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.aleatorio(this.poblacionTSP, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.mitad(this.poblacionTSP, cantidad);

           for(int j=0; j<this.tamanioPoblacion/*-cantidad*/; j++){
               //selección:
               //torneo
               IndividuoTSP madre = Seleccion.seleccionTorneoTSP(poblacionTSP);
               IndividuoTSP padre = Seleccion.seleccionAleatoriaTSP(poblacionTSP);
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
           actualizarPoblacionTSP(pobAux);
           
           IndividuoTSP mejor = Seleccion.seleccionTorneoTSP(this.poblacionTSP);
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

    public void generarPoblacionInicial() {
        //se genere de manera aleatoria
        for(int i=0; i<this.tamanioPoblacion; i++)
            this.poblacion.add(new IndividuoBinario());
        
    }
    public void generarPoblacionInicialTSP() {
        //se genere de manera aleatoria
        Random r = new Random();
        int n = r.nextInt(MatrizDistancia.matriz.length);
        for(int i=0; i<this.tamanioPoblacion; i++)
            this.poblacionTSP.add(new IndividuoTSP(n, MatrizDistancia.matriz.length));
        
    }
    public void generarPoblacionInicialTSP(int n) {
        //System.out.println("POBLACIÓN INICIAL");
        //se genere de manera aleatoria
        for(int i=0; i<this.tamanioPoblacion; i++){
            IndividuoTSP in = new IndividuoTSP(n, MatrizDistancia.matriz.length);
            this.poblacionTSP.add(in);
            //VER EL INDIVIDUO
            //Herramientas.imprimirArreglo(in.getGenotipo());
            //System.out.println("\t Fitness: " + in.getFitness());
        }  
    }
    

    private void actualizarPoblacion(ArrayList<IndividuoBinario> pobAux) {
        this.poblacion = new ArrayList<>();
        for(IndividuoBinario i : pobAux){
            this.poblacion.add(new IndividuoBinario(i.getGenotipo()));
        }
    }
    
    private void actualizarPoblacionTSP(ArrayList<IndividuoTSP> pobAux) {
        this.poblacionTSP = new ArrayList<>();
        for(IndividuoTSP i : pobAux){
            this.poblacionTSP.add(new IndividuoTSP(i.getGenotipo()));
        }
    }
}

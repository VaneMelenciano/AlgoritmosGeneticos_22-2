/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.IndividuoTSP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import objetos.Cruza;
import objetos.Matriz;
import objetos.Muestreo;
import objetos.Muta;
import objetos.Seleccion;

/**
 *
 * @author Vanessa
 */
public final class GeneticoTSP extends Genetico{
    /*private int tamanioPoblacion; //numero de cuidades
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta*/
    public ArrayList<IndividuoTSP> poblacion;
    //private ArrayList<IndividuoTSP> poblacion;
    
    /*public GeneticoTSP(int t, int n, double p){ //24, 20, 0.2
        getTamanioPoblacion()=t;
        getProbMuta()=p;
        getNumGeneraciones()=n;
        this.poblacion = new ArrayList<>();
        generarPoblacionInicialTSP();
    }
    public GeneticoTSP(int t, int n, double p, int cuidadI){ //24, 20, 0.2
        getTamanioPoblacion()=t;
        getProbMuta()=p;
        getNumGeneraciones()=n;
        this.poblacion = new ArrayList<>();
        generarPoblacionInicialTSP(cuidadI);
    }*/
    public GeneticoTSP(int t, int n, double p){
        super(t, n, p);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
    public GeneticoTSP(int t, int n, double p, int cuidadI){ //24, 20, 0.2
        super(t, n, p, cuidadI);
        //this.poblacion = new ArrayList<>();
        //generarPoblacionInicial(cuidadI);
    }

    /**
     *
     */
    @Override
    public void evolucionar(){
        //String [][] matrizRes = new String[getNumGeneraciones()+1][this.poblacion.get(0).getGenotipo().length+2];
        ArrayList<IndividuoTSP> pobAux;
        //someter a la poblacion a un proceso evolutivo
        int mejorRes=0, genRes=0;
       for(int i=0; i<getNumGeneraciones(); i++){
           //System.out.println("GENERACIÓN: " + i);
           //crear una población nueva           
           pobAux = new ArrayList<>();
           for(int j=0; j<getTamanioPoblacion(); j++){
               IndividuoTSP madre = Seleccion.seleccionTorneoTSP(poblacion);
               
               /*System.out.println("MADRE: ");
               System.out.println(Arrays.toString(madre.getGenotipo()) + " " + madre.getFitness());*/
               /**/
               IndividuoTSP padre = Seleccion.seleccionAleatoriaTSP(poblacion);
               //System.out.println("PADRE: ");
               //System.out.println(Arrays.toString(padre.getGenotipo()) + " " + padre.getFitness());
               //cruza
               IndividuoTSP hijo = Cruza.cruzaTSP(madre, padre);
               /*System.out.println("HIJO: ");
               System.out.println(Arrays.toString(hijo.getGenotipo()) + " " + hijo.getFitness());*/
               /**/
               //evaluar la posibilidad de muta
               if(Muta.muta(getProbMuta())){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           actualizarPoblacion(pobAux);
           
           IndividuoTSP mejor = Seleccion.seleccionTorneoTSP(this.poblacion);
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
       /*matrizRes[getNumGeneraciones()][0] = "Mejor resultado:";
       matrizRes[getNumGeneraciones()][1] = "\t" + mejorRes;
       matrizRes[getNumGeneraciones()][2] = "\tGeneracion:";
       matrizRes[getNumGeneraciones()][3] = "\t" + genRes;
       
       System.out.println("Mejor resultado: " + mejorRes + "  Generacin: " + genRes);
       for(int i=4; i<this.poblacion.get(0).getGenotipo().length+1; i++) matrizRes[getNumGeneraciones()][i] = "";
       //Matriz.guardarArchivo(matrizRes);*/
    }
    
    @Override
    public void evolucionar(float porcentaje){
        String [][] matrizRes = new String[getNumGeneraciones()+1][this.poblacion.get(0).getGenotipo().length+2];
        ArrayList<IndividuoTSP> pobAux;
        
        //someter a la poblacion a un proceso evolutivo
        int mejorRes=0, genRes=0;
       for(int i=0; i<getNumGeneraciones(); i++){
           pobAux = new ArrayList<>();
           //crear una población nueva
           ///MUESTREO
                    //Torneo, aleatorio y 50/50
           int cantidad = Math.round(porcentaje*this.poblacion.size());
           pobAux = Muestreo.torneo(this.poblacion, cantidad);
           //pobAux = Muestreo.aleatorio(this.poblacion, cantidad);
           //pobAux = Muestreo.mitad(this.poblacion, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.aleatorio(this.poblacion, cantidad);
           //ArrayList<IndividuoTSP> nueAux = Muestreo.mitad(this.poblacion, cantidad);
           
           //crear una población nueva   
           for(int j=0; j<getTamanioPoblacion()-cantidad; j++){
               IndividuoTSP madre = Seleccion.seleccionTorneoTSP(poblacion);
               
               /*System.out.println("MADRE: ");
               System.out.println(Arrays.toString(madre.getGenotipo()) + " " + madre.getFitness());*/
               /**/
               IndividuoTSP padre = Seleccion.seleccionAleatoriaTSP(poblacion);
               //System.out.println("PADRE: ");
               //System.out.println(Arrays.toString(padre.getGenotipo()) + " " + padre.getFitness());
               //cruza
               IndividuoTSP hijo = Cruza.cruzaTSP(madre, padre);
               /*System.out.println("HIJO: ");
               System.out.println(Arrays.toString(hijo.getGenotipo()) + " " + hijo.getFitness());*/
               /**/
               //evaluar la posibilidad de muta
               if(Muta.muta(getProbMuta())){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           actualizarPoblacion(pobAux);
           
           IndividuoTSP mejor = Seleccion.seleccionTorneoTSP(this.poblacion);
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
       matrizRes[getNumGeneraciones()][0] = "Mejor resultado:";
       matrizRes[getNumGeneraciones()][1] = "\t" + mejorRes;
       matrizRes[getNumGeneraciones()][2] = "\tGeneracion:";
       matrizRes[getNumGeneraciones()][3] = "\t" + genRes;
       
       //System.out.println("Mejor resultado: " + mejorRes + "  Generacin: " + genRes);
       for(int i=4; i<this.poblacion.get(0).getGenotipo().length+1; i++) matrizRes[getNumGeneraciones()][i] = "";
       //Matriz.guardarArchivo(matrizRes);
    }
    
    @Override
    public void generarPoblacionInicial() {
        this.poblacion = new ArrayList<>();
        //se genere de manera aleatoria
        Random r = new Random();
        int n = r.nextInt(Matriz.matriz.length);
        for(int i=0; i<getTamanioPoblacion(); i++)
            this.poblacion.add(new IndividuoTSP(n, Matriz.matriz.length));
        
    }
    @Override
    public void generarPoblacionInicial(int n) {
        this.poblacion = new ArrayList<>();
        //System.out.println("POBLACIÓN INICIAL");
        //se genere de manera aleatoria
        for(int i=0; i<getTamanioPoblacion(); i++){
            IndividuoTSP in = new IndividuoTSP(n, Matriz.matriz.length);
            this.poblacion.add(in);
            //VER EL INDIVIDUO
            //Herramientas.imprimirArreglo(in.getGenotipo());
            //System.out.println("\t Fitness: " + in.getFitness());
        }  
    }
    private void actualizarPoblacion(ArrayList<IndividuoTSP> pobAux) {
        this.poblacion = new ArrayList<>();
        //for(IndividuoTSP i : pobAux){
        pobAux.forEach(i -> {
            this.poblacion.add(new IndividuoTSP(i.getGenotipo()));
        });
    }
}

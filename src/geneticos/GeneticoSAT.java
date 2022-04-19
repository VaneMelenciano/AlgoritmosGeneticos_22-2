/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.IndividuoSAT;
import geneticosParalelos.Consola;
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

//SALTISFACIBILIDAD BOOLEANA
//Usamos la matriz para leer el archivo
public class GeneticoSAT extends Genetico{
    private ArrayList<IndividuoSAT> poblacion;
    public GeneticoSAT(int t, int num, double p, int n){ //tamaño de poblacion, numGenereaciones, probabilidad de muta, tamaño de instancias de prueba
        super(t, num, p, n);
    }
    public GeneticoSAT(int t, int num, double p, int n, int mueT, float mue){ //tamaño de poblacion, numGenereaciones, probabilidad de muta, tamaño de instancias de prueba
        super(t, num, p, n);
    }
    public GeneticoSAT(int t, int n, double p, int seleM, int seleP, int mueT, float mue, int nn){ //tamaño de poblacion, numGenereaciones, probabilidad de muta, tamaño de instancias de prueba
        super(t, n, p, seleM, seleP, mueT, mue, nn);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
    public GeneticoSAT(int t, int n, double p, int seleM, int seleP, int mueT, float mue, int nn, Consola c){ //tamaño de poblacion, numGenereaciones, probabilidad de muta, tamaño de instancias de prueba
        super(t, n, p, seleM, seleP, mueT, mue, nn, c);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }

    @Override
    public void evolucionar(){
        //setMuestreo(0.30F); /**/
        //setMueT(1);
        ArrayList<IndividuoSAT> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara = Herramientas.generarArregloBinario(getN());
        //someter a la poblacion a un proceso evolutivo
        int mejorRes = 0;
       for(int i=0; i<getNumGeneraciones(); i++){
           //crear una población nueva
           pobAux = new ArrayList<>();
           ///MUESTREO
                    //Torneo, aleatorio y 50/50
                    
             int cantidad = Math.round(getMuestreo()*this.poblacion.size());
             //System.out.println("Cantidad: " + cantidad + "  Muestreo: " + getMuestreo());
             if(getMueT()==0){
                 pobAux = Muestreo.aleatorioSAT(this.poblacion, cantidad);
                 //System.out.println("Aleatorio: " + cantidad);
             }
             else if(getMueT()==1){
                 pobAux = Muestreo.torneoSAT(this.poblacion, cantidad);
                 //System.out.println("Torneo: " + cantidad);
             }
              
             
           for(int j=0; j<getTamanioPoblacion()-cantidad; j++){
               //selección
               
               IndividuoSAT madre = null;
               if(getSeleM()==0)  madre = Seleccion.seleccionAleatoriaSAT(poblacion);
               else madre = Seleccion.seleccionTorneoSAT(poblacion);
               
               IndividuoSAT padre = null;
               if(getSeleP()==0){
                   padre = Seleccion.seleccionAleatoriaSAT(poblacion);
               }
               else padre = Seleccion.seleccionTorneoSAT(poblacion);
               //cruza
               IndividuoSAT hijo = Cruza.cruzaMascara(madre, padre, mascara);
               //evaluar la posibilidad de muta
               if(Muta.muta(getProbMuta())){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
               //System.out.println("Mama: " + madre.getFitness() +"  Papa: " + " " +padre.getFitness() + "    Hijo: " +" " + hijo.getFitness());
           
           }
           //se tiene que acualizar la población
           actualizar(pobAux);
           //VER CUAL ES EL MEJOR RESULTADO ENTRE TODAS LAS GENERACIONES
           IndividuoSAT mejor = Seleccion.seleccionTorneoSAT(this.poblacion);
           //System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
           String texto = "Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo() )+ "\n";
           this.consola.setTexto(texto);
           
           
            /*if(i==0){
                mejorRes = mejor.getFitness();
                System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            } 
            else if(mejorRes<mejor.getFitness()){
                mejorRes = mejor.getFitness();
                System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            }*/
       }
    }
    private void actualizar(ArrayList<IndividuoSAT> pobAux) {
         this.poblacion = new ArrayList<>();
        for(int i=0; i<pobAux.size(); i++){
            //System.out.println(pobAux.get(i).fitness);
            this.poblacion.add(new IndividuoSAT(pobAux.get(i).getGenotipo()));
            //this.poblacion.get(i).actualizar();
            //System.out.println(this.poblacion.get(i).fitness);
        }
    }

    /**
     *
     * @param n
     */
    @Override
    public void generarPoblacionInicial() {
        this.poblacion = new ArrayList<>();
        //se genere de manera aleatoria
        for(int i=0; i<getTamanioPoblacion(); i++)
            this.poblacion.add(new IndividuoSAT(getN()));
    }
}

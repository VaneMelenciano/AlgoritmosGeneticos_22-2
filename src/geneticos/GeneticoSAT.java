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
    private IndividuoSAT mejorIndividuo;
    private IndividuoSAT nuevoMejorIndividuo; //cuando se recibe un individuo
    
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
        ArrayList<IndividuoSAT> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara = Herramientas.generarArregloBinario(getN());
        //someter a la poblacion a un proceso evolutivo
        //int mejorRes = 0;
       for(int i=0; i<getNumeroGeneraciones(); i++){
           //crear una población nueva
           pobAux = new ArrayList<>();
           ///MUESTREO
             int cantidadMuestreo = Math.round(getPorcentajeMuestreo()*this.poblacion.size());
             if(getTipoMuestreo()==0){
                 pobAux = Muestreo.aleatorioSAT(this.poblacion, cantidadMuestreo);
             }
             else if(getTipoMuestreo()==1){
                 pobAux = Muestreo.torneoSAT(this.poblacion, cantidadMuestreo);
             }
             
              if(getInsertarMejorIndividuo()==true){ //INSERTAR MEJOR INDIVIDUO DE OTRO GENETICO
                  pobAux.add(nuevoMejorIndividuo); cantidadMuestreo++;
                    setInsertarMejorIndividuo(false); 
                    System.out.println(this.nuevoMejorIndividuo.getFitness() + " " + Arrays.toString(this.nuevoMejorIndividuo.getGenotipo()));
              }
             
           for(int j=0; j<getTamanioPoblacion()-cantidadMuestreo; j++){
               //selección
               
               IndividuoSAT madre = null;
               if(getSeleccionMadre()==0)  madre = Seleccion.seleccionAleatoriaSAT(poblacion);
               else madre = Seleccion.seleccionTorneoSAT(poblacion);
               
               IndividuoSAT padre = null;
               if(getSeleccionPadre()==0){
                   padre = Seleccion.seleccionAleatoriaSAT(poblacion);
               }
               else padre = Seleccion.seleccionTorneoSAT(poblacion);
               //cruza
               IndividuoSAT hijo = Cruza.cruzaMascara(madre, padre, mascara);
               //evaluar la posibilidad de muta
               if(Muta.muta(getProbabilidadMuta())){
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
           this.mejorIndividuo = mejor;
           if(this.getUsarGeneticosParalelos()){
                String texto = "Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo() )+ "\n";
                this.consola.setTexto(texto);
           }else{
               System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
           }
           
           
           
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
        this.mejorIndividuo = this.poblacion.get(0);
    }

    /**
     * @return the mejorIndividuo
     */
    public IndividuoSAT getMejorIndividuo() {
        return mejorIndividuo;
    }

    /**
     * @param mejorIndividuo the mejorIndividuo to set
     */
    public void setMejorIndividuo(IndividuoSAT mejorIndividuo) {
        this.nuevoMejorIndividuo = mejorIndividuo;
        this.nuevoMejorIndividuo.actualizar();
        this.setInsertarMejorIndividuo(true);           
    }
    
}

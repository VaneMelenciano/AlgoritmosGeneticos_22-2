/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.IndividuoBinario;
import geneticosParalelos.Consola;
import java.util.ArrayList;
import java.util.Arrays;
import objetos.Clasificador;
import objetos.Cruza;
import objetos.Herramientas;
import objetos.Muestreo;
import objetos.Muta;
import objetos.Seleccion;

/**
 *
 * @author Vanessa
 */
public final class GeneticoBinario extends Genetico{
    /*private int tamanioPoblacion; //numero de cuidades
    private int numGeneraciones;
    private double probMuta; //probabilidad de muta*/
    private ArrayList<IndividuoBinario> poblacion;
    private IndividuoBinario mejorIndividuo;
    private IndividuoBinario nuevoMejorIndividuo; //cuando se recibe un individuo
    
    public static Clasificador clasificador;
    public static boolean banderaUsarClasificador = false;
    
    public GeneticoBinario(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, boolean banderaUsarClasificador){ //24, 20, 0.2
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta);
        if(banderaUsarClasificador){
            clasificador = new Clasificador();
            GeneticoBinario.banderaUsarClasificador=true;
        }
        generarPoblacionInicial();
    }
    public GeneticoBinario(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, int seleM, int seleP, int tipoMuestreo, float muestreo, Consola consola){ //24, 20, 0.2
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, seleM, seleP, tipoMuestreo, muestreo, consola);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
     public GeneticoBinario(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, int seleM, int seleP, int tipoMuestreo, float muestreo, Consola consola, boolean banderaUsarClasificador){ //24, 20, 0.2
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, seleM, seleP, tipoMuestreo, muestreo, consola);
        if(banderaUsarClasificador){
            clasificador = new Clasificador();
            GeneticoBinario.banderaUsarClasificador=true;
        }
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
    public GeneticoBinario(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, int seleM, int seleP, int tipoMuestreo, float muestreo, boolean banderaUsarClasificador){ //24, 20, 0.2
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, seleM, seleP, tipoMuestreo, muestreo);
        if(banderaUsarClasificador){
            clasificador = new Clasificador();
            GeneticoBinario.banderaUsarClasificador=true;
        }
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }

    /**
     *
     */
    @Override
    public void evolucionar(){
        ArrayList<IndividuoBinario> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara;
        if(GeneticoBinario.banderaUsarClasificador) mascara = Herramientas.generarArregloBinario(GeneticoBinario.clasificador.getNumeroAtributos());
        else mascara = Herramientas.generarArregloBinario(clasificador.getNumeroAtributos());
        //someter a la poblacion a un proceso evolutivo
       for(int i=0; i<getNumeroGeneraciones(); i++){
           //crear una población nueva
           pobAux = new ArrayList<>();
           //MUESTREO
           int cantidadMuestreo = Math.round(getPorcentajeMuestreo()*this.poblacion.size());
             if(getTipoMuestreo()==0){
                 pobAux = Muestreo.aleatorioBinario(this.poblacion, cantidadMuestreo);
             }
             else if(getTipoMuestreo()==1){
                 pobAux = Muestreo.torneoBinario(this.poblacion, cantidadMuestreo);
             }
              if(getInsertarMejorIndividuo()==true){ //INSERTAR MEJOR INDIVIDUO DE OTRO GENETICO
                  pobAux.add(nuevoMejorIndividuo); cantidadMuestreo++;
                    setInsertarMejorIndividuo(false); 
                    System.out.println(this.nuevoMejorIndividuo.getFitness() + " " + Arrays.toString(this.nuevoMejorIndividuo.getGenotipo()));
              }
           for(int j=0; j<getTamanioPoblacion(); j++){
               //seleccion
               IndividuoBinario madre = null;
               if(getSeleccionMadre()==0)  madre = Seleccion.seleccionAleatoriaBinario(poblacion);
               else madre = Seleccion.seleccionTorneoBinario(poblacion);
               
               IndividuoBinario padre = null;
               if(getSeleccionPadre()==0){
                   padre = Seleccion.seleccionAleatoriaBinario(poblacion);
               }
               else padre = Seleccion.seleccionTorneoBinario(poblacion);
               
               //cruza
               IndividuoBinario hijo = Cruza.cruzaMascara(madre, padre, mascara);
               //evaluar la posibilidad de muta
               if(Muta.muta(getProbabilidadMuta())){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           actualizarPoblacion(pobAux);
           
           IndividuoBinario mejor = Seleccion.seleccionTorneoBinario(this.poblacion);
           this.mejorIndividuo = mejor;
           if(this.getUsarGeneticosParalelos() && banderaUsarClasificador==true){
                String texto = "Generacion: " + i + " Fitness: " + mejor.getFitnessDecimal()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo() )+ "\n";
                this.consola.setTexto(texto);
           }else if(this.getUsarGeneticosParalelos()){
                String texto = "Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Fenotipo: " +mejor.getFenotipo()+  "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo() )+ "\n";
                this.consola.setTexto(texto);
           }else if(banderaUsarClasificador){
               System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitnessDecimal()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
           }else{
             System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
           }
           /*IndividuoBinario mejor = Seleccion.seleccionTorneoBinario(this.poblacion);
           if(mejor.getFenotipo()<16777215){
           System.out.print("\nGeneración :"+(i+1)+"\n\tFenotipo: "+mejor.getFenotipo() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           for(int m : mejor.getGenotipo()) 
               System.out.print(m);
           System.out.println();}*/
       }
    }
    
    @Override
    public void generarPoblacionInicial() {
        this.poblacion = new ArrayList<>();
        //se genere de manera aleatoria
        for(int i=0; i<getTamanioPoblacion(); i++)
            if(banderaUsarClasificador)this.poblacion.add(new IndividuoBinario(GeneticoBinario.clasificador.getNumeroAtributos()));
            else this.poblacion.add(new IndividuoBinario());
        this.mejorIndividuo = this.poblacion.get(0);
        
    }
    
     private void actualizarPoblacion(ArrayList<IndividuoBinario> pobAux) {
        this.poblacion = new ArrayList<>();
        for(IndividuoBinario i : pobAux){
            this.poblacion.add(new IndividuoBinario(i.getGenotipo()));
        }
    }
      /**
     * @return the mejorIndividuo
     */
    public IndividuoBinario getMejorIndividuo() {
        return mejorIndividuo;
    }

    /**
     * @param mejorIndividuo the mejorIndividuo to set
     */
    public void setMejorIndividuo(IndividuoBinario mejorIndividuo) {
        this.nuevoMejorIndividuo = mejorIndividuo;
        this.nuevoMejorIndividuo.actualizar();
        this.setInsertarMejorIndividuo(true);           
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.Individuo;
import Individuos.IndividuoReinas;
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
public class GeneticoReinas extends Genetico{
    private ArrayList<IndividuoReinas> poblacion;
    private IndividuoReinas mejorIndividuo;
    private IndividuoReinas nuevoMejorIndividuo; //cuando se recibe un individuo
    
    public GeneticoReinas(int t, int num, double p, int n){ //24, 20, 0.2
        super(t, num, p, n);
    }
    //
    public GeneticoReinas(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, int seleM, int seleP, int tipoMuestreo, float muestreo, int tamanioTablero, Consola consola){ //24, 20, 0.2
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, seleM, seleP, tipoMuestreo, muestreo, tamanioTablero, consola);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
    
 
    @Override
    public void evolucionar(){
        ArrayList<IndividuoReinas> pobAux;
        //una sola mascara para todo el proceso evolutivo
        //int[] mascara = Herramientas.generarArreglo(this.n);
        //someter a la poblacion a un proceso evolutivo
       for(int i=0; i<getNumeroGeneraciones(); i++){
           int[] mascara = Herramientas.generarArregloBinario(this.getN());
           
           pobAux = new ArrayList<>();
          //MUESTREO 
           int cantidadMuestreo = Math.round(getPorcentajeMuestreo()*this.poblacion.size());
           
            if(getTipoMuestreo()==0){
                 pobAux = Muestreo.aleatorioReinas(this.poblacion, cantidadMuestreo);
             }
             else if(getTipoMuestreo()==1){
                 pobAux = Muestreo.torneoReinas(this.poblacion, cantidadMuestreo);
             }
             
              if(getInsertarMejorIndividuo()==true){ //INSERTAR MEJOR INDIVIDUO DE OTRO GENETICO
                  pobAux.add(nuevoMejorIndividuo); cantidadMuestreo++;
                    setInsertarMejorIndividuo(false); 
                    System.out.println(this.nuevoMejorIndividuo.getFitness() + " " + Arrays.toString(this.nuevoMejorIndividuo.getGenotipo()));
              }
           for(int j=0; j<getTamanioPoblacion(); j++){
               //seleccion
               IndividuoReinas madre = null;
               if(getSeleccionMadre()==0)  madre = Seleccion.seleccionAleatoriaReinas(poblacion);
               else madre = Seleccion.seleccionTorneoReinas(poblacion);
               
               IndividuoReinas padre = null;
               if(getSeleccionPadre()==0){
                   padre = Seleccion.seleccionAleatoriaReinas(poblacion);
               }
               else padre = Seleccion.seleccionTorneoReinas(poblacion);
               
                //cruza
               IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, mascara); //CHECAR
               //evaluar la posibilidad de muta
              
               if(Muta.muta(getProbabilidadMuta())){
                   Muta.muta(hijo); //CHECAR
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
               
           }
           //se tiene que acualizar la población
           actualizar(pobAux);
           IndividuoReinas mejor = Seleccion.seleccionTorneoReinas(this.poblacion);
          this.mejorIndividuo = mejor;
           if(this.getUsarGeneticosParalelos()){
                String texto = "Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo() )+ "\n";
                this.consola.setTexto(texto);
           }else{
               System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
           }
           /*System.out.print("\n\tFitness: "+mejor.getFitness() + "  Genotipo: " + Arrays.toString(mejor.getGenotipo())); //con 24, el mayor puede ser -> 16,777,215
           System.out.println();//}
           madre = mejor;*/
       }
    }

    /**
     *
     * @param n
     */
    @Override
    public void generarPoblacionInicial() {
        this.poblacion = new ArrayList<>();
        for(int i=0; i<getTamanioPoblacion(); i++){
            this.poblacion.add(new IndividuoReinas(getN()));
        }
        this.mejorIndividuo=this.poblacion.get(0);
    }

    private void actualizar(ArrayList<IndividuoReinas> pobAux) {
         this.poblacion = new ArrayList<>();
        for(int i=0; i<pobAux.size(); i++){
            //System.out.println(pobAux.get(i).fitness);
            this.poblacion.add(new IndividuoReinas(pobAux.get(i).getGenotipo()));
            //this.poblacion.get(i).actualizar();
            //System.out.println(this.poblacion.get(i).fitness);
        }
    }
    public IndividuoReinas getMejorIndividuo() {
        return mejorIndividuo;
    }

    /**
     * @param mejorIndividuo the mejorIndividuo to set
     */
    public void setMejorIndividuo(IndividuoReinas mejorIndividuo) {
        this.nuevoMejorIndividuo = mejorIndividuo;
        this.nuevoMejorIndividuo.actualizar();
        this.setInsertarMejorIndividuo(true);           
    }
}

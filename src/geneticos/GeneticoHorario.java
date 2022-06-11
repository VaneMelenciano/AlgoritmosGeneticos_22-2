/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.IndividuoHorario;
import geneticosParalelos.Consola;
import java.util.ArrayList;
import java.util.Arrays;
import objetos.Cruza;
import objetos.Herramientas;
import objetos.Horario;
import objetos.Muestreo;
import objetos.Muta;
import objetos.Seleccion;

/**
 *
 * @author Vanessa
 */
public class GeneticoHorario extends Genetico{
    private ArrayList<IndividuoHorario> poblacion;
    private IndividuoHorario mejorIndividuo;
    private IndividuoHorario nuevoMejorIndividuo; //cuando se recibe un individuo
    
    private Horario modulos;
    
    public GeneticoHorario(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta){ //24, 20, 0.2
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta);
        generarPoblacionInicial();
    }
    public GeneticoHorario(int t, int n, double p, int seleM, int seleP, int mueT, float mue){ //tamaño de poblacion, numGenereaciones, probabilidad de muta, tamaño de instancias de prueba
        super(t, n, p, seleM, seleP, mueT, mue);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
    
    public GeneticoHorario(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, int seleM, int seleP, int tipoMuestreo, float muestreo, int tamanioTablero, Consola consola){ //24, 20, 0.2
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, seleM, seleP, tipoMuestreo, muestreo, tamanioTablero, consola);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
    
 
    @Override
    public void evolucionar(){
        ArrayList<IndividuoHorario> pobAux;
        
        //someter a la poblacion a un proceso evolutivo
        int longGenotipo = Horario.numeroMaterias*Horario.numeroGrupos*Horario.vecesMateriaPorSemana;
       for(int i=0; i<getNumeroGeneraciones(); i++){
           int[] mascara = Herramientas.generarArregloBinario(longGenotipo);
           
           pobAux = new ArrayList<>();
          //MUESTREO 
           int cantidadMuestreo = Math.round(getPorcentajeMuestreo()*this.poblacion.size());
           
            if(getTipoMuestreo()==0){
                 pobAux = Muestreo.aleatorioHorarios(this.poblacion, cantidadMuestreo);
             }
             else if(getTipoMuestreo()==1){
                 pobAux = Muestreo.torneoHorarios(this.poblacion, cantidadMuestreo);
             }
             
              if(getInsertarMejorIndividuo()==true){ //INSERTAR MEJOR INDIVIDUO DE OTRO GENETICO
                  pobAux.add(nuevoMejorIndividuo); cantidadMuestreo++;
                    setInsertarMejorIndividuo(false); 
                    System.out.println(this.nuevoMejorIndividuo.getFitness() + " " + Arrays.toString(this.nuevoMejorIndividuo.getGenotipo()));
              }
           for(int j=0; j<getTamanioPoblacion(); j++){
               //seleccion
               IndividuoHorario madre = null;
               if(getSeleccionMadre()==0)  madre = Seleccion.seleccionAleatoriaHorarios(poblacion);
               else madre = Seleccion.seleccionTorneoHorarios(poblacion);
               
               IndividuoHorario padre = null;
               if(getSeleccionPadre()==0){
                   padre = Seleccion.seleccionAleatoriaHorarios(poblacion);
               }
               else padre = Seleccion.seleccionTorneoHorarios(poblacion);
               
                //cruza
               IndividuoHorario hijo = Cruza.cruzaHorarios(madre, padre, mascara); //CHECAR
               //evaluar la posibilidad de muta
              
               if(Muta.muta(getProbabilidadMuta())){
                   Muta.muta(hijo); //CHECAR
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
               
           }
           //se tiene que acualizar la población
           actualizar(pobAux);
           IndividuoHorario mejor = Seleccion.seleccionTorneoHorarios(this.poblacion);
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

    
    @Override
    public void generarPoblacionInicial() {
        this.poblacion = new ArrayList<>();
        for(int i=0; i<getTamanioPoblacion(); i++){
            this.poblacion.add(new IndividuoHorario());
        }
        
        System.out.println(this.poblacion.get(0).getGenotipo().length);
        this.mejorIndividuo=this.poblacion.get(0);
        for(int i=0; i<this.poblacion.size();i++){
            System.out.println(Arrays.toString(this.poblacion.get(i).getGenotipo()) + " " + this.poblacion.get(i).getFitness());
        }
    }

    private void actualizar(ArrayList<IndividuoHorario> pobAux) {
         this.poblacion = new ArrayList<>();
        for(int i=0; i<pobAux.size(); i++){
            //System.out.println(pobAux.get(i).fitness);
            this.poblacion.add(new IndividuoHorario(pobAux.get(i).getGenotipo()));
            //this.poblacion.get(i).actualizar();
            //System.out.println(this.poblacion.get(i).fitness);
        }
    }
    public IndividuoHorario getMejorIndividuo() {
        return mejorIndividuo;
    }

    /**
     * @param mejorIndividuo the mejorIndividuo to set
     */
    public void setMejorIndividuo(IndividuoHorario mejorIndividuo) {
        this.nuevoMejorIndividuo = mejorIndividuo;
        this.nuevoMejorIndividuo.actualizar();
        this.setInsertarMejorIndividuo(true);           
    }
}

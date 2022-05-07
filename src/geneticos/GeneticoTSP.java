/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;


import Individuos.IndividuoTSP;
import geneticosParalelos.Consola;
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
    public ArrayList<IndividuoTSP> poblacion;
    private IndividuoTSP mejorIndividuo;
    private IndividuoTSP nuevoMejorIndividuo; //cuando se recibe un individuo
    
    private float porcentajeDistancia = 0;
    private float porcentajeElevacion = 0;
    
    private boolean banderUsarElevaciones = false;
    
    public GeneticoTSP(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, float porcentajeDistancia, float porcentajeElevacion){
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta);
        this.poblacion = new ArrayList<>();
        this.porcentajeDistancia=porcentajeDistancia;
        this.porcentajeElevacion=porcentajeElevacion;
        this.banderUsarElevaciones=true;
        generarPoblacionInicial();
    }
    
    public GeneticoTSP(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta){
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta);
        this.poblacion = new ArrayList<>();
    }
    public GeneticoTSP(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, int seleM, int seleP, int mueT, float mue){
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, seleM, seleP, mueT, mue);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
    public GeneticoTSP(int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta, int seleM, int seleP, int mueT, float mue, Consola consola){
        super(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, seleM, seleP, mueT, mue, consola);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
    }
    public GeneticoTSP(int t, int n, double p, int cuidadI){ //24, 20, 0.2
        super(t, n, p, cuidadI);
    }
    
    @Override
    public void evolucionar(){
        ArrayList<IndividuoTSP> pobAux;
        
        //someter a la poblacion a un proceso evolutivo
        //int mejorRes=0, genRes=0;
       for(int generacion=0; generacion<getNumeroGeneraciones(); generacion++){
           pobAux = new ArrayList<>();
           ///MUESTREO
           int cantidadMuestreo = Math.round(getPorcentajeMuestreo()*this.poblacion.size());
            if(getTipoMuestreo()==0){
                pobAux = Muestreo.aleatorio(this.poblacion, cantidadMuestreo);
            }
            else if(getTipoMuestreo()==1){
                pobAux = Muestreo.torneo(this.poblacion, cantidadMuestreo);
            }
            if(getInsertarMejorIndividuo()==true){ //INSERTAR MEJOR INDIVIDUO DE OTRO GENETICO
                  pobAux.add(nuevoMejorIndividuo); cantidadMuestreo++;
                    setInsertarMejorIndividuo(false); 
                    System.out.println(this.nuevoMejorIndividuo.getFitness() + " " + Arrays.toString(this.nuevoMejorIndividuo.getGenotipo()));
              }
           //crear una población nueva   
           for(int poblacionNueva=0; poblacionNueva<getTamanioPoblacion()-cantidadMuestreo; poblacionNueva++){
               IndividuoTSP madre = null;
               if(getSeleccionMadre()==0)  madre = Seleccion.seleccionAleatoriaTSP(poblacion);
               else madre = Seleccion.seleccionTorneoTSP(poblacion);
               
               IndividuoTSP padre = null;
               if(getSeleccionPadre()==0) padre = Seleccion.seleccionAleatoriaTSP(poblacion);
               else padre = Seleccion.seleccionTorneoTSP(poblacion);
               
               //cruza
               IndividuoTSP hijo = Cruza.cruzaTSP(madre, padre);
               if(this.banderUsarElevaciones) hijo.setPorcentajes(porcentajeDistancia, porcentajeElevacion);
               
                //evaluar la posibilidad de muta
               if(Muta.muta(getProbabilidadMuta())){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
               //System.out.println("Mama: " + Arrays.toString(madre.getGenotipo()) + "  Papa: " + Arrays.toString(padre.getGenotipo()) + " " +padre.getFitness() + "    Hijo: " + Arrays.toString(hijo.getGenotipo()) + " " + hijo.getFitness());
           }
           //se tiene que acualizar la población
           actualizarPoblacion(pobAux);
           
           IndividuoTSP mejor = Seleccion.seleccionTorneoTSP(this.poblacion);
           
           this.mejorIndividuo = mejor;
           
           if(this.getUsarGeneticosParalelos()){
                String texto = "Generacion: " + generacion + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo() )+ "\n";
                this.consola.setTexto(texto);
           }else{
               System.out.println("Generacion: " + generacion + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
           }
       }
    }
    
    @Override
    public void generarPoblacionInicial() {
        this.poblacion = new ArrayList<>();
        //se genere de manera aleatoria
        Random r = new Random();
        int n = r.nextInt(Matriz.matriz.length);
        for(int i=0; i<getTamanioPoblacion(); i++)
            if(!this.banderUsarElevaciones)this.poblacion.add(new IndividuoTSP(n, Matriz.matriz.length));
            else this.poblacion.add(new IndividuoTSP(n, Matriz.matriz.length, this.porcentajeDistancia, this.porcentajeElevacion));
        this.mejorIndividuo = this.poblacion.get(0);
        
    }
    @Override
    public void generarPoblacionInicial(int n) {
        this.poblacion = new ArrayList<>();
        //System.out.println("POBLACIÓN INICIAL");
        //se genere de manera aleatoria
        for(int i=0; i<getTamanioPoblacion(); i++){
             IndividuoTSP in = null;
            if(!this.banderUsarElevaciones) in = new IndividuoTSP(n, Matriz.matriz.length);
            else in = new IndividuoTSP(n, Matriz.matriz.length, this.porcentajeDistancia, this.porcentajeElevacion);
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
             if(!this.banderUsarElevaciones) this.poblacion.add(new IndividuoTSP(i.getGenotipo()));
             else this.poblacion.add(new IndividuoTSP(i.getGenotipo(), this.porcentajeDistancia, this.porcentajeElevacion));
        });
    }
    /**
     * @return the mejorIndividuo
     */
    public IndividuoTSP getMejorIndividuo() {
        return mejorIndividuo;
    }

    /**
     * @param mejorIndividuo the mejorIndividuo to set
     */
    public void setMejorIndividuo(IndividuoTSP mejorIndividuo) {
        this.nuevoMejorIndividuo = mejorIndividuo;
        this.nuevoMejorIndividuo.actualizar();
        this.setInsertarMejorIndividuo(true);           
    }

    /**
     * @return the porcentajeDistancia
     */
    public float getPorcentajeDistancia() {
        return porcentajeDistancia;
    }

    /**
     * @param porcentajeDistancia the porcentajeDistancia to set
     */
    public void setPorcentajeDistancia(float porcentajeDistancia) {
        this.porcentajeDistancia = porcentajeDistancia;
        this.banderUsarElevaciones=true;
    }

    /**
     * @return the porcentajeElevacion
     */
    public float getPorcentajeElevacion() {
        return porcentajeElevacion;
    }

    /**
     * @param porcentajeElevacion the porcentajeElevacion to set
     */
    public void setPorcentajeElevacion(float porcentajeElevacion) {
        this.porcentajeElevacion = porcentajeElevacion;
        this.banderUsarElevaciones=true;
    }
    
}

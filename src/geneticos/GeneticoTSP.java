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
    
    public GeneticoTSP(int t, int n, double p){
        super(t, n, p);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial();
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
        //String [][] matrizRes = new String[getNumeroGeneraciones()+1][this.poblacion.get(0).getGenotipo().length+2];
        ArrayList<IndividuoTSP> pobAux;
        
        //someter a la poblacion a un proceso evolutivo
        int mejorRes=0, genRes=0;
       for(int i=0; i<getNumeroGeneraciones(); i++){
           pobAux = new ArrayList<>();
           //crear una población nueva
           ///MUESTREO
                    //Torneo, aleatorio y 50/50
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
           for(int j=0; j<getTamanioPoblacion()-cantidadMuestreo; j++){
               IndividuoTSP madre = null;
               if(getSeleccionMadre()==0)  madre = Seleccion.seleccionAleatoriaTSP(poblacion);
               else madre = Seleccion.seleccionTorneoTSP(poblacion);
               
               IndividuoTSP padre = null;
               if(getSeleccionPadre()==0) padre = Seleccion.seleccionAleatoriaTSP(poblacion);
               else padre = Seleccion.seleccionTorneoTSP(poblacion);
               
               //cruza
               IndividuoTSP hijo = Cruza.cruzaTSP(madre, padre);
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
                String texto = "Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo() )+ "\n";
                this.consola.setTexto(texto);
           }else{
               System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
           }
           
            //AGREGAR MEJOR INDIVIDUO A TXT
            /*matrizRes[i][0] = "g" + i;
            for(int k=0; k<mejor.getGenotipo().length ; k++){
               matrizRes[i][k+1] = "\t" +mejor.getGenotipo()[k] + "\t"; //imprime camino de mejor individuo
            } matrizRes[i][mejor.getGenotipo().length+1] = "" + mejor.getFitness(); */
            
            //VER CUAL ES EL MEJOR RESULTADO ENTRE TODAS LAS GENERACIONES
            /*if(i==0){
                mejorRes = mejor.getFitness();
                genRes=i;
                System.out.println("Generacion: " + genRes + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            } 
            else if(mejorRes>mejor.getFitness()){
                mejorRes = mejor.getFitness();
                genRes=i;
                System.out.println("Generacion: " + genRes + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            }*/
            
       }
       //GUARDAR EN TXT MEJORES RESULTADOS
       /*matrizRes[getNumeroGeneraciones()][0] = "Mejor resultado:";
       matrizRes[getNumeroGeneraciones()][1] = "\t" + mejorRes;
       matrizRes[getNumeroGeneraciones()][2] = "\tGeneracion:";
       matrizRes[getNumeroGeneraciones()][3] = "\t" + genRes;
      
       for(int i=4; i<this.poblacion.get(0).getGenotipo().length+1; i++) matrizRes[getNumeroGeneraciones()][i] = "";
       */
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
        this.mejorIndividuo = this.poblacion.get(0);
        
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
}

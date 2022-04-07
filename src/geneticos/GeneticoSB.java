/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.IndividuoSB;
import java.util.ArrayList;
import java.util.Arrays;
import objetos.Cruza;
import objetos.Herramientas;
import objetos.Muta;
import objetos.Seleccion;

/**
 *
 * @author Vanessa
 */

//SALTISFACIBILIDAD BOOLEANA
//Usamos la matriz para leer el archivo
public class GeneticoSB extends Genetico{
    private ArrayList<IndividuoSB> poblacion;
    public GeneticoSB(int t, int num, double p, int n){ //tamaño de poblacion, numGenereaciones, probabilidad de muta, tamaño de instancias de prueba
        super(t, num, p, n);
    }
    public void evolucionar(float porcentaje){
        
    }

    @Override
    public void evolucionar(){
        ArrayList<IndividuoSB> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara = Herramientas.generarArregloBinario(24);
        //someter a la poblacion a un proceso evolutivo
        int mejorRes = 0;
       for(int i=0; i<getNumGeneraciones(); i++){
           //crear una población nueva
           pobAux = new ArrayList<>();
           for(int j=0; j<getTamanioPoblacion(); j++){
               //muestreo y/o selección
               //torneo
               IndividuoSB madre = Seleccion.seleccionTorneoSB(this.poblacion);
               IndividuoSB padre = Seleccion.seleccionAleatoriaSB(this.poblacion);
               //cruza
               IndividuoSB hijo = Cruza.cruzaMascara(madre, padre, mascara);
               //evaluar la posibilidad de muta
               if(Muta.muta(getProbMuta())){
                   Muta.muta(hijo);
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
           }
           //se tiene que acualizar la población
           actualizar(pobAux);
           //VER CUAL ES EL MEJOR RESULTADO ENTRE TODAS LAS GENERACIONES
           IndividuoSB mejor = Seleccion.seleccionTorneoSB(this.poblacion);
           System.out.println("Generacion: " + i + " Fitness: " + mejor.getFitness()+ "  Mejor resultado: "+ Arrays.toString(mejor.getGenotipo()));
            
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
    private void actualizar(ArrayList<IndividuoSB> pobAux) {
         this.poblacion = new ArrayList<>();
        for(int i=0; i<pobAux.size(); i++){
            //System.out.println(pobAux.get(i).fitness);
            this.poblacion.add(new IndividuoSB(pobAux.get(i).getGenotipo()));
            //this.poblacion.get(i).actualizar();
            //System.out.println(this.poblacion.get(i).fitness);
        }
    }
    @Override
    public void generarPoblacionInicial(int n) {
        this.poblacion = new ArrayList<>();
        //se genere de manera aleatoria
        for(int i=0; i<getTamanioPoblacion(); i++)
            this.poblacion.add(new IndividuoSB(n));
        
    }
}

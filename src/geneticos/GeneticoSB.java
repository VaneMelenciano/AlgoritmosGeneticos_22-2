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
import objetos.Muestreo;
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
    public GeneticoSB(int t, int num, double p, int n, int mueT, float mue){ //tamaño de poblacion, numGenereaciones, probabilidad de muta, tamaño de instancias de prueba
        super(t, num, p, n);
    }
    public GeneticoSB(int t, int n, double p, int seleM, int seleP, int mueT, float mue, int nn){ //tamaño de poblacion, numGenereaciones, probabilidad de muta, tamaño de instancias de prueba
        super(t, n, p, seleM, seleP, mueT, mue, nn);
        this.poblacion = new ArrayList<>();
        generarPoblacionInicial(getN());
    }
    public void evolucionar(float porcentaje){
        
    }

    @Override
    public void evolucionar(){
        //setMuestreo(0.30F); /**/
        //setMueT(1);
        ArrayList<IndividuoSB> pobAux;
        //una sola mascara para todo el proceso evolutivo
        int[] mascara = Herramientas.generarArregloBinario(24);
        //someter a la poblacion a un proceso evolutivo
        int mejorRes = 0;
       for(int i=0; i<getNumGeneraciones(); i++){
           //crear una población nueva
           pobAux = new ArrayList<>();
           ///MUESTREO
                    //Torneo, aleatorio y 50/50
                    
             int cantidad = Math.round(getMuestreo()*this.poblacion.size());
             System.out.println("Cantidad: " + cantidad + "  Muestreo: " + getMuestreo());
             if(getMueT()==0){
                 pobAux = Muestreo.aleatorioSB(this.poblacion, cantidad);
                 System.out.println("Aleatorio: " + cantidad);
             }
             else if(getMueT()==1){
                 pobAux = Muestreo.torneoSB(this.poblacion, cantidad);
                 System.out.println("Torneo: " + cantidad);
             }
             
             
           for(int j=0; j<getTamanioPoblacion(); j++){
               //muestreo y/o selección
               
               
               //IndividuoSB madre = Seleccion.seleccionTorneoSB(this.poblacion);
               //IndividuoSB padre = Seleccion.seleccionAleatoriaSB(this.poblacion);
               IndividuoSB madre = null;
               if(getSeleM()==0)  madre = Seleccion.seleccionAleatoriaSB(poblacion);
               else madre = Seleccion.seleccionTorneoSB(poblacion);
               
               IndividuoSB padre = null;
               if(getSeleP()==0) padre = Seleccion.seleccionAleatoriaSB(poblacion);
               else padre = Seleccion.seleccionTorneoSB(poblacion);
               //cruza
               IndividuoSB hijo = Cruza.cruzaMascara(madre, padre, mascara);
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

    /**
     *
     * @param n
     */
    @Override
    public void generarPoblacionInicial(int n) {
        this.poblacion = new ArrayList<>();
        //se genere de manera aleatoria
        for(int i=0; i<getTamanioPoblacion(); i++)
            this.poblacion.add(new IndividuoSB(n));
        
    }
}

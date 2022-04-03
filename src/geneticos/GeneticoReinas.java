/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.Individuo;
import Individuos.IndividuoReinas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import objetos.Cruza;
import objetos.Herramientas;
import objetos.Muta;
import objetos.Seleccion;

/**
 *
 * @author Vanessa
 */
public class GeneticoReinas extends Genetico{
    private ArrayList<IndividuoReinas> pob;
    private int n; //tamaño del tablero
    //private ArrayList<IndividuoTSP> poblacionTSP;
    
    public GeneticoReinas(int t, int num, double p, int n){ //24, 20, 0.2
        super(t, num, p);
    }
    Random r = new Random();
    
    /**
     *
     * @param porcentaje
     */
    @Override
    public void evolucionar(float porcentaje){
        ArrayList<IndividuoReinas> pobAux;
        //una sola mascara para todo el proceso evolutivo
        //int[] mascara = Herramientas.generarArreglo(this.n);
        //someter a la poblacion a un proceso evolutivo
        IndividuoReinas madre = Seleccion.seleccionTorneoReinas(pob);
       for(int i=0; i<getNumGeneraciones(); i++){
           int[] mascara = Herramientas.generarArregloBinario(this.n);
           
           System.out.println("\nGeneración :"+(i+1));
           //System.out.println("Mascara" + Arrays.toString(mascara));
           //crear una población nueva
           pobAux = new ArrayList<>();
           
           int cantidad = Math.round(porcentaje*this.pob.size());
           //AAAHHHH
           //ArrayList<Individuo> aux11 = Muestreo.torneo(this.poblacion, cantidad);
           //ArrayList<Individuo> aux11 = Muestreo.aleatorio(this.poblacion, cantidad);
           /*for (Individuo aux111 : aux11) {
                pobAux.add((IndividuoReinas) aux111);
            }*/
           //MUESTREO
           //pobAux = cambiarIndividuo(Muestreo.torneo(this.poblacion, cantidad));
           //pobAux = cambiarIndividuo(Muestreo.aleatorio(this.poblacion, cantidad));
            //IndividuoReinas madre = Seleccion.torneoMenorR(pob);//(IndividuoReinas) Seleccion.torneo(poblacion);
            if(i%2==0){
                   r = new Random(System.currentTimeMillis());
               }  
           for(int j=0; j<getTamanioPoblacion(); j++){
           //for(int j=0; j<getTamanioPoblacion()-cantidad; j++){
               //muestreo y/o selección
               //torneo
               //IndividuoReinas madre = new IndividuoReinas(Seleccion.torneoMenor(poblacion));//(IndividuoReinas) Seleccion.torneo(poblacion);
               //IndividuoReinas madre = Seleccion.torneoMenorR(pob);//(IndividuoReinas) Seleccion.torneo(poblacion);
               //IndividuoReinas padre = Seleccion.aleatoriaR(pob);//(IndividuoReinas) Seleccion.aleatoria(poblacion);
               //Random r = new Random();
               
       int pos = r.nextInt(pob.size());
       //System.out.println("Aleatorio: " + pos + " " + Arrays.toString(pob.get(pos).getGenotipo()) + " " + pob.get(pos).fitness);
       IndividuoReinas padre = new IndividuoReinas(pob.get(pos).getGenotipo());
       


                //cruza
               //IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, mascara); //CHECAR
               //IndividuoReinas hijo = Cruza.cruzaReinas(madre, padre); //CHECAR
               IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, mascara); //CHECAR
               //evaluar la posibilidad de muta
              
               System.out.println("Mama: " + Arrays.toString(madre.getGenotipo()) + "  Papa: " + Arrays.toString(padre.getGenotipo()) + "    Hijo: " + Arrays.toString(hijo.getGenotipo()) + " " + hijo.getFitness());

               if(Muta.muta(getProbMuta())){
                   Muta.muta(hijo); //CHECAR
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
               //System.out.println("Mama: " + Arrays.toString(madre.genotipo) + "  Papa: " + Arrays.toString(padre.genotipo) + "    Hijo: " + Arrays.toString(hijo.genotipo) + " " + hijo.fitness);
               
           }
           //for(int x=0; x<this.poblacion.size(); x++){
           //    System.out.println(this.poblacion.get(x).fitness);
           //}
           //se tiene que acualizar la población
           actualizar(pobAux);
           /*for(int x=0; x<this.poblacion.size(); x++){
               System.out.println(this.poblacion.get(x).fitness);
           }*/
           IndividuoReinas mejor = Seleccion.seleccionTorneoReinas(this.pob);
           //if(mejor.getFenotipo()<16777215){
           System.out.print("\n\tFitness: "+mejor.getFitness() + "  Genotipo: " + Arrays.toString(mejor.getGenotipo())); //con 24, el mayor puede ser -> 16,777,215
           //System.out.print("\nGeneración :"+(i+1)+"\n\tFitness: "+mejor.getFitness() + "  Genotipo: "); //con 24, el mayor puede ser -> 16,777,215
           System.out.println();//}
           madre = mejor;
       }
    }

    /**
     *
     */
    @Override
    public void generarPoblacionInicial() {
        this.pob = new ArrayList<>();
        for(int i=0; i<getTamanioPoblacion(); i++)
            this.pob.add(new IndividuoReinas(n)); 

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actualizar(ArrayList<IndividuoReinas> pobAux) {
         this.pob = new ArrayList<>();
        for(int i=0; i<pobAux.size(); i++){
            //System.out.println(pobAux.get(i).fitness);
            this.pob.add(new IndividuoReinas(pobAux.get(i).getGenotipo()));
            //this.poblacion.get(i).actualizar();
            //System.out.println(this.poblacion.get(i).fitness);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

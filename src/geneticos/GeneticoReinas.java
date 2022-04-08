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
    
    public GeneticoReinas(int t, int num, double p, int n){ //24, 20, 0.2
        super(t, num, p, n);
    }
    //Random r = new Random();
    
    /**
     *
     * @param porcentaje
     */
    public void evolucionar(float porcentaje){
        ArrayList<IndividuoReinas> pobAux;
        //una sola mascara para todo el proceso evolutivo
        //int[] mascara = Herramientas.generarArreglo(this.n);
        //someter a la poblacion a un proceso evolutivo
        IndividuoReinas madre = Seleccion.seleccionTorneoReinas(pob);
       for(int i=0; i<getNumGeneraciones(); i++){
           int[] mascara = Herramientas.generarArregloBinario(this.getN());
           
           System.out.println("\nGeneración :"+(i+1));
           pobAux = new ArrayList<>();
           
           int cantidad = Math.round(porcentaje*this.pob.size());
           //MUESTREO
           //pobAux = cambiarIndividuo(Muestreo.torneo(this.poblacion, cantidad));
           //pobAux = cambiarIndividuo(Muestreo.aleatorio(this.poblacion, cantidad));
            //IndividuoReinas madre = Seleccion.torneoMenorR(pob);//(IndividuoReinas) Seleccion.torneo(poblacion);
            /*if(i%2==0){
                   r = new Random(System.currentTimeMillis());
               }  */
           for(int j=0; j<getTamanioPoblacion(); j++){
           //for(int j=0; j<getTamanioPoblacion()-cantidad; j++){
               //muestreo y/o selección
               //torneo
               //IndividuoReinas madre = new IndividuoReinas(Seleccion.torneoMenor(poblacion));//(IndividuoReinas) Seleccion.torneo(poblacion);
               //IndividuoReinas madre = Seleccion.torneoMenorR(pob);//(IndividuoReinas) Seleccion.torneo(poblacion);
               IndividuoReinas padre = Seleccion.seleccionAleatoriaReinas(this.pob);//(IndividuoReinas) Seleccion.aleatoria(poblacion);    
            //int pos = r.nextInt(pob.size());
            //IndividuoReinas padre = new IndividuoReinas(pob.get(pos).getGenotipo());
       


                //cruza
               IndividuoReinas hijo = Cruza.cruzaMascara(madre, padre, mascara); //CHECAR
               //evaluar la posibilidad de muta
              
               if(Muta.muta(getProbMuta())){
                   Muta.muta(hijo); //CHECAR
               }
               //agregar el hijo a la población Auxiliar
               pobAux.add(hijo);
               System.out.println("Mama: " + Arrays.toString(madre.getGenotipo()) + "  Papa: " + Arrays.toString(padre.getGenotipo()) + " " +padre.getFitness() + "    Hijo: " + Arrays.toString(hijo.getGenotipo()) + " " + hijo.getFitness());
 
           }
           //se tiene que acualizar la población
           actualizar(pobAux);
           IndividuoReinas mejor = Seleccion.seleccionTorneoReinas(this.pob);
           System.out.print("\n\tFitness: "+mejor.getFitness() + "  Genotipo: " + Arrays.toString(mejor.getGenotipo())); //con 24, el mayor puede ser -> 16,777,215
           System.out.println();//}
           madre = mejor;
       }
    }

    /**
     *
     * @param n
     */
    @Override
    public void generarPoblacionInicial(int n) {
        this.pob = new ArrayList<>();
        for(int i=0; i<getTamanioPoblacion(); i++){
            this.pob.add(new IndividuoReinas(n));
        }
             

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
    }
}

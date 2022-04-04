/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos;

import Individuos.IndividuoSB;
import java.util.ArrayList;

/**
 *
 * @author Vanessa
 */

//SALTISFACIBILIDAD BOOLEANA
//Usamos la matriz para leer el archivo
public class GeneticoSB extends Genetico{
    private ArrayList<IndividuoSB> pob;
    public GeneticoSB(int t, int num, double p){ //tamaño de poblacion, numGenereaciones, probabilidad de muta
        super(t, num, p);
    }
    @Override
    public void evolucionar(float porcentaje){
        
    }

    @Override
    public void evolucionar(){
        
    }
    private void actualizar(ArrayList<IndividuoSB> pobAux) {
         this.pob = new ArrayList<>();
        for(int i=0; i<pobAux.size(); i++){
            //System.out.println(pobAux.get(i).fitness);
            this.pob.add(new IndividuoSB(pobAux.get(i).getGenotipo()));
            //this.poblacion.get(i).actualizar();
            //System.out.println(this.poblacion.get(i).fitness);
        }
    }
}

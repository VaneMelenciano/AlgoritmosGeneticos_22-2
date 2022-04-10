/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import java.util.Arrays;
import objetos.Herramientas;
import objetos.Matriz;

/**
 *
 * @author Vanessa
 */

//SATISFACIBILIDAD BOOLEANA
public class IndividuoSAT extends Individuo{
    public IndividuoSAT(int n){ //n es el numero máximo en la matriz (100)
        setGenotipo(Herramientas.generarArregloBinario(n));
        actualizar();
        /**/
        //System.out.println(getFitness() + "  " + getGenotipo().length + " " +Arrays.toString(getGenotipo()));
    }
    //ceación aleatoria
    public IndividuoSAT(int[] gen){
        //super(gen);
        setGenotipo(gen.clone());
        actualizar();
    }

    private void calcularFitness() {
        int cont=0;
        for(int i=0; i<Matriz.matriz.length; i++){ //filas
            boolean n = false; //si esa fila es verdadera o falsa
            for(int j=0; j<3; j++){ //columnas
                int pos = Matriz.matriz[i][j];
                //System.out.println("pos: " + pos);
                int aux = getGenotipo()[Math.abs(pos)-1];
                if(pos<0) {
                    if (aux == 0){
                        aux = 1;
                    } else aux = 0;
                }
                
                if(aux==1){
                    n = true;
                    break;
                }
            }
            //terminando la fila
            if(n==true){
               cont++; 
            }
        }
        setFitness(cont);
    }

    @Override
    public void actualizar() {
        calcularFitness();
    }
    
}

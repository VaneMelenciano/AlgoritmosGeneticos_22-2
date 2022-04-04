/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import objetos.Herramientas;
import objetos.Matriz;

/**
 *
 * @author Vanessa
 */

//SATISFACIBILIDAD BOOLEANA
public class IndividuoSB extends Individuo{
    public IndividuoSB(int n){ //n es el tamaño de la matriz (num de filas)
        setGenotipo(Herramientas.generarArregloBinario(n));
        actualizar();
    }
    //ceación aleatoria
    public IndividuoSB(int[] gen){
        super(gen);
    }

    private void calcularFitness() {
        int cont=0;
        for(int i=0; i<Matriz.matriz.length; i++){ //filas
            boolean n = false; //si esa fila es verdadera o falsa
            for(int j=0; j<3; j++){ //columnas
                if(getGenotipo()[Matriz.matriz[i][j]]==1){
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

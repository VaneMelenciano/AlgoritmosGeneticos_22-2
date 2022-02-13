/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.Random;

/**
 *
 * @author Vanessa
 */
public class Herramientas {
    //arreglos con datos binarios
    public static int[] generarArreglo(int n){
        int[] aux = new int[n];
        Random r = new Random();
        for( int i=0; i<n; i++){
            aux[i]=r.nextInt(2);
        }
        return aux;
    }
}

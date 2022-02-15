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
    
    public static int[] generarMascara1punto(int n, int j){
        int[] aux = new int[n];
        for(int i=0; i<j; i++){
            aux[i]=1;
        }
        return aux;
    }
    
    public static int[] generarMascara2punto(int n, int k, int j){
        int[] aux = new int[n];
            if(k<j){
              for(int i=k; i<j; i++){
                aux[i]=1;
            }  
        }
        return aux;
    }
}

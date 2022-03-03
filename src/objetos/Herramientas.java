/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.Arrays;
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
    //Para TSP
    public static int[] generarArreglo(int ci, int nc){ //int ciudadIni, int numCiudades
        int cont = 0;
        int num = (int)(Math.random()*nc);
        int [] aux = new int[nc];
        //Relleno mi matriz con 0
        for(int i=0; i< nc; i++){
            aux[i]=-1;           
        }
        //Comienzo con el relleno del arreglo
        aux[0] = ci;
        while(cont<nc-1){
            if(num!=ci){
                for(int j=1;j<nc;j++){
                    if(num==aux[j]){
                        num = (int)(Math.random()*nc);
                        break;
                    }else if(j==nc-1){
                        aux[cont+1]=num;
                        cont++;
                    }              
                }
            }
            else{
                num = (int)(Math.random()*nc);
            }
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
    public static void imprimirArreglo(int[] n){
        System.out.println("Arreglo");
        for(int i=0; i<n.length; i++)
            System.out.println(n[i] + " ");
        System.out.println();
    }
}

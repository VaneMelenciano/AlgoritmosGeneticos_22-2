/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Individuos.IndividuoTSP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Vanessa
 */
public class Herramientas {
    public static int[] generarArregloBinario(int n){
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
        
        //Herramientas.imprimir(aux);
        return aux;
    } //TSP
        
    public static int[] generarArregloReinas(int n){ 
        //System.out.println("N: " + n);
        int[] aux = new int[n];
        Random r = new Random();
        for( int i=0; i<n; i++){
            int j = r.nextInt(n);
            aux[i]=j;
           
        }
        //System.out.println(Arrays.toString(aux));
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
    
    
    public static boolean verificarIndividuo(IndividuoTSP in){ //TSP, camino correcto
        System.out.println("Verificando");
        ArrayList<Integer> numeros = new ArrayList();
        for(int i=0; i<in.getGenotipo().length;i++) numeros.add(i);
        System.out.println("Array");
        imprimir(numeros);
        
        for(int n:in.getGenotipo()){
            int pos = numeros.indexOf(n);
            System.out.println(n + "   pos: " + pos);
            if(pos>=0) numeros.remove(pos);
            else return false;
        }
        return true;
    }
    
    private static void imprimir(ArrayList<Integer> a){
        for(int i : a){
            System.out.print(i + " ");
        }System.out.println();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import Individuos.IndividuoSAT;
import geneticos.GeneticoSAT;
import java.util.Arrays;
import objetos.Matriz;

/**
 *
 * @author Vanessa
 */
public class mainSB {
    public static void main(String[] args) {
    //SAT
        /*int[] ge = {3,3,1,0,0};
        Matriz.matriz = Matriz.leerArchivo(1); // 1 porque es para SB, si fuera TSP sería 0
        //Matriz.imprimirMatriz(Matriz.matriz);
        //IndividuoReinas ir = new IndividuoReinas(ge); 
        //System.out.println(ir.getFitness());
        int tamanio = 5000;
        int numGen = 5000000;
        double probM = 0.2;
        GeneticoSAT gen = new GeneticoSAT(tamanio, numGen, probM, 1, 1, 1, 0.20F, 100);
        //GeneticoSB gen = new GeneticoSAT(tamanio, numGen, probM, 100);
        gen.evolucionar();*/
        /*Matriz.matriz = Matriz.leerArchivo(1);
        IndividuoSAT sb = new IndividuoSAT(100);
        System.out.println(sb.getFitness() + "  " + sb.getGenotipo().length + " " +Arrays.toString(sb.getGenotipo()));
    */
    Matriz.matriz = Matriz.leerArchivo(1);
    int n3[] = {0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1};
    int n4[] = {0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1};
    int n5[] = {0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1};
    IndividuoSAT sb = new IndividuoSAT(n3);
    System.out.println(sb.getFitness());
    }
        
}

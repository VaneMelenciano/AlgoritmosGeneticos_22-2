/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import geneticos.GeneticoSB;
import objetos.Matriz;

/**
 *
 * @author Vanessa
 */
public class mainSB {
    public static void main(String[] args) {
    //REINAS
        int[] ge = {3,3,1,0,0};
        Matriz.matriz = Matriz.leerArchivo(1); // 1 porque es para SB, si fuera TSP sería 0
        //Matriz.imprimirMatriz(Matriz.matriz);
        //IndividuoReinas ir = new IndividuoReinas(ge); 
        //System.out.println(ir.getFitness());
        int tamanio = 5000;
        int numGen = 5000000;
        double probM = 0.05;
        GeneticoSB gen = new GeneticoSB(tamanio, numGen, probM, Matriz.matriz.length);
        gen.evolucionar();
    }
        
}

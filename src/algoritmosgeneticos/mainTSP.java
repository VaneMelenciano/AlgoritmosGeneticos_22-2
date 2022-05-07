/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import Individuos.IndividuoTSP;
import geneticos.GeneticoTSP;
import objetos.Matriz;

/**
 *
 * @author Vanessa
 */
public class mainTSP {
    public static void main(String[] args) {
        /*Matriz.matriz=Matriz.leerArchivo(0);
        Matriz.matrizElevaciones=Matriz.leerArchivo(0);
        Matriz.imprimirMatriz(Matriz.matriz);
        Matriz.imprimirMatriz(Matriz.matrizElevaciones);*/
        //Matriz.guardarArchivo(Matriz.matrizAleatoriaTSP(5, 0, 6), "Matriz elevaciones 5 cuidades, min 0 max 6");
        
        /*EJEMPLO EXCEL*/
        Matriz.matriz=Matriz.leerArchivo(0);
        double[] alturas = {0, 3, 2, 2.7, 1.6};
        System.out.println("\nMatriz de pendientes\n");
        Matriz.matrizElevaciones = Matriz.matrizElevacionesPendienteTSP(Matriz.matriz, alturas);
        //Matriz.imprimirMatriz(Matriz.matrizElevacionesPendienteTSP(Matriz.matriz, alturas));
        System.out.println("\nMatriz de angulos\n");
        Matriz.matrizElevaciones = Matriz.matrizElevacionesPendienteTSP(Matriz.matriz, alturas);
        //Matriz.matrizElevaciones = Matriz.matrizElevacionesAngulosTSP(Matriz.matriz, alturas);
        Matriz.guardarArchivo(Matriz.matrizElevaciones, "Mariz elevaciones 5 cuidades con angulo");
        Matriz.imprimirMatriz(Matriz.matrizElevacionesAngulosTSP(Matriz.matriz, alturas));
        System.out.println("\n");
        int[] genotipo = {0,1,2,3,4};
        IndividuoTSP individuo = new IndividuoTSP(genotipo, 0.6F, 0.4F);
        System.out.println(individuo.getFitness());
        
        
        /*Matriz.matriz=Matriz.leerArchivo(0);
        double[] alturas = {0, 3, 2, 2.7, 1.6};
        System.out.println("\nMatriz de pendientes\n");
        Matriz.imprimirMatriz(Matriz.matrizElevacionesPendienteTSP(Matriz.matriz, alturas));
        Matriz.matrizElevaciones = Matriz.matrizElevacionesPendienteTSP(Matriz.matriz, alturas);
        int tamanioPoblacion = 900;
        int numeroGeneraciones = 500000;
        double probabilidadMuta = 0.09;
        float porcentajeDistancia = 0.6F;
        float porcentajeElevacion = 0.4F;
        GeneticoTSP tsp = new GeneticoTSP(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, porcentajeDistancia, porcentajeElevacion);
        tsp.evolucionar();*/
    }
}

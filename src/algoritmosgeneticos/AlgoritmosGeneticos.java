/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import funcionSimple.Cruza;
import objetos.Herramientas;
import objetos.Individuo;

/**
 *
 * @author Vanessa
 */
public class AlgoritmosGeneticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] m = Herramientas.generarArreglo(8);
        int[] p = Herramientas.generarArreglo(8);
        int[] mascara = Herramientas.generarArreglo(8);
        //int[] g = {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1}; //53
        Individuo m2 = new Individuo(m); 
        Individuo p2 = new Individuo(p); 
        //Cruza.cruzaMascara(new Individuo(Herramientas.generarArreglo(8)), new Individuo(Herramientas.generarArreglo(8)), Herramientas.generarArreglo(8));
        System.out.println(Cruza.cruzaMascara(m2, p2, mascara).getFitness());
        System.out.println();
    }
    
}

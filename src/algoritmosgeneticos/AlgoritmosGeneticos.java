/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

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
        int[] g = Herramientas.generarArreglo(24);
        int[] ge = {1, 1, 0, 1, 0, 1}; //53
        Individuo a = new Individuo(ge); 
        System.out.println();
    }
    
}

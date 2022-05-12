/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import geneticos.GeneticoBinario;
import objetos.Clasificador;

/**
 *
 * @author Vanessa
 */
public class mainBinarioClasificador {
    public static void main(String[] args) {
        //construir un genetico binario
        int tamanioPoblacion = 150;
        int numeroGeneraciones = 500;
        double probabilidadMuta = 0.8;
        boolean banderaUsarClasificador= true;
        GeneticoBinario gb = new GeneticoBinario(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, banderaUsarClasificador);
        gb.evolucionar();
       
       
        /*Clasificador c = new Clasificador();
        int[] t = {1, 0, 1, 1};
        System.out.println(c.clasificar(t));
        System.out.println(Clasificador.clasificador.getMc().toString() + "\n");
        System.out.println(Clasificador.clasificador.getMc().calcularEfectividad());*/
        
    }
}

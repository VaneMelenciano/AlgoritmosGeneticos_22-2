/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import geneticos.GeneticoReinas;

/**
 *
 * @author Vanessa
 */
public class mainReinas {
  public static void main(String[] args) {
      //REINAS
        int[] ge = {3,3,1,0,0};
        //IndividuoReinas ir = new IndividuoReinas(ge); 
        //System.out.println(ir.getFitness());
        int tamanio = 900;
        int numGen = 5000;
        double probM = 0.15;
        int tamTab = 8;
        GeneticoReinas g = new GeneticoReinas(tamanio, numGen, probM, tamTab);
        g.evolucionar(0.10F);
  }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import funcionSimple.Cruza;
import funcionSimple.Muta;
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
        /*int[] m = Herramientas.generarArreglo(8);
        int[] p = Herramientas.generarArreglo(8);
        int[] mascara = Herramientas.generarArreglo(8);
        //int[] g = {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1}; //53
        Individuo m2 = new Individuo(m); 
        Individuo p2 = new Individuo(p); 
        //Cruza.cruzaMascara(new Individuo(Herramientas.generarArreglo(8)), new Individuo(Herramientas.generarArreglo(8)), Herramientas.generarArreglo(8));
        System.out.println(Cruza.cruzaMascara(m2, p2, mascara).getFitness());
        System.out.println();*/
        
        //COMPROBAR CLUZA Y MASCARAS
        //Mascara
        /*int[] mascara = Herramientas.generarMascara1punto(8, 3);
        //int[] mascara = Herramientas.generarMascara2punto(7, 3, 6);
        //int[] mascara = Herramientas.generarArreglo(8);
        System.out.println("Mascara");
        for(int i=0; i<mascara.length; i++)
            System.out.print(mascara[i]);
        System.out.println("\n");
        
        //mamá papá
        int[] m = Herramientas.generarArreglo(8);
        int[] p = Herramientas.generarArreglo(8);
        Individuo m2 = new Individuo(m); 
        Individuo p2 = new Individuo(p); 
        System.out.println("Mamá");
        for(int i=0; i<m.length; i++)
            System.out.print(m[i]);
        System.out.println("\nPapá");
        for(int i=0; i<p.length; i++)
            System.out.print(p[i]);
        System.out.println();
        
        
        Individuo elegido = Cruza.cruzaMascara(m2, p2,mascara);
        System.out.println("Hijo elegido");
        for(int i=0; i<elegido.getGenotipo().length; i++)
            System.out.print(elegido.getGenotipo()[i]);
        System.out.println("\tFitness: " + elegido.getFitness());*/
        
        int[] g = Herramientas.generarArreglo(8);
        Individuo a = new Individuo(g);
        Muta.muta(a);
         System.out.println();
    }
    
}

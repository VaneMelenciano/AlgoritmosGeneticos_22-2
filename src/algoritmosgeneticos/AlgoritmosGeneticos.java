/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;


import TSP.MatrizDistancia;
import objetos.Cruza;
import funcionSimple.GeneticoSimple;
import objetos.Muta;
import java.lang.reflect.Array;
import java.util.ArrayList;
import objetos.Herramientas;
import TSP.IndividuoTSP;
import java.util.Arrays;
import objetos.Muestreo;

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
        IndividuoTSP m2 = new IndividuoTSP(m); 
        IndividuoTSP p2 = new IndividuoTSP(p); 
        //Cruza.cruzaMascara(new IndividuoTSP(Herramientas.generarArreglo(8)), new IndividuoTSP(Herramientas.generarArreglo(8)), Herramientas.generarArreglo(8));
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
        IndividuoTSP m2 = new IndividuoTSP(m); 
        IndividuoTSP p2 = new IndividuoTSP(p); 
        System.out.println("Mamá");
        for(int i=0; i<m.length; i++)
            System.out.print(m[i]);
        System.out.println("\nPapá");
        for(int i=0; i<p.length; i++)
            System.out.print(p[i]);
        System.out.println();
        
        
        IndividuoTSP elegido = Cruza.cruzaMascara(m2, p2,mascara);
        System.out.println("Hijo elegido");
        for(int i=0; i<elegido.getGenotipo().length; i++)
            System.out.print(elegido.getGenotipo()[i]);
        System.out.println("\tFitness: " + elegido.getFitness());*/
        
        //COMPROBAR MUTA
        /*int[] g = Herramientas.generarArreglo(8);
        IndividuoTSP a = new IndividuoTSP(g);
        Muta.muta(a);
         System.out.println();*/
        
        //Comprobar seleccion torneo
        // mayor con 24 -> 16,777,215
        //tamaño de población, npumero de genéraciones, probabilidad de muta
        //GeneticoSimple gs = new GeneticoSimple(1400, 100, 0.5);
        //gs.evolucionar();
        
        //TSP
        
        //MatrizDistancia.imprimirMatriz(MatrizDistancia.matrizAleatoria(6, 3, 99));
        //Herramientas.imprimirArreglo(Herramientas.generarArreglo(3, 9));
        
        /*MatrizDistancia.matriz = new int[][]{{0,34,6,12},
                                           {34,0,40,8},
                                           {6,40,0,7},
                                           {12,8,7,0}};
        //31203 = 8+40+6+12=66
            //34 + 40 + 7 + 12
            
        //10231 = 34+6+7+8=55
            //34 + 40 + 7 + 8
        //03210 = 12+7+40+34=93
        //Individuo aux = new IndividuoTSP(3,4);
        int[] genotipo = {3,1,2,0};
        int[] genotipo2 = {1,0,2,3};
        //int[] genotipo = {0,3,2,1};
        IndividuoTSP aux = new IndividuoTSP(genotipo);
        IndividuoTSP aux2 = new IndividuoTSP(genotipo2);
        int[] mascara = {1, 0, 1, 0};
        IndividuoTSP nuevo = Cruza.cruzaTSP(aux, aux2);
        //Muta.muta(aux);
        System.out.println();*/
        
        
        /*int tamanioPob = 50; //tamaño de poblacion
        int numG = 3500; //numero de generaciones
        double posMuta = 0.2; //posibilidad de muta
        int cuI = 18; //cuidad inical
        MatrizDistancia.matriz = MatrizDistancia.leerArchivo();
        GeneticoSimple gs = new GeneticoSimple(tamanioPob, numG, posMuta);
        ArrayList<IndividuoTSP> original = (ArrayList<IndividuoTSP>) gs.poblacionTSP.clone();
        int porcentaje = 50;
        ArrayList<IndividuoTSP> nuevo = Muestreo.torneo((ArrayList<IndividuoTSP>) original.clone(), 50);
        System.out.println();*/
        //System.out.println(Arrays.toString(Herramientas.generarArreglo(10, 12)));
        
        int tamanioPob = 200; //tamaño de poblacion
        int numG = 4000; //numero de generaciones
        double posMuta = 0.1; //posibilidad de muta
        int cuI = 10; //cuidad inical
        MatrizDistancia.matriz = MatrizDistancia.leerArchivo();
        //MatrizDistancia.imprimirMatriz(MatrizDistancia.matriz);
        GeneticoSimple gs = new GeneticoSimple(tamanioPob, numG, posMuta, cuI);
        gs.evolucionarTSP(0.15F);
        //gs.evolucionarTSP(0.15F);
        //227
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;


//import geneticos.GeneticoReina;
import geneticos.GeneticoTSP;
//import Individuos.IndividuoReinas;
import objetos.Matriz;
import objetos.Cruza;
import objetos.Muta;
import java.lang.reflect.Array;
import java.util.ArrayList;
import objetos.Herramientas;
import Individuos.IndividuoTSP;
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
        
        //Matriz.imprimirMatriz(Matriz.matrizAleatoria(6, 3, 99));
        //Herramientas.imprimirArreglo(Herramientas.generarArreglo(3, 9));
        
        /*Matriz.matriz = new int[][]{{0,34,6,12},
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
        //System.out.println(Arrays.toString(genotipo));
        IndividuoTSP aux = new IndividuoTSP(genotipo);
        
        IndividuoTSP aux2 = new IndividuoTSP(genotipo2);
        int[] mascara = {1, 0, 1, 0};
        IndividuoTSP nuevo = Cruza.cruzaTSP(aux, aux2);
        //Muta.muta(aux);
        System.out.println();*/
        
        
        int tamanioPob = 500; //tamaño de poblacion
        int numG = 500; //numero de generaciones
        int ciuI = 20;
        double posMuta = 0.07; //posibilidad de muta
        int cuI = 18; //cuidad inical
        Matriz.matriz = Matriz.leerArchivo();
        GeneticoTSP gs = new GeneticoTSP(tamanioPob, numG, posMuta);
        gs.evolucionar(0.15F);
        //ArrayList<IndividuoTSP> original = (ArrayList<IndividuoTSP>) gs.poblacionTSP.clone();
        //int porcentaje = 50;
        //ArrayList<IndividuoTSP> nuevo = Muestreo.torneo((ArrayList<IndividuoTSP>) original.clone(), 50);
        //System.out.println();
        //System.out.println(Arrays.toString(Herramientas.generarArreglo(10, 12)));
        
        /*int tamanioPob = 1100; //tamaño de poblacion
        int numG = 5000; //numero de generaciones
        double posMuta = 0.09; //posibilidad de muta
        int cuI = 18; //cuidad inical
        Matriz.matriz = Matriz.leerArchivo();
        //Matriz.imprimirMatriz(Matriz.matriz);
        GeneticoSimple gs = new GeneticoSimple(tamanioPob, numG, posMuta, cuI);
        gs.evolucionarTSP();
        gs.evolucionarTSP(0.18F);
        System.out.println();
        int t=5;
        while(t>=0){
            //String gs = String.valueOf(t) + "gs"; 
            gs = new GeneticoSimple(tamanioPob, numG, posMuta);
            gs.evolucionarTSP(0.18F);
            t--;
            System.out.println();
        }*/
        //gs.evolucionarTSP(0.15F);
        //227
        
       
        //Matriz.guardarArchivo( Matriz.matrizAleatoria(15, 15, 96), "Mtariz 15 cuidades min 15 max 96");
        //Matriz.guardarArchivo( Matriz.matrizAleatoria(50, 20, 130), "Matriz 50 cuidades min 20 max 130");
        //Matriz.guardarArchivo( Matriz.matrizAleatoria(100, 0, 50), "Matriz 100 cuidades min 0 max 50");
        //Matriz.guardarArchivo( Matriz.matrizAleatoria(400, 15, 80), "Matriz 400 cuidades min 15 max 80");
        
        //REINAS
        /*int[] ge = {3,3,1,0,0};
        //IndividuoReinas ir = new IndividuoReinas(ge); 
        //System.out.println(ir.getFitness());
        int tamanio = 500;
        int numGen = 10000000;
        double probM = 0.01;
        int tamTab = 8;
        GeneticoReina g = new GeneticoReina(tamanio, numGen, probM, tamTab);
        g.evolucionar(0.10F);*/
    }
    
}

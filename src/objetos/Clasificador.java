/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;
import Herramientas.Factor;
import Herramientas.GeneradorInstancias;
import clasesSupervisadas.NaiveBayes;
import Herramientas.Instancias;
import Herramientas.Tokenizador;
import Individuos.Individuo;
import java.util.ArrayList;
/**
 *
 * @author Vanessa
 */
public class Clasificador {
    public static NaiveBayes clasificador;
    public static Instancias instancias;
    private final ArrayList<int[]> genotiposCalculados; //tiene que tener el genotipo y firness calculado
    private final ArrayList<Float> fitnessCalculados;
    //private final ArrayList<Integer> fitnessCalculados;
    private int numeroAtributos = 0;
    
    public Clasificador(){
        genotiposCalculados = new ArrayList<>();
        fitnessCalculados = new ArrayList<>();
        clasificador = new NaiveBayes();
        Tokenizador t = new Tokenizador(1); //lee el archivo de las instancias
        numeroAtributos = t.getInstancias().getNumAtributos();
        instancias = t.getInstancias();
    }
    private void entrenarClasificador(){
        clasificador.entrenar(instancias);
    }
    public float clasificar(int[] atributosTomar){
        int posicionEncontrada = this.genotiposCalculados.indexOf(atributosTomar);
        if(posicionEncontrada<0){
            
            GeneradorInstancias gi1 = new GeneradorInstancias(instancias);
            gi1.generarInstancia(atributosTomar, 0, Factor.RANDOM);
            clasificador.entrenar(gi1.getNuevasInstancias());
            clasificador.clasificar(gi1.getNuevasInstancias().getPatrones());
            float fitness = (float) clasificador.getMc().calcularEfectividad();
            this.genotiposCalculados.add(atributosTomar);
            this.fitnessCalculados.add(fitness);
            return fitness;
        }else{
            return this.fitnessCalculados.get(posicionEncontrada);
        }
        
    }

    /**
     * @return the numeroAtributos
     */
    public int getNumeroAtributos() {
        return numeroAtributos;
    }
    
}

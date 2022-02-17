/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionSimple;

import objetos.Individuo;

/**
 *
 * @author Vanessa
 */
public class Cruza {
    //metodo de cruza con base a mascara, y retorna el mejor
    public static Individuo cruzaMascara(Individuo m, Individuo p, int[] mascara){
        int[] g1 = new int[m.getGenotipo().length];    
        int[] g2 = new int[m.getGenotipo().length];    
        //recorriendo la mascara
        for(int i=0; i<mascara.length; i++){
            //copias genotipicas en los genes de los hijos
            if(mascara[i]==1){
                g1[i]=m.getGenotipo()[i];
                g2[i]=p.getGenotipo()[i];
            }else{
                g1[i]=p.getGenotipo()[i];
                g2[i]=m.getGenotipo()[i];
            }
        }
        Individuo h1 = new Individuo(g1);
        Individuo h2 = new Individuo(g2);
        
        
        System.out.println("\nIndividuo 1");
        for(int i=0; i<h1.getGenotipo().length; i++)
            System.out.print(h1.getGenotipo()[i]);
        System.out.println("\tFitness: " + h1.getFitness() + "\nIndividuo 2");
        for(int i=0; i<h2.getGenotipo().length; i++)
            System.out.print(h2.getGenotipo()[i]);
        System.out.println("\tFitness: " + h2.getFitness());
        
        return (h1.getFitness()>h2.getFitness() ? h1 : h2);
    }
}

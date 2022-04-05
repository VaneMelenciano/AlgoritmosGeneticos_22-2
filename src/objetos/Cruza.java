/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Individuos.IndividuoBinario;
import Individuos.IndividuoReinas;
import Individuos.IndividuoSB;
import Individuos.IndividuoTSP;
import java.util.LinkedHashSet;

/**
 *
 * @author Vanessa
 */
public class Cruza {
    //metodo de cruza con base a mascara, y retorna el mejor
    public static IndividuoBinario cruzaMascara(IndividuoBinario m, IndividuoBinario p, int[] mascara){
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
        IndividuoBinario h1 = new IndividuoBinario(g1);
        IndividuoBinario h2 = new IndividuoBinario(g2);
        
        /*System.out.println("\nIndividuo 1");
        for(int i=0; i<h1.getGenotipo().length; i++)
            System.out.print(h1.getGenotipo()[i]);
        System.out.println("\tFitness: " + h1.getFitness() + "\nIndividuo 2");
        for(int i=0; i<h2.getGenotipo().length; i++)
            System.out.print(h2.getGenotipo()[i]);
        System.out.println("\tFitness: " + h2.getFitness());*/
        
        return (h1.getFitness()>h2.getFitness() ? h1 : h2);
    }
    public static IndividuoTSP cruzaTSP(IndividuoTSP m, IndividuoTSP p, int[] mascara){
        int[] g1 = new int[m.getGenotipo().length];    
        int[] g2 = new int[m.getGenotipo().length];
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
        IndividuoTSP h1 = new IndividuoTSP(g1);
        IndividuoTSP h2 = new IndividuoTSP(g2);
        //REVISAR SI LOS INDIVIDUOS CREADOS SON VALIDOS
        boolean h1valido = Herramientas.verificarIndividuo(h1);
        boolean h2valido = Herramientas.verificarIndividuo(h2);
        
        if(h1valido && h2valido)
            return verificarMenor(h1,h2);
        else if(h1valido) 
            return h1;
        else if(h2valido)
            return h2;
         else
            return verificarMenor(m,p);
    }
    public static IndividuoTSP cruzaTSP(IndividuoTSP m, IndividuoTSP p){
        LinkedHashSet<Integer> li1 = new LinkedHashSet<>(m.getGenotipo().length);
        LinkedHashSet<Integer> li2 = new LinkedHashSet<>(m.getGenotipo().length);
        boolean bandera = true;
        li1.add(m.getGenotipo()[0]);
        li2.add(m.getGenotipo()[0]);
        //primer individuo
        for(int i=1; i<m.getGenotipo().length; i++){
            if(bandera){
                li1.add(m.getGenotipo()[i]);
                bandera=false;
            }
            if(!bandera){
                li1.add(p.getGenotipo()[i]);
                bandera=true;
            }
        }
        //segundo individuo
        bandera = true;
        for(int i=m.getGenotipo().length-1; i>0; i--){
            if(bandera){
                li2.add(m.getGenotipo()[i]);
                bandera=false;
            }
            if(!bandera){
                li2.add(p.getGenotipo()[i]);
                bandera=true;
            }
        }
        IndividuoTSP indi1 = new IndividuoTSP(li1.stream().mapToInt(i -> i).toArray());// de integer -> int
        IndividuoTSP indi2 = new IndividuoTSP(li2.stream().mapToInt(i -> i).toArray());
        return verificarMenor(indi1, indi2); 
    }
    private static IndividuoTSP verificarMenor(IndividuoTSP m, IndividuoTSP p){
        //if(m.getFitness()<p.getFitness()) return m;
        if(m.getFitness()>p.getFitness()) return p;
        else return m;
    }
    public static IndividuoReinas cruzaMascara(IndividuoReinas m, IndividuoReinas p, int[] mascara){
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
        IndividuoReinas h1 = new IndividuoReinas(g1);
        IndividuoReinas h2 = new IndividuoReinas(g2);
        
        /*System.out.println("\nIndividuo 1");
        for(int i=0; i<h1.getGenotipo().length; i++)
            System.out.print(h1.getGenotipo()[i]);
        System.out.println("\tFitness: " + h1.getFitness() + "\nIndividuo 2");
        for(int i=0; i<h2.getGenotipo().length; i++)
            System.out.print(h2.getGenotipo()[i]);
        System.out.println("\tFitness: " + h2.getFitness());*/
        
        return (h1.getFitness()<h2.getFitness() ? h1 : h2);
    }
    public static IndividuoSB cruzaMascara(IndividuoSB m, IndividuoSB p, int[] mascara){
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
        IndividuoSB h1 = new IndividuoSB(g1);
        IndividuoSB h2 = new IndividuoSB(g2);
        
        /*System.out.println("\nIndividuo 1");
        for(int i=0; i<h1.getGenotipo().length; i++)
            System.out.print(h1.getGenotipo()[i]);
        System.out.println("\tFitness: " + h1.getFitness() + "\nIndividuo 2");
        for(int i=0; i<h2.getGenotipo().length; i++)
            System.out.print(h2.getGenotipo()[i]);
        System.out.println("\tFitness: " + h2.getFitness());*/
        
        return (h1.getFitness()<h2.getFitness() ? h1 : h2);
    }
}

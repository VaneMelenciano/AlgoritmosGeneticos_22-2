/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Individuos.IndividuoReinas;
import Individuos.IndividuoTSP;
import Individuos.IndividuoBinario;
import static java.lang.Math.max;
import java.util.LinkedHashSet;
import java.util.Random;

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
        boolean h1valido = Herramientas.verificarIndividuoTSP(h1);
        boolean h2valido = Herramientas.verificarIndividuoTSP(h2);
        
        if(h1valido && h2valido)
            return verificarMenor(h1,h2);
        else if(h1valido) 
            return h1;
        else if(h2valido)
            return h2;
         else
            return verificarMenor(m,p);
    }
    
    private static IndividuoTSP verificarMenor(IndividuoTSP m, IndividuoTSP p){
        //if(m.getFitness()<p.getFitness()) return m;
        if(m.getFitness()>p.getFitness()) return p;
        else return m;
    }
    private static IndividuoReinas verificarMenor(IndividuoReinas m, IndividuoReinas p){
        //if(m.getFitness()<p.getFitness()) return m;
        if(m.getFitness()>p.getFitness()) return p;
        else return m;
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
    public static IndividuoReinas cruzaReinas(IndividuoReinas m, IndividuoReinas p){
        if(m.getGenotipo().length!=p.getGenotipo().length){
            throw new RuntimeException(m.getGenotipo().length+"");
        }
        LinkedHashSet<Integer> li1 = new LinkedHashSet<>(m.getGenotipo().length);
        LinkedHashSet<Integer> li2 = new LinkedHashSet<>(m.getGenotipo().length);
        boolean bandera = true;
        li1.add(m.getGenotipo()[0]);
        li2.add(m.getGenotipo()[0]);
        //primer individuo
        for(int i=1; i<m.getGenotipo().length; i++){
            //System.out.println(m.getGenotipo().length);
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
        //System.out.println(li1.size() + "aqui");
        IndividuoReinas indi1 = new IndividuoReinas(li1.stream().mapToInt(i -> i).toArray());// de integer -> int
        IndividuoReinas indi2 = new IndividuoReinas(li2.stream().mapToInt(i -> i).toArray());
        return verificarMenor(indi1, indi2); 
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
}

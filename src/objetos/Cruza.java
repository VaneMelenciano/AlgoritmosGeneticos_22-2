/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Individuos.IndividuoBinario;
import Individuos.IndividuoHorario;
import Individuos.IndividuoReinas;
import Individuos.IndividuoSAT;
import Individuos.IndividuoTSP;
import java.util.Arrays;
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
    public static IndividuoSAT cruzaMascara(IndividuoSAT m, IndividuoSAT p, int[] mascara){
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
        IndividuoSAT h1 = new IndividuoSAT(g1);
        IndividuoSAT h2 = new IndividuoSAT(g2);
        
        /*System.out.println("\nIndividuo 1");
        for(int i=0; i<h1.getGenotipo().length; i++)
            System.out.print(h1.getGenotipo()[i]);
        System.out.println("\tFitness: " + h1.getFitness() + "\nIndividuo 2");
        for(int i=0; i<h2.getGenotipo().length; i++)
            System.out.print(h2.getGenotipo()[i]);
        System.out.println("\tFitness: " + h2.getFitness());*/
        
        return (h1.getFitness()>h2.getFitness() ? h1 : h2);
    }

    public static IndividuoHorario cruzaHorarios(IndividuoHorario m, IndividuoHorario p, int[] mascara) {
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
        IndividuoHorario h1 = new IndividuoHorario(g1);
        IndividuoHorario h2 = new IndividuoHorario(g2);
        return verificarMenor(h1, h2);
    }
    
    public static IndividuoHorario cruzaHorarios(IndividuoHorario m, IndividuoHorario p) {
        int[] geneticoAux1 = new int[m.getGenotipo().length];
        int[] geneticoAux2 = new int[m.getGenotipo().length];;
        
        boolean bandera = true;
        int j=0;
        //primer individuo
        for(int i=0; i<m.getGenotipo().length; i++){
            if(bandera){
                geneticoAux1[j++] = m.getGenotipo()[i];
                bandera=false;
            }
            if(!bandera){
                geneticoAux1[j++] = p.getGenotipo()[i];
                bandera=true;
            }
        }
        //segundo individuo
        bandera = true; j=0;
        for(int i=m.getGenotipo().length-1; i>0; i--){
            if(bandera){
                geneticoAux2[j++] = m.getGenotipo()[i];
                bandera=false;
            }
            if(!bandera){
                geneticoAux2[j++] = p.getGenotipo()[i];
                bandera=true;
            }
        }
        IndividuoHorario hijo1 = new IndividuoHorario(geneticoAux1);
        IndividuoHorario hijo2 = new IndividuoHorario(geneticoAux2);
        return verificarMenor(hijo1, hijo2);
    }

    private static IndividuoHorario verificarMenor(IndividuoHorario hijo1, IndividuoHorario hijo2) {
        if(hijo1.getFitness()>hijo2.getFitness()) return hijo2;
        else return hijo1;
    }
}

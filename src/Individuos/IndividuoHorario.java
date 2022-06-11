/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuos;

import geneticos.GeneticoHorario;
import java.util.LinkedHashSet;
import objetos.Herramientas;
import objetos.Horario;

/**
 *
 * @author Vanessa
 */
public final class IndividuoHorario extends Individuo{
    
    public IndividuoHorario(){
        setGenotipo(Herramientas.generarArregloHorario(Horario.numeroMaterias*Horario.numeroGrupos*Horario.vecesMateriaPorSemana));
        actualizar();
    }
    //ceación aleatoria
    public IndividuoHorario(int[] gen){
        super(gen);
    }

    public void calcularFitness() {
        int contador=0, aux, auxMaestro;
        
        Horario.ordenarCondicionesGrupo();
        for(int grupo = 0; grupo<Horario.numeroGrupos; grupo++){
                //modulos de un grupo
             aux = Horario.modulosPorSemana*Horario.numeroMaterias; //numero de modulos para un grupo
             LinkedHashSet<Integer> listaAux = new LinkedHashSet<>();
             for(int modulo=0; modulo<aux; modulo++){
                 listaAux.add(this.getGenotipo()[modulo]);
             } 
             contador+= (Horario.modulosPorSemana*Horario.numeroMaterias)-listaAux.size();
        }
        
        Horario.ordenarCondicionesMaestro();
        for(int maestro = 0; maestro<Horario.numeroMaestros; ){
                //modulos de un grupo
             auxMaestro = Horario.actividades.get(maestro).getMaestro();
             LinkedHashSet<Integer> listaAux = new LinkedHashSet<>();
             int grupoPorMaestro = 0;
             while(Horario.actividades.get(maestro).getMaestro() == auxMaestro){ //miestras siga siendo el mismo maestro
                 //5 modulos de la semana correspondientes al grupo y materia que da ese maestro
                 for(int modulo=0; modulo<Horario.modulosPorSemana; modulo++){
                     listaAux.add(this.getGenotipo()[modulo]);
                 }
                 maestro++;
                 grupoPorMaestro++;
             } 
             contador+= (grupoPorMaestro*Horario.modulosPorSemana)-listaAux.size();
        }
        this.setFitness(contador);
            
    }

    @Override
    public void actualizar() {
        calcularFitness();
    }
}


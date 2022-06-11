/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Vanessa
 */
public class Horario {
    public static int modulosPorDia;
    public static int modulosPorSemana;
    public static int vecesMateriaPorSemana; //cuantas veces sé da cada materia en la semana
    public static int numeroMaterias;
    public static int numeroGrupos;
    public static int numeroMaestros;
    
    public static ArrayList<Actividad> actividades; //id, maestro, grupo, materia
    /*
    maestro, grupo, materia -> va a tener materiaSemana
    */
    public Horario (int modulosDia, int materiaSemana, int materias, int maestros, int grupos, ArrayList<Actividad> act){
        modulosPorDia = modulosDia; //5
        numeroMaterias = materias; //7
        numeroGrupos = grupos; //6
        modulosPorSemana = modulosDia*5; //5*7
        vecesMateriaPorSemana = materiaSemana; //5
        actividades = act;
        numeroMaestros = maestros;
    }
    public static void ordenarCondicionesMaestro(){
        actividades.sort(Comparator.comparingInt(i -> i.getMaestro()));
    }
    public static void ordenarCondicionesGrupo(){
        actividades.sort(Comparator.comparingInt(i -> i.getGrupo()));
    }
}

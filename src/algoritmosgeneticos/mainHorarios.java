/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import geneticos.GeneticoHorario;
import objetos.Horario;
import objetos.TokenizadorHorarios;

/**
 *
 * @author Vanessa
 */
public class mainHorarios {
    public static void main(String[] args) {
        //public Horario (int modulosDia, int materiaSemana, int materias, int maestros, int grupos, ArrayList<Actividad> act){
        TokenizadorHorarios.leerArchivo();
        Horario horario = new Horario(5, 5, 7, 15, 6, TokenizadorHorarios.listaActividades);
        //int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta
        GeneticoHorario gh = new GeneticoHorario(25, 300000, 0.4);
        gh.evolucionar();
        
        System.out.println("");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Vanessa
 */
public class Actividad {
    private int maestro;
    private int grupo;
    private int materia;
    
    public Actividad(){
    }
    
    public Actividad(int mae, int gru, int mat){
        this.maestro = mae;
        this.grupo = gru;
        this.materia = mat;
    }

    /**
     * @return the maestro
     */
    public int getMaestro() {
        return maestro;
    }

    /**
     * @param maestro the maestro to set
     */
    public void setMaestro(int maestro) {
        this.maestro = maestro;
    }

    /**
     * @return the grupo
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the materia
     */
    public int getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(int materia) {
        this.materia = materia;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class TokenizadorHorarios {
    
    public static ArrayList<Actividad> listaActividades;
    
    public static int[][] leerArchivo(){
        String aux, texto;
        int matriz[][] = null;
        LinkedList<String> lista = new LinkedList(); //para guardar los datos que se vayan leyendo
        
        
        try {
            JFileChooser file = new JFileChooser(); //llamamos el metodo que permite cargar la ventana
            file.setCurrentDirectory(new File(".././Pruebas"));
            file.showOpenDialog(file);
            //Abre el archivo
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) { //verifica que esté abierto
                
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux; //guarda la linea del archivo leido en el String
                    lista.add(texto); //añade el String anterior a la lista
                }
                lee.close();
                
                
                //TOKENIZAR DATOS PARA TSP
                    ArrayList<String> lista2 = new ArrayList<>(); //un renglon
                    matriz = new int[lista.size()][lista.size()];
                    ArrayList<Actividad> actividades = new ArrayList<Actividad>();
                    
                    for (int i = 0; i < lista.size(); i++) { 
                        Actividad act = new Actividad();
                        StringTokenizer tokens = new StringTokenizer(lista.get(i), ","); //va separando los renglones guardado en la lista, por los espacios

                        while (tokens.hasMoreTokens()) { //mientras existan tokens (renglones)
                            lista2.add(tokens.nextToken()); //guarda cada dato del renglo en la lista2
                        }
                        
                        act.setMaestro(Integer.parseInt(lista2.get(0)));
                        act.setMateria(Integer.parseInt(lista2.get(1)));
                        act.setGrupo(Integer.parseInt(lista2.get(2)));
                        actividades.add(act);
                        lista2.clear();
                    }
                    listaActividades = actividades;
                
            }
            
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nArchivo no encontrado",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
        return matriz;
    }
}

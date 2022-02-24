/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
public class Tokenizador {
    //lee datos de un archivo, los tokeniza, y los guarda en una matriz
    private int matriz[][];
    //Leer archivo (csv, txt), tokenizar datos, guardar los Items (de cada renglon)
    public Tokenizador(){
        leerArchivo();
    }
    //Leer el archivo (csc o txt)
    public void leerArchivo(){
        String aux, texto;
        LinkedList<String> lista = new LinkedList(); //para guardar los datos que se vayan leyendo
        
        
        try {
            JFileChooser file = new JFileChooser(); //llamamos el metodo que permite cargar la ventana
            file.setCurrentDirectory(new File("./"));
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
                
                
                //TOKENIZAR DATOS
                ArrayList<String> lista2 = new ArrayList<>(); //un renglon
                this.matriz = new int[lista.size()][lista.size()];
                for (int i = 0; i < lista.size(); i++) { 

                    StringTokenizer tokens = new StringTokenizer(lista.get(i), " "); //va separando los renglones guardado en la lista, por los espacios

                    while (tokens.hasMoreTokens()) { //mientras existan tokens (renglones)
                        lista2.add(tokens.nextToken()); //guarda cada dato del renglo en la lista2
                    }
                    
                    for (int x = 0; x < lista2.size(); x++) { 
                        this.matriz[i][x] = Integer.parseInt(lista2.get(x));
                    }
                    lista2.clear();
                }
          
            }
            
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nArchivo no encontrado",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
    }
    public void guardarArchivo(int[][] m){
        this.matriz = m;
        FileWriter flwriter = null;
            try {
                    //crea el flujo para escribir en el archivo
                    flwriter = new FileWriter(".././matriz.txt");
                    //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
                    BufferedWriter bfwriter = new BufferedWriter(flwriter);
                    
                    for(int i=0; i<this.matriz.length; i++){
                        for(int j : this.matriz[i]){
                           bfwriter.write(j + " "); 
                        }
                        bfwriter.write("\n");
                    }
                    //cierra el buffer intermedio
                    bfwriter.close();

            } catch (IOException e) {
                    e.printStackTrace();
            } finally {
                    if (flwriter != null) {
                            try {//cierra el flujo principal
                                    flwriter.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }
    }

    /**
     * @return the matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }
    public void imprimirMatriz(){
       for(int i=0; i<this.matriz.length; i++){
            for(int j : this.matriz[i]){
               System.out.print(j + " "); 
            }
            System.out.println();
        } 
    }

    /**
     * @return the items
     */
}

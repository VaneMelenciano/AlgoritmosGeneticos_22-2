/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class MatrizDistancia {
    public static int[][] matriz;
    
    public static int[][] leerArchivo(){
        String aux, texto;
        int matriz[][] = null;
        LinkedList<String> lista = new LinkedList(); //para guardar los datos que se vayan leyendo
        
        
        try {
            JFileChooser file = new JFileChooser(); //llamamos el metodo que permite cargar la ventana
            file.setCurrentDirectory(new File(".././Pruebas/TSP"));
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
                matriz = new int[lista.size()][lista.size()];
                for (int i = 0; i < lista.size(); i++) { 

                    StringTokenizer tokens = new StringTokenizer(lista.get(i), " "); //va separando los renglones guardado en la lista, por los espacios

                    while (tokens.hasMoreTokens()) { //mientras existan tokens (renglones)
                        lista2.add(tokens.nextToken()); //guarda cada dato del renglo en la lista2
                    }
                    
                    for (int x = 0; x < lista2.size(); x++) { 
                        matriz[i][x] = Integer.parseInt(lista2.get(x));
                    }
                    lista2.clear();
                }
          
            }
            
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nArchivo no encontrado",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
        return matriz;
    }
    
    public static void guardarArchivo(int[][] m){ //nombre con base en hora de creación
        int matriz[][] = m;
        FileWriter flwriter = null;
            try {
                    //crea el flujo para escribir en el archivo
                    //SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
                    SimpleDateFormat ff1 = new SimpleDateFormat("ss-mm-hh");
                    SimpleDateFormat ff2 = new SimpleDateFormat("dd-MM-yyyy");
                    Date d = new Date();
                    String time1 = ff1.format(d);
                    String time2 = ff2.format(d);
                    String name = "matriz_" + time1 + "_" +time2; 
                    
                    flwriter = new FileWriter(".././" + name + ".txt");
                    //flwriter = new FileWriter(".././matriz.txt");
                    //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
                    BufferedWriter bfwriter = new BufferedWriter(flwriter);
                    
                    for(int i=0; i<matriz.length; i++){
                        for(int j : matriz[i]){
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
    
    public static void guardarArchivo(int[][] m, String name){ //recibe nombre como parametro
        int matriz[][] = m;
        FileWriter flwriter = null;
            try {
                    //crea el flujo para escribir en el archivo
                    
                    flwriter = new FileWriter(".././" + name + ".txt");
                    //flwriter = new FileWriter(".././matriz.txt");
                    //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
                    BufferedWriter bfwriter = new BufferedWriter(flwriter);
                    
                    for(int i=0; i<matriz.length; i++){
                        for(int j : matriz[i]){
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
    
    public static void guardarArchivo(String[][] m){ //nombre con base en hora de creación
        String matriz[][] = m;
        FileWriter flwriter = null;
            try {
                    //crea el flujo para escribir en el archivo
                    //SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
                    SimpleDateFormat ff1 = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat ff2 = new SimpleDateFormat("hh-mm-ss");
                    Date d = new Date();
                    String time1 = ff1.format(d);
                    String time2 = ff2.format(d);
                    String name = "matriz_" + time1 + "_" +time2; 
                    
                    flwriter = new FileWriter(".././Pruebas/TSP/" + name + ".txt");
                    //flwriter = new FileWriter(".././matriz.txt");
                    //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
                    BufferedWriter bfwriter = new BufferedWriter(flwriter);
                    
                    for(int i=0; i<matriz.length; i++){
                        for(String j : matriz[i]){
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
    
    public static int[][] matrizAleatoria(int n, int min, int max){
        Random r = new Random();
        int[][] matriz = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                int num = r.nextInt(max-min+1) + min;
                if(i==j)
                    matriz[i][j] = 0;
                    //matriz[j][i] = (j==i ? 0 :num);
                else{
                   matriz[i][j] = num; 
                   matriz[j][i] = num; 
                }
            }
        }
        return matriz;
    }
    
    public static void imprimirMatriz(int[][] matriz){
       for(int i=0; i<matriz.length; i++){
            for(int j : matriz[i]){
               System.out.print(j + "\t"); 
            }
            System.out.println();
        } 
    }
    
}

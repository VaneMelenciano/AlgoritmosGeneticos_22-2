/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HilosEjemplo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Vanessa
 */
public class Listener implements ActionListener{
    
    private ClaseA entidad;
    private ClaseBJFrame frame;
    public Listener(ClaseA entidad, ClaseBJFrame frame){
        this.entidad = entidad;
        this.frame=frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        //ClaseBJFrame frame = (ClaseBJFrame) boton.getParent();
        String texto = this.frame.getjTextField1().getText();
        try{
           int numero = Integer.parseInt(this.frame.getjTextField2().getText()); 
           this.entidad.setN(numero);
        }catch(NumberFormatException ex){
            
        }
        
        if(!texto.isEmpty())
            this.entidad.setMensaje(texto);
       
    }
}

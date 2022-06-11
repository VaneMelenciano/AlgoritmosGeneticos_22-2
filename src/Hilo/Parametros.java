/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilo;

import geneticos.GeneticoBinario;
import geneticos.GeneticoHorario;
import geneticos.GeneticoReinas;
import geneticos.GeneticoSAT;
import geneticos.GeneticoTSP;
import objetos.Horario;
import objetos.Matriz;
import objetos.TokenizadorHorarios;

/**
 *
 * @author Vanessa
 */
public class Parametros extends javax.swing.JFrame {
    //private GeneticoTSP genetico;
    private GeneticoSAT geneticoSAT;
    private GeneticoBinario geneticoBinario;
    private GeneticoReinas geneticoReinas;
    private GeneticoTSP geneticoTSP;
    private GeneticoHorario geneticoHorario;
    private int seleccion; 
    //Binario=0, Reinas=1, SAT=2, TSP=3, Horario = 4
    /**
     * Creates new form Parametros
     */
    public Parametros() {
        
        /*initComponents();
        Matriz.matriz=Matriz.leerArchivo(1); //0: TSP, 1: SB
       geneticoSAT = new GeneticoSAT(900, 100000000, 0, 0, 0, 0, 0, 100);
       this.seleccion=2;
       Thread hilo = new Thread(geneticoSAT);
       hilo.start();*/
       /*initComponents();
        //Matriz.matriz=Matriz.leerArchivo(1); //0: TSP, 1: SB
       geneticoBinario = new GeneticoBinario(100, 50000, 0, 0, 0, 0, 0, true);
       this.seleccion=0;
       Thread hilo = new Thread(geneticoBinario);
       hilo.start();*/
        initComponents();
        TokenizadorHorarios.leerArchivo();
        Horario horario = new Horario(5, 5, 7, 15, 6, TokenizadorHorarios.listaActividades);
        //int tamanioPoblacion, int numeroGeneraciones, double probabilidadMuta
        geneticoHorario = new GeneticoHorario(25, 300000, 0.4);
        seleccion=4;
        Thread hilo = new Thread(geneticoHorario);
       hilo.start();
    }
    public Parametros(GeneticoSAT genetico, String titulo) {
        super.setTitle(titulo);
        initComponents();
        this.geneticoSAT = genetico;
        this.seleccion=2;
       Thread hilo = new Thread(genetico);
       hilo.start();
    }
    public Parametros(GeneticoBinario genetico, String titulo) {
        super.setTitle(titulo);
        initComponents();
        this.geneticoBinario = genetico;
        this.seleccion=0;
       Thread hilo = new Thread(genetico);
       hilo.start();
    }
    public Parametros(GeneticoTSP genetico, String titulo) {
        super.setTitle(titulo);
        initComponents();
        this.geneticoTSP = genetico;
        this.seleccion=3;
       Thread hilo = new Thread(genetico);
       hilo.start();
    }
    public Parametros(GeneticoReinas genetico, String titulo) {
        super.setTitle(titulo);
        initComponents();
        this.geneticoReinas = genetico;
        this.seleccion=1;
       Thread hilo = new Thread(genetico);
       hilo.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        textPoblacion = new javax.swing.JLabel();
        textMutaP = new javax.swing.JLabel();
        textSel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        probabilidadMuta = new javax.swing.JTextField();
        tamanioPoblacion = new javax.swing.JTextField();
        seleccionMadre = new javax.swing.JComboBox<>();
        textSel1 = new javax.swing.JLabel();
        seleccionPadre = new javax.swing.JComboBox<>();
        tamanioMuestreo = new javax.swing.JTextField();
        tipoMuestreo = new javax.swing.JComboBox<>();
        cambiar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textPoblacion.setText("Tamaño de población:");

        textMutaP.setText("Probabilidad de muta: ");

        textSel.setText("Tipo de selección madre:");

        jLabel1.setText("Tipo de muestreo:");

        jLabel2.setText("Porcentaje de muestreo:");

        tamanioPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamanioPoblacionActionPerformed(evt);
            }
        });

        seleccionMadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Torneo", "Selección" }));
        seleccionMadre.setSelectedIndex(2);
        seleccionMadre.setToolTipText("");
        seleccionMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionMadreActionPerformed(evt);
            }
        });

        textSel1.setText("Tipo de selección padre:");

        seleccionPadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Torneo", "Selección" }));
        seleccionPadre.setSelectedIndex(2);
        seleccionPadre.setToolTipText("");
        seleccionPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionPadreActionPerformed(evt);
            }
        });

        tipoMuestreo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Torneo", "Selección" }));
        tipoMuestreo.setSelectedIndex(2);
        tipoMuestreo.setToolTipText("");
        tipoMuestreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoMuestreoActionPerformed(evt);
            }
        });

        cambiar.setText("Cambiar");
        cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textMutaP)
                            .addComponent(textPoblacion)
                            .addComponent(textSel))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(seleccionMadre, javax.swing.GroupLayout.Alignment.TRAILING, 0, 113, Short.MAX_VALUE)
                            .addComponent(probabilidadMuta, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tamanioPoblacion, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSel1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(seleccionPadre, 0, 113, Short.MAX_VALUE)
                            .addComponent(tipoMuestreo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tamanioMuestreo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cambiar)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPoblacion)
                    .addComponent(tamanioPoblacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMutaP)
                    .addComponent(probabilidadMuta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSel)
                    .addComponent(seleccionMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSel1)
                    .addComponent(seleccionPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tipoMuestreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tamanioMuestreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(cambiar)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tamanioPoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanioPoblacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamanioPoblacionActionPerformed

    private void seleccionMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionMadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionMadreActionPerformed

    private void seleccionPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionPadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionPadreActionPerformed

    private void tipoMuestreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoMuestreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoMuestreoActionPerformed

    public void actualizarValores(){
        //Binario=0, Reinas=1, SAT=2, TSP=3
        switch(this.seleccion){
               case 0:
                   this.tamanioPoblacion.setText(String.valueOf(this.geneticoBinario.getTamanioPoblacion()));
                   this.probabilidadMuta.setText(String.valueOf(this.geneticoBinario.getProbabilidadMuta()));
                   this.seleccionMadre.setSelectedIndex(this.geneticoBinario.getSeleccionMadre());
                   this.seleccionPadre.setSelectedIndex(this.geneticoBinario.getSeleccionPadre());
                   this.tipoMuestreo.setSelectedIndex(this.geneticoBinario.getTipoMuestreo());
                   this.tamanioMuestreo.setText(String.valueOf(this.geneticoBinario.getPorcentajeMuestreo()));
                   break;
               case 1:
                   this.tamanioPoblacion.setText(String.valueOf(this.geneticoReinas.getTamanioPoblacion()));
                   this.probabilidadMuta.setText(String.valueOf(this.geneticoReinas.getProbabilidadMuta()));
                   this.seleccionMadre.setSelectedIndex(this.geneticoReinas.getSeleccionMadre());
                   this.seleccionPadre.setSelectedIndex(this.geneticoReinas.getSeleccionPadre());
                   this.tipoMuestreo.setSelectedIndex(this.geneticoReinas.getTipoMuestreo());
                   this.tamanioMuestreo.setText(String.valueOf(this.geneticoReinas.getPorcentajeMuestreo()));
                   break;
               case 2: 
                   this.tamanioPoblacion.setText(String.valueOf(this.geneticoSAT.getTamanioPoblacion()));
                   this.probabilidadMuta.setText(String.valueOf(this.geneticoSAT.getProbabilidadMuta()));
                   this.seleccionMadre.setSelectedIndex(this.geneticoSAT.getSeleccionMadre());
                   this.seleccionPadre.setSelectedIndex(this.geneticoSAT.getSeleccionPadre());
                   this.tipoMuestreo.setSelectedIndex(this.geneticoSAT.getTipoMuestreo());
                   this.tamanioMuestreo.setText(String.valueOf(this.geneticoSAT.getPorcentajeMuestreo()));
                   break;
               case 4:
                    this.tamanioPoblacion.setText(String.valueOf(this.geneticoHorario.getTamanioPoblacion()));
                   this.probabilidadMuta.setText(String.valueOf(this.geneticoHorario.getProbabilidadMuta()));
                   this.seleccionMadre.setSelectedIndex(this.geneticoHorario.getSeleccionMadre());
                   this.seleccionPadre.setSelectedIndex(this.geneticoHorario.getSeleccionPadre());
                   this.tipoMuestreo.setSelectedIndex(this.geneticoHorario.getTipoMuestreo());
                   this.tamanioMuestreo.setText(String.valueOf(this.geneticoHorario.getPorcentajeMuestreo()));
               default:
                   this.tamanioPoblacion.setText(String.valueOf(this.geneticoTSP.getTamanioPoblacion()));
                   this.probabilidadMuta.setText(String.valueOf(this.geneticoTSP.getProbabilidadMuta()));
                   this.seleccionMadre.setSelectedIndex(this.geneticoTSP.getSeleccionMadre());
                   this.seleccionPadre.setSelectedIndex(this.geneticoTSP.getSeleccionPadre());
                   this.tipoMuestreo.setSelectedIndex(this.geneticoTSP.getTipoMuestreo());
                   this.tamanioMuestreo.setText(String.valueOf(this.geneticoTSP.getPorcentajeMuestreo()));
                   break;
           }
    }
    
    private void cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarActionPerformed
       //Binario=0, Reinas=1, SAT=2, TSP=3

        //Tamaño de población
       if(this.tamanioPoblacion.getText().length()!=0){
           cambiarTamanioPoblacio();
       }
       //Probabilidad de muta
       if(this.probabilidadMuta.getText().length()!=0){
           cambiarProbabilidadMuta(); 
       }
       //Tipo de seleccion madre
       if(this.seleccionMadre.getSelectedIndex()!=2){
           cambiarSeleccionMadre();
       }
       //Tipo de seleccion padre
       if(this.seleccionPadre.getSelectedIndex()!=2){
           cambiarSeleccionPadre();
       }
       //Tipo de muestreo
       if(this.tipoMuestreo.getSelectedIndex()!=2){
           cambiarTipoMuestreo();
       }
       //Porcentaje de muestreo
       if(this.tamanioMuestreo.getText().length()!=0){
           cambiarTamanioMuestreo();
       }
    }//GEN-LAST:event_cambiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parametros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField probabilidadMuta;
    private javax.swing.JComboBox<String> seleccionMadre;
    private javax.swing.JComboBox<String> seleccionPadre;
    private javax.swing.JTextField tamanioMuestreo;
    private javax.swing.JTextField tamanioPoblacion;
    private javax.swing.JLabel textMutaP;
    private javax.swing.JLabel textPoblacion;
    private javax.swing.JLabel textSel;
    private javax.swing.JLabel textSel1;
    private javax.swing.JComboBox<String> tipoMuestreo;
    // End of variables declaration//GEN-END:variables

    private void cambiarSeleccionMadre() {
        switch(this.seleccion){
               case 0: this.geneticoBinario.setSeleccionMadre(this.seleccionMadre.getSelectedIndex());
                   break;
               case 1: this.geneticoReinas.setSeleccionMadre(this.seleccionMadre.getSelectedIndex());
                   break;
               case 2: this.geneticoSAT.setSeleccionMadre(this.seleccionMadre.getSelectedIndex());
                   break;
               case 4: this.geneticoHorario.setSeleccionMadre(this.seleccionMadre.getSelectedIndex());
                   break;
               default: this.geneticoTSP.setSeleccionMadre(this.seleccionMadre.getSelectedIndex());
                   break;
           }
    }
    
    private void cambiarProbabilidadMuta() {
        double muta = Double.parseDouble(this.probabilidadMuta.getText()); //pMuta
           switch(this.seleccion){
               case 0: this.geneticoBinario.setProbabilidadMuta(muta);
                   break;
               case 1: this.geneticoReinas.setProbabilidadMuta(muta);
                   break;
               case 2: this.geneticoSAT.setProbabilidadMuta(muta);
                   break;
               case 4: this.geneticoHorario.setProbabilidadMuta(muta);
                   break;
               default: this.geneticoTSP.setProbabilidadMuta(muta);
                   break;
           }
    }

    private void cambiarSeleccionPadre() {
           switch(this.seleccion){
               case 0: this.geneticoBinario.setSeleccionPadre(this.seleccionPadre.getSelectedIndex());
                   break;
               case 1: this.geneticoReinas.setSeleccionPadre(this.seleccionPadre.getSelectedIndex());
                   break;
               case 2:this.geneticoSAT.setSeleccionPadre(this.seleccionPadre.getSelectedIndex());
                   break;
               case 4:this.geneticoHorario.setSeleccionPadre(this.seleccionPadre.getSelectedIndex());
                   break;
               default: this.geneticoTSP.setSeleccionPadre(this.seleccionPadre.getSelectedIndex());
                   break;
           }
    }

    private void cambiarTipoMuestreo() {
        switch(this.seleccion){
               case 0: this.geneticoBinario.setTipoMuestreo(this.seleccionPadre.getSelectedIndex());
                   break;
               case 1: this.geneticoReinas.setTipoMuestreo(this.seleccionPadre.getSelectedIndex());
                   break;
               case 2:this.geneticoSAT.setTipoMuestreo(this.tipoMuestreo.getSelectedIndex());
                   break;
               case 4:this.geneticoHorario.setTipoMuestreo(this.tipoMuestreo.getSelectedIndex());
                   break;
               default: this.geneticoTSP.setTipoMuestreo(this.seleccionPadre.getSelectedIndex());
                   break;
           }
    }

    private void cambiarTamanioMuestreo() {
        float por = Float.parseFloat(this.tamanioMuestreo.getText());
           switch(this.seleccion){
               case 0: this.geneticoBinario.setPorcentajeMuestreo(por);
                   break;
               case 1: this.geneticoReinas.setPorcentajeMuestreo(por);
                   break;
               case 2:this.geneticoSAT.setPorcentajeMuestreo(por);
                   break;
               case 4:this.geneticoHorario.setPorcentajeMuestreo(por);
                   break;
               default: this.geneticoTSP.setPorcentajeMuestreo(por);
                   break;
           }
    }

    private void cambiarTamanioPoblacio() {
        int poblacion = Integer.parseInt(this.tamanioPoblacion.getText());
           switch(this.seleccion){
               case 0: this.geneticoBinario.setTamanioPoblacion(poblacion);
                   break;
               case 1: this.geneticoReinas.setTamanioPoblacion(poblacion);
                   break;
               case 2:this.geneticoSAT.setTamanioPoblacion(poblacion);
                   break;
               case 4:this.geneticoHorario.setTamanioPoblacion(poblacion);
                   break;
               default: this.geneticoTSP.setTamanioPoblacion(poblacion);
                   break;
           } 
    }

    
}

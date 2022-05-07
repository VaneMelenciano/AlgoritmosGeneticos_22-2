/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilo;

import geneticos.GeneticoBinario;
import geneticos.GeneticoReinas;
import geneticos.GeneticoSAT;
import geneticos.GeneticoTSP;
import objetos.Matriz;

/**
 *
 * @author Vanessa
 */
public class ParametrosTSPmultiobjetivo extends javax.swing.JFrame {
    //private GeneticoTSP genetico;
    private GeneticoSAT geneticoSAT;
    private GeneticoBinario geneticoBinario;
    private GeneticoReinas geneticoReinas;
    private GeneticoTSP geneticoTSP;
    private int seleccion; 
    //Binario=0, Reinas=1, SAT=2, TSP=3
    /**
     * Creates new form Parametros
     */
    public ParametrosTSPmultiobjetivo(){
        initComponents();
        this.seleccion=3;
        Matriz.matriz=Matriz.leerArchivo(0);
        double[] alturas = {0, 3, 2, 2.7, 1.6};
        System.out.println("\nMatriz de pendientes\n");
        Matriz.imprimirMatriz(Matriz.matrizElevacionesPendienteTSP(Matriz.matriz, alturas));
        Matriz.matrizElevaciones = Matriz.matrizElevacionesPendienteTSP(Matriz.matriz, alturas);
        int tamanioPoblacion = 900;
        int numeroGeneraciones = 500000;
        double probabilidadMuta = 0.09;
        float porcentajeDistancia = 1F;
        float porcentajeElevacion = 0F;
        geneticoTSP = new GeneticoTSP(tamanioPoblacion, numeroGeneraciones, probabilidadMuta, porcentajeDistancia, porcentajeElevacion);
       Thread hilo = new Thread(geneticoTSP);
       hilo.start();
       
    }
    public ParametrosTSPmultiobjetivo(GeneticoSAT genetico, String titulo) {
        super.setTitle(titulo);
        initComponents();
        this.geneticoSAT = genetico;
        this.seleccion=2;
       Thread hilo = new Thread(genetico);
       hilo.start();
    }
    public ParametrosTSPmultiobjetivo(GeneticoBinario genetico, String titulo) {
        super.setTitle(titulo);
        initComponents();
        this.geneticoBinario = genetico;
        this.seleccion=0;
       Thread hilo = new Thread(genetico);
       hilo.start();
    }
    public ParametrosTSPmultiobjetivo(GeneticoTSP genetico, String titulo) {
        super.setTitle(titulo);
        initComponents();
        this.geneticoTSP = genetico;
        this.seleccion=3;
       Thread hilo = new Thread(genetico);
       hilo.start();
    }
    public ParametrosTSPmultiobjetivo(GeneticoReinas genetico, String titulo) {
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
        jLabel3 = new javax.swing.JLabel();
        porcentajeDistancia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        porcentajeElevacion = new javax.swing.JTextField();

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

        jLabel3.setText("Porcentaje distancia:");

        porcentajeDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porcentajeDistanciaActionPerformed(evt);
            }
        });

        jLabel4.setText("Porcentaje elevacion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cambiar)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(textPoblacion)
                        .addGap(40, 40, 40)
                        .addComponent(tamanioPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textMutaP)
                                    .addComponent(textSel))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(seleccionMadre, javax.swing.GroupLayout.Alignment.TRAILING, 0, 113, Short.MAX_VALUE)
                                    .addComponent(probabilidadMuta, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textSel1)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(seleccionPadre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tipoMuestreo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tamanioMuestreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(porcentajeDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(porcentajeElevacion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPoblacion)
                    .addComponent(tamanioPoblacion))
                .addGap(18, 18, 18)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(porcentajeDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(porcentajeElevacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
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
       //PORCENTAJES
       if(this.porcentajeDistancia.getText().length()!=0){
           float por = Float.parseFloat(this.porcentajeDistancia.getText());
           this.geneticoTSP.setPorcentajeDistancia(por);
       }
       if(this.porcentajeElevacion.getText().length()!=0){
           float por = Float.parseFloat(this.porcentajeElevacion.getText());
           this.geneticoTSP.setPorcentajeElevacion(por);
       }
    }//GEN-LAST:event_cambiarActionPerformed

    private void porcentajeDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcentajeDistanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porcentajeDistanciaActionPerformed

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
            java.util.logging.Logger.getLogger(ParametrosTSPmultiobjetivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParametrosTSPmultiobjetivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParametrosTSPmultiobjetivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParametrosTSPmultiobjetivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParametrosTSPmultiobjetivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField porcentajeDistancia;
    private javax.swing.JTextField porcentajeElevacion;
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
               default: this.geneticoTSP.setTamanioPoblacion(poblacion);
                   break;
           } 
    }

    
}

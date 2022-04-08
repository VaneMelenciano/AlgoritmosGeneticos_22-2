/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilo;

import geneticos.GeneticoSB;
import geneticos.GeneticoTSP;
import objetos.Matriz;

/**
 *
 * @author Vanessa
 */
public class Parametros extends javax.swing.JFrame {
    //private GeneticoTSP genetico;
    private GeneticoSB genetico;
    /**
     * Creates new form Parametros
     */
    public Parametros() {
        initComponents();
        Matriz.matriz=Matriz.leerArchivo(1); //0: TSP, 1: SB
       genetico = new GeneticoSB(900, 1000000, 0.15, 1, 0, 1, 0.20F, 100);
       //genetico = new GeneticoTSP(500, 1000000, 0.15, 1, 0, 1, 0.20F);
       
       //tamaño de pobleación, num Generaciones, cuidad inicial o tamaño de tabl, 
        //prob Muta, seleccion para madre y padre, tipo de muestreo y tamaño de muestreo
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
        pMuta = new javax.swing.JTextField();
        tPob = new javax.swing.JTextField();
        tSelM = new javax.swing.JComboBox<>();
        textSel1 = new javax.swing.JLabel();
        tSelP = new javax.swing.JComboBox<>();
        pMueP = new javax.swing.JTextField();
        tMue = new javax.swing.JComboBox<>();
        cambiar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textPoblacion.setText("Tamaño de población:");

        textMutaP.setText("Probabilidad de muta: ");

        textSel.setText("Tipo de selección madre:");

        jLabel1.setText("Tipo de muestreo:");

        jLabel2.setText("Porcentaje de muetreo:");

        tPob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPobActionPerformed(evt);
            }
        });

        tSelM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Torneo", "Selección" }));
        tSelM.setSelectedIndex(2);
        tSelM.setToolTipText("");
        tSelM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSelMActionPerformed(evt);
            }
        });

        textSel1.setText("Tipo de selección padre:");

        tSelP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Torneo", "Selección" }));
        tSelP.setSelectedIndex(2);
        tSelP.setToolTipText("");
        tSelP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSelPActionPerformed(evt);
            }
        });

        tMue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Torneo", "Selección" }));
        tMue.setSelectedIndex(2);
        tMue.setToolTipText("");
        tMue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tMueActionPerformed(evt);
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
                            .addComponent(tPob, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(pMuta)
                            .addComponent(tSelM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSel1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tSelP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tMue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pMueP))
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cambiar)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPoblacion)
                    .addComponent(tPob))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMutaP)
                    .addComponent(pMuta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSel)
                    .addComponent(tSelM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSel1)
                    .addComponent(tSelP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tMue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pMueP))
                .addGap(48, 48, 48)
                .addComponent(cambiar)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tPobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPobActionPerformed

    private void tSelMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSelMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSelMActionPerformed

    private void tSelPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSelPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSelPActionPerformed

    private void tMueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tMueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tMueActionPerformed

    private void cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarActionPerformed
       //Tamaño de población
       /*if(this.tPob.getText().length()!=0){
           int poblacion = Integer.parseInt(this.tPob.getText());
           this.genetico.setTamanioPoblacion(poblacion);
       }*/
       //Probabilidad de muta
       if(this.pMuta.getText().length()!=0){
           double muta = Double.parseDouble(this.pMuta.getText()); //pMuta
           this.genetico.setProbMuta(muta);
       }
       //Tipo de seleccion madre tSelM
       if(this.tSelM.getSelectedIndex()!=2){
           this.genetico.setSeleM(this.tSelM.getSelectedIndex());
       }
       //Tipo de seleccion apdre tSelP
       if(this.tSelP.getSelectedIndex()!=2){
           this.genetico.setSeleP(this.tSelP.getSelectedIndex());
       }
       //Tipo de muestreo tMue
       if(this.tMue.getSelectedIndex()!=2){
           this.genetico.setMueT(this.tMue.getSelectedIndex());
       }
       //Porcentaje de muestreo pMueP
       if(this.pMueP.getText().length()!=0){
           float por = Float.parseFloat(this.pMueP.getText());
           this.genetico.setMuestreo(por);
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
    private javax.swing.JTextField pMueP;
    private javax.swing.JTextField pMuta;
    private javax.swing.JComboBox<String> tMue;
    private javax.swing.JTextField tPob;
    private javax.swing.JComboBox<String> tSelM;
    private javax.swing.JComboBox<String> tSelP;
    private javax.swing.JLabel textMutaP;
    private javax.swing.JLabel textPoblacion;
    private javax.swing.JLabel textSel;
    private javax.swing.JLabel textSel1;
    // End of variables declaration//GEN-END:variables
}
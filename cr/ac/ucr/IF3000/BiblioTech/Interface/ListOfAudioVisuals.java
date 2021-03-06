/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.IF3000.BiblioTech.Interface;

import File.AudioVisualFile;
import File.BooksFile;
import cr.ac.ucr.IF3000.BiblioTech.domain.AudioVisual;
import cr.ac.ucr.IF3000.BiblioTech.domain.Books;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Max
 */
public class ListOfAudioVisuals extends javax.swing.JFrame {

    /**
     * Creates new form ListOfAudioVisuals
     */
    public AudioVisualFile audioFile;
    public ListOfAudioVisuals() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            showTable(lvl_AudioVisualtList);
        } catch (IOException e) {
            System.err.println("No match found vehicles");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_InfoListAudioVisuals = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lvl_AudioVisualtList = new javax.swing.JTable();
        btn_BackBooksRecord = new javax.swing.JButton();
        lbl_StuRecedBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(948, 555));
        setMinimumSize(new java.awt.Dimension(948, 555));
        setPreferredSize(new java.awt.Dimension(948, 555));
        setResizable(false);
        getContentPane().setLayout(null);

        lbl_InfoListAudioVisuals.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_InfoListAudioVisuals.setText("Audio Visuals Recorded");
        getContentPane().add(lbl_InfoListAudioVisuals);
        lbl_InfoListAudioVisuals.setBounds(20, 10, 300, 30);

        lvl_AudioVisualtList.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lvl_AudioVisualtList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Brand", "Model", "Code", "Amount"
            }
        ));
        jScrollPane2.setViewportView(lvl_AudioVisualtList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 40, 660, 402);

        btn_BackBooksRecord.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_BackBooksRecord.setText("Back");
        btn_BackBooksRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackBooksRecordActionPerformed(evt);
            }
        });
        getContentPane().add(btn_BackBooksRecord);
        btn_BackBooksRecord.setBounds(100, 400, 100, 40);
        getContentPane().add(lbl_StuRecedBackground);
        lbl_StuRecedBackground.setBounds(0, 0, 970, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BackBooksRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackBooksRecordActionPerformed
        // TODO add your handling code here:
        Principal p = new Principal();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_BackBooksRecordActionPerformed
    
    public void showTable(JTable table) throws IOException {
        File file = new File("./AudioVisual.dat");
        audioFile = new AudioVisualFile(file);
        AudioVisual audioVisual = new AudioVisual();
        ArrayList<AudioVisual> myArrayList = audioFile.getAudioList();
        
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        table = new JTable(modelo);
        for(int i=0;i<myArrayList.size();i++){
            audioVisual = myArrayList.get(i);
            Object obj[] = new Object[]{
                audioVisual.getName(),audioVisual.getBrand(),audioVisual.getModel(),audioVisual.getCode(),audioVisual.getAmount()};
            modelo.addRow(obj);
        }
        
        lvl_AudioVisualtList.setModel(modelo);
    }
    
    
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
            java.util.logging.Logger.getLogger(ListOfAudioVisuals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfAudioVisuals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfAudioVisuals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfAudioVisuals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfAudioVisuals().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BackBooksRecord;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_InfoListAudioVisuals;
    private javax.swing.JLabel lbl_StuRecedBackground;
    private javax.swing.JTable lvl_AudioVisualtList;
    // End of variables declaration//GEN-END:variables
}

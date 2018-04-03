/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.IF3000.BiblioTech.Interface;

import File.AudioVisualFile;
import java.io.File;
import java.io.IOException;
import File.StudentFile;
import cr.ac.ucr.IF3000.BiblioTech.domain.AudioVisual;
import cr.ac.ucr.IF3000.BiblioTech.domain.Student;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Max
 */
public class RecordStudent extends javax.swing.JFrame {

    /**
     * Creates new form RecordStudent
     */
    public RecordStudent() {
        initComponents();
        setLocationRelativeTo(null);
        tfd_problem.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_RecName = new javax.swing.JLabel();
        lbl_RecMay = new javax.swing.JLabel();
        lbl_RecYear = new javax.swing.JLabel();
        tfd_RecName = new javax.swing.JTextField();
        tfd_RecMay = new javax.swing.JTextField();
        tfd_RecYear = new javax.swing.JTextField();
        btn_RecDone = new javax.swing.JButton();
        btn_RecStudentBack = new javax.swing.JButton();
        tfd_problem = new javax.swing.JTextField();
        lbl_RecordStudentBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(948, 575));
        setMinimumSize(new java.awt.Dimension(948, 575));
        setPreferredSize(new java.awt.Dimension(948, 575));
        setResizable(false);
        getContentPane().setLayout(null);

        lbl_RecName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_RecName.setText("Name ");
        getContentPane().add(lbl_RecName);
        lbl_RecName.setBounds(450, 50, 140, 30);
        lbl_RecName.getAccessibleContext().setAccessibleDescription("");

        lbl_RecMay.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_RecMay.setText("Mayor");
        getContentPane().add(lbl_RecMay);
        lbl_RecMay.setBounds(450, 150, 100, 30);

        lbl_RecYear.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_RecYear.setText("Year of income");
        getContentPane().add(lbl_RecYear);
        lbl_RecYear.setBounds(450, 250, 190, 30);

        tfd_RecName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfd_RecName.setRequestFocusEnabled(false);
        getContentPane().add(tfd_RecName);
        tfd_RecName.setBounds(450, 90, 170, 40);

        tfd_RecMay.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(tfd_RecMay);
        tfd_RecMay.setBounds(450, 190, 170, 40);

        tfd_RecYear.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(tfd_RecYear);
        tfd_RecYear.setBounds(450, 290, 170, 40);

        btn_RecDone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_RecDone.setText("Done");
        btn_RecDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RecDoneActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RecDone);
        btn_RecDone.setBounds(480, 390, 100, 40);

        btn_RecStudentBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_RecStudentBack.setText("Back");
        btn_RecStudentBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RecStudentBackActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RecStudentBack);
        btn_RecStudentBack.setBounds(290, 390, 100, 40);

        tfd_problem.setEditable(false);
        tfd_problem.setForeground(new java.awt.Color(255, 0, 0));
        tfd_problem.setText("Find space within complet");
        getContentPane().add(tfd_problem);
        tfd_problem.setBounds(590, 390, 190, 40);
        getContentPane().add(lbl_RecordStudentBackground);
        lbl_RecordStudentBackground.setBounds(0, 0, 960, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RecStudentBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RecStudentBackActionPerformed
        // TODO add your handling code here:
        Principal p = new Principal();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_RecStudentBackActionPerformed

    
    
    public void insertStudent() throws IOException{
        File file = new File("./student.dat");
        StudentFile studentFile = new StudentFile(file);
                
                
                
        String name=tfd_RecName.getText();
        String mayor=tfd_RecMay.getText();
        String year=tfd_RecYear.getText();
        String ID="";
        //""+mayor.charAt(0)+yearIncome.charAt(3)+""
        if(studentFile.returnIntID()<10){
            ID+=""+mayor.charAt(0)+year.charAt(3)+"00"+studentFile.returnIntID();
        }else if(studentFile.returnIntID()<99){
            ID+=""+mayor.charAt(0)+year.charAt(3)+"0"+studentFile.returnIntID();
        }else{
            ID+=""+mayor.charAt(0)+year.charAt(3)+""+studentFile.returnIntID();
        }
        Student inserStudent = new Student(name, mayor, year,ID);
        studentFile.addEndRecord(inserStudent);
        
    }
    
    private void btn_RecDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RecDoneActionPerformed
        try {
            // TODO add your handling code here:
         
            if(tfd_RecName.getText().equals("") || tfd_RecMay.getText().equals("") || tfd_RecYear.getText().equals("") ){
                tfd_problem.setVisible(true);
            }else{
                tfd_problem.setVisible(false);
                insertStudent();
                tfd_RecName.setText("");
                tfd_RecMay.setText("");
                tfd_RecYear.setText("");
                tfd_RecName.requestFocus();
            }
        
            
        } catch (IOException ex) {
            System.err.println("Vehicle can't be added in the file");
        }
    }//GEN-LAST:event_btn_RecDoneActionPerformed

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
            java.util.logging.Logger.getLogger(RecordStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecordStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecordStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecordStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecordStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_RecDone;
    private javax.swing.JButton btn_RecStudentBack;
    private javax.swing.JLabel lbl_RecMay;
    private javax.swing.JLabel lbl_RecName;
    private javax.swing.JLabel lbl_RecYear;
    private javax.swing.JLabel lbl_RecordStudentBackground;
    private javax.swing.JTextField tfd_RecMay;
    private javax.swing.JTextField tfd_RecName;
    private javax.swing.JTextField tfd_RecYear;
    private javax.swing.JTextField tfd_problem;
    // End of variables declaration//GEN-END:variables
}

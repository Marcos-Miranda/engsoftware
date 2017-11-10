/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlReservas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marki
 */
public class Reservas extends javax.swing.JFrame {
    
    private SalaTableModel stm = new SalaTableModel();
    private static ReservaTableModel rtm = new ReservaTableModel();
    private static int login;
    private static int cargo; 

    /**
     * Creates new form Reservas
     */
    public Reservas() {
        initComponents();
    }
    
    public void setLogin(int log){
        login = log;
    }
    
    public void setCargo(int c){
        cargo = c;
    }
    
    public ReservaTableModel getRtm(){
        return rtm;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpFazerReserva = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lData = new javax.swing.JLabel();
        jbVerificarSalas = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        lHorario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSalasDisp = new javax.swing.JTable();
        jbEfetuarReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jpSuasReservas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtSuasReservas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jDateChooser1.setMinSelectableDate(new java.util.Date(-62135755084000L));
        Date hoje = new Date();
        jDateChooser1.setDate(hoje);
        jDateChooser1.getDateEditor().setEnabled(false);

        lData.setText("Selecione a data:");

        jbVerificarSalas.setText("Verificar salas");
        jbVerificarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerificarSalasActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M1:  07:30-08:20", "M2:  08:20-09:10", "M3:  09:10-10:00", "M4:  10:20-11:10", "M5:  11:10-12:00", "M6:  12:00-12:50", "T1:  13:00-13:50", "T2:  13:50-14:40", "T3:  14:40-15:30", "T4:  15:50-16:40", "T5:  16:40-17:30", "T6:  17:50-18:40", "N1:  18:40-19:30", "N2:  19:30-20:20", "N3:  20:20-21:10", "N4:  21:20-22:10", "N5:  22:10-23:00" }));

        lHorario.setText("Selecione o horário:");

        jtSalasDisp.setModel(stm);
        jScrollPane1.setViewportView(jtSalasDisp);

        jbEfetuarReserva.setText("Efetuar Reserva");
        jbEfetuarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEfetuarReservaActionPerformed(evt);
            }
        });

        jLabel1.setText("Insira a motivação da reserva(Opcional):");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFazerReservaLayout = new javax.swing.GroupLayout(jpFazerReserva);
        jpFazerReserva.setLayout(jpFazerReservaLayout);
        jpFazerReservaLayout.setHorizontalGroup(
            jpFazerReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFazerReservaLayout.createSequentialGroup()
                .addGroup(jpFazerReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lHorario)
                    .addComponent(lData, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpFazerReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jpFazerReservaLayout.createSequentialGroup()
                .addGroup(jpFazerReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFazerReservaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1))
                    .addGroup(jpFazerReservaLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jbVerificarSalas)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFazerReservaLayout.createSequentialGroup()
                .addGap(0, 183, Short.MAX_VALUE)
                .addComponent(jbEfetuarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
            .addGroup(jpFazerReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFazerReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFazerReservaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpFazerReservaLayout.setVerticalGroup(
            jpFazerReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFazerReservaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpFazerReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lData)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jpFazerReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jbVerificarSalas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jbEfetuarReserva)
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Nova Reserva", jpFazerReserva);

        jtSuasReservas.setModel(rtm);
        jScrollPane2.setViewportView(jtSuasReservas);

        jButton1.setText("Cancelar reserva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpSuasReservasLayout = new javax.swing.GroupLayout(jpSuasReservas);
        jpSuasReservas.setLayout(jpSuasReservasLayout);
        jpSuasReservasLayout.setHorizontalGroup(
            jpSuasReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuasReservasLayout.createSequentialGroup()
                .addGroup(jpSuasReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSuasReservasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSuasReservasLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpSuasReservasLayout.setVerticalGroup(
            jpSuasReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuasReservasLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Suas Reservas", jpSuasReservas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVerificarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerificarSalasActionPerformed
      // TODO add your handling code here:
      if(Controle.validaData(jDateChooser1.getDate())==-1){
          JOptionPane.showMessageDialog(null,"A data da reserva deve ser pelo menos um dia posterior à data atual");
      }
      else if(Controle.validaData(jDateChooser1.getDate())==1){
          JOptionPane.showMessageDialog(null,"A data da reserva não pode ser no sábado nem no domingo");
      }
      else{
          String horario = jComboBox1.getSelectedItem().toString().substring(0,2);
          try {
              stm.limpar();
              stm.addListaDeSalas(Bd.retornaSalas(jDateChooser1.getDate(),horario));
          } catch (ParseException ex) {
              Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

    }//GEN-LAST:event_jbVerificarSalasActionPerformed

    private void jbEfetuarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEfetuarReservaActionPerformed
        // TODO add your handling code here:
        if(stm.getRowCount()==0 || jtSalasDisp.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"Selecione uma sala antes de efetuar a reserva");
        }
        else{
            String horario = jComboBox1.getSelectedItem().toString().substring(0,2);
            String motivacao = jTextField1.getText();
            int linha = jtSalasDisp.getSelectedRow();
            String sala = stm.getValueAt(linha,0).toString();
            String msg;


            if(cargo==0){
                msg=Controle.reservaAluno(login, jDateChooser1.getDate(), horario, sala, motivacao);
                jbVerificarSalas.doClick();
            }
            else{
                msg=Controle.reservaProfessor(login, jDateChooser1.getDate(), horario, sala, motivacao);
                jbVerificarSalas.doClick();
            }
            
            JOptionPane.showMessageDialog(null,msg);
        }
        
        rtm.limpar();
        if(cargo==0){
            rtm.addListaDeReservas(Controle.reservasAluno(login));
        }
        else{
            rtm.addListaDeReservas(Controle.reservasProfessor(login));
        }
    }//GEN-LAST:event_jbEfetuarReservaActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int linha = jtSuasReservas.getSelectedRow();
        String sala = rtm.getValueAt(linha,0).toString();
        String horario = rtm.getValueAt(linha,1).toString();
        String data = rtm.getValueAt(linha, 2).toString();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient (false); 
        Date dat = null;
        try {
            dat = df.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Bd.excluirReserva(horario, dat, sala);
        rtm.limpar();
        if(cargo==0){
            rtm.addListaDeReservas(Controle.reservasAluno(login));
        }
        else{
            rtm.addListaDeReservas(Controle.reservasProfessor(login));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservas().setVisible(true);
                
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbEfetuarReserva;
    private javax.swing.JButton jbVerificarSalas;
    private javax.swing.JPanel jpFazerReserva;
    private javax.swing.JPanel jpSuasReservas;
    private javax.swing.JTable jtSalasDisp;
    private javax.swing.JTable jtSuasReservas;
    private javax.swing.JLabel lData;
    private javax.swing.JLabel lHorario;
    // End of variables declaration//GEN-END:variables
}
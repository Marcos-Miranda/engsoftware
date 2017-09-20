
package ControlReservas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//Interface da tela de login do usuário

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BgFuncão = new javax.swing.ButtonGroup();
        RbAluno = new javax.swing.JRadioButton();
        RbProfessor = new javax.swing.JRadioButton();
        lfunção = new javax.swing.JLabel();
        Bconfirmar = new javax.swing.JButton();
        lLogin = new javax.swing.JLabel();
        lSenha = new javax.swing.JLabel();
        CampoLogin = new javax.swing.JTextField();
        CampoSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BgFuncão.add(RbAluno);
        RbAluno.setText("Aluno");
        RbAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbAlunoActionPerformed(evt);
            }
        });

        BgFuncão.add(RbProfessor);
        RbProfessor.setText("Professor");
        RbProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbProfessorActionPerformed(evt);
            }
        });

        lfunção.setText("Função:");

        Bconfirmar.setText("Confirmar");
        Bconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BconfirmarActionPerformed(evt);
            }
        });

        lLogin.setText("Login (RA):");

        lSenha.setText("Senha:");

        CampoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSenhaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Autenticação Obrigatória");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lfunção)
                        .addGap(29, 29, 29)
                        .addComponent(RbAluno)
                        .addGap(28, 28, 28)
                        .addComponent(RbProfessor))
                    .addComponent(lSenha)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bconfirmar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CampoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(CampoSenha)))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lLogin)
                    .addComponent(CampoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSenha)
                    .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lfunção)
                    .addComponent(RbAluno)
                    .addComponent(RbProfessor))
                .addGap(63, 63, 63)
                .addComponent(Bconfirmar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RbProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbProfessorActionPerformed

    private void CampoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoSenhaActionPerformed

    private void RbAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbAlunoActionPerformed

    private void BconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BconfirmarActionPerformed
        if(RbAluno.isSelected()){
            if(CampoLogin.getText().trim().equals("") && CampoSenha.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"Os campos não foram preenchidos");
            }
            else if(CampoLogin.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"Preencha o campo Login antes de confirmar");
            }
            else if(CampoSenha.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"Preencha o campo Senha antes de confirmar");
            }
            else{
                try {
                    Controle.autenticarAluno(CampoLogin.getText(),CampoSenha.getText());
                } 
                catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(RbProfessor.isSelected()){
            if(CampoLogin.getText().trim().equals("") && CampoSenha.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"Os campos não foram preenchidos");
            }
            else if(CampoLogin.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"Preencha o campo Login antes de confirmar");
            }
            else if(CampoSenha.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"Preencha o campo Senha antes de confirmar");
            }
            else{
                try {
                    Controle.autenticarProfessor(CampoLogin.getText(),CampoSenha.getText());
                } 
                catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    
        }
        else{
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi selecionada");
        }
    }//GEN-LAST:event_BconfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bconfirmar;
    private javax.swing.ButtonGroup BgFuncão;
    private javax.swing.JTextField CampoLogin;
    private javax.swing.JTextField CampoSenha;
    private javax.swing.JRadioButton RbAluno;
    private javax.swing.JRadioButton RbProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lLogin;
    private javax.swing.JLabel lSenha;
    private javax.swing.JLabel lfunção;
    // End of variables declaration//GEN-END:variables
}

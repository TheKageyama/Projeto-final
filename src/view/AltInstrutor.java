
package view;


import Controller.InstrutorController;
import model.Instrutor;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class AltInstrutor extends javax.swing.JDialog {

    private Instrutor instrutor;
        
    public AltInstrutor(java.awt.Frame parent, boolean modal, Instrutor instrutor) {
    super(parent, modal);
    this.instrutor = instrutor;  
    initComponents();
    
    if (this.instrutor != null) {
        preencherCampos();  
    }
}


    
    private void preencherCampos() {
        edtNome.setText(instrutor.getNome());
        edtCpf.setText(instrutor.getCpf());
        edtCpf.setEditable(false); // CPF não pode ser alterado
        edtEmail.setText(instrutor.getEmail());
        edtSenha.setText(instrutor.getSenha());
    }

    
    private boolean validarCampos() {
        if (edtNome.getText().isEmpty() || edtEmail.getText().isEmpty() || edtSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return false;
        }
        return true;
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        edtCpf = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        edtSenha = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 255, 255));
        lblTitulo.setText("Alterar Instrutor");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(51, 255, 255));
        lblNome.setText("Nome");

        lblCpf.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCpf.setForeground(new java.awt.Color(51, 255, 255));
        lblCpf.setText("CPF");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(51, 255, 255));
        lblEmail.setText("Email");

        lblSenha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(51, 255, 255));
        lblSenha.setText("Senha");

        btnAlterar.setBackground(new java.awt.Color(102, 102, 102));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(51, 255, 255));
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCpf)
                            .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSenha)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edtSenha, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(87, 87, 87)
                                .addComponent(btnBuscar)))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblTitulo)
                .addGap(63, 63, 63)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnBuscar))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
          if (!validarCampos()) return;
        try {
            instrutor.setNome(edtNome.getText());
            instrutor.setEmail(edtEmail.getText());
            instrutor.setSenha(edtSenha.getText());

            InstrutorController controller = new InstrutorController();
            controller.alterarInstrutor(instrutor); 

            JOptionPane.showMessageDialog(this, "Instrutor alterado com sucesso!");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         if (edtCpf.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Informe o CPF para buscar.");
        return;
     }
            try {
       
        InstrutorController controller = new InstrutorController();
        
        Instrutor instrutorEncontrado = controller.buscarInstrutorPorCpf(edtCpf.getText());

         if (instrutorEncontrado != null) {
            instrutor = instrutorEncontrado; 
            edtNome.setText(instrutor.getNome());
            edtEmail.setText(instrutor.getEmail());
            edtSenha.setText(instrutor.getSenha());
            edtCpf.setEditable(false); // CPF não deve ser alterado
        } else {
            JOptionPane.showMessageDialog(this, "Instrutor não encontrado.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao buscar instrutor: " + e.getMessage());
        e.printStackTrace();
      }   
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            AltInstrutor dialog = new AltInstrutor(new javax.swing.JFrame(), true, null);
            dialog.setLocationRelativeTo(null);  // Para centralizar a janela na tela
            dialog.setVisible(true);    
        }
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}

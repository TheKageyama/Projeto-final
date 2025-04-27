/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import model.CadastroExercicio;
import Controller.CadastroExercicioController;
import javax.swing.JOptionPane;

public class FrExercicios extends javax.swing.JDialog {

    public FrExercicios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblFuncao = new javax.swing.JLabel();
        lblEquipamento = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lblTipodeExercicio = new javax.swing.JLabel();
        edtTipodeExercicio = new javax.swing.JTextField();
        edtfuncao = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        edtEquipamento = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(51, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Exercícios");

        lblFuncao.setBackground(new java.awt.Color(102, 255, 255));
        lblFuncao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFuncao.setForeground(new java.awt.Color(102, 255, 255));
        lblFuncao.setText("Função:");

        lblEquipamento.setBackground(new java.awt.Color(102, 255, 255));
        lblEquipamento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEquipamento.setForeground(new java.awt.Color(102, 255, 255));
        lblEquipamento.setText("Equipamento:");

        btnCadastrar.setBackground(new java.awt.Color(0, 0, 0));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(102, 255, 255));
        btnCadastrar.setText("cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblTipodeExercicio.setBackground(new java.awt.Color(102, 255, 255));
        lblTipodeExercicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTipodeExercicio.setForeground(new java.awt.Color(102, 255, 255));
        lblTipodeExercicio.setText("Tipo de exercício:");

        edtfuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtfuncaoActionPerformed(evt);
            }
        });

        lblNome1.setBackground(new java.awt.Color(51, 255, 255));
        lblNome1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNome1.setForeground(new java.awt.Color(102, 255, 255));
        lblNome1.setText("Nome:");

        btnFechar.setBackground(new java.awt.Color(0, 0, 0));
        btnFechar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(102, 255, 255));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTipodeExercicio)
                        .addGap(18, 18, 18)
                        .addComponent(edtTipodeExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNome1)
                        .addGap(18, 18, 18)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFuncao)
                        .addGap(18, 18, 18)
                        .addComponent(edtfuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCadastrar)
                            .addComponent(lblEquipamento))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(edtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(btnFechar)))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(169, 169, 169)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome1)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncao)
                    .addComponent(edtfuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipodeExercicio)
                    .addComponent(edtTipodeExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipamento)
                    .addComponent(edtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnFechar))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (validarCampos()) {
            cadastrarExercicio();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void edtfuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtfuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtfuncaoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
        FrMenu telaMenu = new FrMenu(null, true);
        telaMenu.setVisible(true);


    }//GEN-LAST:event_btnFecharActionPerformed

    private boolean validarCampos() {

        if (edtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do exercício", "Erro", JOptionPane.ERROR_MESSAGE);
            edtNome.requestFocus();
            return false;
        }

        if (edtfuncao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe a função do exercício", "Erro", JOptionPane.ERROR_MESSAGE);
            edtfuncao.requestFocus();
            return false;
        }

        if (edtTipodeExercicio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o tipo de exercício", "Erro", JOptionPane.ERROR_MESSAGE);
            edtTipodeExercicio.requestFocus();
            return false;
        }

        // se todas as validações passarem
        return true;
    }

    private void cadastrarExercicio() {
        CadastroExercicio exercicio = new CadastroExercicio();
        exercicio.setNome(edtNome.getText());
        exercicio.setFuncao(edtfuncao.getText());
        exercicio.setTipoDeExercicio(edtTipodeExercicio.getText());
        exercicio.setEquipamento(edtEquipamento.getText());

        CadastroExercicioController controller = new CadastroExercicioController();
        if (controller.inserirExercicio(exercicio)) {
            JOptionPane.showMessageDialog(this, "Exercício cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar exercício", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        edtNome.setText("");
        edtfuncao.setText("");
        edtTipodeExercicio.setText("");
        edtEquipamento.setText("");
        edtNome.requestFocus();
    }

    private String identificacaoAtual;

    public FrExercicios(java.awt.Frame parent, boolean modal, String identificacao) {
        super(parent, modal);
        initComponents();
        this.identificacaoAtual = identificacao;
        this.setLocationRelativeTo(null);
        carregarDadosExercicio();

    }

    private void carregarDadosExercicio() {
        if (this.identificacaoAtual != null && !this.identificacaoAtual.isEmpty()) {
            CadastroExercicioController controller = new CadastroExercicioController();
            CadastroExercicio exercicio = controller.buscarPorIdentificacao(this.identificacaoAtual);

            if (exercicio != null) {
                edtNome.setText(exercicio.getNome());
                edtfuncao.setText(exercicio.getFuncao());
                edtTipodeExercicio.setText(exercicio.getTipoDeExercicio());
                edtEquipamento.setText(exercicio.getEquipamento());

            }
        }
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
            java.util.logging.Logger.getLogger(FrExercicios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrExercicios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrExercicios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrExercicios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrExercicios dialog = new FrExercicios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JTextField edtEquipamento;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTipodeExercicio;
    private javax.swing.JTextField edtfuncao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEquipamento;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblTipodeExercicio;
    // End of variables declaration//GEN-END:variables

}

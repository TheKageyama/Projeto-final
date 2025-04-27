package view;

import Controller.TreinoController;
import model.Treino;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import model.ExercicioTreino;

public class FrConsultaTreino extends javax.swing.JDialog {
    private JTextField txtNomeAluno;
    private JButton btnBuscar;
    private JButton btnFechar;
    private JTable tblTreinos;
    private JTextArea txtDetalhesTreino;
    
    private TreinoController treinoController;

    public FrConsultaTreino(java.awt.Frame parent, boolean modal, TreinoController controller) {
        super(parent, modal);
        this.treinoController = controller;
        initComponents();
        setLocationRelativeTo(parent);
    }

    FrConsultaTreino(Object object, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initComponents() {
        setTitle("Consulta de Treinos por Aluno");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de busca
        JPanel panelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBusca.add(new JLabel("Nome do Aluno:"));
        txtNomeAluno = new JTextField(20);
        panelBusca.add(txtNomeAluno);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this::buscarTreinos);
        panelBusca.add(btnBuscar);
        
        panelPrincipal.add(panelBusca, BorderLayout.NORTH);
        
        // Tabela de treinos
        tblTreinos = new JTable();
        tblTreinos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblTreinos.getSelectionModel().addListSelectionListener(e -> mostrarDetalhesTreino());
        
        JScrollPane scrollTreinos = new JScrollPane(tblTreinos);
        panelPrincipal.add(scrollTreinos, BorderLayout.CENTER);
        
        // Detalhes do treino
        txtDetalhesTreino = new JTextArea(10, 50);
        txtDetalhesTreino.setEditable(false);
        txtDetalhesTreino.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panelPrincipal.add(new JScrollPane(txtDetalhesTreino), BorderLayout.SOUTH);
        
        // Painel de botões
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        panelBotoes.add(btnFechar);
        
        panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }

    private void buscarTreinos(ActionEvent evt) {
        String nomeAluno = txtNomeAluno.getText().trim();
        if (!nomeAluno.isEmpty()) {
            List<Treino> treinos = treinoController.consultarTreinosPorAluno(nomeAluno);
            if (treinos != null && !treinos.isEmpty()) {
                atualizarTabelaTreinos(treinos);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum treino encontrado para o aluno.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Informe o nome do aluno para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void atualizarTabelaTreinos(List<Treino> treinos) {
        String[] colunas = {"ID", "Nome do Treino", "Aluno", "Instrutor", "Data Criação"};
        Object[][] dados = new Object[treinos.size()][5];
        
        for (int i = 0; i < treinos.size(); i++) {
            Treino t = treinos.get(i);
            dados[i][0] = t.getId();
            dados[i][1] = t.getNome();
            dados[i][2] = t.getAluno().getNome();
            dados[i][3] = t.getInstrutor().getNome();
            dados[i][4] = t.getDataCriacao();
        }
        
        tblTreinos.setModel(new javax.swing.table.DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    private void mostrarDetalhesTreino() {
        int selectedRow = tblTreinos.getSelectedRow();
        if (selectedRow != -1) {
            int idTreino = (int) tblTreinos.getValueAt(selectedRow, 0);
            Treino treino = treinoController.buscarTreinoPorId(idTreino);
            
            if (treino != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("=== DETALHES DO TREINO ===\n");
                sb.append("Nome: ").append(treino.getNome()).append("\n");
                sb.append("Aluno: ").append(treino.getAluno().getNome()).append("\n");
                sb.append("Instrutor: ").append(treino.getInstrutor().getNome()).append("\n");
                sb.append("Data: ").append(treino.getDataCriacao()).append("\n");
                sb.append("Observações: ").append(treino.getObservacoes()).append("\n\n");
                sb.append("=== EXERCÍCIOS ===\n");
                
                for (ExercicioTreino ex : treino.getExercicios()) {
                    sb.append("\n- ").append(ex.getExercicio().getNome()).append("\n");
                    sb.append("  Séries: ").append(ex.getSeries()).append("\n");
                    sb.append("  Repetições: ").append(ex.getRepeticoes()).append("\n");
                    sb.append("  Carga: ").append(ex.getCarga()).append(" kg\n");
                    sb.append("  Descanso: ").append(ex.getDescanso()).append(" seg\n");
                    if (ex.getObservacoes() != null && !ex.getObservacoes().isEmpty()) {
                        sb.append("  Obs: ").append(ex.getObservacoes()).append("\n");
                    }
                }
                
                txtDetalhesTreino.setText(sb.toString());
            }
        }
    }
}
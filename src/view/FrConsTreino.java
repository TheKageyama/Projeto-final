package view;

import Controller.TreinoController;
import model.Instrutor;
import model.Treino;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import model.ExercicioTreino;

public class FrConsTreino extends javax.swing.JDialog {
    // Componentes da interface
    private JTextField txtPesquisaAluno;
    private JButton btnPesquisar;
    private JButton btnListarInstrutores;
    private JTable tblTreinos;
    private JButton btnDetalhes;
    private JButton btnFechar;
    
    // Controlador
    private TreinoController treinoController;
    private DefaultTableModel tableModel;

    public FrConsTreino(java.awt.Frame parent, boolean modal, TreinoController controller) {
        super(parent, modal);
        this.treinoController = controller;
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        // Configuração básica da janela
        setTitle("Consulta de Treinos");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // Painel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de pesquisa
        JPanel panelPesquisa = new JPanel(new BorderLayout(5, 5));
        
        JPanel panelPesquisaAluno = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPesquisaAluno.add(new JLabel("Pesquisar por aluno:"));
        txtPesquisaAluno = new JTextField(20);
        panelPesquisaAluno.add(txtPesquisaAluno);
        
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(this::pesquisarTreinos);
        panelPesquisaAluno.add(btnPesquisar);
        
        btnListarInstrutores = new JButton("Listar Instrutores");
        btnListarInstrutores.addActionListener(this::listarInstrutores);
        panelPesquisaAluno.add(btnListarInstrutores);
        
        panelPesquisa.add(panelPesquisaAluno, BorderLayout.CENTER);
        panelPrincipal.add(panelPesquisa, BorderLayout.NORTH);
        
        // Tabela de treinos
        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Aluno", "Instrutor", "Data Criação", "Qtd Exercícios"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Torna todas as células não editáveis
            }
        };
        
        tblTreinos = new JTable(tableModel);
        tblTreinos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblTreinos.getTableHeader().setReorderingAllowed(false);
        
        // Configuração da seleção
        tblTreinos.setRowSelectionInterval(0, 0); // Seleciona a primeira linha por padrão
        
        panelPrincipal.add(new JScrollPane(tblTreinos), BorderLayout.CENTER);
        
        // Painel de botões
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        btnDetalhes = new JButton("Ver Detalhes");
        btnDetalhes.addActionListener(this::mostrarDetalhesTreino);
        panelBotoes.add(btnDetalhes);
        
        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        panelBotoes.add(btnFechar);
        
        panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }

    private void pesquisarTreinos(ActionEvent evt) {
        String nomeAluno = txtPesquisaAluno.getText().trim();
        List<Treino> treinos = treinoController.consultarTreinosPorAluno(nomeAluno);
        atualizarTabela(treinos);
    }

    private void listarInstrutores(ActionEvent evt) {
        List<Instrutor> instrutores = treinoController.listarInstrutores();
        exibirListaInstrutores(instrutores);
    }

    private void atualizarTabela(List<Treino> treinos) {
        tableModel.setRowCount(0); // Limpa a tabela
        
        if (treinos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum treino encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Treino treino : treinos) {
                Object[] row = {
                    treino.getId(),
                    treino.getAluno().getNome(),
                    treino.getInstrutor().getNome(),
                    treino.getDataCriacao(),
                    treino.getExercicios().size()
                };
                tableModel.addRow(row);
            }
        }
    }

    private void exibirListaInstrutores(List<Instrutor> instrutores) {
        // Cria modelo para a tabela
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Nome", "Especialidade", "Telefone"}, 0);
        
        for (Instrutor instrutor : instrutores) {
            model.addRow(new Object[]{
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEspecialidade(),
                instrutor.getTelefone()
            });
        }
        
        // Cria e exibe a dialog com a lista
        JDialog dialog = new JDialog(this, "Instrutores Cadastrados", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(this);
        
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(table);
        dialog.add(scrollPane, BorderLayout.CENTER);
        
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.dispose());
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnFechar);
        dialog.add(panelBotoes, BorderLayout.SOUTH);
        
        dialog.setVisible(true);
    }

    private void mostrarDetalhesTreino(ActionEvent evt) {
        int selectedRow = tblTreinos.getSelectedRow();
        if (selectedRow >= 0) {
            int idTreino = (int) tableModel.getValueAt(selectedRow, 0);
            Treino treino = treinoController.buscarTreinoPorId(idTreino);
            
            if (treino != null) {
                exibirDetalhesTreino(treino);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um treino primeiro!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void exibirDetalhesTreino(Treino treino) {
        JDialog dialog = new JDialog(this, "Detalhes do Treino", true);
        dialog.setSize(600, 500);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Informações básicas
        JPanel panelInfo = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInfo.add(new JLabel("Aluno:"));
        panelInfo.add(new JLabel(treino.getAluno().getNome()));
        panelInfo.add(new JLabel("Instrutor:"));
        panelInfo.add(new JLabel(treino.getInstrutor().getNome()));
        panelInfo.add(new JLabel("Data Criação:"));
        panelInfo.add(new JLabel(treino.getDataCriacao().toString()));
        panelInfo.add(new JLabel("Observações:"));
        panelInfo.add(new JLabel(treino.getObservacoes() != null ? treino.getObservacoes() : "Nenhuma"));
        
        panel.add(panelInfo, BorderLayout.NORTH);
        
        // Lista de exercícios
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Exercício", "Séries", "Repetições", "Carga", "Descanso"}, 0);
        
        for (ExercicioTreino ex : treino.getExercicios()) {
            model.addRow(new Object[]{
                ex.getExercicio().getNome(),
                ex.getSeries(),
                ex.getRepeticoes(),
                ex.getCarga() + " kg",
                ex.getDescanso() + " seg"
            });
        }
        
        JTable table = new JTable(model);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.dispose());
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnFechar);
        panel.add(panelBotoes, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }

    public static void main(String args[]) {
        // Exemplo de uso
        java.awt.EventQueue.invokeLater(() -> {
            TreinoController controller = new TreinoController(); // Você precisará instanciar seu controller
            FrConsTreino dialog = new FrConsTreino(new JFrame(), true, controller);
            dialog.setVisible(true);
        });
    }
}
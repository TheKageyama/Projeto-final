package view;

import Controller.TreinoController;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrCadTreino extends javax.swing.JDialog {
    private JTextField txtNomeTreino;
    private JTextArea txtObservacoes;
    private JComboBox<Aluno> cbAlunos;
    private JComboBox<Instrutor> cbInstrutores;
    private JList<CadastroExercicio> lstExerciciosDisponiveis;
    private JList<ExercicioTreino> lstExerciciosSelecionados;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JSpinner spnSeries;
    private JSpinner spnRepeticoes;
    private JSpinner spnCarga;
    private JSpinner spnDescanso;
    
    private TreinoController treinoController;
    private DefaultListModel<ExercicioTreino> modelExerciciosSelecionados;

    public FrCadTreino(java.awt.Frame parent, boolean modal, TreinoController controller) {
        super(parent, modal);
        this.treinoController = controller;
        initComponents();
        carregarDados();
        setLocationRelativeTo(parent);
    }

    FrCadTreino(Object object, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initComponents() {
        setTitle("Cadastro de Treino");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de título
        JLabel lblTitulo = new JLabel("CADASTRO DE TREINO");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
        
        // Painel central com os campos
        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 10, 10));
        
        // Nome do treino
        panelCampos.add(new JLabel("Nome do Treino:"));
        txtNomeTreino = new JTextField();
        panelCampos.add(txtNomeTreino);
        
        // Aluno
        panelCampos.add(new JLabel("Aluno:"));
        cbAlunos = new JComboBox<>();
        panelCampos.add(cbAlunos);
        
        // Instrutor
        panelCampos.add(new JLabel("Instrutor:"));
        cbInstrutores = new JComboBox<>();
        panelCampos.add(cbInstrutores);
        
        // Observações
        panelCampos.add(new JLabel("Observações:"));
        txtObservacoes = new JTextArea(3, 20);
        panelCampos.add(new JScrollPane(txtObservacoes));
        
        panelPrincipal.add(panelCampos, BorderLayout.NORTH);
        
        // Painel de exercícios
        JPanel panelExercicios = new JPanel(new BorderLayout(10, 10));
        
        // Painel superior para exercícios
        JPanel panelSuperiorExercicios = new JPanel(new GridLayout(1, 3, 10, 10));
        
        // Lista de exercícios disponíveis
        JPanel panelDisponiveis = new JPanel(new BorderLayout());
        panelDisponiveis.add(new JLabel("Exercícios Disponíveis:"), BorderLayout.NORTH);
        lstExerciciosDisponiveis = new JList<>();
        panelDisponiveis.add(new JScrollPane(lstExerciciosDisponiveis), BorderLayout.CENTER);
        
        // Painel de configuração do exercício
        JPanel panelConfigExercicio = new JPanel(new GridLayout(5, 2, 5, 5));
        panelConfigExercicio.add(new JLabel("Séries:"));
        spnSeries = new JSpinner(new SpinnerNumberModel(3, 1, 10, 1));
        panelConfigExercicio.add(spnSeries);
        
        panelConfigExercicio.add(new JLabel("Repetições:"));
        spnRepeticoes = new JSpinner(new SpinnerNumberModel(10, 1, 20, 1));
        panelConfigExercicio.add(spnRepeticoes);
        
        panelConfigExercicio.add(new JLabel("Carga (kg):"));
        spnCarga = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 200.0, 0.5));
        panelConfigExercicio.add(spnCarga);
        
        panelConfigExercicio.add(new JLabel("Descanso (seg):"));
        spnDescanso = new JSpinner(new SpinnerNumberModel(60, 0, 300, 5));
        panelConfigExercicio.add(spnDescanso);
        
        JPanel panelBotoesExercicios = new JPanel(new GridLayout(2, 1, 5, 5));
        btnAdicionar = new JButton("Adicionar >");
        btnAdicionar.addActionListener(this::adicionarExercicio);
        panelBotoesExercicios.add(btnAdicionar);
        
        btnRemover = new JButton("< Remover");
        btnRemover.addActionListener(this::removerExercicio);
        panelBotoesExercicios.add(btnRemover);
        
        // Lista de exercícios selecionados
        JPanel panelSelecionados = new JPanel(new BorderLayout());
        panelSelecionados.add(new JLabel("Exercícios do Treino:"), BorderLayout.NORTH);
        modelExerciciosSelecionados = new DefaultListModel<>();
        lstExerciciosSelecionados = new JList<>(modelExerciciosSelecionados);
        panelSelecionados.add(new JScrollPane(lstExerciciosSelecionados), BorderLayout.CENTER);
        
        panelSuperiorExercicios.add(panelDisponiveis);
        panelSuperiorExercicios.add(panelConfigExercicio);
        panelSuperiorExercicios.add(panelSelecionados);
        
        panelExercicios.add(panelSuperiorExercicios, BorderLayout.CENTER);
        panelExercicios.add(panelBotoesExercicios, BorderLayout.EAST);
        
        panelPrincipal.add(panelExercicios, BorderLayout.CENTER);
        
        // Painel de botões inferiores
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(this::salvarTreino);
        panelBotoes.add(btnSalvar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panelBotoes.add(btnCancelar);
        
        panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }

    private void carregarDados() {
        // Carregar alunos
        List<Aluno> alunos = treinoController.listarAlunos();
        alunos.forEach(a -> cbAlunos.addItem(a));
        
        // Carregar instrutores
        List<Instrutor> instrutores = treinoController.listarInstrutores();
        instrutores.forEach(i -> cbInstrutores.addItem(i));
        
        // Carregar exercícios
        List<CadastroExercicio> exercicios = treinoController.listarExercicios();
        DefaultListModel<CadastroExercicio> model = new DefaultListModel<>();
        exercicios.forEach(model::addElement);
        lstExerciciosDisponiveis.setModel(model);
    }

    private void adicionarExercicio(ActionEvent evt) {
        CadastroExercicio exercicioSelecionado = lstExerciciosDisponiveis.getSelectedValue();
        if (exercicioSelecionado != null) {
            ExercicioTreino exercicioTreino = new ExercicioTreino();
            exercicioTreino.setExercicio(exercicioSelecionado);
            exercicioTreino.setSeries((int) spnSeries.getValue());
            exercicioTreino.setRepeticoes((int) spnRepeticoes.getValue());
            exercicioTreino.setCarga((double) spnCarga.getValue());
            exercicioTreino.setDescanso((int) spnDescanso.getValue());
            
            modelExerciciosSelecionados.addElement(exercicioTreino);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um exercício para adicionar", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void removerExercicio(ActionEvent evt) {
        int selectedIndex = lstExerciciosSelecionados.getSelectedIndex();
        if (selectedIndex != -1) {
            modelExerciciosSelecionados.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um exercício para remover", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void salvarTreino(ActionEvent evt) {
        if (validarCampos()) {
            Treino novoTreino = new Treino();
            novoTreino.setNome(txtNomeTreino.getText());
            novoTreino.setAluno((Aluno) cbAlunos.getSelectedItem());
            novoTreino.setInstrutor((Instrutor) cbInstrutores.getSelectedItem());
            novoTreino.setObservacoes(txtObservacoes.getText());
            novoTreino.setDataCriacao(new Date());
            
            List<ExercicioTreino> exercicios = new ArrayList<>();
            for (int i = 0; i < modelExerciciosSelecionados.size(); i++) {
                exercicios.add(modelExerciciosSelecionados.getElementAt(i));
            }
            novoTreino.setExercicios(exercicios);
            
            if (treinoController.cadastrarTreino(novoTreino)) {
                JOptionPane.showMessageDialog(this, "Treino cadastrado com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar treino!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validarCampos() {
        if (txtNomeTreino.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do treino!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (cbAlunos.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (cbInstrutores.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um instrutor!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (modelExerciciosSelecionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Adicione pelo menos um exercício ao treino!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
}
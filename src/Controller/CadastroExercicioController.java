package Controller;

import model.CadastroExercicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroExercicioController {
    private Connection conexao;

    public CadastroExercicioController() {
        this.conexao = Conexao.getConexao();
    }

    public boolean cadastrarExercicio(CadastroExercicio exercicio) {
        String sql = "INSERT INTO exercicios (nome, funcao, tipo_exercicio, equipamento, identificacao, grupo_muscular, descricao) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getFuncao());
            stmt.setString(3, exercicio.getTipoDeExercicio());
            stmt.setString(4, exercicio.getEquipamento());
            stmt.setString(5, exercicio.getIdentificacao());
            stmt.setString(6, exercicio.getGrupoMuscular());
            stmt.setString(7, exercicio.getDescricao());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar exercício: " + e.getMessage());
            return false;
        }
    }

    public List<CadastroExercicio> listarTodosExercicios() {
        List<CadastroExercicio> exercicios = new ArrayList<>();
        String sql = "SELECT * FROM exercicios ORDER BY nome";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                CadastroExercicio ex = new CadastroExercicio();
                ex.setId(rs.getInt("id"));
                ex.setNome(rs.getString("nome"));
                ex.setFuncao(rs.getString("funcao"));
                ex.setTipoDeExercicio(rs.getString("tipo_exercicio"));
                ex.setEquipamento(rs.getString("equipamento"));
                ex.setIdentificacao(rs.getString("identificacao"));
                ex.setGrupoMuscular(rs.getString("grupo_muscular"));
                ex.setDescricao(rs.getString("descricao"));
                exercicios.add(ex);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar exercícios: " + e.getMessage());
        }
        return exercicios;
    }

    public List<CadastroExercicio> listarExerciciosPorGrupoMuscular(String grupoMuscular) {
        List<CadastroExercicio> exercicios = new ArrayList<>();
        String sql = "SELECT * FROM exercicios WHERE grupo_muscular = ? ORDER BY nome";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, grupoMuscular);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                CadastroExercicio ex = new CadastroExercicio();
                ex.setId(rs.getInt("id"));
                ex.setNome(rs.getString("nome"));
                ex.setGrupoMuscular(rs.getString("grupo_muscular"));
                exercicios.add(ex);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar exercícios por grupo: " + e.getMessage());
        }
        return exercicios;
    }

    public CadastroExercicio buscarPorIdentificacao(String identificacaoAtual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean inserirExercicio(CadastroExercicio exercicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CadastroExercicio buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean alterarExercicio(CadastroExercicio exercicioAtual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<CadastroExercicio> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deletarExercicio(int idExercicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
package Controller;

import model.CadastroAluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroAlunoController {
    private Connection conexao;

    public CadastroAlunoController() {
        this.conexao = Conexao.getConexao();
    }

    public boolean cadastrarAluno(CadastroAluno aluno) {
        String sql = "INSERT INTO alunos (nome, cpf, email, senha, telefone, data_nascimento) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getSenha());
            stmt.setString(5, aluno.getTelefone());
            stmt.setDate(6, new java.sql.Date(aluno.getDataNascimento().getTime()));
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno: " + e.getMessage());
            return false;
        }
    }

    public List<CadastroAluno> listarTodosAlunos() {
        List<CadastroAluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos ORDER BY nome";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                CadastroAluno aluno = new CadastroAluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setDataNascimento(rs.getDate("data_nascimento"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar alunos: " + e.getMessage());
        }
        return alunos;
    }

    public CadastroAluno buscarAlunoPorId(int id) {
        String sql = "SELECT * FROM alunos WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                CadastroAluno aluno = new CadastroAluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setDataNascimento(rs.getDate("data_nascimento"));
                return aluno;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar aluno: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizarAluno(CadastroAluno aluno) {
        String sql = "UPDATE alunos SET nome=?, cpf=?, email=?, telefone=?, data_nascimento=? WHERE id=?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getTelefone());
            stmt.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
            stmt.setInt(6, aluno.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno: " + e.getMessage());
            return false;
        }
    }

    public boolean deletarAluno(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar aluno: " + e.getMessage());
            return false;
        }
    }

    public CadastroAluno buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM alunos WHERE cpf = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                CadastroAluno aluno = new CadastroAluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setDataNascimento(rs.getDate("data_nascimento"));
                return aluno;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar aluno por CPF: " + e.getMessage());
        }
        return null;
    }

    public boolean alterarPorCpf(CadastroAluno alunoAtual) {
        String sql = "UPDATE alunos SET nome=?, email=?, telefone=?, data_nascimento=? WHERE cpf=?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, alunoAtual.getNome());
            stmt.setString(2, alunoAtual.getEmail());
            stmt.setString(3, alunoAtual.getTelefone());
            stmt.setDate(4, new java.sql.Date(alunoAtual.getDataNascimento().getTime()));
            stmt.setString(5, alunoAtual.getCpf());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno: " + e.getMessage());
            return false;
        }
    }
}
package Controller;

import model.Instrutor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InstrutorController {
    private Connection conexao;

    public InstrutorController() {
        this.conexao = Conexao.getConexao();
    }

    public boolean cadastrarInstrutor(Instrutor instrutor) {
        String sql = "INSERT INTO instrutores (nome, cpf, email, senha, telefone, especialidade) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCpf());
            stmt.setString(3, instrutor.getEmail());
            stmt.setString(4, instrutor.getSenha());
            stmt.setString(5, instrutor.getTelefone());
            stmt.setString(6, instrutor.getEspecialidade());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar instrutor: " + e.getMessage());
            return false;
        }
    }

    public List<Instrutor> listarTodosInstrutores() {
        List<Instrutor> instrutores = new ArrayList<>();
        String sql = "SELECT * FROM instrutores";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Instrutor i = new Instrutor();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setCpf(rs.getString("cpf"));
                i.setEmail(rs.getString("email"));
                i.setTelefone(rs.getString("telefone"));
                i.setEspecialidade(rs.getString("especialidade"));
                instrutores.add(i);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar instrutores: " + e.getMessage());
        }
        return instrutores;
    }

    public Instrutor buscarInstrutorPorId(int id) {
        String sql = "SELECT * FROM instrutores WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Instrutor i = new Instrutor();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setCpf(rs.getString("cpf"));
                i.setEmail(rs.getString("email"));
                i.setTelefone(rs.getString("telefone"));
                i.setEspecialidade(rs.getString("especialidade"));
                return i;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar instrutor: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizarInstrutor(Instrutor instrutor) {
        String sql = "UPDATE instrutores SET nome=?, cpf=?, email=?, telefone=?, especialidade=? WHERE id=?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCpf());
            stmt.setString(3, instrutor.getEmail());
            stmt.setString(4, instrutor.getTelefone());
            stmt.setString(5, instrutor.getEspecialidade());
            stmt.setInt(6, instrutor.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar instrutor: " + e.getMessage());
            return false;
        }
    }

    public boolean deletarInstrutor(int id) {
        String sql = "DELETE FROM instrutores WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar instrutor: " + e.getMessage());
            return false;
        }
    }

    public Instrutor fazerLogin(String email, String senha) {
        String sql = "SELECT * FROM instrutores WHERE email = ? AND senha = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Instrutor i = new Instrutor();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setEmail(rs.getString("email"));
                return i;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + e.getMessage());
        }
        return null;
    }

    public void alterarInstrutor(Instrutor instrutor) {
        String sql = "UPDATE instrutores SET nome=?, email=?, telefone=?, especialidade=? WHERE cpf=?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getEmail());
            stmt.setString(3, instrutor.getTelefone());
            stmt.setString(4, instrutor.getEspecialidade());
            stmt.setString(5, instrutor.getCpf());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar instrutor: " + e.getMessage());
        }
    }

    public Instrutor buscarInstrutorPorCpf(String cpf) {
        String sql = "SELECT * FROM instrutores WHERE cpf = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Instrutor i = new Instrutor();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setCpf(rs.getString("cpf"));
                i.setEmail(rs.getString("email"));
                i.setTelefone(rs.getString("telefone"));
                i.setEspecialidade(rs.getString("especialidade"));
                return i;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar instrutor por CPF: " + e.getMessage());
        }
        return null;
    }
}
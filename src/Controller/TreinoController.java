package Controller;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TreinoController {
    private Connection conexao;

    public TreinoController() {
        this.conexao = Conexao.getConexao();
    }

   
    public boolean cadastrarTreino(Treino treino) {
        String sqlTreino = "INSERT INTO treinos (nome, id_aluno, id_instrutor, data_criacao, observacoes) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmtTreino = conexao.prepareStatement(sqlTreino, Statement.RETURN_GENERATED_KEYS)) {
            stmtTreino.setString(1, treino.getNome());
            stmtTreino.setInt(2, treino.getAluno().getId());
            stmtTreino.setInt(3, treino.getInstrutor().getId());
            stmtTreino.setDate(4, new java.sql.Date(treino.getDataCriacao().getTime()));
            stmtTreino.setString(5, treino.getObservacoes());
            
            int affectedRows = stmtTreino.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmtTreino.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idTreino = generatedKeys.getInt(1);
                        return cadastrarExerciciosTreino(idTreino, treino.getExercicios());
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar treino: " + e.getMessage());
            return false;
        }
        return false;
    }

   
    private boolean cadastrarExerciciosTreino(int idTreino, List<ExercicioTreino> exercicios) {
        String sqlExercicio = "INSERT INTO exercicios_treino (id_treino, id_exercicio, series, repeticoes, carga, descanso, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmtExercicio = conexao.prepareStatement(sqlExercicio)) {
            for (ExercicioTreino ex : exercicios) {
                stmtExercicio.setInt(1, idTreino);
                stmtExercicio.setInt(2, ex.getExercicio().getId());
                stmtExercicio.setInt(3, ex.getSeries());
                stmtExercicio.setInt(4, ex.getRepeticoes());
                stmtExercicio.setDouble(5, ex.getCarga());
                stmtExercicio.setInt(6, ex.getDescanso());
                stmtExercicio.setString(7, ex.getObservacoes());
                stmtExercicio.addBatch();
            }
            stmtExercicio.executeBatch();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar exercícios do treino: " + e.getMessage());
            return false;
        }
    }

   
    public List<Treino> consultarTreinosPorAluno(String nomeAluno) {
        List<Treino> treinos = new ArrayList<>();
        String sql = "SELECT t.*, a.nome as nome_aluno, i.nome as nome_instrutor " +
                     "FROM treinos t " +
                     "JOIN alunos a ON t.id_aluno = a.id " +
                     "JOIN instrutores i ON t.id_instrutor = i.id " +
                     "WHERE a.nome LIKE ? ORDER BY t.data_criacao DESC";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeAluno + "%");
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Treino treino = mapearTreino(rs);
                treinos.add(treino);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar treinos: " + e.getMessage());
        }
        return treinos;
    }

    public Treino buscarTreinoPorId(int idTreino) {
        String sql = "SELECT t.*, a.nome as nome_aluno, i.nome as nome_instrutor " +
                     "FROM treinos t " +
                     "JOIN alunos a ON t.id_aluno = a.id " +
                     "JOIN instrutores i ON t.id_instrutor = i.id " +
                     "WHERE t.id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idTreino);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapearTreino(rs);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar treino: " + e.getMessage());
        }
        return null;
    }

  
    private Treino mapearTreino(ResultSet rs) throws SQLException {
        Treino treino = new Treino();
        treino.setId(rs.getInt("id"));
        treino.setNome(rs.getString("nome"));
        
        Aluno aluno = new Aluno();
        aluno.setId(rs.getInt("id_aluno"));
        aluno.setNome(rs.getString("nome_aluno"));
        treino.setAluno(aluno);
        
        Instrutor instrutor = new Instrutor();
        instrutor.setId(rs.getInt("id_instrutor"));
        instrutor.setNome(rs.getString("nome_instrutor"));
        treino.setInstrutor(instrutor);
        
        treino.setDataCriacao(rs.getDate("data_criacao"));
        treino.setObservacoes(rs.getString("observacoes"));
        
        treino.setExercicios(listarExerciciosDoTreino(treino.getId()));
        
        return treino;
    }

    
    public List<ExercicioTreino> listarExerciciosDoTreino(int idTreino) {
        List<ExercicioTreino> exercicios = new ArrayList<>();
        String sql = "SELECT et.*, e.nome, e.descricao, e.grupo_muscular " +
                     "FROM exercicios_treino et " +
                     "JOIN exercicios e ON et.id_exercicio = e.id " +
                     "WHERE et.id_treino = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idTreino);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ExercicioTreino exercicioTreino = new ExercicioTreino();
                exercicioTreino.setId(rs.getInt("id"));
                
                CadastroExercicio exercicio = new CadastroExercicio();
                exercicio.setId(rs.getInt("id_exercicio"));
                exercicio.setNome(rs.getString("nome"));
                exercicio.setDescricao(rs.getString("descricao"));
                exercicio.setGrupoMuscular(rs.getString("grupo_muscular"));
                exercicioTreino.setExercicio(exercicio);
                
                exercicioTreino.setSeries(rs.getInt("series"));
                exercicioTreino.setRepeticoes(rs.getInt("repeticoes"));
                exercicioTreino.setCarga(rs.getDouble("carga"));
                exercicioTreino.setDescanso(rs.getInt("descanso"));
                exercicioTreino.setObservacoes(rs.getString("observacoes"));
                
                exercicios.add(exercicioTreino);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar exercícios do treino: " + e.getMessage());
        }
        return exercicios;
    }

   
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT id, nome, cpf, email, telefone, data_nascimento FROM alunos ORDER BY nome";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Aluno aluno = new Aluno();
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

  
    public List<Instrutor> listarInstrutores() {
        List<Instrutor> instrutores = new ArrayList<>();
        String sql = "SELECT id, nome, cpf, email, telefone, especialidade FROM instrutores ORDER BY nome";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Instrutor instrutor = new Instrutor();
                instrutor.setId(rs.getInt("id"));
                instrutor.setNome(rs.getString("nome"));
                instrutor.setCpf(rs.getString("cpf"));
                instrutor.setEmail(rs.getString("email"));
                instrutor.setTelefone(rs.getString("telefone"));
                instrutor.setEspecialidade(rs.getString("especialidade"));
                instrutores.add(instrutor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar instrutores: " + e.getMessage());
        }
        return instrutores;
    }

   
    public List<CadastroExercicio> listarExercicios() {
        List<CadastroExercicio> exercicios = new ArrayList<>();
        String sql = "SELECT id, nome, funcao, tipo_exercicio, equipamento, identificacao, grupo_muscular, descricao FROM exercicios ORDER BY nome";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                CadastroExercicio exercicio = new CadastroExercicio();
                exercicio.setId(rs.getInt("id"));
                exercicio.setNome(rs.getString("nome"));
                exercicio.setFuncao(rs.getString("funcao"));
                exercicio.setTipoDeExercicio(rs.getString("tipo_exercicio"));
                exercicio.setEquipamento(rs.getString("equipamento"));
                exercicio.setIdentificacao(rs.getString("identificacao"));
                exercicio.setGrupoMuscular(rs.getString("grupo_muscular"));
                exercicio.setDescricao(rs.getString("descricao"));
                exercicios.add(exercicio);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar exercícios: " + e.getMessage());
        }
        return exercicios;
    }

   
    public List<CadastroExercicio> listarExerciciosPorGrupoMuscular(String grupoMuscular) {
        List<CadastroExercicio> exercicios = new ArrayList<>();
        String sql = "SELECT id, nome, grupo_muscular, descricao FROM exercicios WHERE grupo_muscular = ? ORDER BY nome";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, grupoMuscular);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                CadastroExercicio exercicio = new CadastroExercicio();
                exercicio.setId(rs.getInt("id"));
                exercicio.setNome(rs.getString("nome"));
                exercicio.setGrupoMuscular(rs.getString("grupo_muscular"));
                exercicio.setDescricao(rs.getString("descricao"));
                exercicios.add(exercicio);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar exercícios por grupo muscular: " + e.getMessage());
        }
        return exercicios;
    }

 
    public boolean atualizarTreino(Treino treino) {
        String sql = "UPDATE treinos SET nome = ?, id_aluno = ?, id_instrutor = ?, observacoes = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, treino.getNome());
            stmt.setInt(2, treino.getAluno().getId());
            stmt.setInt(3, treino.getInstrutor().getId());
            stmt.setString(4, treino.getObservacoes());
            stmt.setInt(5, treino.getId());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
               
                String sqlRemoverExercicios = "DELETE FROM exercicios_treino WHERE id_treino = ?";
                try (PreparedStatement stmtRemover = conexao.prepareStatement(sqlRemoverExercicios)) {
                    stmtRemover.setInt(1, treino.getId());
                    stmtRemover.executeUpdate();
                }
                
             
                return cadastrarExerciciosTreino(treino.getId(), treino.getExercicios());
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar treino: " + e.getMessage());
            return false;
        }
    }

    
    public boolean excluirTreino(int idTreino) {
        String sql = "DELETE FROM treinos WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idTreino);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir treino: " + e.getMessage());
            return false;
        }
    }
}
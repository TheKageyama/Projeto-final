package model;

import java.util.Date;
import java.util.List;

public class Treino {
    private int id;
    private String nome;
    private Aluno aluno;
    private Instrutor instrutor;
    private Date dataCriacao;
    private String observacoes;
    private List<ExercicioTreino> exercicios;

    public Treino() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
    
    public Instrutor getInstrutor() { return instrutor; }
    public void setInstrutor(Instrutor instrutor) { this.instrutor = instrutor; }
    
    public Date getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }
    
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    
    public List<ExercicioTreino> getExercicios() { return exercicios; }
    public void setExercicios(List<ExercicioTreino> exercicios) { this.exercicios = exercicios; }

    @Override
    public String toString() {
        return nome + " - " + aluno.getNome() + " (" + dataCriacao + ")";
    }
}
package model;

public class CadastroExercicio {
    private int id;
    private String nome;
    private String funcao;
    private String tipoDeExercicio;
    private String equipamento;
    private String identificacao;
    private String grupoMuscular;
    private String descricao;

    public CadastroExercicio() {}

    public CadastroExercicio(int id, String nome, String funcao, String tipoDeExercicio,
                           String equipamento, String identificacao, String grupoMuscular, String descricao) {
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
        this.tipoDeExercicio = tipoDeExercicio;
        this.equipamento = equipamento;
        this.identificacao = identificacao;
        this.grupoMuscular = grupoMuscular;
        this.descricao = descricao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }
    
    public String getTipoDeExercicio() { return tipoDeExercicio; }
    public void setTipoDeExercicio(String tipoDeExercicio) { this.tipoDeExercicio = tipoDeExercicio; }
    
    public String getEquipamento() { return equipamento; }
    public void setEquipamento(String equipamento) { this.equipamento = equipamento; }
    
    public String getIdentificacao() { return identificacao; }
    public void setIdentificacao(String identificacao) { this.identificacao = identificacao; }
    
    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return nome;
    }
}
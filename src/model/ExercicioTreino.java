package model;

public class ExercicioTreino {
    private int id;
    private CadastroExercicio exercicio;
    private int series;
    private int repeticoes;
    private double carga;
    private int descanso; // em segundos
    private String observacoes;

    public ExercicioTreino() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public CadastroExercicio getExercicio() { return exercicio; }
    public void setExercicio(CadastroExercicio exercicio) { this.exercicio = exercicio; }
    
    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }
    
    public int getRepeticoes() { return repeticoes; }
    public void setRepeticoes(int repeticoes) { this.repeticoes = repeticoes; }
    
    public double getCarga() { return carga; }
    public void setCarga(double carga) { this.carga = carga; }
    
    public int getDescanso() { return descanso; }
    public void setDescanso(int descanso) { this.descanso = descanso; }
    
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    @Override
    public String toString() {
        return exercicio.getNome() + " - " + series + "x" + repeticoes + " - " + carga + "kg";
    }
}
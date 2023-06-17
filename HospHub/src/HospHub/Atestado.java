package HospHub;
import java.time.LocalDate;

public class Atestado {
    private Medique medique;
    private int diasAusencia;
    private LocalDate dataAtendimento;

    public Atestado(Medique medique, int diasAusencia, LocalDate dataAtendimento){
        this.medique = medique;
        this.diasAusencia = diasAusencia;
        this.dataAtendimento = dataAtendimento;
    }

    public Medique getMedique() {
        return medique;
    }
    public void setMedique(Medique medique) {
        this.medique = medique;
    }
    public int getDiasAusencia() {
        return diasAusencia;
    }
    public void setDiasAusencia(int diasAusencia) {
        this.diasAusencia = diasAusencia;
    }
    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }
    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String toString(){
        return "e medique " + medique + " concede " + diasAusencia + " dias de ausencia a partir de " + dataAtendimento;
    }
    
}

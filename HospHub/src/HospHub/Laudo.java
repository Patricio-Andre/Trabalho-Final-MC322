package HospHub;
import java.time.LocalDate;

public class Laudo {
    private Medique medique;
    private String doenca;
    private LocalDate dataAtendimento;

    public Laudo(Medique medique, String doenca, LocalDate dataAtendimento){
        this.medique = medique;
        this.doenca = doenca;
        this.dataAtendimento = dataAtendimento;
    }

    public Medique getMedique() {
        return medique;
    }
    public void setMedique(Medique medique) {
        this.medique = medique;
    }
    public String getDoenca() {
        return doenca;
    }
    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }
    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }
    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String toString(){
        return " e medique " + medique + " atesta que e paciente possui a doenca " + doenca + " conforme o atendimento da data " +dataAtendimento;
    }

}

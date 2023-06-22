package HospHub;
import java.time.LocalDate;

public class Exame {
    private String nome;
    private double custo;
    private LocalDate data;



    public Exame(String nome, double custo, LocalDate data){
        this.nome = nome;
        this.custo = custo;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getCusto() {
        return custo;
    }


    public void setCusto(double custo) {
        this.custo = custo;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }

    public String toString(){
        return "o exame " + nome + "custa " + custo + " e foi realizado em " + data;
    }

    
}
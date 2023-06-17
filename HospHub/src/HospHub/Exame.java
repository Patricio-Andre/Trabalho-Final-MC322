package HospHub;
import java.time.LocalDateTime;

public class Exame {
    private String nome;
    private double custo;
    private LocalDateTime data;



    public Exame(String nome, double custo, LocalDateTime data){
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


    public LocalDateTime getData() {
        return data;
    }


    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String toString(){
        return "o exame " + nome + "custa " + custo + " e foi realizado em " + data;
    }

    
}


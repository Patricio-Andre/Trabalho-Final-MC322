package hospitaleservicos;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exame {
    private String nome;
    private double custo;
    private LocalDate data;
    private static int numeroArquivo = 0;
    private Paciente paciente;


    public Exame(String nome, double custo, LocalDate data, Paciente paciente){
        this.nome = nome;
        this.custo = custo;
        this.data = data;
        this.paciente = paciente;
        this.paciente.getListaDeExames().add(this);
        salvarArquivo();
        defineNumeroArquivo();
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
    
    public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void defineNumeroArquivo() {
    	// Garante que todo arquivo terá um nome diferente;
    	boolean achou = false;
    	for (int i = 0; i < numeroArquivo; i++) {
    		String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "exames";
            String caminhoArquivo = diretorioPrincipal + File.separator + "exame_" + nome + "_" + paciente.getNome() + "_" + i + ".txt";
            File diretorio = new File(diretorioPrincipal);
            
            // Verifica se o diretório existe e é um diretório válido
            if (diretorio.exists() && diretorio.isDirectory()) {
                // Cria um objeto File para o arquivo
                File file = new File(diretorio, caminhoArquivo);
                
                // Verifica se o arquivo existe
                if (!file.exists()) {
                    achou = true;
                    numeroArquivo = i;
                }
            }
    	}
        if (!achou) {
        	numeroArquivo++;
        }
    }
    public void salvarArquivo() {
    	String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "exames";
        String caminhoArquivo = diretorioPrincipal + File.separator + "exame_" + nome + "_" + paciente.getNome() + "_" + numeroArquivo + ".txt";
        BufferedWriter writer = null;
        try {
        	// Cria o diretório de exames caso não exista
            File diretorio = new File(diretorioPrincipal);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            // Cria o arquivo no diretório relativo ao programa
            writer = new BufferedWriter(new FileWriter(caminhoArquivo));
            writer.write("Requerimento de exame");
            writer.newLine();
            writer.write("Nome do exame: " + nome);
            writer.newLine();
            writer.write("Data do Exame: " + data);
            writer.newLine();
            writer.write("Custo: " + custo);
            for (int i = 0; i < 8; i++) {
            	writer.newLine();
            }
            writer.write("Assinatura do profissional responsável: _________________________________________________________");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "o exame " + nome + "custa " + custo + " e foi realizado em " + data;
    }

    
}
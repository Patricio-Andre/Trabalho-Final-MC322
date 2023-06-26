package hospitaleservicos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Atestado {
    private Medique medique;
    private int diasAusencia;
    private LocalDate dataAtendimento;
    private static int numeroArquivo;
    private Paciente paciente;

    public Atestado(Medique medique, int diasAusencia, LocalDate dataAtendimento, Paciente paciente) {
		super();
		this.medique = medique;
		this.diasAusencia = diasAusencia;
		this.dataAtendimento = dataAtendimento;
		this.paciente = paciente;
		salvarArquivo();
        defineNumeroArquivo();
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
    
    public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String toString(){
        return "e medique " + medique + " concede " + diasAusencia + " dias de ausencia a partir de " + dataAtendimento;
    }
    
    
    
    public void defineNumeroArquivo() {
    	// Garante que todo arquivo terá um nome diferente;
    	boolean achou = false;
    	for (int i = 0; i < numeroArquivo; i++) {
    		String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "atestados";
            String caminhoArquivo = diretorioPrincipal + File.separator + "Atestados_" + paciente.getCPF() + "_" + numeroArquivo + ".txt";
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
    	String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "atestados";
        String caminhoArquivo = diretorioPrincipal + File.separator + "Atestados_" + paciente.getCPF() + "_" + numeroArquivo + ".txt";
        BufferedWriter writer = null;
        try {
        	// Cria o diretório de exames caso não exista
            File diretorio = new File(diretorioPrincipal);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            // Cria o arquivo no diretório relativo ao programa
            writer = new BufferedWriter(new FileWriter(caminhoArquivo));
            writer.write("Atestado médico");
            writer.newLine();
            writer.write("Paciente: " + paciente.getNome());
            writer.newLine();
            writer.write("Dias ausência" + diasAusencia);
            writer.newLine();
            writer.write("Data do atendimento: " + dataAtendimento);
            writer.newLine();
            for (int i = 0; i < 8; i++) {
            	writer.newLine();
            }
            writer.write("Assinatura do profissional de saúde responsável: _________________________________________________________");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
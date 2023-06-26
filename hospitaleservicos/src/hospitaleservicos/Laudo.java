package hospitaleservicos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Laudo {
    private Medique medique;
    private String doenca;
    private LocalDate dataAtendimento;
    private Paciente paciente;
    private static int numeroArquivo = 0;

    public Laudo(Medique medique, String doenca, LocalDate dataAtendimento, Paciente paciente) {
		super();
		this.medique = medique;
		this.doenca = doenca;
		this.dataAtendimento = dataAtendimento;
		this.paciente = paciente;
		this.paciente.getListaDeLaudos().add(this);
		salvarArquivo();
        defineNumeroArquivo();
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
    		String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "laudos";
    		String caminhoArquivo = diretorioPrincipal + File.separator + "Laudo_" + paciente.getCPF() + "_" + numeroArquivo + ".txt";
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
    	String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "laudos";
        String caminhoArquivo = diretorioPrincipal + File.separator + "Laudo_" + paciente.getCPF() + "_" + numeroArquivo + ".txt";
        BufferedWriter writer = null;
        try {
        	// Cria o diretório de exames caso não exista
            File diretorio = new File(diretorioPrincipal);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            // Cria o arquivo no diretório relativo ao programa
            writer = new BufferedWriter(new FileWriter(caminhoArquivo));
            writer.write("Laudo médico");
            writer.newLine();
            writer.write("Nome do paciente: " + paciente.getNome());
            writer.newLine();
            writer.write("CPF: " + paciente.getCPF());
            writer.newLine();
            writer.write("Data do Laudo: " + dataAtendimento);
            writer.newLine();
            writer.write("Doença: " + doenca);
            for (int i = 0; i < 8; i++) {
            	writer.newLine();
            }
            writer.write("Assinatura do profissional de saúde responsável: _________________________________________________________");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String toString(){
        return " e medique " + medique + " atesta que e paciente possui a doenca " + doenca + " conforme o atendimento da data " + dataAtendimento;
    }
}

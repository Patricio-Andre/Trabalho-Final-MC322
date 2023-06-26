package hospitaleservicos;
import java.util.LinkedList;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;

public class Receita {
    private String remedio; // nome do composto quimico -> vai ser unico pq a anvisa garante isso
    private String dosagem; // tem que ser String pq tem unidade
    private ProfissionalSaude profissionalSaude;
    private LinkedList <String> listaInterferencias;
    private LocalDate dataVencimento; // so vale pra antibiotico
    private Paciente paciente;
    private static int numeroArquivo = 0;

	public Receita(String remedio, String dosagem, ProfissionalSaude profissionalSaude, Paciente paciente){
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.profissionalSaude = profissionalSaude;
        listaInterferencias = new LinkedList<String>();
        dataVencimento = null;
        this.paciente = paciente;
        salvarArquivo();
        defineNumeroArquivo();
    }

    public Receita(String remedio, String dosagem, ProfissionalSaude profissionalSaude, LocalDate dataVencimento, Paciente paciente){
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.profissionalSaude = profissionalSaude;
        listaInterferencias = new LinkedList<String>();
        this.dataVencimento = dataVencimento;
        this.paciente = paciente;
        salvarArquivo();
        defineNumeroArquivo();
    }


    public String getRemedio() {
        return remedio;
    }
    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }
    public String getDosagem() {
        return dosagem;
    }
    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }
    public ProfissionalSaude getProfissionalSaude() {
        return profissionalSaude;
    }
    public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
    }
    public LinkedList<String> getListaInterferencias() {
        return listaInterferencias;
    }
    public void setListaInterferencias(LinkedList<String> listaInterferencias) {
        this.listaInterferencias = listaInterferencias;
    }
    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean addInterferencia(String interferencia){
        if(listaInterferencias.contains(interferencia)){
            System.out.println("interferencia ja cadastrada");
            return false;
        }
        listaInterferencias.add(interferencia);
        System.out.println("interferencia cadastrada com sucesso");
        return true;

    }

    public boolean removeInterferencia(String inter){
        if(!listaInterferencias.contains(inter)){
            System.out.println("interferencia nao cadastrada"); // poderia dar exception mas ja tem 3
            return true;
        }
        listaInterferencias.remove(inter);
        System.out.println("interferencia removida com sucesso");
        return true;
    
    }

    public String listarInterferencias(){
        StringBuilder sb = new StringBuilder();
        for(String value : listaInterferencias){
            sb.append(value);
        }
       return sb.toString().equals("") ? "nao ha interferencias" : sb.toString();
    }
    
    public void defineNumeroArquivo() {
    	// Garante que todo arquivo terá um nome diferente;
    	boolean achou = false;
    	for (int i = 0; i < numeroArquivo; i++) {
    		String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "receitas";
            String caminhoArquivo = diretorioPrincipal + File.separator + "Receita_" + paciente.getCPF() + "_" + numeroArquivo + ".txt";
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
    	String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "receitas";
        String caminhoArquivo = diretorioPrincipal + File.separator + "Receita_" + paciente.getCPF() + "_" + numeroArquivo + ".txt";
        BufferedWriter writer = null;
        try {
        	// Cria o diretório de exames caso não exista
            File diretorio = new File(diretorioPrincipal);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            // Cria o arquivo no diretório relativo ao programa
            writer = new BufferedWriter(new FileWriter(caminhoArquivo));
            writer.write("Receita médica");
            writer.newLine();
            writer.write("Remédio: " + remedio);
            writer.newLine();
            writer.write("Dosagem: " + dosagem);
            writer.newLine();
            if (dataVencimento != null) {
            	writer.write("Data de vencimento" + dataVencimento);
                writer.newLine();
            }
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
        try{
        return " o remedio " + remedio + " de dose " + dosagem + " receitado por " + profissionalSaude + " interfere com " + listarInterferencias() + " essa receita eh valida" +
        " ateh " + dataVencimento;
        }
        catch (NullPointerException e){
            return " o remedio " + remedio + " de dose " + dosagem + " receitado por " + profissionalSaude + " interfere com " + listarInterferencias();
        }
    }
}

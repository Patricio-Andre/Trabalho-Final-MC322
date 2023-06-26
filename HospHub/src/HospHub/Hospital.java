package HospHub;

import java.util.HashMap;
import java.lang.StringBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Hospital implements Cadastrable {
    private HashMap<String, Internacao> mapaInternacoes;
    private String nome;
    private final String cnpj;
    private String telefone;
    private String email;
    private String endereco;
    private HashMap<String, ProfissionalSaude> mapaFuncionarios;

    public Hospital(String nome, String cnpj, String telefone, String email, String endereco) {
        mapaInternacoes = new HashMap<String, Internacao>();
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        mapaFuncionarios = new HashMap<String, ProfissionalSaude>();
        salvaArquivos();
    }

    public HashMap<String, Internacao> getMapaInternacoes() {
        return mapaInternacoes;
    }

    public void setMapaInternacoes(HashMap<String, Internacao> mapaInternacoes) {
        this.mapaInternacoes = mapaInternacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public HashMap<String, ProfissionalSaude> getMapaFuncionarios() {
        return mapaFuncionarios;
    }

    public void setMapaFuncionarios(HashMap<String, ProfissionalSaude> mapaFuncionarios) {
        this.mapaFuncionarios = mapaFuncionarios;
    }

    public boolean cadastrar(Object profissionalouinternacao) {
        if (profissionalouinternacao instanceof ProfissionalSaude) {
            ProfissionalSaude profissional = (ProfissionalSaude) profissionalouinternacao;
            if (mapaFuncionarios.values().contains(profissional)) {
                System.out.println("profissional ja cadastrado");
                return false;
            }
            mapaFuncionarios.put(profissional.getRegistro(), profissional);
            System.out.println("profissional cadastrado com sucesso!");
            salvaArquivos();
            return true;
        } else if (profissionalouinternacao instanceof Internacao) {
            Internacao internacao = (Internacao) profissionalouinternacao;
            if (mapaInternacoes.keySet().contains(internacao.getId())) {
                System.out.println("internacao ja cadastrada");
                return false;
            }
            mapaInternacoes.put(internacao.getId(), internacao);
            System.out.println("internacao cadastrada com sucesso!");
            return true;
        }
        System.out.println("entrada invalida");
        return false;
    }

    public boolean remover(String registroouid) {
        try { // se eu conseguir transformar em numero, eh pq eh id
            int registro = Integer.parseInt(registroouid);
            Internacao internacao = mapaInternacoes.remove(Integer.toString(registro));
            if (internacao == null) {
                System.out.println("paciente nao cadastrado"); // nao eh 100% de ctz q foi paciente not found nao vou
                                                               // jogar aqui
                return false;
            }
            System.out.println("internacao removida com sucesso");
            salvaArquivos();
            return true;
        } catch (NumberFormatException e) {
            if (registroouid.charAt(registroouid.length() - 1) == 'E'
                    || registroouid.charAt(registroouid.length() - 1) == 'M') { // garanto q eh registro
                ProfissionalSaude profissional = mapaFuncionarios.remove(registroouid);
                if (profissional == null) {
                    System.out.println("profissional nao cadastrado"); // nao eh 100% de ctz q foi paciente not found
                                                                       // nao vou jogar aqui
                    return false;
                }
                System.out.println("profissional removido com sucesso");
                return true;
            }
            System.out.println("entrada incorreta");
            return false;
        }
    }

    public ProfissionalSaude buscaProfissionalSaude(String registro) {
        ProfissionalSaude procurado = null;
        for (ProfissionalSaude values : mapaFuncionarios.values()) {
            if (registro.equals(values.getRegistro())) {
                procurado = values;
                System.out.println("o profissional procurado eh: ");
                System.out.println(procurado);
                return procurado;
            }
        }
        System.out.println("profissional nao encontrado");
        return null;
    }

    public String ListarFuncionarios() {
        StringBuilder sb = new StringBuilder();
        for (ProfissionalSaude values : mapaFuncionarios.values()) {
            sb.append(values);
            sb.append("\n");
        }
        return sb.toString().equals("") ? "nao ha funcionarios cadastrados" : sb.toString();
    }

    public String ListarMedicos() {
        StringBuilder sb = new StringBuilder();
        for (ProfissionalSaude values : mapaFuncionarios.values()) {
            if (values instanceof Medique) {
                sb.append(values.toString());
                sb.append("\n");
            }
        }
        return sb.toString().equals("") ? "nao ha mediques cadastrades" : sb.toString();
    }

    public String ListarEnfermeiros() {
        StringBuilder sb = new StringBuilder();
        for (ProfissionalSaude values : mapaFuncionarios.values()) {
            if (values instanceof Enfermeire) {
                sb.append(values.toString());
                sb.append("\n");
            }
        }
        return sb.toString().equals("") ? "nao ha enfermeires cadastrades" : sb.toString();
    }

    public String ListarInternacoes() {
        StringBuilder sb = new StringBuilder();
        for (Internacao values : mapaInternacoes.values()) {
            sb.append(values.toString());
            sb.append("\n");
        }
        return sb.toString().equals("") ? "nao ha internacoes cadastradas" : sb.toString();
    }

    public void leArquivo() {
        // Ler arquivos quando iniciar o sistema novamente
        try {
            String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "profissionalSaude";
            String caminhoArquivo = diretorioPrincipal + "HashMap_Profissionais_de_Saude" + ".obj";
            FileInputStream fileIn = new FileInputStream(caminhoArquivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            HashMap<String, ProfissionalSaude> hashMapLido = (HashMap<String, ProfissionalSaude>) objectIn.readObject();
            for (String i : hashMapLido.keySet()) {
                ProfissionalSaude profissional = hashMapLido.get(i);
                cadastrar(profissional);
            }
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hashmap não encontrado");
        }
    }

    public void salvaArquivos() {
        // Salva a lista de profissionais de saúde toda vez que um novo profissional é
        // adicionado ou removido
        try {
            String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "profissionalSaude";
            String caminhoArquivo = diretorioPrincipal + "HashMap_Profissionais_de_Saude" + ".obj";
            FileOutputStream fileOut = new FileOutputStream(caminhoArquivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(mapaFuncionarios);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Não conseguiu salvar o hashmap");
        }
    }

    public String toString() {
        return " o hospital " + nome + " de cnpj " + cnpj + " no endereco " + endereco + " possui telefone " + telefone
                + " e email " + email + " e possui os seguintes medicos "
                + ListarMedicos() + " os seguintes enfermeiros " + ListarEnfermeiros() + " e as seguintes internacoes "
                + ListarInternacoes();
    }

}
package HospHub;
import java.util.HashMap;
import java.lang.StringBuilder;

public class Hospital implements Cadastrable{
    private HashMap <String, Internacao> mapaInternacoes;
    private String nome;
    private final String cnpj;
    private String telefone;
    private String email;
    private String endereco;
    private HashMap <String, ProfissionalSaude> mapaFuncionarios;
    private ArquivoProfissionais arquivoprofissionais;

    public Hospital(String nome, String cnpj, String telefone,String email, String endereco, ArquivoProfissionais arquivoprofissionais) {
        mapaInternacoes = new HashMap <String, Internacao> ();
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
       mapaFuncionarios = new HashMap<String, ProfissionalSaude>();
        this.arquivoprofissionais = arquivoprofissionais;
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


    public ArquivoProfissionais getArquivoprofissionais() {
        return arquivoprofissionais;
    }


    public void setArquivoprofissionais(ArquivoProfissionais arquivoprofissionais) {
        this.arquivoprofissionais = arquivoprofissionais;
    }


    public boolean cadastrar(Object profissionalouinternacao){
        if(profissionalouinternacao instanceof ProfissionalSaude){
            ProfissionalSaude profissional = (ProfissionalSaude) profissionalouinternacao;
            if(mapaFuncionarios.values().contains(profissional)){
                System.out.println("profissional ja cadastrado");
                return false;
            }
            mapaFuncionarios.put(profissional.getRegistro(), profissional);
            System.out.println("profissional cadastrado com sucesso!");
            return true;
        }
        else if (profissionalouinternacao instanceof Internacao){
            Internacao internacao = (Internacao) profissionalouinternacao;
            if(mapaInternacoes.keySet().contains(internacao.getId())){
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

    public boolean remover (String registroouid)  {
        try{ // se eu conseguir transformar em numero, eh pq eh id 
           int registro = Integer.parseInt(registroouid);
           Internacao internacao = mapaInternacoes.remove(Integer.toString(registro));
           if(internacao == null){
            System.out.println("paciente nao cadastrado"); // nao eh 100% de ctz q foi paciente not found nao vou jogar aqui
            return false;
           }
           System.out.println("internacao removida com sucesso");
           return true;
        }
        catch(NumberFormatException e){
            if (registroouid.charAt(registroouid.length() - 1) == 'E'|| registroouid.charAt(registroouid.length() - 1) == 'M'){ // garanto q eh registro
                ProfissionalSaude profissional = mapaFuncionarios.remove(registroouid);
                if(profissional == null){
                    System.out.println("profissional nao cadastrado"); // nao eh 100% de ctz q foi paciente not found nao vou jogar aqui
                    return false;
                    }
                    System.out.println("profissional removido com sucesso");
                    return true;
                        }
            System.out.println("entrada incorreta");
            return false;
        }
    }


    public ProfissionalSaude buscaProfissionalSaude(String registro){
        ProfissionalSaude procurado = null;
        for(ProfissionalSaude values: mapaFuncionarios.values()){
            if(registro.equals(values.getRegistro())){
                procurado = values;
                System.out.println("o profissional procurado eh: ");
                System.out.println(procurado);
                return procurado;
            }
        }
        System.out.println("profissional nao encontrado");
        return null;
    }

    public String ListarFuncionarios(){
        StringBuilder sb = new StringBuilder();
        for(ProfissionalSaude values: mapaFuncionarios.values()){
            sb.append(values);
            sb.append("\n");
        }
        return sb.toString().equals("\n") ? "nao ha funcionarios cadastrados" : sb.toString();
    }

    public String ListarMedicos(){
        StringBuilder sb = new StringBuilder();
        for(ProfissionalSaude values: mapaFuncionarios.values()){
            if(values instanceof Medique){
                sb.append(values.toString());
                sb.append("\n");
            }
        }
        return sb.toString().equals("\n") ? "nao ha mediques cadastrades" : sb.toString();
    }

    public String ListarEnfermeiros(){
        StringBuilder sb = new StringBuilder();
        for(ProfissionalSaude values: mapaFuncionarios.values()){
            if(values instanceof Enfermeire){
                sb.append(values.toString());
                sb.append("\n");
            }
        }
        return sb.toString().equals("\n") ? "nao ha enfermeires cadastrades" : sb.toString();
    }

    public String ListarInternacoes(){
        StringBuilder sb = new StringBuilder();
        for(Internacao values: mapaInternacoes.values()){
            sb.append(values.toString());
            sb.append("\n");
        }
        return sb.toString().equals("\n") ? "nao ha internacoes cadastradas" : sb.toString();
    }

    public void leArquivo(ArquivoProfissionais a){
        System.out.println("Aaaa");
        // soh o patricio sabe como vai ser o arquivo
    }

    public String toString(){
        return " o hospital " + nome + " de cnpj " + cnpj + " no endereco " + endereco + " possui telefone " + telefone + " e email " + email + " e possui os seguintes medicos "
        + ListarMedicos() + " os seguintes enfermeiros " + ListarEnfermeiros() + " e as seguintes internacoes " + ListarInternacoes();
    }

}

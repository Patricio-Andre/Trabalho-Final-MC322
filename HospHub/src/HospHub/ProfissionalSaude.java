package HospHub;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public abstract class ProfissionalSaude implements Cadastrable{
    private String nome;
    private String registro;
    private String endereco;
    private LocalTime inicioplantao;
    private LocalTime fimplantao;
    private final String CPF;
    private HashMap <String, Paciente>  mapaPacientes; // cpf 
    private int limitepacientes;
    private int atendendo;

    public int getAtendendo() {
        return atendendo;
    }

    public void setAtendendo(int atendendo) {
        this.atendendo = atendendo;
    }

    public ProfissionalSaude(String nome, String registro, String endereco, LocalTime inicioplantao,
        LocalTime fimplantao, String cPF, int limitepacientes) {
        this.nome = nome;
        this.registro = registro;
        this.endereco = endereco;
        this.inicioplantao = inicioplantao;
        this.fimplantao = fimplantao;
        CPF = cPF;
        this.limitepacientes = limitepacientes;
        mapaPacientes = new HashMap <String, Paciente> ();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalTime getInicioplantao() {
        return inicioplantao;
    }

    public void setInicioplantao(LocalTime inicioplantao) {
        this.inicioplantao = inicioplantao;
    }

    public LocalTime getFimplantao() {
        return fimplantao;
    }

    public void setFimplantao(LocalTime fimplantao) {
        this.fimplantao = fimplantao;
    }

    public String getCPF() {
        return CPF;
    }

    public HashMap<String, Paciente> getMapaPacientes() {
        return mapaPacientes;
    }

    public void setMapaPacientes(HashMap<String, Paciente> mapaPacientes) {
        this.mapaPacientes = mapaPacientes;
    }

    public int getLimitepacientes() {
        return limitepacientes;
    }

    public void setLimitepacientes(int limitepacientes) {
        this.limitepacientes = limitepacientes;
    }


        

    public boolean remover(String cpf) throws PacienteNotFoundException{ 
        PacienteNotFoundException e = new PacienteNotFoundException();
        Paciente paciente = null;
        paciente = mapaPacientes.remove(cpf.replaceAll("[^\\d]",""));
        if(paciente == null){
            throw e; // nando vc tem q pegar la na main
        }
        atendendo--;
        System.out.println("paciente removido com sucesso");
        return true;
    }

    protected Paciente achaPaciente(String cpf) throws PacienteNotFoundException{
        PacienteNotFoundException e = new PacienteNotFoundException();
        Paciente paciente = null;
        for(Paciente values: mapaPacientes.values()){
            if(paciente.getCPF().equals(cpf.replaceAll("[^\\d]",""))) {
                paciente = values;
                return paciente;
            }
        }
        throw e;
    }

    protected boolean interfere(String cpf, String remedio) throws RemedioIncompativelException{
        try{
            Paciente paciente = achaPaciente(cpf);
            if(paciente.getExamesProibidos().contains(remedio)){
                throw new RemedioIncompativelException();
            }
            return true;
        }
        catch(PacienteNotFoundException e){
            System.out.println("paciente nao encontrado");
            return false;
        }
    }

    public boolean gerarReceita(String remedio, String dosagem, ProfissionalSaude profissionalSaude, String cpf){
        try{
            boolean flag = interfere(cpf, remedio);
            Paciente paciente = achaPaciente(cpf);
            if(flag) {
                Receita receita = new Receita(remedio, dosagem, this, paciente);
                paciente.getListaDeReceitas().add(receita);
                System.out.println("receita cadastrada com sucesso");
                return true;
            }
            return false;
        }
        catch (RemedioIncompativelException e){
            System.out.println("remedio nao pode ser prescrevido");
            return false;
        }
        catch (PacienteNotFoundException a){
            System.out.println("paciente nao encontrado");
            return false;
        }
    }

    // sobrecarga
    public boolean gerarReceita(String remedio, String dosagem, ProfissionalSaude profissionalSaude, LocalDate dataVencimento, String cpf){
        
    	
    	try{
    		Paciente paciente = this.achaPaciente(cpf);
            boolean flag = interfere(cpf, remedio);
            if(flag){
                Receita receita = new Receita(remedio, dosagem, this, dataVencimento, paciente);
                paciente.getListaDeReceitas().add(receita);
                System.out.println("receita cadastrada com sucesso");
                return true;
            }
            return false;
        }
        catch (RemedioIncompativelException e){
            System.out.println("remedio nao pode ser prescrevido");
            return false;
        }
    	catch (PacienteNotFoundException a){
            System.out.println("paciente nao encontrado");
            return false;
        }
    }

    public boolean removerReceita(String remedio, String cpf){
        try{
            Paciente paciente = achaPaciente(cpf);
            paciente.removerRemedio(remedio);
            return true;
        }
        catch (PacienteNotFoundException e){
            System.out.println("paciente nao encontrado");
            return false;
        }
    }


   
}
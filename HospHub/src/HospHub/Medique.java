package HospHub;

import java.time.LocalDate;
import java.time.LocalTime;

public class Medique extends ProfissionalSaude {
    private String especializacao;
    private double custo;

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Medique(String especializacao, double custo, String nome, String registro, String endereco, LocalTime inicioplantao,
        LocalTime fimplantao, String cPF, int limitepacientes ){
        super(nome, registro, endereco, inicioplantao, fimplantao, cPF, limitepacientes);
        // String registroM = registro + 'M'; nando faz isso na main
        this.especializacao = especializacao; 
        this.custo = custo;
    }

    public boolean cadastrar(Object pacienteo) throws ProfissionalUnfitException{
         ProfissionalUnfitException e = new ProfissionalUnfitException();
        if(this.getAtendendo() < this.getLimitepacientes() && LocalTime.now().isAfter(this.getInicioplantao()) && LocalTime.now().isBefore(this.getFimplantao())){ // ver se to de plantao e se minha especialidade eh a dele;
            if(pacienteo instanceof Paciente){
            Paciente paciente = (Paciente) pacienteo;
            if(paciente.getEspecialidadeNecessaria().equals(especializacao)){
                if(this.getMapaPacientes().containsKey(paciente.getCPF())){
                System.out.println("paciente ja cadastrado");
                return false;
            }
            this.getMapaPacientes().put(paciente.getCPF(), paciente);
            this.setAtendendo(this.getAtendendo()+1);
            cobrar(paciente);
            System.out.println("paciente cadastrado com sucesso");
            return true;
            }
            throw e;
            }
        System.out.println("Entrada invalida");
        return false;
    }
        throw e;

    }

    public void cobrar(Paciente paciente){
        if(paciente instanceof PacienteParticular){
        	PacienteParticular pacienteParticular = (PacienteParticular) paciente;
        	pacienteParticular.setCusto(pacienteParticular.getCusto() + this.custo);
        }
    }

    private boolean exameInterfere(Paciente paciente,String nome){
        if(paciente.getExamesProibidos().contains(nome)){
            return true;
        }
        return false;

    }

    public boolean solicitarExame(String cpf, String nome, double custoE, LocalDate data ) throws ExameIncompativelException{
        ExameIncompativelException a = new ExameIncompativelException();
        try{
            Paciente paciente = this.achaPaciente(cpf);
            boolean interfere = exameInterfere(paciente, nome);
            if(interfere){
                throw a;
            }
            Exame exame = new Exame(nome, custoE, data, paciente);
            paciente.getListaDeExames().add(exame);
            if(paciente instanceof PacienteParticular){
            	PacienteParticular pacienteParticular = (PacienteParticular) paciente;
            	pacienteParticular.setCusto(pacienteParticular.getCusto() + custoE);
            }
            System.out.println("exame solicitado com sucesso");
            return true;
        }
        catch (PacienteNotFoundException e){
            System.out.println("paciente nao encontrado");
            return false;
        }
    }

    public boolean gerarLaudo(String cpf, String doenca, LocalDate dataAtendimento){
        try{
            Paciente paciente = this.achaPaciente(cpf);

            Laudo laudo = new Laudo(this, doenca, dataAtendimento, paciente);
            paciente.getListaDeLaudos().add(laudo);
            System.out.println("laudo emitido com sucessso");
            return true;
        }
        catch (PacienteNotFoundException e){
            System.out.println("paciente nao encontrado");
            return false;
        }
    }

    public boolean gerarAtestado(String cpf, int diasAusencia, LocalDate data){
        try{
            Paciente paciente = this.achaPaciente(cpf);
            Atestado atestado = new Atestado(this, diasAusencia, data, paciente);
            paciente.getListaDeAtestados().add(atestado);
            System.out.println("atestado emitido com sucessso");
            return true;

        }
        catch (PacienteNotFoundException e){
            System.out.println("paciente nao encontrado");
            return false;
        }
    }

    public String toString(){
        return "e medique " + this.getNome()+ " e registro " + this.getRegistro() + " e endereco "  + this.getEndereco() + " possui um limite de pacientes " + this.getLimitepacientes()
        + " tem cpf " + this.getCPF() + " inicia plantao em " + this.getInicioplantao() + " e acaba em " + this.getFimplantao() + " especializade em " + especializacao + " cobrando "
        + custo;
    }



}
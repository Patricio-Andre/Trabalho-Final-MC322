package hospitaleservicos;

import java.time.LocalTime;

public class Enfermeire extends  ProfissionalSaude {
    public Enfermeire(String nome, String registro, String endereco, LocalTime inicioplantao,
        LocalTime fimplantao, String cPF, int limitepacientes){
            super(nome, registro, endereco, inicioplantao, fimplantao, cPF, limitepacientes);
        }


    public boolean cadastrar(Object pacienteo) throws ProfissionalUnfitException{
        ProfissionalUnfitException e = new ProfissionalUnfitException();
        if(this.getAtendendo() < this.getLimitepacientes() && LocalTime.now().isAfter(this.getInicioplantao()) && LocalTime.now().isBefore(this.getFimplantao())){ // ver se to de plantao e se minha especialidade eh a dele;
            if(pacienteo instanceof Paciente){ //tipo medico so que sem especializacao
            Paciente paciente = (Paciente) pacienteo;
                if(this.getMapaPacientes().containsKey(paciente.getCPF())){
                System.out.println("paciente ja cadastrado");
                return false;
            }
            this.getMapaPacientes().put(paciente.getCPF(), paciente);
            this.setAtendendo(this.getAtendendo()+1);
            System.out.println("paciente cadastrado com sucesso");
            return true;
            }
            }
        throw e;
    }

    public String alimentar(Paciente paciente){
        return " o paciente " + paciente + " foi alimentado ";
    }


    public String darBanho(Paciente paciente){
        return "o paciente " + paciente + " foi banhado ";
    }

    
}

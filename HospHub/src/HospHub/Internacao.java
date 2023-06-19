package HospHub;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.Clock;

public class Internacao {
    private String id;
    private static int contador = 0; 
    private Paciente paciente;
    private Enfermeire enfermeire;
    private Medique medique;
    private LocalDateTime entrada;
    private double custo;
    private LocalDateTime saida;
    private Hospital hospital;

    public Internacao(Paciente paciente, Enfermeire enfermeire, Medique medique, double custo, LocalDateTime entrada, LocalDateTime saida, Hospital hospital){
        try{
            medique.cadastrar(paciente);
            enfermeire.cadastrar(paciente);
            this.custo = custo;
            this.paciente = paciente;
            this.enfermeire = enfermeire;
            this.medique = medique;
            this.entrada = entrada;
            this.saida = saida;
            id = Integer.toString(contador);
            contador ++;
            cuida();
        }
        catch (ProfissionalUnfitException e){
            System.out.println("nao foi possivel cadastrar com esses profissionais");
            return;
        }
        
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Hospital getHospital() {
        return hospital;
    }
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Enfermeire getEnfermeire() {
        return enfermeire;
    }
    public void setEnfermeire(Enfermeire enfermeire) {
        this.enfermeire = enfermeire;
    }
    public Medique getMedique() {
        return medique;
    }
    public void setMedique(Medique medique) {
        this.medique = medique;
    }
    public LocalDateTime getEntrada() {
        return entrada;
    }
    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }
    public double getCusto() {
        return custo;
    }
    public void setCusto(double custo) {
        this.custo = custo;
    }
    public LocalDateTime getSaida() {
        return saida;
    }
    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public void cuida(){
        ZoneId fuso = ZoneId.of("America/Sao_Paulo");
        LocalDateTime ultimobanho = entrada;
        LocalDateTime ultimacomida = entrada;
        while(ChronoUnit.MILLIS.between(entrada,saida) > 0){
            if(ChronoUnit.SECONDS.between(LocalDateTime.now(fuso), ultimacomida) % 5 == 0){
                enfermeire.alimentar(paciente);
                ultimacomida = LocalDateTime.now(fuso);
            }
            else if(ChronoUnit.SECONDS.between(LocalDateTime.now(fuso), ultimobanho) % 13 == 0){
                enfermeire.darBanho(paciente);
                ultimobanho = LocalDateTime.now(fuso);
            }
        }
        hospital.remover(id);
        medique.remover(paciente.getCPF());
        enfermeire.remover(paciente.getCPF());

    }

    public String toString(){
        return "A internacao do paciente " + paciente + " que se iniciou" + entrada + " de id " + id + " e acabara em " + saida; // nao botei o medico ou enfermeiro pq ia ficar medico chamando paciente 2 vezes
    }
}

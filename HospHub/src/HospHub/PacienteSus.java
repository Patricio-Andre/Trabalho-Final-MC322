package HospHub;
public class PacienteSus  extends Paciente{
	private final int numeroSUS;

	// Construtor
	public PacienteSus(String cPF, int idade, int nivelDor, String nome, String remediosProibidos,
			String especialidadeNecessaria, String examesProibidos, Hospital hospital, int numeroSUS) {
		super(cPF, idade, nivelDor, nome, remediosProibidos, especialidadeNecessaria, examesProibidos, hospital);
		this.numeroSUS = numeroSUS;
	}
	// Getter
	public int getNumeroSUS() {
		return numeroSUS;
	}
}

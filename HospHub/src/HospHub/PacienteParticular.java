package HospHub;
public class PacienteParticular extends Paciente{
	private String convenio;
	private final int idConvenio;
	private double custo;
	// Construtor
	public PacienteParticular(String cPF, int idade, int nivelDor, String nome, String remediosProibidos,
			String especialidadeNecessaria, String examesProibidos, Hospital hospital, String convenio,
			int idConvenio) {
		super(cPF, idade, nivelDor, nome, remediosProibidos, especialidadeNecessaria, examesProibidos, hospital);
		this.convenio = convenio;
		this.idConvenio = idConvenio;
	}
	// Getters e Setters
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public int getIdConvenio() {
		return idConvenio;
	}
}

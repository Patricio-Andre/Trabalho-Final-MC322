package HospHub;
import java.util.ArrayList;

public class PacienteParticular extends Paciente{
	private String convenio;
	private final int idConvenio;
	private double custo;
	// Construtor
	public PacienteParticular(String cPF, int idade, int nivelDor, int gravidade, String nome, String remediosProibidos,
			String especialidadeNecessaria, String examesProibidos, Medique medicoAlocado,
			ArrayList<Laudo> listaDeLaudos, ArrayList<Exame> listaDeExames, ArrayList<Atestado> listaDeAtestados,
			ArrayList<Receita> listaDeReceitas, String convenio, int idConvenio, double custo) {
		super(cPF, idade, nivelDor, gravidade, nome, remediosProibidos, especialidadeNecessaria, examesProibidos,
				medicoAlocado, listaDeLaudos, listaDeExames, listaDeAtestados, listaDeReceitas);
		this.convenio = convenio;
		this.idConvenio = idConvenio;
		this.custo = custo;
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

package hospitaleservicos;

import java.util.ArrayList;

public class PacienteParticular extends Paciente{
	private String convenio;
	private final int idConvenio;
	private double custo;
	// Construtor
	public PacienteParticular(int cpf, int idade, int nivelDor, String nome, String remediosProibidos,
			String especialidadeNecessaria, String quarto, String examesProibidos, String medicoAlocado,
			ArrayList<Laudo> listaDeLaudos, ArrayList<Exame> listaDeExames, ArrayList<Atestado> listaDeAtestados,
			String convenio, int idConvenio, double custo) {
		super(cpf, idade, nivelDor, nome, remediosProibidos, especialidadeNecessaria, quarto, examesProibidos,
				medicoAlocado, listaDeLaudos, listaDeExames, listaDeAtestados);
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

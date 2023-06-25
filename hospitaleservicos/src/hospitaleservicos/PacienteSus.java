package hospitaleservicos;

import java.util.ArrayList;

public class PacienteSus  extends Paciente{
	private final int numeroSUS;

	// Construtor
	public PacienteSus(int cpf, int idade, int nivelDor, String nome, String remediosProibidos,
			String especialidadeNecessaria, String quarto, String examesProibidos, String medicoAlocado,
			ArrayList<Laudo> listaDeLaudos, ArrayList<Exame> listaDeExames, ArrayList<Atestado> listaDeAtestados,
			int numeroSUS) {
		super(cpf, idade, nivelDor, nome, remediosProibidos, especialidadeNecessaria, quarto, examesProibidos,
				medicoAlocado, listaDeLaudos, listaDeExames, listaDeAtestados);
		this.numeroSUS = numeroSUS;
	}
	// Getter
	public int getNumeroSUS() {
		return numeroSUS;
	}
	
}

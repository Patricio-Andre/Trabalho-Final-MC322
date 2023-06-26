package hospitaleservicos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PacienteSus  extends Paciente{
	private final int numeroSUS;

	// Construtor
	public PacienteSus(String cPF, int idade, int nivelDor, int gravidade, String nome, String remediosProibidos,
			String especialidadeNecessaria, String examesProibidos, Medique medicoAlocado,
			ArrayList<Laudo> listaDeLaudos, ArrayList<Exame> listaDeExames, ArrayList<Atestado> listaDeAtestados,
			ArrayList<Receita> listaDeReceitas, LocalDateTime contador, int numeroSUS) {
		super(cPF, idade, nivelDor, gravidade, nome, remediosProibidos, especialidadeNecessaria, examesProibidos,
				medicoAlocado, listaDeLaudos, listaDeExames, listaDeAtestados, listaDeReceitas, contador);
		this.numeroSUS = numeroSUS;
	}
	// Getter
	public int getNumeroSUS() {
		return numeroSUS;
	}
}

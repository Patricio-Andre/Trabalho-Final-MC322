package hospitaleservicos;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;


public abstract class Paciente implements Cadastrable{
	private final int cpf;
	private int idade;
	private int nivelDor;
	private String nome;
	private String remediosProibidos;
	private String especialidadeNecessaria;
	private String quarto;
	private int gravidade;
	private String examesProibidos;
	private String medicoAlocado;
	private ArrayList<Laudo> listaDeLaudos = new ArrayList<Laudo>();
	private ArrayList<Exame> listaDeExames = new ArrayList<Exame>();
	private ArrayList<Atestado> listaDeAtestados = new ArrayList<Atestado>();
	private LocalDateTime contador = LocalDateTime.now();
	// Construtor
	public Paciente(int cpf, int idade, int nivelDor, String nome, String remediosProibidos,
			String especialidadeNecessaria, String quarto, String examesProibidos, String medicoAlocado,
			ArrayList<Laudo> listaDeLaudos, ArrayList<Exame> listaDeExames, ArrayList<Atestado> listaDeAtestados) {
		super();
		this.cpf = cpf;
		this.idade = idade;
		this.nivelDor = nivelDor;
		this.nome = nome;
		this.remediosProibidos = remediosProibidos;
		this.especialidadeNecessaria = especialidadeNecessaria;
		this.quarto = quarto;
		this.examesProibidos = examesProibidos;
		this.medicoAlocado = medicoAlocado;
		this.listaDeLaudos = listaDeLaudos;
		this.listaDeExames = listaDeExames;
		this.listaDeAtestados = listaDeAtestados;
	}
	// Getters e Setters
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getNivelDor() {
		return nivelDor;
	}
	public void setNivelDor(int nivelDor) {
		this.nivelDor = nivelDor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRemediosProibidos() {
		return remediosProibidos;
	}
	public void setRemediosProibidos(String remediosProibidos) {
		this.remediosProibidos = remediosProibidos;
	}
	public String getEspecialidadeNecessaria() {
		return especialidadeNecessaria;
	}
	public void setEspecialidadeNecessaria(String especialidadeNecessaria) {
		this.especialidadeNecessaria = especialidadeNecessaria;
	}
	public String getQuarto() {
		return quarto;
	}
	public void setQuarto(String quarto) {
		this.quarto = quarto;
	}
	public int getGravidade() {
		return gravidade;
	}
	public String getExamesProibidos() {
		return examesProibidos;
	}
	public void setExamesProibidos(String examesProibidos) {
		this.examesProibidos = examesProibidos;
	}
	public String getMedicoAlocado() {
		return medicoAlocado;
	}
	public void setMedicoAlocado(String medicoAlocado) {
		this.medicoAlocado = medicoAlocado;
	}
	public int getCpf() {
		return cpf;
	}
	public ArrayList<Laudo> getListaDeLaudos() {
		return listaDeLaudos;
	}
	public void setListaDeLaudos(ArrayList<Laudo> listaDeLaudos) {
		this.listaDeLaudos = listaDeLaudos;
	}
	public ArrayList<Exame> getListaDeExames() {
		return listaDeExames;
	}
	public void setListaDeExames(ArrayList<Exame> listaDeExames) {
		this.listaDeExames = listaDeExames;
	}
	public LocalDateTime getContador() {
		return contador;
	}
	public void setContador(LocalDateTime contador) {
		this.contador = contador;
	}
	// Métodos não abstratos
	public void gerarGravidade() {
		// Usando um artigo presente em https://l1nq.com/QK0o5 temos essas informações
		// Falta estabelecer a lógica de duration na interface
		Scanner leitura = new Scanner(System.in);
		System.out.print("Digite a gravidade do paciente");
		this.gravidade = leitura.nextInt();
		leitura.close();
		switch (gravidade) {
			case 1:
				System.out.println("Necessita Tratamento imediato, risco de morte!");
				contador = LocalDateTime.now().plusMinutes(5);
			case 2:
				System.out.println("Risco de morte! Necessita de tratamento em até 15 minutos");
				contador = LocalDateTime.now().plusMinutes(15);
			case 3:
				System.out.println("Urgência! Necessita de tratamento em até 15 minutos");
				contador = LocalDateTime.now().plusMinutes(15);
			case 4:
				System.out.println("Pouco urgente. Necessita de tratamento em até 30 minutos");
				contador = LocalDateTime.now().plusMinutes(30);
			case 5:
				System.out.println("Não urgente. Necessita de tratamento em até 30 minutos");
				contador = LocalDateTime.now().plusMinutes(30);
		}
	}
	public boolean listarLaudos() {
		if (listaDeLaudos.size() == 0) {
			return false;
		}
		for (int i = 0; i < listaDeLaudos.size(); i++) {
			System.out.println(listaDeLaudos.get(i));
		}
		return true;
	}
	public boolean listarAtestados() {
		if (listaDeAtestados.size() == 0) {
			return false;
		}
		for (int i = 0; i < listaDeAtestados.size(); i++) {
			System.out.println(listaDeAtestados.get(i));
		}
		return true;
	}
	public boolean listarExamesFeitos() {
		if (listaDeExames.size() == 0) {
			return false;
		}
		for (int i = 0; i < listaDeExames.size(); i++) {
			System.out.println(listaDeExames.get(i));
		}
		return true;
	}
}

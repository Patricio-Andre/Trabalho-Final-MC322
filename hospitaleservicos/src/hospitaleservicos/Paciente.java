package hospitaleservicos;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDate;


public abstract class Paciente{
	private final String CPF;
	private int idade;
	private int nivelDor;
	private String gravidade;
	private String nome;
	private String remediosProibidos;
	private String especialidadeNecessaria;
	private String quarto;
	private String examesProibidos;
	private Medique medicoAlocado;
	private ArrayList<Laudo> listaDeLaudos = new ArrayList<Laudo>();
	private ArrayList<Exame> listaDeExames = new ArrayList<Exame>();
	private ArrayList<Atestado> listaDeAtestados = new ArrayList<Atestado>();
	private ArrayList<Receita> listaDeReceitas = new ArrayList<Receita>();
	private LocalDateTime contador = LocalDateTime.now();
	// Construtor
	public Paciente(String cPF, int idade, int nivelDor, int gravidade, String nome, String remediosProibidos,
			String especialidadeNecessaria, String examesProibidos, Medique medicoAlocado,
			ArrayList<Laudo> listaDeLaudos, ArrayList<Exame> listaDeExames, ArrayList<Atestado> listaDeAtestados,
			ArrayList<Receita> listaDeReceitas, LocalDateTime contador) {
		super();
		CPF = cPF;
		this.idade = idade;
		this.nivelDor = nivelDor;
		this.nome = nome;
		this.remediosProibidos = remediosProibidos;
		this.especialidadeNecessaria = especialidadeNecessaria;
		this.examesProibidos = examesProibidos;
		this.medicoAlocado = medicoAlocado;
		this.listaDeLaudos = listaDeLaudos;
		this.listaDeExames = listaDeExames;
		this.listaDeAtestados = listaDeAtestados;
		this.listaDeReceitas = listaDeReceitas;
		this.contador = contador;
		gerarGravidade();
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
	public String getGravidade() {
		return gravidade;
	}
	public String getExamesProibidos() {
		return examesProibidos;
	}
	public void setExamesProibidos(String examesProibidos) {
		this.examesProibidos = examesProibidos;
	}
	public Medique getMedicoAlocado() {
		return medicoAlocado;
	}
	public void setMedicoAlocado(Medique medicoAlocado) {
		this.medicoAlocado = medicoAlocado;
	}
	public String getCPF() {
		return CPF;
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
	public ArrayList<Atestado> getListaDeAtestados() {
		return listaDeAtestados;
	}
	public void setListaDeAtestados(ArrayList<Atestado> listaDeAtestados) {
		this.listaDeAtestados = listaDeAtestados;
	}
	public ArrayList<Receita> getListaDeReceitas() {
		return listaDeReceitas;
	}
	public void setListaDeReceitas(ArrayList<Receita> listaDeReceitas) {
		this.listaDeReceitas = listaDeReceitas;
	}
	// Métodos não abstratos
	public void gerarGravidade() {
		if (nivelDor >= 7) {
			gravidade = "vermelho";
			medicoAlocado.gerarAtestado(CPF, 10, LocalDate.now());
			System.out.println("o médico " + medicoAlocado.getNome() + "deve gerar um laudo para esse paciente");
			try {
				medicoAlocado.solicitarExame(CPF, "Exame de Sangue", 25, LocalDate.now());
			} catch (ExameIncompativelException e) {
				System.out.println("Exame Incompatível");
			}
		} else if (nivelDor < 7 && nivelDor >= 4) {
			gravidade = "amarelo";
			medicoAlocado.gerarAtestado(CPF, 5, LocalDate.now());
			System.out.println("o médico " + medicoAlocado.getNome() + "deve gerar uma receita para esse paciente");
		} else if (nivelDor < 4) {
			gravidade = "verde";
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
	public boolean listarReceitas() {
		if (listaDeReceitas.size() == 0) {
			return false;
		}
		for (int i = 0; i < listaDeReceitas.size(); i++) {
			System.out.println(listaDeReceitas.get(i));
		}
		return true;
	}
	
	public boolean removerRemedio(String remedio) {
		for (Receita i: listaDeReceitas) {
			if (i.getRemedio().equals(remedio)) {
				listaDeReceitas.remove(i);
				return true;
			}
		}
		return false;
	}
}

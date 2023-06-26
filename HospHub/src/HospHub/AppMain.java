package HospHub;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppMain {

    public static void cadastrarReceita(Scanner in, Hospital hospital) {
        System.out.println("Digite o nome do remedio");
        String nome = in.nextLine();
        boolean nomeEhValido = ValidaDados.validaNome(nome);
        while (!nomeEhValido) {
            System.out.println("nome invalido, tente novamente");
            nome = in.nextLine();
            nomeEhValido = ValidaDados.validaNome(nome);
        }
        System.out.println("Informe a dosagem");
        String dosagem = in.nextLine();
        System.out.println("Informe o registro do profissional da saude");
        String registro = in.nextLine();
        System.out.println("Informe o cpf do paciente");
        String cpf = in.nextLine();
        ProfissionalSaude profissional = hospital.buscaProfissionalSaude(registro);
        profissional.gerarReceita(nome, dosagem, profissional, cpf);
    }

    public static void cadastrarReceitaAntibiotico(Scanner in, Hospital hospital) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Digite o nome do remedio");
        String nome = in.nextLine();
        boolean nomeEhValido = ValidaDados.validaNome(nome);
        while (!nomeEhValido) {
            System.out.println("nome invalido, tente novamente");
            nome = in.nextLine();
            nomeEhValido = ValidaDados.validaNome(nome);
        }
        System.out.println("Informe a dosagem");
        String dosagem = in.nextLine();
        System.out.println("Informe a data de vencimento da receita");
        String data = in.nextLine();
        boolean dataEhValida = ValidaDados.validaData(data);
        while (!dataEhValida) {
            System.out.println("data invalida, tente novamente");
            data = in.nextLine();
            dataEhValida = ValidaDados.validaData(data);
        }
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        System.out.println("Informe o registro do profissional da saude");
        String registro = in.nextLine();
        System.out.println("Informe o cpf do paciente");
        String cpf = in.nextLine();
        ProfissionalSaude profissional = hospital.buscaProfissionalSaude(registro);
        profissional.gerarReceita(registro, dosagem, profissional, dataFormatada, cpf);
    }

    public static void removerReceita(Scanner in, Hospital hospital) {
        System.out.println("Digite o nome do remedio");
        String nome = in.nextLine();
        boolean nomeEhValido = ValidaDados.validaNome(nome);
        while (!nomeEhValido) {
            System.out.println("nome invalido, tente novamente");
            nome = in.nextLine();
            nomeEhValido = ValidaDados.validaNome(nome);
        }
        System.out.println("Informe o registro do profissional da saude");
        String registro = in.nextLine();
        System.out.println("Informe o cpf do paciente");
        String cpf = in.nextLine();
        ProfissionalSaude profissional = hospital.buscaProfissionalSaude(registro);
        if (profissional.removerReceita(nome, cpf)) {
            System.out.println("Receita removida com sucesso");
        } else {
            System.out.println("Falha ao realizar a remoção da receita");
        }
    }

    public static void imprimeMenu() {
        System.out.println("Bem vindo ao menu");
        System.out.println("Selecione uma das seguintes ações:");
        System.out.println("1 - receitas");
        System.out.println("2 - listar");
        System.out.println("3 - solicitar exame");
        System.out.println("4 - gerar laudo");
        System.out.println("5 - gerar atestado");
        System.out.println("0 - sair");
    }

    public static void imprimeMenuListar() {
        System.out.println("Selecione o item que deseja listar");
        System.out.println("1 - Funcionarios");
        System.out.println("2 - Medicos");
        System.out.println("3 - Enfermeiros");
        System.out.println("4 - Internacoes");
        System.out.println("0 - voltar");
    }

    public static void menuListar(Scanner in, Hospital hospital) {
        imprimeMenuListar();
        int comando = in.nextInt();
        switch (comando) {
            case 1:
                System.out.println(hospital.ListarFuncionarios());
                break;
            case 2:
                System.out.println(hospital.ListarMedicos());
                break;
            case 3:
                System.out.println(hospital.ListarEnfermeiros());
                break;
            case 4:
                System.out.println(hospital.ListarInternacoes());
                break;
            case 0:
                break;
            default:
                System.out.println("Comando invalido");
                break;
        }
    }

    public static void imprimeMenuReceitas() {
        System.out.println("Selecione a ação desejada");
        System.out.println("1 - gerar receita normal");
        System.out.println("2 - gerar receita de antibiótico");
        System.out.println("3 - remover receita");
        System.out.println("0 - voltar");
    }

    public static void menuReceitas(Scanner in, Hospital hospital) {
        imprimeMenuReceitas();
        int comando = in.nextInt();
        switch (comando) {
            case 1:
                cadastrarReceita(in, hospital);
                break;
            case 2:
                cadastrarReceitaAntibiotico(in, hospital);
                break;
            case 3:
                break;
            case 0:
                break;
            default:
                System.out.println("Comando invalido");
                break;
        }
    }

    public static void novoExame(Scanner in, Hospital hospital) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Digite o nome do exame");
        String nome = in.nextLine();
        System.out.println("Insira o cpf do paciente");
        String cpf = in.nextLine();
        System.out.println("Insira o valor do exame");
        double valor = in.nextDouble();
        System.out.println("Insira a data do exame");
        String data = in.nextLine();
        boolean dataEhValida = ValidaDados.validaData(data);
        while (!dataEhValida) {
            System.out.println("data invalida, tente novamente");
            data = in.nextLine();
            dataEhValida = ValidaDados.validaData(data);
        }
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        System.out.println("Informe o registro do profissional da saude que pregetende marcar o exame");
        String registro = in.nextLine();
        ProfissionalSaude profissional = hospital.buscaProfissionalSaude(registro);
        if (profissional instanceof Medique) {
            Medique medico = (Medique) profissional;
            try {
                if (medico.solicitarExame(cpf, nome, valor, dataFormatada)) {
                    System.out.println("Exame solicitado com sucesso");
                } else {
                    System.out.println("Falha ao solicitar o exame");
                }
            } catch (ExameIncompativelException e) {
                System.out.println("Falha ao realizar o pedido: Exame inconpativel");
            }
        } else {
            System.out.println("O profissional solicitado não é um médico, logo não pode solicitar um exame");
        }
    }

    public static void gerarLaudo(Scanner in, Hospital hospital) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Informe o registro do profissional da saude que pretende gerar o laudo");
        String registro = in.nextLine();
        System.out.println("Insira o cpf do paciente");
        String cpf = in.nextLine();
        System.out.println("Informe a doença do paciente");
        String doenca = in.nextLine();
        System.out.println("Insira a data do atendimento");
        String data = in.nextLine();
        boolean dataEhValida = ValidaDados.validaData(data);
        while (!dataEhValida) {
            System.out.println("data invalida, tente novamente");
            data = in.nextLine();
            dataEhValida = ValidaDados.validaData(data);
        }
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        ProfissionalSaude profissional = hospital.buscaProfissionalSaude(registro);
        if (profissional instanceof Medique) {
            Medique medico = (Medique) profissional;
            medico.gerarLaudo(cpf, doenca, dataFormatada);
        } else {
            System.out.println("O profissional solicitado não é um médico, logo não pode gerar um laudo");
        }
    }

    public static void gerarAtestado(Scanner in, Hospital hospital) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Informe o registro do profissional da saude que pretende gerar o laudo");
        String registro = in.nextLine();
        System.out.println("Insira o cpf do paciente");
        String cpf = in.nextLine();
        System.out.println("Informe a quantidade de dias do atestado");
        int dias = in.nextInt();
        System.out.println("Insira a data do atendimento");
        String data = in.nextLine();
        boolean dataEhValida = ValidaDados.validaData(data);
        while (!dataEhValida) {
            System.out.println("data invalida, tente novamente");
            data = in.nextLine();
            dataEhValida = ValidaDados.validaData(data);
        }
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        ProfissionalSaude profissional = hospital.buscaProfissionalSaude(registro);
        if (profissional instanceof Medique) {
            Medique medico = (Medique) profissional;
            medico.gerarAtestado(cpf, dias, dataFormatada);
        } else {
            System.out.println("O profissional solicitado não é um médico, logo não pode gerar um atestado");
        }
    }

    public static void main(String args[]) {
        // new MinhaInterfaceGrafica();
        Hospital hospital = new Hospital("Novo Hospital", "12.821.660/0001-12", "(19)992926745",
                "hosp@placeholder.com.br", "Rua temporaria", null);
        Scanner entrada = new Scanner(System.in);
        imprimeMenu();
        int comando = entrada.nextInt();
        while (comando != 0) {
            switch (comando) {
                case 1:
                    menuReceitas(entrada, hospital);
                    break;
                case 2:
                    menuListar(entrada, hospital);
                    break;
                case 3:
                    novoExame(entrada, hospital);
                    break;
                case 4:
                    gerarLaudo(entrada, hospital);
                    break;
                case 5:
                    gerarAtestado(entrada, hospital);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Comando invalido tente novamente");
                    break;
            }
            imprimeMenu();
            comando = entrada.nextInt();
        }
        System.out.println("saiu");
        entrada.close();
    }
}

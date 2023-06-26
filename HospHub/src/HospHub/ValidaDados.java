
package HospHub;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidaDados {
	// peguei todas essas de validacao diretamente do meu lab05
	private static int calculaDigitoCPF(String cpfTeste, int aSomar, int acrescimo) {
		int soma = 0;
		for (int i = 8; i >= 0; i--) {
			soma += aSomar * (Character.getNumericValue(cpfTeste.charAt(i)));
			aSomar++;
		}
		soma += acrescimo;
		return soma % 11 >= 2 ? (11 - (soma % 11)) : 0;
	}

	public static boolean validarCPF(String cpfTeste) {
		cpfTeste = cpfTeste.replaceAll("[^\\d]", "");
		char base = cpfTeste.charAt(0);
		int cont = 1, primeiroDigito, segundoDigito, digitoParcial, a, b;
		if (cpfTeste.length() != 11)
			return false;
		for (int i = 1; i < 11; i++) { // acredito que um cpf completamente igual nao passaria no teste numerico, mas o
										// lab pedia especificamente para testar se todos eram iguais
			if (cpfTeste.charAt(i) == base)
				cont++;
		}
		if (cont == 11)
			return false;
		primeiroDigito = calculaDigitoCPF(cpfTeste, 2, 0);
		digitoParcial = primeiroDigito * 2;
		segundoDigito = calculaDigitoCPF(cpfTeste, 3, digitoParcial);
		a = Character.getNumericValue(cpfTeste.charAt(9));
		b = Character.getNumericValue(cpfTeste.charAt(10));
		return ((primeiroDigito == a) && (segundoDigito == b));
	}

	private static int calculaDigitoCNPJ(ArrayList<Integer> arraybase, int max, String cnpjTeste, int sub) {

		int soma = 0;

		for (int i = 0; i < max; i++) {
			soma += Character.getNumericValue(cnpjTeste.charAt(i)) * arraybase.get(arraybase.size() - sub - i);
		}

		return soma % 11 >= 2 ? (11 - (soma % 11)) : 0;

	}

	public static boolean validaNome(String nomeTeste) {
		String sobra = nomeTeste.replaceAll("[a-zA-Z\\s]", "");
		return (sobra.equals(""));
	}

	public static boolean validaCNPJ(String cnpjTeste) {
		char base = cnpjTeste.charAt(0);
		int cont = 1, primeiroDigito, segundoDigito, a, b;
		cnpjTeste = cnpjTeste.replaceAll("[^\\d]", "");
		if (cnpjTeste.length() != 14) {
			return false;
		}
		for (int i = 1; i < 14; i++) {
			if (cnpjTeste.charAt(i) == base)
				cont++;
		}
		if (cont == 14)
			return false;
		ArrayList<Integer> arraybase = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6));
		primeiroDigito = calculaDigitoCNPJ(arraybase, 12, cnpjTeste, 2);
		a = Character.getNumericValue(cnpjTeste.charAt(12));
		if (a != primeiroDigito)
			return false;
		segundoDigito = calculaDigitoCNPJ(arraybase, 13, cnpjTeste, 1);
		b = Character.getNumericValue(cnpjTeste.charAt(13));
		return (b == segundoDigito);
	}

	public static boolean validaTelefone(String telefone) {
		String sobra = telefone.replaceAll("[0-9\\s-]", "");
		return (sobra.equals(""));
	}

	public static boolean validaData(String data) {
		if (data.length() < 10)
			return false;
		boolean vale = data.matches("\\d{2}/\\d{2}/\\d{4}");
		String ano = Character.toString(data.charAt(6)) + Character.toString(data.charAt(7))
				+ Character.toString(data.charAt(8)) + Character.toString(data.charAt(9));
		String dia = Character.toString(data.charAt(0)) + Character.toString(data.charAt(1));
		String mes = Character.toString(data.charAt(3)) + Character.toString(data.charAt(4));
		int anonum = Integer.parseInt(ano);
		int dianum = Integer.parseInt(dia);
		int mesnum = Integer.parseInt(mes);
		if (!vale)
			return false;
		if (anonum > 2023)
			return false;
		if (mesnum == 2) {
			if ((anonum % 4 != 0) && dianum > 28)
				return false;
			else if (anonum % 4 == 0 && dianum > 29)
				return false;
		}
		if ((mesnum == 1 || mesnum == 3 || mesnum == 5 || mesnum == 7 || mesnum == 8 || mesnum == 10 || mesnum == 12)
				&& dianum > 31)
			return false;

		else if ((mesnum == 4 || mesnum == 6 || mesnum == 9 || mesnum == 11) && dianum > 30)
			return false;
		return true;
	}

}

package HospHub;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivos {
	private static ArrayList<String> caminhosArquivos = new ArrayList<String>();
	
	public static void abrirArquivos(String CPF, String tipo) {
		ArrayList<String> arquivos = arquivosPorCPF(CPF, tipo);
		for (String i : arquivos) {
			abrir(i);
		}
	}
	private static ArrayList<String> arquivosPorCPF(String CPF, String tipo) {
		String diretorioPrincipal = System.getProperty("user.dir") + File.separator + "arquivos";
		if (tipo.equals("laudo")) {
			diretorioPrincipal += File.separator + "laudos";
		} else if (tipo.equals("exame")){
			diretorioPrincipal += File.separator + "exames";
		} else if (tipo.equals("receita")){
			diretorioPrincipal += File.separator + "receitas";
		} else if (tipo.equals("atestado")){
			diretorioPrincipal += File.separator + "atestado";
		}
		listaArquivos(diretorioPrincipal, CPF);
		return caminhosArquivos;
	}
	private static void listaArquivos (String diretorioPrincipal, String CPF) {
        File diretorio = new File(diretorioPrincipal);
        String parteDoNome = CPF;
        ArrayList<String> caminhosArquivos = new ArrayList<String>();
        // Verifica se o diretório existe
        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles();
            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isFile() && arquivo.getName().contains(parteDoNome)) {
                    	caminhosArquivos.add(arquivo.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Diretório não encontrado.");
        }
    }
	private static void abrir(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);

            if (arquivo.exists() && arquivo.isFile()) {
                Desktop.getDesktop().open(arquivo);
            } else {
                System.out.println("Arquivo não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }
}

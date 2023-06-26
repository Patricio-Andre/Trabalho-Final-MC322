package HospHub;

import java.util.LinkedList;
import java.time.LocalDate;
import java.lang.StringBuilder;

public class Receita {
    private String remedio; // nome do composto quimico -> vai ser unico pq a anvisa garante isso
    private String dosagem; // tem que ser String pq tem unidade
    private ProfissionalSaude profissionalSaude;
    private LinkedList<String> listaInterferencias;
    private LocalDate dataVencimento; // so vale pra antibiotico

    public Receita(String remedio, String dosagem, ProfissionalSaude profissionalSaude) {
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.profissionalSaude = profissionalSaude;
        listaInterferencias = new LinkedList<String>();
        dataVencimento = null;
    }

    public Receita(String remedio, String dosagem, ProfissionalSaude profissionalSaude, LocalDate dataVencimento) {
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.profissionalSaude = profissionalSaude;
        listaInterferencias = new LinkedList<String>();
        this.dataVencimento = dataVencimento;
    }

    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public ProfissionalSaude getProfissionalSaude() {
        return profissionalSaude;
    }

    public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
    }

    public LinkedList<String> getListaInterferencias() {
        return listaInterferencias;
    }

    public void setListaInterferencias(LinkedList<String> listaInterferencias) {
        this.listaInterferencias = listaInterferencias;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean addInterferencia(String interferencia) {
        if (listaInterferencias.contains(interferencia)) {
            System.out.println("interferencia ja cadastrada");
            return false;
        }
        listaInterferencias.add(interferencia);
        System.out.println("interferencia cadastrada com sucesso");
        return true;

    }

    public boolean removeInterferencia(String inter) {
        if (!listaInterferencias.contains(inter)) {
            System.out.println("interferencia nao cadastrada"); // poderia dar exception mas ja tem 3
            return true;
        }
        listaInterferencias.remove(inter);
        System.out.println("interferencia removida com sucesso");
        return true;

    }

    public String listarInterferencias() {
        StringBuilder sb = new StringBuilder();
        for (String value : listaInterferencias) {
            sb.append(value);
        }
        return sb.toString().equals("") ? "nao ha interferencias" : sb.toString();
    }

    public String toString() {
        try {
            return " o remedio " + remedio + " de dose " + dosagem + " receitado por " + profissionalSaude
                    + " interfere com " + listarInterferencias() + " essa receita eh valida" +
                    " ateh " + dataVencimento;
        } catch (NullPointerException e) {
            return " o remedio " + remedio + " de dose " + dosagem + " receitado por " + profissionalSaude
                    + " interfere com " + listarInterferencias();
        }
    }
}

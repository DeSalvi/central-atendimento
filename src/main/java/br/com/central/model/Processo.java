package main.java.br.com.central.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Processo {
    private static int contador = 1;
    private int protocolo;
    private String solicitante;
    private String tipoServico;
    private int prioridade;
    private String dataHora;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Processo(String solicitante, String tipoServico, int prioridade) {
        this.protocolo = contador;
        contador++;
        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;
        this.dataHora = LocalDateTime.now().format(formatter);
    }

    @Override
    public String toString() {
        String prioridadeTexto;

        if (prioridade == 1) {
            prioridadeTexto = "Baixa";
        } else if (prioridade == 2) {
            prioridadeTexto = "Normal";
        } else {
            prioridadeTexto = "Urgente";
        }

        return String.format("[#%03d] %s | %s | %s | %s",
                protocolo,
                solicitante,
                tipoServico,
                prioridadeTexto,
                dataHora);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Processo outro = (Processo) obj;

        return this.protocolo == outro.protocolo;
    }

    // Getters

    public int getProtocolo() {
        return protocolo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getDataHora() {
        return dataHora;
    }

    // Setters

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setPrioridade(int prioridade) {
        if (prioridade >= 1 && prioridade <= 3) {
            this.prioridade = prioridade;
        } else {
            System.out.println("Prioridade Invalida! Por favor use 1, 2, ou 3.");
        }
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}

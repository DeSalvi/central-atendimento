package main.java.br.com.central.service;

import main.java.br.com.central.estrutura.PilhaPrioridade;
import main.java.br.com.central.estrutura.PilhaProcesso;
import main.java.br.com.central.exception.PilhaVaziaException;
import main.java.br.com.central.model.Processo;

public class CentralAtendimento {

    private PilhaPrioridade fila;
    private PilhaProcesso historico;

    public CentralAtendimento(int capacidade) {
        this.fila = new PilhaPrioridade(capacidade);
        this.historico = new PilhaProcesso(capacidade);
    }

    public void abrirProcesso(Processo p) {
        fila.push(p);
    }

    public Processo atenderProximo() {
        Processo atendido = fila.pop();
        historico.push(atendido);
        return atendido;
    }

    public Processo desfazerUltimoAtendimento() {
        if (historico.estaVazio())
            throw new PilhaVaziaException();

        Processo processo = historico.pop();
        fila.push(processo);
        return processo;
    }

    public void listarPendentes() {
        System.out.println("Pendentes organizados por prioridade:");
        fila.imprimir();
    }

    public void listarHistorico() {
        historico.imprimir();
    }
}
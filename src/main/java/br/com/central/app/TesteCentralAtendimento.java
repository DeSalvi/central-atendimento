package main.java.br.com.central.app;

import main.java.br.com.central.exception.PilhaVaziaException;
import main.java.br.com.central.model.Processo;
import main.java.br.com.central.service.CentralAtendimento;

public class TesteCentralAtendimento {
    public static void main(String[] args) {
        CentralAtendimento centralAtendimento = new CentralAtendimento();

        // Criação de 4 projetos, deixando o de maior urgência no meio.
        criarProcessoNormal(centralAtendimento);
        criarProcessoBaixoUrgencia(centralAtendimento);
        criarProcessoUrgente(centralAtendimento);
        criarProcessoBaixoUrgencia(centralAtendimento);

        // O processo de maior urgência será atendido primeiro
        atenderProximo(centralAtendimento);

        // Listando o historico para comprovar
        listarHistorico(centralAtendimento);
    }

    private static void criarProcessoUrgente(CentralAtendimento centralAtendimento) {
        Processo p = new Processo("Pedro", "Processo urgente", 3);
        centralAtendimento.abrirProcesso(p);
        System.out.println("Processo gerado e aberto!");
    }

    private static void criarProcessoBaixoUrgencia(CentralAtendimento centralAtendimento) {
        Processo p = new Processo("Vinicius", "Processo pouco urgente", 1);
        centralAtendimento.abrirProcesso(p);
        System.out.println("Processo gerado e aberto!");
    }

    private static void criarProcessoNormal(CentralAtendimento centralAtendimento) {
        Processo p = new Processo("Vinicius", "Processo normal", 2);
        centralAtendimento.abrirProcesso(p);
        System.out.println("Processo gerado e aberto!");
    }

    private static void atenderProximo(CentralAtendimento centralAtendimento) {
        try {
            Processo p = centralAtendimento.atenderProximo();
            System.out.println("Processo sendo atendido:\n" + p);
        } catch (PilhaVaziaException e) {
            System.out.println("Não tem processo na fila!");
        }
    }

    private static void desfazerUltimoAtendimento(CentralAtendimento centralAtendimento) {
        try {
            Processo p = centralAtendimento.desfazerUltimoAtendimento();
            System.out.println("Processo desfeito:\n" + p);
        } catch (PilhaVaziaException e) {
            System.out.println("Não tem processo no histórico!");
        }
    }

    private static void listarPendentes(CentralAtendimento centralAtendimento) {
        try {
            centralAtendimento.listarPendentes();
        } catch (PilhaVaziaException e) {
            System.out.println("Não tem processos pendentes!");
        }
    }

    private static void listarHistorico(CentralAtendimento centralAtendimento) {
        try {
            centralAtendimento.listarHistorico();
        } catch (PilhaVaziaException e) {
            System.out.println("Não tem processos no histórico!");
        }
    }
}

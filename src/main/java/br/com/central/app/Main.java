package main.java.br.com.central.app;

import main.java.br.com.central.exception.PilhaVaziaException;
import main.java.br.com.central.model.Processo;
import main.java.br.com.central.service.CentralAtendimento;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CentralAtendimento centralAtendimento = new CentralAtendimento(10);

        System.out.println("SEJA BEM-VINDO A CENTRAL DE ATENDIMENTO");
        int i;

        boolean rodando = true;
        while (rodando) {
            System.out.println("DIGITE UMA DAS OPÇÕES A SEGUIR:\n" +
                    "1: Gerar e abrir processo\n" +
                    "2: Atender proximo\n" +
                    "3: Desfazer ultimo atendimento\n" +
                    "4: Listar processos pendentes\n" +
                    "5: Listar historico de processos atendidos\n" +
                    "0: Sair");

            i = scanner.nextInt();
            scanner.nextLine();

            switch (i) {
                case 1:
                    criarProcesso(scanner, centralAtendimento);
                    break;
                case 2:
                    atenderProximo(centralAtendimento);
                    break;
                case 3:
                    desfazerUltimoAtendimento(centralAtendimento);
                    break;
                case 4:
                    listarPendentes(centralAtendimento);
                    break;
                case 5:
                    listarHistorico(centralAtendimento);
                    break;
                default:
                    System.out.println("Saindo...");
                    rodando = false;
                    break;
            }
        }
    }

    private static void criarProcesso(Scanner scanner, CentralAtendimento centralAtendimento) {
        System.out.println("Digite o nome do solicitante:");
        String solicitante = scanner.nextLine();

        System.out.println("Digite o tipo de serviço:");
        String tipoServico = scanner.nextLine();

        System.out.println("Digite o nivel de prioridade (1 baixa, 2 normal, 3 urgente):");
        int prioridade = scanner.nextInt();
        scanner.nextLine();

        Processo p = new Processo(solicitante, tipoServico, prioridade);

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
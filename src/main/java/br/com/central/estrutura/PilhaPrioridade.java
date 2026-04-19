package main.java.br.com.central.estrutura;

import main.java.br.com.central.exception.PilhaVaziaException;
import main.java.br.com.central.model.Processo;

public class PilhaPrioridade {
    private PilhaProcesso pilhaUrgente;
    private PilhaProcesso pilhaNormal;
    private PilhaProcesso pilhaBaixa;

    public PilhaPrioridade() {
        this.pilhaUrgente = new PilhaProcesso();
        this.pilhaNormal = new PilhaProcesso();
        this.pilhaBaixa = new PilhaProcesso();
    }

    public void push(Processo processo) {
        int prioridade = processo.getPrioridade();

        if (prioridade == 3) {
            pilhaUrgente.push(processo);
        } else if (prioridade == 2) {
            pilhaNormal.push(processo);
        } else {
            pilhaBaixa.push(processo);
        }
    }

    public boolean estaVazio() {
        return pilhaUrgente.estaVazio()
                && pilhaNormal.estaVazio()
                && pilhaBaixa.estaVazio();
    }

    public Processo pop() {
        if (!pilhaUrgente.estaVazio()) {
            return pilhaUrgente.pop();
        } else if (!pilhaNormal.estaVazio()) {
            return pilhaNormal.pop();
        } else if (!pilhaBaixa.estaVazio()) {
            return pilhaBaixa.pop();
        } else {
            throw new PilhaVaziaException();
        }
    }

    public void imprimir() {
        if (pilhaUrgente.estaVazio() &&
                pilhaNormal.estaVazio() &&
                pilhaBaixa.estaVazio()) {

            throw new PilhaVaziaException();
        }

        if (!pilhaUrgente.estaVazio()) {
            System.out.println("=== URGENTE ===");
            pilhaUrgente.imprimir();
        }

        if (!pilhaNormal.estaVazio()) {
            System.out.println("=== NORMAL ===");
            pilhaNormal.imprimir();
        }

        if (!pilhaBaixa.estaVazio()) {
            System.out.println("=== BAIXA ===");
            pilhaBaixa.imprimir();
        }
    }
}

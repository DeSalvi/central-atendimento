package main.java.br.com.central.app;

import main.java.br.com.central.estrutura.PilhaProcesso;
import main.java.br.com.central.model.Processo;

public class TestePilhaProcesso {
    public static void main(String[] args) {
        PilhaProcesso pilha = new PilhaProcesso(10);
        pilha.pop(); // Testar a exception PilhaVaziaException
        pilha.push(new Processo("Vinicius", "1", 1));
        pilha.push(new Processo("Vinicius", "2", 1));
        pilha.push(new Processo("Vinicius", "3", 1));
        pilha.push(new Processo("Vinicius", "4", 1));
        pilha.peek();
        pilha.imprimir();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.peek();
        pilha.imprimir();
    }
}

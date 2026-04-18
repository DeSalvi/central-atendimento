package main.java.br.com.central.estrutura;

import main.java.br.com.central.model.Processo;

public class PilhaPrioridade{
    private PilhaProcesso pilhaBaixa;
    private PilhaProcesso pilhaNormal;
    private PilhaProcesso pilhaUrgente;

    public PilhaPrioridade(){
        this.pilhaBaixa = new PilhaProcesso();
        this.pilhaNormal = new PilhaProcesso();
        this.pilhaUrgente = new PilhaProcesso();
    }

    public void push(Processo p){
        int i = p.getPrioridade();

        if(i ==1)
            pilhaBaixa.push(p);
        else if (i ==2)
            pilhaNormal.push(p);
        else if (i ==3)
            pilhaUrgente.push(p);
        else throw new IllegalArgumentException();
    }

    public void pop(){
        if(!pilhaUrgente.estaVazio()){
            pilhaUrgente.pop();
        }else if(!pilhaNormal.estaVazio()){
            pilhaNormal.pop();
        }else {
            pilhaBaixa.pop();
        }
    }

    public void peek(){
        if(!pilhaUrgente.estaVazio()){
            pilhaUrgente.peek();
        }else if(!pilhaNormal.estaVazio()){
            pilhaNormal.peek();
        }else {
            pilhaBaixa.peek();
        }
    }

    public int tamanho(){
        return pilhaBaixa.getTamanho() + pilhaNormal.getTamanho() + pilhaUrgente.getTamanho();
    }

    public void listar(){
        System.out.println("Urgentes:");
        pilhaUrgente.imprimir();
        System.out.println("------------");
        System.out.println("Normal");
        pilhaNormal.imprimir();
        System.out.println("------------");
        System.out.println("Baixa");
        pilhaBaixa.imprimir();
    }
}
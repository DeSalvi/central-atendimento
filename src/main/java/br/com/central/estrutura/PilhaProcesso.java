package main.java.br.com.central.estrutura;

import main.java.br.com.central.exception.PilhaVaziaException;
import main.java.br.com.central.model.Processo;

public class PilhaProcesso {
    private VetorDinamico vetorDinamico;
    private int ocupacao;

    public PilhaProcesso(int capacidade){
        this.vetorDinamico = new VetorDinamico(capacidade);
        this.ocupacao = 0;
    }

    public void push (Processo processo){
        vetorDinamico.add(processo);
        ocupacao++;
    }

    public void pop(){
        if (vetorDinamico.estaVazio())
            throw new PilhaVaziaException();
        vetorDinamico.remove();
        ocupacao--;
    }

    public Processo peek(){
        if (vetorDinamico.estaVazio())
            throw new PilhaVaziaException();
        System.out.println(vetorDinamico.peek());
        return vetorDinamico.peek();
    }

    public void imprimir(){
        if (vetorDinamico.estaVazio())
            throw new PilhaVaziaException();
        vetorDinamico.imprimir();
    }
}

package main.java.br.com.central.estrutura;

import main.java.br.com.central.exception.PilhaVaziaException;
import main.java.br.com.central.model.Processo;

public class PilhaProcesso {
    private VetorDinamico vetorDinamico;

    public PilhaProcesso(){
        this.vetorDinamico = new VetorDinamico();
    }

    public void push (Processo processo){
        vetorDinamico.add(processo);
    }

    public Processo pop(){
        if (vetorDinamico.estaVazio())
            throw new PilhaVaziaException();
        return vetorDinamico.remove();
    }

    public Processo peek(){
        if (vetorDinamico.estaVazio())
            throw new PilhaVaziaException();
        return vetorDinamico.peek();
    }

    public void imprimir(){
        if (vetorDinamico.estaVazio())
            throw new PilhaVaziaException();
        vetorDinamico.imprimir();
    }

    public boolean estaVazio() {
    return vetorDinamico.estaVazio();
}
}

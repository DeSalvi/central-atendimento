package main.java.br.com.central.estrutura;

import main.java.br.com.central.model.Processo;

public class VetorDinamico {
    private Processo[] v;
    private int capacidade;
    private int ocupacao;

    public VetorDinamico(int capacidade_inicial) {
        v = new Processo[capacidade_inicial];
        capacidade = capacidade_inicial;
        ocupacao = 0;
    }

    public boolean estaCheio() {
        if (capacidade == ocupacao)
            return true;
        else
            return false;
    }

    private void redimensiona(int novaCapacidade) {
        Processo[] temp = new Processo[novaCapacidade];
        for (int i = 0; i < ocupacao; i++) {
            temp[i] = v[i];
        }
        v = temp;
        capacidade = novaCapacidade;
    }

    public void add(Processo p) {
        if (estaCheio())
            redimensiona(capacidade * 2);
        v[ocupacao++] = p;
    }
}

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
        return capacidade == ocupacao;
    }

    public boolean estaVazio(){
        return ocupacao == 0;
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

    public Processo remove(){
        if(estaVazio())
            return null;

        Processo aux = v[--ocupacao];
        if(capacidade >= 10 && ocupacao <= capacidade / 4)
            redimensiona(capacidade / 2);

        return aux;
    }

    public void listar(){
        for (int i=0; i< ocupacao; i++){
            System.out.println(v[i].toString());
        }
    }

    public void imprimir(){
        for (int i=ocupacao-1; i>= 0; i--){
            System.out.println(v[i].toString());
        }
    }

    public int buscarPorProtocolo(int protocolo){
        for (int i = 0; i < ocupacao; i++){
            if (v[i].getProtocolo() == protocolo) {
                return i;
            }
        }
        return -1;
    }

    public void preencheVetor(){
        for (int i=ocupacao; i < capacidade; i++){
        v[i] = new Processo("Vinicius",""+(i+1), 1);
        }
        ocupacao = capacidade;
        redimensiona(capacidade * 2);
    }

    public Processo peek(){
        return v[ocupacao-1];
    }
}

package main.java.br.com.central.app;

import main.java.br.com.central.estrutura.VetorDinamico;

public class TesteVetor {
    public static void main(String[] args) {
        VetorDinamico vetorDinamico = new VetorDinamico(3);
        vetorDinamico.preencheVetor();
        vetorDinamico.preencheVetor();
        vetorDinamico.preencheVetor();
        vetorDinamico.listar();
        System.out.println("------------------------------------");
        vetorDinamico.remove();
        vetorDinamico.remove();
        vetorDinamico.remove();
        vetorDinamico.remove();
        vetorDinamico.remove();
        vetorDinamico.remove();
        vetorDinamico.listar();
        System.out.println(vetorDinamico.buscarPorProtocolo(1));
        System.out.println(vetorDinamico.buscarPorProtocolo(0));
        System.out.println(vetorDinamico.buscarPorProtocolo(10));
    }
}

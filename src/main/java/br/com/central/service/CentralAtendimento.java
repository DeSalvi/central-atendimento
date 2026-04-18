package main.java.br.com.central.service;

import main.java.br.com.central.estrutura.PilhaProcesso;
import main.java.br.com.central.model.Processo;

public class CentralAtendimento{
    public PilhaProcesso pilhaPrincipal;
    public PilhaProcesso pilhaAuxiliar;

<<<<<<< HEAD
    public CentralAtendimento(int capacidade){
        this.pilhaPrincipal = new PilhaProcesso(capacidade);
        this.pilhaAuxiliar = new PilhaProcesso(capacidade);
    }

=======
>>>>>>> 7369661 (feat: Implementa PilhaPrioridade e ajuste nas classes)
    public CentralAtendimento(){
        this.pilhaPrincipal = new PilhaProcesso();
        this.pilhaAuxiliar = new PilhaProcesso();
    }

    public void abrirProcesso(Processo p){
        pilhaPrincipal.push(p);
<<<<<<< HEAD
//        pilhaAuxiliar.pop();
=======
        pilhaAuxiliar.limpar();
>>>>>>> 7369661 (feat: Implementa PilhaPrioridade e ajuste nas classes)
    }

    public void atenderProximo(){
        pilhaAuxiliar.push(pilhaPrincipal.peek());
        pilhaPrincipal.pop();
    }

    public void desfazerUltimoAtendimento(){
        pilhaPrincipal.push(pilhaAuxiliar.peek());
        pilhaAuxiliar.pop();
    }

    public void listarPendentes(){
        pilhaPrincipal.imprimir();
    }

    public void listarHistorico(){
        pilhaAuxiliar.imprimir();
    }
}
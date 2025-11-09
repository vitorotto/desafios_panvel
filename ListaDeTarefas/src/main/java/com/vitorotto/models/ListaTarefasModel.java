package com.vitorotto.models;

import java.util.ArrayList;

public class ListaTarefasModel {
    private NoModel<TarefaModel> inicio;
    private int tamanho;
    private NoModel<TarefaModel> ultimo;

    private int proximoId = 1;

    public ListaTarefasModel() {
        this.inicio = null;
        this.tamanho = 0;
        this.ultimo = null;
    }

    public void adicionar(String titulo, String descricao) {
        String statusTarefa = "PENDENTE";
        TarefaModel novaTarefa = new TarefaModel(proximoId++, titulo, descricao, statusTarefa);
        NoModel<TarefaModel> novoNo = new NoModel<>(novaTarefa);
        if (this.tamanho == 0) {
            this.inicio = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
        }
        this.ultimo = novoNo;
        this.tamanho++;
    }

    public ArrayList<TarefaModel> listar() {
        ArrayList<TarefaModel> listaResultado = new ArrayList<>();

        NoModel<TarefaModel> atual = this.inicio;

        while (atual != null) {
            listaResultado.add(atual.getElemento());
            atual = atual.getProximo();
        }

        return listaResultado;
    }

    public TarefaModel buscarTarefa(int id) {
        NoModel<TarefaModel> noAtual = this.inicio;

        while (noAtual != null) {
            if (noAtual.getElemento().getId() == id) {
                return noAtual.getElemento();
            }
            noAtual = noAtual.getProximo();
        }
        return null;
    }

    public NoModel<TarefaModel> buscarNo(int id) {
        NoModel<TarefaModel> noAtual = this.inicio;

        while (noAtual != null) {
            if (noAtual.getElemento().getId() == id) {
                return noAtual;
            }
            noAtual = noAtual.getProximo();
        }
        return null;
    }

    public boolean marcarConcluida(int id) {
        NoModel<TarefaModel> noEncontrado = buscarNo(id);
        if (noEncontrado != null) {
            noEncontrado.getElemento().setStatus("FINALIZADA");
            return true;
        }
        return false;
    }

    public boolean remover(int id) {
        NoModel<TarefaModel> atual = this.inicio;
        NoModel<TarefaModel> anterior = null;

        while (atual != null) {
            if (atual.getElemento().getId() == id) {
                this.tamanho--;
                if (anterior == null) {
                    this.inicio = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }

                if (this.ultimo == atual) {
                    this.ultimo = anterior;
                }

                return true; 
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return false;
    }

    public int total() {
        return  this.tamanho;
    }

    public void limpar() {
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public String toString() {

        if (this.tamanho == 0) {
            return "[ Nenhuma tarefa cadastrada ]";
        }

        StringBuilder sb = new StringBuilder("");
        NoModel<TarefaModel> atual = this.inicio;
        
        for (int i = 0; i < this.tamanho - 1; i++) {
            sb.append(atual.getElemento()).append("");
            atual = atual.getProximo();
        }

        sb.append(atual.getElemento()).append("");

        return sb.toString();
    }

    
}

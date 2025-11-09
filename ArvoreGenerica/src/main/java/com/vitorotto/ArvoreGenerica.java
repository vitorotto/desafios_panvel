package com.vitorotto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreGenerica {

    private Nodo nodo;
    private final List<ArvoreGenerica> filhos;

    public ArvoreGenerica() {
        this.nodo = null;
        this.filhos = new ArrayList<>();
    }

    public ArvoreGenerica(Nodo nodo) {
        this.nodo = nodo;
        this.filhos = new ArrayList<>();
    }

    public boolean arvoreVazia() {
        return this.nodo == null;
    }

    public boolean inserir(Nodo pai, Nodo novoFilho) {

        // Se a arvore estiver vazia
        if (arvoreVazia()) {
            this.nodo = novoFilho;
            System.out.println("Definida raiz: " + novoFilho.getValor());
            return true;
        }

        // Se o no atual é o pai
        if (this.nodo.equals(pai)) {
            ArvoreGenerica novaArvoreFilho = new ArvoreGenerica(novoFilho);
            this.filhos.add(novaArvoreFilho);
            return true;
        }

        // Percorrendo recursivamente tentando inserir
        for (ArvoreGenerica filho : this.filhos) {
            if (filho.inserir(pai, novoFilho)) {
                return true;
            }
        }

        return false;
    }

    // Método para percorrer a árvore e exebir uma lista com o formato solicitado
    public List<List<Integer>> pegarTravessiaPorNivel() {
        List<List<Integer>> resultado = new ArrayList<>();

        if (arvoreVazia()) {
            return resultado;
        }

        Queue<ArvoreGenerica> fila = new LinkedList<>();
        fila.offer(this);

        while (!fila.isEmpty()) {
            int tamanhoDoNivel = fila.size();
            List<Integer> valoresDoNivelAtual = new ArrayList<>();

            for (int i = 0; i < tamanhoDoNivel; i++) {
                ArvoreGenerica nodoAtual = fila.poll();
                valoresDoNivelAtual.add(nodoAtual.nodo.getValor());
                for (ArvoreGenerica filho : nodoAtual.filhos) {
                    fila.offer(filho);
                }
            }
            resultado.add(valoresDoNivelAtual);
        }
        return resultado;
    }
}

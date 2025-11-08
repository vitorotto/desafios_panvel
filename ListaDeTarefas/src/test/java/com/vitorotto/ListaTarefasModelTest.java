package com.vitorotto;

import com.vitorotto.models.ListaTarefasModel;

public class ListaTarefasModelTest {
    public static void main(String[] args) {
        ListaTarefasModel lista = new ListaTarefasModel();

        lista.adicionar("Tarefa 01", "Descricao 01");
        lista.adicionar("Tarefa 02", "Descricao 02");
        lista.adicionar("Tarefa 03", "Descricao 03");
        
        // System.out.println(lista.listar());
        lista.remover(3);
        lista.remover(1);

        lista.adicionar("Tarefa 04", "Descricao 04");
        lista.marcarConcluida(4);

        lista.adicionar("Tarefa 05", "Descricao 05");
        lista.adicionar("Tarefa 06", "Descricao 06");


        System.out.println(lista.listar());

    }
}

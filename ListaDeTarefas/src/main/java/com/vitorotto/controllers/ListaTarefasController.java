package com.vitorotto.controllers;

import java.util.ArrayList;

import com.vitorotto.dtos.TarefaDTO;
import com.vitorotto.models.ListaTarefasModel;
import com.vitorotto.models.TarefaModel;
import com.vitorotto.views.ListaTarefasView;

public class ListaTarefasController {

    private final ListaTarefasModel model;
    private final ListaTarefasView view;

    public ListaTarefasController(ListaTarefasModel model, ListaTarefasView view) {
        this.model = model;
        this.view = view;
    }

    // Inicilização do loop principal do código
    public void iniciar() {
        boolean executando = true;
        while (executando) {

            view.mostrarMenu();

            int opcao = view.lerOpc();

            executando = processarOpcao(opcao);
        }
    }

    private boolean processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> adicionarTarefa();
            case 2 -> listarTarefas();
            case 3 -> marcarTarefaConcluida();
            case 4 -> removerTarefa();
            case 5 -> mostrarTotal();
            case 6 -> limparTudo();
            case 7 -> buscarTarefa();
            case 0 -> {
                view.mostrarMensagem("Até logo!");
                return false;
            }
            default -> view.mostrarMensagem("Opção inválida. Tente novamente.");
        }
        return true;
    }

    private void adicionarTarefa() {
        String titulo = view.lerTituloTarefa();
        String descricao = view.lerDescricaoTarefa();

        model.adicionar(titulo, descricao);

        view.mostrarMensagem("Tarefa adicionada com sucesso!");
    }

    private void listarTarefas() {
        if (model.total() == 0) {
            view.mostrarMensagem("Nenhuma tarefa cadastrada");
            return;
        }
        ArrayList<TarefaModel> tarefasDoModel = model.listar();
        ArrayList<TarefaDTO> tarefasDTO = new ArrayList<>();

        for (TarefaModel tarefaModel : tarefasDoModel) {
            TarefaDTO dto = new TarefaDTO(tarefaModel.getDescricao(), tarefaModel.getId(), tarefaModel.getStatus(), tarefaModel.getTitulo());
            tarefasDTO.add(dto);
        }
        view.mostrarLista(tarefasDTO);
    }

    private void buscarTarefa() {
        if (model.total() == 0) {
            view.mostrarMensagem("Nenhuma tarefa cadastrada");
            return;
        }
        int id = view.lerIdTarefa("buscar");
        TarefaModel tarefa = model.buscarTarefa(id);
        if (tarefa == null) {
            view.mostrarMensagem("Erro: Tarefa #" + id + " não encontrada.");
        } else {
            view.mostrarMensagem("Tarefa #" + id + " encontrada.");
            TarefaDTO dto = new TarefaDTO(tarefa.getDescricao(), tarefa.getId(), tarefa.getStatus(), tarefa.getTitulo());
            view.mostrarTarefa(dto);
        }
    }

    private void limparTudo() {
        if (model.total() == 0) {
            view.mostrarMensagem("Nenhuma tarefa cadastrada");
        } else {
            model.limpar();
            view.mostrarMensagem("Histórico limpo");
        }
    }

    private void marcarTarefaConcluida() {
        if (model.total() == 0) {
            view.mostrarMensagem("Nenhuma tarefa cadastrada");
            return;
        }
        int id = view.lerIdTarefa("marcar como concluída");
        boolean sucesso = model.marcarConcluida(id);
        if (sucesso) {
            view.mostrarMensagem("Tarefa #" + id + " marcada como concluída.");
        } else {
            view.mostrarMensagem("Erro: Tarefa #" + id + " não encontrada.");
        }
    }

    private void removerTarefa() {
        if (model.total() == 0) {
            view.mostrarMensagem("Nenhuma tarefa cadastrada");
            return;
        }
        int id = view.lerIdTarefa("remover");
        boolean sucesso = model.remover(id);
        if (sucesso) {
            view.mostrarMensagem("Tarefa #" + id + " removida com sucesso.");
        } else {
            view.mostrarMensagem("Erro: Tarefa #" + id + " não encontrada.");
        }
    }

    private void mostrarTotal() {
        int total = model.total();
        view.mostrarMensagem("Total de tarefas: " + total);
    }
}

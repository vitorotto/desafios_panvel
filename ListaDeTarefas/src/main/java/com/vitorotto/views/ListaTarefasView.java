package com.vitorotto.views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.vitorotto.controllers.ListaTarefasController;
import com.vitorotto.dtos.TarefaDTO;

public class ListaTarefasView {
    private final Scanner scanner;
    private ListaTarefasController controller;

    public ListaTarefasView() {
        this.scanner = new Scanner(System.in);
    }

    public void setController(ListaTarefasController controller) {
        this.controller = controller;
    }

    public void mostrarMenu() {
        System.out.println("\n========= MENU DE TAREFAS =========");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Remover Tarefa");
        System.out.println("5. Ver Total de Tarefas");
        System.out.println("6. Limpar tudo");
        System.out.println("7. Buscar tarefa");
        System.out.println("0. Sair");
        System.out.println("===================================");
        System.out.print("Escolha uma opção: ");
    }

    public void mostrarLista(ArrayList<TarefaDTO> tarefas) {
        if (tarefas.isEmpty()) {
            mostrarMensagem("Nenhuma tarefa na lista.");
            return;
        }

        System.out.println("\n---------- LISTA DE TAREFAS ----------");
        
        for (TarefaDTO tarefa : tarefas) { 
            System.out.println("--------------------------------------");
            System.out.println(" ID: " + tarefa.getId());
            System.out.println(" Título: " + tarefa.getTitulo());
            System.out.println(" Descrição: " + tarefa.getDescricao());
            System.out.println(" Status: " + tarefa.getStatus());
        }
        System.out.println("--------------------------------------");
    }

    public void mostrarTarefa(TarefaDTO tarefa) {
        if (tarefa == null) {
            mostrarMensagem("Tarefa não encontrada com esse ID");
        }
        System.out.println("\n---------- SUA TAREFA ----------");
        System.out.println(" ID: " + tarefa.getId());
        System.out.println(" Título: " + tarefa.getTitulo());
        System.out.println(" Descrição: " + tarefa.getDescricao());
        System.out.println(" Status: " + tarefa.getStatus());
        System.out.println("----------------------------------");
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println("MSG: " + mensagem);
    }

    public int lerOpc() {
        return lerInt("Escolha uma opcão: ");
    }

    public int lerIdTarefa(String acao) {
        System.out.print("Digite o ID da tarefa que deseja " + acao + ": ");
        return lerInt("Digite o ID da tarefa que deseja " + acao + ": ");
    }

    public String lerTituloTarefa() {
        System.out.print("Digite o título da tarefa: ");
        return scanner.nextLine();
    }

    public String lerDescricaoTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        return scanner.nextLine();
    }

    private int lerInt(String promptRepetido) {
        while (true) { // Loop infinito até receber um inteiro válido
            try {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\nErro: Por favor, digite um NÚMERO válido.");
                System.out.print(promptRepetido);
            }
        }
    }
}

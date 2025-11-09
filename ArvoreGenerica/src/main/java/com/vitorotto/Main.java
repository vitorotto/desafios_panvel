package com.vitorotto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArvoreGenerica arvore = new ArvoreGenerica();

        // Declarando nos do exemplo
        Nodo f1  = new Nodo(1);
        Nodo f10 = new Nodo(10);
        Nodo f20 = new Nodo(20);
        Nodo f50 = new Nodo(50);
        Nodo f25 = new Nodo(25);
        Nodo f35 = new Nodo(35);

        System.out.println("--- Inserindo Nós ---");
        arvore.inserir(null, f1);  // Insere 1 como raiz (pai é null por que é o primeiro valor da arvore)
        arvore.inserir(f1, f10);   // Insere 10 como filho de 1
        arvore.inserir(f1, f20);   // Insere 20 como filho de 1
        arvore.inserir(f1, f50);   // Insere 50 como filho de 1
        arvore.inserir(f20, f25);  // Insere 25 como filho de 30
        arvore.inserir(f20, f35);  // Insere 35 como filho de 30

        List<List<Integer>> saida = arvore.pegarTravessiaPorNivel();
        
        System.out.println("\nSaída da Travessia por Nível:");
        System.out.println(saida);
    }
}

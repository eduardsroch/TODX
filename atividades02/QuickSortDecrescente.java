package atividades02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSortDecrescente {
    public static void main(String[] args) {
        // Criando um ArrayList com números inteiros
        List<Integer> lista = new ArrayList<>();
        Random rand = new Random();

        // Adicionando números aleatórios ao ArrayList
        for (int i = 0; i < 10; i++) {
            lista.add(rand.nextInt(100)); // Números aleatórios entre 0 e 99
        }

        System.out.println("Lista Original: " + lista);

        // Ordenando a lista usando Quick Sort
        quickSort(lista, 0, lista.size() - 1);

        System.out.println("Lista Ordenada em Ordem Decrescente: " + lista);
    }

    // Método de ordenação Quick Sort
    public static void quickSort(List<Integer> lista, int inicio, int fim) {
        if (inicio < fim) {
            int p = particionar(lista, inicio, fim);
            quickSort(lista, inicio, p - 1); // Recursão na parte esquerda
            quickSort(lista, p + 1, fim);     // Recursão na parte direita
        }
    }

    // Método de particionamento
    public static int particionar(List<Integer> lista, int inicio, int fim) {
        int pivot = lista.get(fim); // O pivô é o último elemento
        int i = inicio - 1; // Índice do menor elemento

        for (int j = inicio; j < fim; j++) {
            // Se o elemento atual for maior que o pivô, troca
            if (lista.get(j) > pivot) {
                i++;
                trocar(lista, i, j);
            }
        }
        // Troca o pivô com o elemento na posição i+1
        trocar(lista, i + 1, fim);
        return i + 1; // Retorna o índice do pivô
    }

    // Método auxiliar para trocar elementos
    public static void trocar(List<Integer> lista, int i, int j) {
        int temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}

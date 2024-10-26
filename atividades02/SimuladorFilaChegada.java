package atividades02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SimuladorFilaChegada {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String nome;
        int quantidade;

        // Solicita a quantidade de pessoas que chegarão
        System.out.print("Digite a quantidade de pessoas que chegarão à fila: ");
        quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Adiciona as pessoas à fila
        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o nome da pessoa " + i + ": ");
            nome = scanner.nextLine();
            fila.add(nome);
            System.out.println(nome + " foi adicionada à fila.");
        }

        // Exibe a ordem de saída
        System.out.println("\n=== Ordem de Saída da Fila ===");
        while (!fila.isEmpty()) {
            String removido = fila.remove();
            System.out.println(removido + " saiu da fila.");
        }

        scanner.close();
    }
}

package atividades02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaFilaEspera {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema de Fila de Espera ===");
            System.out.println("1. Adicionar à Fila");
            System.out.println("2. Remover da Fila");
            System.out.println("3. Exibir Fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome para adicionar à fila: ");
                    String nome = scanner.nextLine();
                    fila.add(nome);
                    System.out.println(nome + " foi adicionado à fila.");
                    break;
                case 2:
                    if (!fila.isEmpty()) {
                        String removido = fila.remove();
                        System.out.println(removido + " foi removido da fila.");
                    } else {
                        System.out.println("A fila está vazia.");
                    }
                    break;
                case 3:
                    if (!fila.isEmpty()) {
                        System.out.println("Elementos na fila: " + fila);
                    } else {
                        System.out.println("A fila está vazia.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class listas {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar número");
            System.out.println("2. Remover número");
            System.out.println("3. Exibir lista");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um número para adicionar: ");
                    int numeroAdicionar = scanner.nextInt();
                    lista.add(numeroAdicionar);
                    System.out.println(numeroAdicionar + " foi adicionado.");
                    break;

                case 2:
                    System.out.print("Digite o índice do número para remover: ");
                    int indice = scanner.nextInt();
                    if (indice >= 0 && indice < lista.size()) {
                        int removido = lista.remove(indice);
                        System.out.println(removido + " foi removido.");
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;

                case 3:
                    System.out.println("Lista atual: " + lista);
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}

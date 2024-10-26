import java.util.ArrayList;
import java.util.Scanner;

class ItemEstoque {
    private String nome;
    private int quantidade;
    private double preco;

    // Construtor
    public ItemEstoque(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método para exibir as informações do item
    @Override
    public String toString() {
        return "Nome: " + nome + ", Quantidade: " + quantidade + ", Preço: R$ " + preco;
    }
}

public class GerenciamentoEstoque {
    private static ArrayList<ItemEstoque> estoque = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar item");
            System.out.println("2. Exibir estoque");
            System.out.println("3. Atualizar item");
            System.out.println("4. Remover item");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    exibirEstoque();
                    break;
                case 3:
                    atualizarItem();
                    break;
                case 4:
                    removerItem();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    // Método para adicionar um novo item ao estoque
    private static void adicionarItem() {
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer

        estoque.add(new ItemEstoque(nome, quantidade, preco));
        System.out.println("Item adicionado com sucesso!");
    }

    // Método para exibir todos os itens do estoque
    private static void exibirEstoque() {
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Itens no estoque:");
            for (ItemEstoque item : estoque) {
                System.out.println(item);
            }
        }
    }

    // Método para atualizar um item no estoque
    private static void atualizarItem() {
        System.out.print("Digite o nome do item a ser atualizado: ");
        String nome = scanner.nextLine();

        for (ItemEstoque item : estoque) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Digite a nova quantidade: ");
                int novaQuantidade = scanner.nextInt();
                System.out.print("Digite o novo preço: ");
                double novoPreco = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer

                item.setQuantidade(novaQuantidade);
                item.setPreco(novoPreco);
                System.out.println("Item atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }

    // Método para remover um item do estoque
    private static void removerItem() {
        System.out.print("Digite o nome do item a ser removido: ");
        String nome = scanner.nextLine();

        for (ItemEstoque item : estoque) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                estoque.remove(item);
                System.out.println("Item removido com sucesso!");
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }
}

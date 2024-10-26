import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    private String nome;
    private int idade;
    private String endereco;

    // Construtor
    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    // Método para exibir informações da pessoa
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Endereço: " + endereco;
    }
}

public class poo {
    private static ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar pessoa");
            System.out.println("2. Exibir lista de pessoas");
            System.out.println("3. Remover pessoa pelo nome");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarPessoa();
                    break;
                case 2:
                    exibirPessoas();
                    break;
                case 3:
                    removerPessoa();
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    // Método para adicionar uma pessoa
    private static void adicionarPessoa() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade, endereco);
        listaDePessoas.add(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");
    }

    // Método para exibir todas as pessoas na lista
    private static void exibirPessoas() {
        if (listaDePessoas.isEmpty()) {
            System.out.println("A lista de pessoas está vazia.");
        } else {
            System.out.println("Lista de Pessoas:");
            for (Pessoa pessoa : listaDePessoas) {
                System.out.println(pessoa);
            }
        }
    }

    // Método para remover uma pessoa pelo nome
    private static void removerPessoa() {
        System.out.print("Digite o nome da pessoa a ser removida: ");
        String nome = scanner.nextLine();

        boolean encontrada = false;
        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                listaDePessoas.remove(pessoa);
                System.out.println("Pessoa removida com sucesso!");
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Pessoa não encontrada.");
        }
    }
}

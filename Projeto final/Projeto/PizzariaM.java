package Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PizzariaM {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();
        
        boolean continuar = true;
        while (continuar) {
            System.out.println();
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Fazer um novo pedido");
            System.out.println("2 - Alterar um pedido");
            System.out.println("3 - Adicionar um cliente");
            System.out.println("4 - Gerar relatório de vendas");
            System.out.println("5 - Gerar lista de clientes");
            System.out.println("6 - Calcular frete");
            System.out.println("9 - Sair");
            
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
            switch (opcao) {
                case 1:
                    fazerPedido(scanner, listaPedidos, listaClientes);
                    break;
                case 2:
                    alterarPedido(scanner, listaPedidos);
                    break;
                case 3:
                    listaClientes.add(adicionarCliente(scanner)); 
                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                case 4:
                    gerarRelatorio(listaPedidos);
                    break;
                case 5:
                    gerarListaClientes(listaClientes);
                    break;
                case 6:
                    calcularFrete(scanner);
                    break;
                case 9:
                    System.out.println("Até amanhã...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {
        List<Pizza> pizzas = new ArrayList<>();
        System.out.println("FAZER PEDIDO");
        
        int x = 1;
        System.out.println("Selecione um cliente: ");
        for (Cliente cliente : listaClientes) {
            System.out.println(x + " - " + cliente.getNome());
            x++;
        }
        System.out.print("Opção: ");
        int clienteIndex = scanner.nextInt() - 1; // Ajuste para índice 0
        scanner.nextLine();
        
        boolean continuar = true;
        while (continuar) {
            x = 1;
            System.out.println("Qual o tamanho da pizza? ");
            System.out.println("Selecione um tamanho: ");
            for (Pizza.TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                System.out.println(x + " - " + tamanhos);
                x++;
            }
            System.out.print("Opção: ");
            int tamanhoIndex = scanner.nextInt() - 1; // Ajuste para índice 0
            scanner.nextLine();
            
            int quantiSabores = 0;
            while (quantiSabores < 1 || quantiSabores > 4) {
                System.out.println("Digite a quantidade de sabores: 1 - 4 ");
                System.out.print("Opção: ");
                quantiSabores = scanner.nextInt();
                scanner.nextLine();
            }
            
            Cardapio cardapio = new Cardapio();
            List<String> saboresSelect = new ArrayList<>();
            
            for (int i = 0; i < quantiSabores; i++) {
                System.out.println("Selecione um sabor: ");
                x = 1;
                for (String sabor : cardapio.getCardapio().keySet()) {
                    System.out.println(x + " - " + sabor);
                    x++;
                }
                System.out.print("Opção: ");
                int saborIndex = scanner.nextInt() - 1; // Ajuste para índice 0
                scanner.nextLine();
                String saborEscolhido = (String) cardapio.getCardapio().keySet().toArray()[saborIndex];
                saboresSelect.add(saborEscolhido);
            }
            
            Pizza pizza = new Pizza(saboresSelect, cardapio.getPrecoJusto(saboresSelect), Pizza.TamanhoPizza.getByIndex(tamanhoIndex));
            pizzas.add(pizza);
            
            System.out.println("Pizza cadastrada com sucesso!");
            System.out.println();
            System.out.println("Deseja cadastrar mais uma pizza no pedido?");
            System.out.print("1 - Sim, 2 - Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if(opcao != 1) {
                continuar = false;
            }
        }
        Pedido pedido = new Pedido(listaPedidos.size() + 1, listaClientes.get(clienteIndex), pizzas, somarPizzas(pizzas));
        listaPedidos.add(pedido);
    }

    private static double somarPizzas(List<Pizza> pizzas) {
        double valorTotal = 0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
        }
        return valorTotal;
    }

    private static void alterarPedido(Scanner scanner, List<Pedido> listaPedidos) {
        System.out.println("ALTERAR PEDIDO");
        System.out.print("Digite o ID do pedido ou nome do cliente: ");
        String entrada = scanner.nextLine();
        
        Pedido pedidoEncontrado = null;
        
        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == Integer.parseInt(entrada) || pedido.getCliente().getNome().equalsIgnoreCase(entrada)) {
                pedidoEncontrado = pedido;
                break;
            }
        }
        
        if (pedidoEncontrado == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }
        
        System.out.println("Pedido encontrado! ID: " + pedidoEncontrado.getId());
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Adicionar pizza");
            System.out.println("2 - Remover pizza");
            System.out.println("3 - Alterar sabor de uma pizza");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    adicionarPizza(pedidoEncontrado, scanner);
                    break;
                case 2:
                    removerPizza(pedidoEncontrado, scanner);
                    break;
                case 3:
                    alterarSaborPizza(pedidoEncontrado, scanner);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void adicionarPizza(Pedido pedido, Scanner scanner) {
        Cardapio cardapio = new Cardapio();
        List<Pizza> pizzas = pedido.getPizzas();
        
        System.out.println("Selecione o tamanho da nova pizza: ");
        int x = 1;
        for (Pizza.TamanhoPizza tamanho : Pizza.TamanhoPizza.values()) {
            System.out.println(x + " - " + tamanho);
            x++;
        }
        System.out.print("Opção: ");
        int tamanhoIndex = scanner.nextInt() - 1; // Ajuste para índice 0
        scanner.nextLine();
        
        int quantiSabores = 0;
        while (quantiSabores < 1 || quantiSabores > 4) {
            System.out.println("Digite a quantidade de sabores: 1 - 4 ");
            System.out.print("Opção: ");
            quantiSabores = scanner.nextInt();
            scanner.nextLine();
        }

        List<String> saboresSelect = new ArrayList<>();
        for (int i = 0; i < quantiSabores; i++) {
            System.out.println("Selecione um sabor: ");
            x = 1;
            for (String sabor : cardapio.getCardapio().keySet()) {
                System.out.println(x + " - " + sabor);
                x++;
            }
            System.out.print("Opção: ");
            int saborIndex = scanner.nextInt() - 1; // Ajuste para índice 0
            scanner.nextLine();
            String saborEscolhido = (String) cardapio.getCardapio().keySet().toArray()[saborIndex];
            saboresSelect.add(saborEscolhido);
        }
        
        Pizza novaPizza = new Pizza(saboresSelect, cardapio.getPrecoJusto(saboresSelect), Pizza.TamanhoPizza.getByIndex(tamanhoIndex));
        pizzas.add(novaPizza);
        
        System.out.println("Pizza adicionada com sucesso!");
        pedido.setValorTotal(somarPizzas(pizzas));
    }

    private static void removerPizza(Pedido pedido, Scanner scanner) {
        List<Pizza> pizzas = pedido.getPizzas();
        
        if (pizzas.isEmpty()) {
            System.out.println("Não há pizzas para remover.");
            return;
        }
        
        System.out.println("Pizzas no pedido: ");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i + 1) + " - " + pizzas.get(i).getSabores());
        }
        
        System.out.print("Digite o número da pizza a ser removida: ");
        int index = scanner.nextInt() - 1; // Ajuste para índice 0
        scanner.nextLine();
        
        if (index < 0 || index >= pizzas.size()) {
            System.out.println("Número inválido!");
            return;
        }
        
        pizzas.remove(index);
        System.out.println("Pizza removida com sucesso!");
        pedido.setValorTotal(somarPizzas(pizzas));
    }

    private static void alterarSaborPizza(Pedido pedido, Scanner scanner) {
        List<Pizza> pizzas = pedido.getPizzas();
        
        if (pizzas.isEmpty()) {
            System.out.println("Não há pizzas para alterar.");
            return;
        }
        
        System.out.println("Pizzas no pedido: ");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i + 1) + " - " + pizzas.get(i).getSabores());
        }
        
        System.out.print("Digite o número da pizza a ser alterada: ");
        int index = scanner.nextInt() - 1; // Ajuste para índice 0
        scanner.nextLine();
        
        if (index < 0 || index >= pizzas.size()) {
            System.out.println("Número inválido!");
            return;
        }
        
        Pizza pizza = pizzas.get(index);
        Cardapio cardapio = new Cardapio();
        
        System.out.println("Selecione a nova quantidade de sabores: ");
        int quantiSabores = scanner.nextInt(); // Ajuste para índice 0
        scanner.nextLine();
        
        List<String> novosSabores = new ArrayList<>();
        for (int i = 0; i < quantiSabores; i++) {
            System.out.println("Selecione um sabor: ");
            int x = 1;
            for (String sabor : cardapio.getCardapio().keySet()) {
                System.out.println(x + " - " + sabor);
                x++;
            }
            System.out.print("Opção: ");
            int saborIndex = scanner.nextInt() - 1; // Ajuste para índice 0
            scanner.nextLine();
            String saborEscolhido = (String) cardapio.getCardapio().keySet().toArray()[saborIndex];
            novosSabores.add(saborEscolhido);
        }
        
        pizza.setSabores(novosSabores);
        pizza.setPreco(cardapio.getPrecoJusto(novosSabores));
        System.out.println("Pizza alterada com sucesso!");
        pedido.setValorTotal(somarPizzas(pizzas));
    }

    private static Cliente adicionarCliente(Scanner scanner) {
        System.out.println("ADICIONAR CLIENTE");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        
        return new Cliente(nome, endereco, telefone, email);
    }

    private static void gerarRelatorio(List<Pedido> listaPedidos) {
        System.out.println("RELATÓRIO DE VENDAS");
        double faturamentoTotal = 0;
        Map<String, Integer> saboresMaisPedididos = new HashMap<>();
        
        for (Pedido pedido : listaPedidos) {
            faturamentoTotal += pedido.getValorTotal();
            for (Pizza pizza : pedido.getPizzas()) {
                for (String sabor : pizza.getSabores()) {
                    saboresMaisPedididos.put(sabor, saboresMaisPedididos.getOrDefault(sabor, 0) + 1);
                }
            }
        }
        
        System.out.println("Faturamento total: R$ " + faturamentoTotal);
        System.out.println("Sabores mais pedidos: ");
        for (Map.Entry<String, Integer> entry : saboresMaisPedididos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void gerarListaClientes(List<Cliente> listaClientes) {
        System.out.println("LISTA DE CLIENTES");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    private static void calcularFrete(Scanner scanner) {
        System.out.print("Digite a distância em km: ");
        double distancia = scanner.nextDouble();
        System.out.print("Digite a quantidade de pizzas: ");
        int quantidadePizzas = scanner.nextInt();
        
        double fretePorDistancia = 5.0 + (1.5 * distancia);
        double fretePorPeso = 2.0 * quantidadePizzas;
        
        System.out.println("Frete por distância: R$ " + fretePorDistancia);
        System.out.println("Frete por peso: R$ " + fretePorPeso);
        System.out.println("Total do frete: R$ " + (fretePorDistancia + fretePorPeso));
    }
}

// Aqui começam as outras classes
class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public Cliente(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Endereço: " + endereco + ", Telefone: " + telefone + ", Email: " + email;
    }
}

class Pizza {
    private List<String> sabores;
    private double preco;
    private TamanhoPizza tamanho;

    public Pizza(List<String> sabores, double preco, TamanhoPizza tamanho) {
        this.sabores = sabores;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public double getPreco() {
        return preco;
    }

    public void setSabores(List<String> sabores) {
        this.sabores = sabores;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public enum TamanhoPizza {
        PEQUENA(20.0), MEDIA(30.0), GRANDE(40.0);
        
        private final double valor;

        TamanhoPizza(double valor) {
            this.valor = valor;
        }

        public double getValor() {
            return valor;
        }

        public static TamanhoPizza getByIndex(int index) {
            return TamanhoPizza.values()[index];
        }
    }
}

class Pedido {
    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double valorTotal;

    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}

class Cardapio {
    private Map<String, Double> cardapio;

    public Cardapio() {
        cardapio = new HashMap<>();
        cardapio.put("Queijo", 25.0);
        cardapio.put("Calabresa", 30.0);
        cardapio.put("Frango", 28.0);
        cardapio.put("Vegetariana", 32.0);
        cardapio.put("Portuguesa", 35.0);
        cardapio.put("Peperoni", 30.0);
    }

    public Map<String, Double> getCardapio() {
        return cardapio;
    }

    public double getPrecoJusto(List<String> sabores) {
        double preco = 0.0;
        for (String sabor : sabores) {
            preco += cardapio.get(sabor);
        }
        return preco;
    }
}

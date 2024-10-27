package DesafioCombinado;

import java.util.*;

// Classe que representa um nó da BST
class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

// Classe da Árvore Binária de Busca (BST)
class BinarySearchTree {
    TreeNode root;

    // Método para inserir um novo valor na BST
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    // Método para encontrar o menor valor na BST
    public int findMin() {
        if (root == null) {
            throw new NoSuchElementException("A árvore está vazia.");
        }
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }
}

// Classe que representa um grafo ponderado
class WeightedGraph {
    private Map<Integer, List<Edge>> adjList = new HashMap<>();

    // Classe que representa uma aresta com peso
    static class Edge {
        int dest, weight;
        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Adiciona uma aresta ao grafo
    public void addEdge(int src, int dest, int weight) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(new Edge(dest, weight));
    }

    // Implementação do algoritmo de Dijkstra
    public void dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> dist = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[]{start, 0});
        dist.put(start, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0], currentDist = current[1];

            if (!visited.add(vertex)) continue;
            if (vertex == end) {
                System.out.println("Menor caminho de " + start + " até " + end + ": " + currentDist);
                return;
            }

            for (Edge edge : adjList.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(edge.dest)) {
                    int newDist = currentDist + edge.weight;
                    if (newDist < dist.getOrDefault(edge.dest, Integer.MAX_VALUE)) {
                        dist.put(edge.dest, newDist);
                        pq.add(new int[]{edge.dest, newDist});
                    }
                }
            }
        }
        System.out.println("Caminho não encontrado.");
    }
}

// Classe que representa um grafo direcionado
class DirectedGraph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Adiciona uma aresta ao grafo
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(dest);
    }

    // Algoritmo de ordenação topológica
    public List<Integer> topologicalSort() {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int vertex : adjList.keySet()) {
            if (!visited.contains(vertex)) {
                topologicalSortUtil(vertex, visited, stack);
            }
        }

        List<Integer> sortedOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            sortedOrder.add(stack.pop());
        }
        return sortedOrder;
    }

    // Função recursiva para a ordenação topológica
    private void topologicalSortUtil(int vertex, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(vertex);

        for (int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }
}

// Classe principal que combina tudo
public class Main {
    public static void main(String[] args) {
        // Teste da BST
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        System.out.println("Menor valor na BST: " + bst.findMin());

        // Teste do Grafo Ponderado
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 4, 3);
        graph.dijkstra(1, 4);

        // Teste da Ordenação Topológica
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addEdge(5, 2);
        directedGraph.addEdge(5, 0);
        directedGraph.addEdge(4, 0);
        directedGraph.addEdge(4, 1);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 1);
        List<Integer> sortedOrder = directedGraph.topologicalSort();
        System.out.println("Ordenação Topológica: " + sortedOrder);
    }
}

package GrafosBFSeDFS;

import java.util.*;

// Classe que representa um grafo usando lista de adjacências
class Graph {
    private Map<Integer, List<Integer>> adjList;

    // Construtor para inicializar o grafo
    public Graph() {
        adjList = new HashMap<>();
    }

    // Método para adicionar um vértice
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Método para adicionar uma aresta entre dois vértices
    public void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    // Exibe o grafo
    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            System.out.println("Vértice " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Retorna a lista de adjacências (para BFS e DFS)
    public Map<Integer, List<Integer>> getAdjList() {
        return adjList;
    }
}

// Classe com o algoritmo de BFS (Busca em Largura)
class BFS {
    public static void bfs(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        System.out.println("BFS a partir do vértice " + start + ":");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : graph.getAdjList().getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}

// Classe com o algoritmo de DFS (Busca em Profundidade)
class DFS {
    public static void dfs(Graph graph, int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS a partir do vértice " + start + ":");
        dfsRecursive(graph, start, visited);
        System.out.println();
    }

    private static void dfsRecursive(Graph graph, int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbor : graph.getAdjList().getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(graph, neighbor, visited);
            }
        }
    }
}

// Classe principal que cria o grafo e executa BFS e DFS
public class Main {
    public static void main(String[] args) {
        // Criação do grafo
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Adicionando arestas
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        // Exibindo o grafo
        System.out.println("Representação do Grafo:");
        graph.printGraph();
        System.out.println();

        // Executando BFS e DFS
        BFS.bfs(graph, 1);
        DFS.dfs(graph, 1);
    }
}


package atividades02;

import java.util.ArrayList;
import java.util.Stack;

public class InverterArrayListComPilha {
    public static void main(String[] args) {
        // Criação e inicialização do ArrayList
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        System.out.println("ArrayList Original: " + lista);

        // Invertendo a lista usando pilha
        inverterLista(lista);

        System.out.println("ArrayList Invertido: " + lista);
    }

    // Método para inverter a ordem dos elementos usando uma pilha
    public static void inverterLista(ArrayList<Integer> lista) {
        Stack<Integer> pilha = new Stack<>();

        // Empilha todos os elementos do ArrayList
        for (Integer elemento : lista) {
            pilha.push(elemento);
        }

        // Desempilha os elementos de volta para o ArrayList
        lista.clear(); // Limpa a lista original
        while (!pilha.isEmpty()) {
            lista.add(pilha.pop());
        }
    }
}

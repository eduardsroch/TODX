package atividades02;

import java.util.Stack;

public class VerificarBalanceamento {
    public static void main(String[] args) {
        String expressao1 = "(a + b) * (c - d)";
        String expressao2 = "(a + b * (c - d))";
        String expressao3 = "(a + b))";

        System.out.println("Expressão: " + expressao1 + " -> " + (estaBalanceada(expressao1) ? "Balanceada" : "Não Balanceada"));
        System.out.println("Expressão: " + expressao2 + " -> " + (estaBalanceada(expressao2) ? "Balanceada" : "Não Balanceada"));
        System.out.println("Expressão: " + expressao3 + " -> " + (estaBalanceada(expressao3) ? "Balanceada" : "Não Balanceada"));
    }

    // Método para verificar se a expressão está balanceada
    public static boolean estaBalanceada(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            // Se o caractere for um parêntese de abertura, empilhe
            if (caractere == '(') {
                pilha.push(caractere);
            }
            // Se o caractere for um parêntese de fechamento, verifique a pilha
            else if (caractere == ')') {
                // Se a pilha estiver vazia, não há parêntese de abertura correspondente
                if (pilha.isEmpty()) {
                    return false;
                }
                // Desempilhe o parêntese de abertura
                pilha.pop();
            }
        }
        // No final, a pilha deve estar vazia para que a expressão esteja balanceada
        return pilha.isEmpty();
    }
}

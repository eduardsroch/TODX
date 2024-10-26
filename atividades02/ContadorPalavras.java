package atividades02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContadorPalavras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicita ao usuário uma frase
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();
        
        // Chama o método para contar a frequência das palavras
        Map<String, Integer> frequencia = contarFrequencia(frase);
        
        // Exibe a contagem de palavras
        System.out.println("\nFrequência das palavras:");
        for (Map.Entry<String, Integer> entrada : frequencia.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
        
        scanner.close();
    }

    // Método para contar a frequência das palavras
    public static Map<String, Integer> contarFrequencia(String frase) {
        Map<String, Integer> frequencia = new HashMap<>();
        
        // Divide a frase em palavras
        String[] palavras = frase.split("\\s+");
        
        // Conta a frequência de cada palavra
        for (String palavra : palavras) {
            palavra = palavra.toLowerCase(); // Ignora maiúsculas/minúsculas
            frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
        }
        
        return frequencia;
    }
}

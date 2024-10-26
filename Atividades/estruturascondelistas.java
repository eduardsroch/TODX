import java.util.*;

public class estruturascondelistas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite os números inteiros (digite 'fim' para terminar):");
        while (scanner.hasNextInt()) {
            numeros.add(scanner.nextInt());
        }

        if (numeros.isEmpty()) {
            System.out.println("Nenhum número foi inserido.");
        } else {
            int maisFrequente = encontrarMaisFrequente(numeros);
            System.out.println("O número que mais se repete é: " + maisFrequente);
        }

        scanner.close();
    }

    public static int encontrarMaisFrequente(List<Integer> numeros) {
        Map<Integer, Integer> frequencia = new HashMap<>();

        // Contando a frequência de cada número
        for (int numero : numeros) {
            frequencia.put(numero, frequencia.getOrDefault(numero, 0) + 1);
        }

        // Encontrando o número com a maior frequência
        int maisFrequente = numeros.get(0);
        int maxFrequencia = 0;

        for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > maxFrequencia) {
                maisFrequente = entry.getKey();
                maxFrequencia = entry.getValue();
            }
        }

        return maisFrequente;
    }
}

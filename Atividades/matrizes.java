import java.util.Scanner;

public class matrizes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho da matriz: ");
        int tamanho = scanner.nextInt();

        int[] matriz = new int[tamanho];

        // Preenchendo a matriz
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            matriz[i] = scanner.nextInt();
        }

        // Encontrando o maior valor
        int maior = matriz[0];  // Inicializa com o primeiro elemento
        for (int i = 1; i < matriz.length; i++) {
            if (matriz[i] > maior) {
                maior = matriz[i];
            }
        }

        System.out.println("O maior valor na matriz é: " + maior);

        scanner.close();
    }
}

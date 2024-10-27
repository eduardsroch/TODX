package BuscaBinaria;

// Busca Linear
public class SearchAlgorithms {
    // Método para realizar busca linear
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Retorna a posição do alvo
            }
        }
        return -1; // Retorna -1 se não encontrado
    }

    // Método para realizar busca binária (array precisa estar ordenado)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Retorna a posição do alvo
            } else if (arr[mid] < target) {
                left = mid + 1; // Ignora a metade esquerda
            } else {
                right = mid - 1; // Ignora a metade direita
            }
        }
        return -1; // Retorna -1 se não encontrado
    }

    public static void main(String[] args) {
        // Exemplo de Busca Linear
        int[] array = {3, 5, 1, 8, 2, 7};
        int targetLinear = 8;
        int linearResult = linearSearch(array, targetLinear);
        System.out.println("Busca Linear: Elemento " + (linearResult != -1 ? 
            "encontrado na posição " + linearResult : "não encontrado."));

        // Exemplo de Busca Binária (array precisa ser ordenado)
        int[] sortedArray = {1, 2, 3, 5, 7, 8, 9};
        int targetBinary = 7;
        int binaryResult = binarySearch(sortedArray, targetBinary);
        System.out.println("Busca Binária: Elemento " + (binaryResult != -1 ? 
            "encontrado na posição " + binaryResult : "não encontrado."));
    }
}

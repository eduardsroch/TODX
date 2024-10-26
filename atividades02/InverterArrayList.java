import java.util.ArrayList;

public class InverterArrayList {
    public static void main(String[] args) {
        // Criação e inicialização do ArrayList
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        System.out.println("ArrayList Original: " + lista);

        // Invertendo a lista manualmente
        inverterLista(lista);

        System.out.println("ArrayList Invertido: " + lista);
    }

    // Função para inverter o ArrayList
    public static void inverterLista(ArrayList<Integer> lista) {
        int tamanho = lista.size();
        for (int i = 0; i < tamanho / 2; i++) {
            // Troca de elementos
            int temp = lista.get(i);
            lista.set(i, lista.get(tamanho - 1 - i));
            lista.set(tamanho - 1 - i, temp);
        }
    }
}

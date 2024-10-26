import java.util.ArrayList;

public class IntercalarListas {
    public static void main(String[] args) {
        // Criação e inicialização das duas ArrayLists
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);

        // Intercalando as listas
        ArrayList<Integer> listaIntercalada = intercalarListas(lista1, lista2);

        System.out.println("Lista Intercalada: " + listaIntercalada);
    }

    // Método para intercalar duas listas
    public static ArrayList<Integer> intercalarListas(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> listaIntercalada = new ArrayList<>();
        int tamanhoMaximo = Math.max(lista1.size(), lista2.size());

        for (int i = 0; i < tamanhoMaximo; i++) {
            if (i < lista1.size()) {
                listaIntercalada.add(lista1.get(i)); // Adiciona da lista1
            }
            if (i < lista2.size()) {
                listaIntercalada.add(lista2.get(i)); // Adiciona da lista2
            }
        }

        return listaIntercalada;
    }
}

import java.util.ArrayList;

public class RemoverDuplicados {
    public static void main(String[] args) {
        // Criação e inicialização do ArrayList com elementos duplicados
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(4);
        lista.add(5);
        lista.add(1);

        System.out.println("ArrayList Original: " + lista);

        // Removendo elementos duplicados
        ArrayList<Integer> listaSemDuplicados = removerDuplicados(lista);

        System.out.println("ArrayList sem Duplicados: " + listaSemDuplicados);
    }

    // Método para remover duplicados
    public static ArrayList<Integer> removerDuplicados(ArrayList<Integer> lista) {
        ArrayList<Integer> listaSemDuplicados = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            Integer elemento = lista.get(i);
            // Verifica se o elemento já está na nova lista
            if (!listaSemDuplicados.contains(elemento)) {
                listaSemDuplicados.add(elemento);
            }
        }

        return listaSemDuplicados;
    }
}

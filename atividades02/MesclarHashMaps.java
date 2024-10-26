package atividades02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MesclarHashMaps {
    public static void main(String[] args) {
        // Criando dois HashMaps de exemplo
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        map2.put("D", 5);

        // Mesclando os HashMaps
        Map<String, List<Integer>> mapaMesclado = mesclarHashMaps(map1, map2);

        // Exibindo o resultado da mesclagem
        System.out.println("Mapa Mesclado: " + mapaMesclado);
    }

    // Método para mesclar dois HashMaps
    public static Map<String, List<Integer>> mesclarHashMaps(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        Map<String, List<Integer>> resultado = new HashMap<>();

        // Adicionando elementos do primeiro HashMap
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            resultado.put(entry.getKey(), new ArrayList<>(List.of(entry.getValue())));
        }

        // Adicionando elementos do segundo HashMap
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            // Se a chave já existir, adiciona o valor à lista existente
            if (resultado.containsKey(entry.getKey())) {
                resultado.get(entry.getKey()).add(entry.getValue());
            } else {
                // Se a chave não existir, cria uma nova lista com o valor
                resultado.put(entry.getKey(), new ArrayList<>(List.of(entry.getValue())));
            }
        }

        return resultado;
    }
}

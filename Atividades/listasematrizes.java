import java.util.Scanner;

public class listasematrizes {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        inicializarTabuleiro(tabuleiro);
        Scanner scanner = new Scanner(System.in);
        char jogadorAtual = 'X';  // Jogador 1 começa com 'X'
        boolean venceu = false;
        int jogadas = 0;

        while (!venceu && jogadas < 9) {
            imprimirTabuleiro(tabuleiro);
            System.out.println("Jogador " + jogadorAtual + ", faça sua jogada.");
            System.out.print("Digite a linha (0, 1 ou 2): ");
            int linha = scanner.nextInt();
            System.out.print("Digite a coluna (0, 1 ou 2): ");
            int coluna = scanner.nextInt();

            // Verifica se a posição é válida
            if (tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual;
                jogadas++;

                // Verifica se houve vitória
                if (verificarVitoria(tabuleiro, jogadorAtual)) {
                    venceu = true;
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("Parabéns! O jogador " + jogadorAtual + " venceu!");
                } else {
                    // Troca o jogador
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Posição já ocupada! Tente novamente.");
            }
        }

        if (!venceu) {
            imprimirTabuleiro(tabuleiro);
            System.out.println("O jogo terminou em empate!");
        }

        scanner.close();
    }

    // Inicializa o tabuleiro com espaços em branco
    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    // Imprime o tabuleiro atual
    public static void imprimirTabuleiro(char[][] tabuleiro) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    // Verifica se o jogador atual venceu
    public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }

        // Verifica diagonais
        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
            (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;
        }

        return false;
    }
}

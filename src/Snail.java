import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snail {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return result; // Retorna lista vazia se a matriz for vazia
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Enquanto houver camadas para percorrer
        while (top <= bottom && left <= right) {
            // Percorre da esquerda para a direita no topo
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Percorre de cima para baixo na direita
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Percorre da direita para a esquerda na parte inferior (se ainda houver
            // linhas)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Percorre de baixo para cima na esquerda (se ainda houver colunas)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o tamanho da matriz ao usuário
        System.out.print("Digite o tamanho da matriz N x N: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        // Solicita que o usuário preencha a matriz
        System.out.println("Preencha a matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Obtém a lista de valores em ordem de espiral
        List<Integer> result = spiralOrder(matrix);

        // Exibe o resultado
        System.out.println("Ordem em espiral: " + result);

        scanner.close();
    }
}

package classwork_3;

import java.util.Random;
import java.util.Scanner;

public class task_6_2 {
    public static void shiftColumns(int[][] matrix, int shifts, boolean direction) {
        // if direction true --> right, false --> left

        int size = matrix.length;
        shifts = shifts % matrix.length;
        if (!direction) shifts = size - shifts;

        int i, j, s;
        for (s = 0; s < shifts; s++){
            for (i = 0; i < size; i++){
                int tmp = matrix[i][size-1];
                for (j = size - 1; j >= 1; j--){
                    matrix[i][j] = matrix[i][j - 1];
                }
                matrix[i][j] = tmp;
            }
        }
    }

    public static void shiftRows(int[][] matrix, int shifts, boolean direction) {
        // if direction true --> down, false --> up

        int size = matrix.length;
        shifts = shifts % matrix.length;
        if (!direction) shifts = size - shifts;

        int i, j, s;

        for (s = 0; s < shifts; s++){
            for (j = 0; j < size; j++){
                int tmp = matrix[size - 1][j];
                for (i = size - 1; i >= 1; i--){
                    matrix[i][j] = matrix[i - 1][j];
                }
                matrix[i][j] = tmp;
            }
        }
    }

    static void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print("\t" + value);
            }
            System.out.println();
        }
    }

    static int[][] getMatrixFromConsole(int size, Scanner scanner){
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static int [][] RandomMatrix(int size){
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = Math.abs(rand.nextInt() % 10);
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] matrix = RandomMatrix(n);
//        int[][] matrix = getMatrixFromConsole(n, scanner);

        printMatrix(matrix);
        System.out.println();

//        shiftColumns(matrix, 1, true);
        shiftRows(matrix, 1, false);

        printMatrix(matrix);

    }
}

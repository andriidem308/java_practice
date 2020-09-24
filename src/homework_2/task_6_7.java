package homework_2;

import java.util.Random;
import java.util.Scanner;

public class task_6_7 {

    static void printMatrix(int[][] matrix){
        System.out.println();
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

    public static void rotateMatrix(int[][] matrix, int mode){
        /**
         * Rotate Matrix at degree depends on mode (1, 2, 3);
         * @param mode - 1->90*, 2-180*, 3-270*
         */

        int size = matrix.length;
        int[][] new_matrix = new int[size][size];
        int x=0, y=0;

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (mode == 1){ x = size-j-1; y = i;}
                if (mode == 2){ x = size-i-1; y = size - j - 1;}
                if (mode == 3){ x = j; y = size - i - 1;}
                new_matrix[i][j] = matrix[x][y];
            }
        }

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = new_matrix[i][j];
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matrix size: ");
        int n = scanner.nextInt();

        int[][] a = RandomMatrix(n);
//        System.out.println("Matrix:");
//        int[][] a = getMatrixFromConsole(n, scanner);
        System.out.print("Rotate mode: ");
        int rotateMode = scanner.nextInt();

        printMatrix(a);
        rotateMatrix(a, rotateMode);
        printMatrix(a);


    }
}

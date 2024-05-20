package LAB1.ex2;

public class MatrixOperations {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {2, 3, 1},
                {7, 1, 6},
                {9, 2, 4}
        };

        int[][] matrix2 = {
                {8, 5, 3},
                {3, 9, 2},
                {2, 7, 3}
        };

        // Calculate and display the sum of matrices
        int[][] sumMatrix = addMatrices(matrix1, matrix2);
        System.out.println("Sum of Matrices:");
        printMatrix(sumMatrix);

        int[][] productMatrix = multiplyMatrices(matrix1, matrix2);
        System.out.println("\nProduct of Matrices:");
        printMatrix(productMatrix);
    }

    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;
        int[][] result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

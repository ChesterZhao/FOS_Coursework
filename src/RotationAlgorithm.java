public class RotationAlgorithm {
    public static int[][] input(int[][] keyMatrix) {
        int[][] matrixKey = keyMatrix.clone();
        int code = 1000;
        for (int i = 0; i < 8; i++) {
            if ((code & 8) == 8) {
                matrixKey = shiftColumnsRightwards(matrixKey);
            }
            if ((code & 4) == 4) {
                matrixKey = shiftRowsDownwards(matrixKey);
            }
            if ((code & 2) == 2) {
                matrixKey = shiftColumnsRightwards(matrixKey);
            }
            if ((code & 1) == 1) {
                matrixKey = shiftRowsDownwards(matrixKey);
            }
            code++;
        }
        return matrixKey;
    }

    private static int[][] shiftColumnsRightwards(int[][] matrix) {
        int[][] shifted = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                shifted[i][j + 1] = matrix[i][j];
            }
            shifted[i][0] = matrix[i][7];
        }
        return shifted;
    }

    private static int[][] shiftRowsDownwards(int[][] matrix) {
        int[][] shifted = new int[8][8];
        for (int i = 0; i < 7; i++) {
            shifted[i + 1] = matrix[i];
        }
        shifted[0] = matrix[7];
        return shifted;
    }

    public static void main(String[] args) {
        // Sample usage
        int[][] keyMatrix = {
                {1, 0, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0, 1, 1, 0}
        };
        int[][] rotatedMatrix = RotationAlgorithm.input(keyMatrix);
        for (int[] row : rotatedMatrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
package top.moonstar.dp;

public class KnightProbability {
    public static void main(String[] args) {
        System.out.println(new KnightProbability().knightProbability(8, 30, 6, 4));
    }

    private static final int[][] DIRECTIONS = new int[][] {
            { -2, 1 },
            { -1, 2 },
            { 1, 2 },
            { 2, 1 },
            { 2, -1 },
            { 1, -2 },
            { -1, -2 },
            { -2, -1 }
    };

    private boolean isOnboard(int n, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return false;
        }
        return true;
    }

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] records = new double[n][n][k];
        double num = traverse(n, k - 1, row, column, records);
        return num;
    }

    private double traverse(int n, int k, int row, int column, double[][][] records) {
        if (k == -1) {
            return 1;
        }
        if (records[row][column][k] != 0) {
            return records[row][column][k];
        }

        double ratio = 0;
        for (int d = 0; d < DIRECTIONS.length; d++) {
            int newRow = row + DIRECTIONS[d][0];
            int newCol = column + DIRECTIONS[d][1];
            if (isOnboard(n, newRow, newCol)) {
                ratio += traverse(n, k - 1, newRow, newCol, records) / 8;
            }
        }
        records[row][column][k] = ratio;
        return ratio;
    }
}
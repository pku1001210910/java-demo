package top.moonstar.array2d;

public class NumberOfIsands {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        System.out.println(new NumberOfIsands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    num++;
                    traverse(grid, i, j, seen);
                }
            }
        }
        return num;
    }

    public void traverse(char[][] grid, int row, int col, boolean[][] seen) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || seen[row][col]) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        seen[row][col] = true;
        traverse(grid, row - 1, col, seen);
        traverse(grid, row + 1, col, seen);
        traverse(grid, row, col - 1, seen);
        traverse(grid, row, col + 1, seen);
    }
}
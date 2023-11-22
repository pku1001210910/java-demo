package top.moonstar.array2d;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrganges {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(new RottingOrganges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[grid.length][grid[0].length];

        // find initial rotten organges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        // let organges rot
        int minutes = -1;
        while (!queue.isEmpty()) {
            Queue<int[]> newlyRottenOrganges = new LinkedList<>();

            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];

                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || seen[r][c]) {
                    continue;
                }

                seen[r][c] = true;
                newlyRottenOrganges.add(new int[] { r - 1, c });
                newlyRottenOrganges.add(new int[] { r + 1, c });
                newlyRottenOrganges.add(new int[] { r, c - 1 });
                newlyRottenOrganges.add(new int[] { r, c + 1 });
            }
            queue = newlyRottenOrganges;

            if (!newlyRottenOrganges.isEmpty()) {
                minutes++;
            }
        }

        // check if there are good ones left
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    return -1;
                }
            }
        }
        return minutes == -1 ? 0 : minutes;
    }
}

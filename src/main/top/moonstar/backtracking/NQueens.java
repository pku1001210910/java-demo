package top.moonstar.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> res = new NQueens().solveNQueens(4);

        for (List<String> solution : res) {
            for (String line : solution) {
                System.out.println(line);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> solutions = new ArrayList<>();
        solveNQueensHelper(n, board, 0, solutions);
        return solutions;
    }

    private void solveNQueensHelper(int n, char[][] board, int row, List<List<String>> solutions) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = "";
                for (int j = 0; j < n; j++) {
                    line += board[i][j];
                }
                solution.add(line);
            }
            solutions.add(solution);
        }

        for (int col = 0; col < n; col++) {
            boolean isValid = validateBoard(board, row, col);
            if (!isValid) {
                continue;
            }

            board[row][col] = 'Q';
            solveNQueensHelper(n, board, row + 1, solutions);
            board[row][col] = '.';
        }
    }

    private boolean validateBoard(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') {
                    if (i == row || j == col || Math.abs(row - i) == Math.abs(col - j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

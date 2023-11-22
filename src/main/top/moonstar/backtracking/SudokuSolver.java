package top.moonstar.backtracking;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        new SudokuSolver().solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static final char[] NUMBERS = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public boolean isValid(char[][] board, int row, int col) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            char ch = board[i][col];
            if (ch == '.') {
                continue;
            }

            if (seen.contains(ch)) {
                return false;
            }
            seen.add(ch);
        }

        seen.clear();
        for (int i = 0; i < board[0].length; i++) {
            char ch = board[row][i];
            if (ch == '.') {
                continue;
            }

            if (seen.contains(ch)) {
                return false;
            }
            seen.add(ch);
        }

        seen.clear();
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }

                if (seen.contains(ch)) {
                    return false;
                }
                seen.add(ch);
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    public boolean solveSudokuHelper(char[][] board) {
        int[] pos = findNext(board);
        int row = pos[0];
        int col = pos[1];
        if (row == -1) {
            return true;
        }

        for (int i = 0; i < NUMBERS.length; i++) {
            char newChar = NUMBERS[i];
            board[row][col] = newChar;
            boolean isValid = isValid(board, row, col);
            if (!isValid) {
                board[row][col] = '.';
                continue;
            }
            isValid = solveSudokuHelper(board);
            if (!isValid) {
                board[row][col] = '.';
                continue;
            }
            return true;
        }

        return false;
    }

    private int[] findNext(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}

package main.java.top.moonstar.array;

/**
 * Link: https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * 
 * Search a 2D Matrix II
 * 
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        int target = 111;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length - 1;
        int m = 0;

        while (n >= 0 && m < matrix[0].length) {
            if (matrix[n][m] > target) {
                n--;
            } else if (matrix[n][m] < target) {
                m++;
            } else {
                return true;
            }
        }

        return false;
    }
}
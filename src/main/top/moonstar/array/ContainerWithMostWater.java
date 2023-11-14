package top.moonstar.array;

/**
 * Link:
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = new int[] {
                1, 8, 6, 2, 5, 4, 8, 3, 7
        };
        System.out.println(maxArea(heights));
        return;
    }

    public static int maxArea(int[] heights) {
        int maxArea = -1;
        int i = 0;
        int j = heights.length - 1;

        while (i != j) {
            int width = j - i;
            int height = Math.min(heights[i], heights[j]);
            maxArea = Math.max(maxArea, width * height);

            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}

package main.java.top.moonstar.array;

/**
 * Link:
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 */

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[] { 4, 2, 0, 3, 2, 5 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int volume = 0;
        int level = 0;
        boolean movingRight = true;

        for (int left = 0, right = height.length - 1; left < right;) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int posHeight = movingRight ? height[left] : height[right];

            if (posHeight < level) {
                volume += level - posHeight;
            }

            if (leftHeight < rightHeight) {
                left++;
                movingRight = true;
            } else {
                right--;
                movingRight = false;
            }

            level = Math.max(level, Math.min(leftHeight, rightHeight));
        }
        return volume;
    }
}

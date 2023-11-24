package top.moonstar.array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] maxToEach = new int[nums.length];
        maxToEach[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxToEach[i] = maxToEach[i - 1] > 0 ? nums[i] + maxToEach[i - 1] : nums[i];
        }

        int max = nums[0];
        for (int i = 0; i < maxToEach.length; i++) {
            max = Math.max(max, maxToEach[i]);
        }
        return max;
    }
}

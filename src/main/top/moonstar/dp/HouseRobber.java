package top.moonstar.dp;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int val = hr.rob(new int[] { 6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3 });
        System.out.println(val);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] maxToEach = new int[n];
        maxToEach[0] = nums[0];
        maxToEach[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < n; i++) {
            maxToEach[i] = Math.max(maxToEach[i - 1], nums[i] + maxToEach[i - 2]);
        }

        return Math.max(maxToEach[n - 1], maxToEach[n - 2]);
    }
}

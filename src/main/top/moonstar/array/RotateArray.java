package top.moonstar.array;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        new RotateArray().rotate2(nums, k);
        System.out.println(nums);
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }

        for (int j = nums.length - 1; j >= k; j--) {
            nums[j] = nums[j - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    // solution 2 - reverse array
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }
}
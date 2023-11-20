package top.moonstar.recursion;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] nums, int from, int to, int pos) {
        int pivot = nums[to];
        int i = from, j = to;
        for (; i <= j;) {
            if (nums[i] > pivot) {
                nums[j] = nums[i];
                nums[i] = nums[j - 1];
                nums[j - 1] = pivot;
                j--;
                continue;
            }
            i++;
        }

        if (pos == j) {
            return nums[j];
        } else if (pos > j) {
            return quickSelect(nums, j + 1, to, pos);
        } else {
            return quickSelect(nums, from, j - 1, pos);
        }
    }
}

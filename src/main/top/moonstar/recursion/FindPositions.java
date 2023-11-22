package top.moonstar.recursion;

public class FindPositions {
    public static void main(String[] args) {
        int[] res = new FindPositions().searchRange(new int[] {  }, 6);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        return searchRangeHelper(nums, 0, nums.length - 1, target);
    }

    private int[] searchRangeHelper(int[] nums, int from, int to, int target) {
        if (from > to) {
            return new int[] { -1, -1 };
        }

        int midPos = (from + to) / 2;
        if (nums[midPos] > target) {
            return searchRangeHelper(nums, from, midPos - 1, target);
        } else if (nums[midPos] < target) {
            return searchRangeHelper(nums, midPos + 1, to, target);
        } else {
            int[] leftRange = searchRangeHelper(nums, from, midPos - 1, target);
            int[] rightRange = searchRangeHelper(nums, midPos + 1, to, target);

            int leftMostPos = leftRange[0] == -1 ? midPos : leftRange[0];
            int rightMostPos = rightRange[0] == -1 ? midPos : rightRange[1];

            return new int[] { leftMostPos, rightMostPos };
        }

    }
}

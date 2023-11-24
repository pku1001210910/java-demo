package top.moonstar.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSum {
    public static void main(String[] args) {
        TreeSum sum = new TreeSum();
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        sum.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1, k = nums.length - 1; j < k;) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> match = new ArrayList<>();
                    match.add(nums[i]);
                    match.add(nums[j++]);
                    match.add(nums[k--]);
                    res.add(match);

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}

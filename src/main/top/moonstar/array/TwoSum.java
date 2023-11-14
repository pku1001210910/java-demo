package top.moonstar.array;
import java.util.HashMap;
import java.util.Map;

/**
 * Link:
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;

        int[] results = twoSum(nums, target);
        if (results == null) {
            System.out.println("No Index");
        } else {
            for (int num : results) {
                System.out.println(num);
            }
        }
        return;
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }

        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pairMap.get(nums[i]) != null) {
                return new int[] { pairMap.get(nums[i]), i };
            }
            pairMap.put(target - nums[i], i);
        }
        return null;
    }
}

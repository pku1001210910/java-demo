package top.moonstar.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> res = new Permutations().permute(nums);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        traverse(nums, ret, new ArrayList<Integer>());
        return ret;
    }

    public void traverse(int[] nums, List<List<Integer>> ret, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            List<Integer> solution = new ArrayList<>();
            solution.addAll(permutation);
            ret.add(solution);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }

            permutation.add((Integer) nums[i]);
            traverse(nums, ret, permutation);
            permutation.remove((Integer) nums[i]);
        }
    }
}

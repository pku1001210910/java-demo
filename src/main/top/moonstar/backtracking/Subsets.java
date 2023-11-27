package top.moonstar.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> res = new Subsets().subsets(nums);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            find(nums, ret, new ArrayList<>(), i);
        }
        return ret;
    }

    public void find(int[] nums, List<List<Integer>> ret, List<Integer> solution, int length) {
        if (solution.size() == length && !containsSolution(ret, solution)) {
            List<Integer> list = new ArrayList<>();
            list.addAll(solution);
            ret.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (solution.contains(nums[i])) {
                continue;
            }

            solution.add((Integer) nums[i]);
            find(nums, ret, solution, length);
            solution.remove((Integer) nums[i]);
        }
    }

    private boolean containsSolution(List<List<Integer>> ret, List<Integer> solution) {
        for (List<Integer> s : ret) {
            boolean find = true;
            for (Integer num : s) {
                if (!solution.contains(num)) {
                    find = false;
                    break;
                }
            }

            for (Integer num : solution) {
                if (!s.contains(num)) {
                    find = false;
                    break;
                }
            }

            if (find) {
                return true;
            }

        }
        return false;
    }
}

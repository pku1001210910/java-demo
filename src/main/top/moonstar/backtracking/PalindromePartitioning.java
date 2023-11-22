package top.moonstar.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aabbaa";
        List<List<String>> res = new PalindromePartitioning().partition(s);
        for (List<String> list : res) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String leftStr = s.substring(0, i + 1);
            if (!isPalindrome(leftStr)) {
                continue;
            }

            String rightStr = s.substring(i + 1);
            if (rightStr.isEmpty()) {
                List<String> subStrings = new ArrayList<>();
                subStrings.add(leftStr);
                res.add(subStrings);
                continue;
            }

            List<List<String>> rightPartiions = partition(rightStr);
            for (List<String> subStrings : rightPartiions) {
                subStrings.add(0, leftStr);
                res.add(subStrings);
            }
        }

        return res;
    }

    private boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char leftCh = s.charAt(i);
            char rightCh = s.charAt(j);
            if (leftCh != rightCh) {
                return false;
            }
        }

        return true;
    }
}

package top.moonstar.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(new String[] { "leet", "code" });

        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] validTo = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            boolean isValid = false;
            for (int j = 0; j <= i; j++) {
                if (j > 0 && !validTo[j - 1]) {
                    continue;
                }

                if (wordDict.contains(s.substring(j, i + 1))) {
                    isValid = true;
                    break;
                }
            }
            validTo[i] = isValid;
        }
        return validTo[s.length() - 1];
    }
}

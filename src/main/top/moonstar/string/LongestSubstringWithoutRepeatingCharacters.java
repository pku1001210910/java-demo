package top.moonstar.string;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            int index = s.indexOf(ch, left, right);
            if (index == -1) {
                maxLength += 1;
            } else {
                left = index + 1;
            }
        }

        return maxLength;
    }
}

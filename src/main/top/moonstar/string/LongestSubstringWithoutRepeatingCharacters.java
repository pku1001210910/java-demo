package top.moonstar.string;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int findChar(String s, char ch, int left, int right) {
        for (int i = left; i < right && i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            int index = findChar(s, ch, left, right);
            if (index == -1) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = index + 1;
            }
        }

        return maxLength;
    }
}

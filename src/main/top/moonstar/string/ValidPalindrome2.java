package top.moonstar.string;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        String str = "abca";
        System.out.println(new ValidPalindrome2().isPalindrome(str));
    }

    public boolean isPalindromeHelper(String s, int left, int right, int chance) {
        while (left <= right) {
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);

            if (leftCh == rightCh) {
                left++;
                right--;
                continue;
            }

            if (chance == 0) {
                return false;
            }

            return isPalindromeHelper(s, left + 1, right, chance - 1)
                    || isPalindromeHelper(s, left, right - 1, chance - 1);

        }
        return true;
    }

    public boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1, 1);
    }
}

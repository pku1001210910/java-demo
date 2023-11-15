package top.moonstar.string;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "0P";
        System.out.println(new ValidPalindrome().isPalindrome(str));
    }

    public boolean isAlphaNumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int left = 0, right = s.length() - 1; left <= right;) {
            char leftCh = s.charAt(left);
            if (!isAlphaNumeric(leftCh)) {
                left++;
                continue;
            }

            char rightCh = s.charAt(right);
            if (!isAlphaNumeric(rightCh)) {
                right--;
                continue;
            }

            if (leftCh != rightCh) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

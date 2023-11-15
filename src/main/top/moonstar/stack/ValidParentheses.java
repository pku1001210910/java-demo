package top.moonstar.stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(){}{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[' || ch == '(' || ch == '{') {
                stack[index++] = ch;
                continue;
            }

            if (index == 0) {
                return false;
            }

            char popedCh = stack[--index];
            if (ch == ')' && popedCh == '(') {
                continue;
            }
            if (ch == '}' && popedCh == '{') {
                continue;
            }
            if (ch == ']' && popedCh == '[') {
                continue;
            }

            return false;
        }

        return index == 0;
    }
}

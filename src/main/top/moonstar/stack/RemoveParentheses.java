package top.moonstar.stack;

public class RemoveParentheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] strArray = new char[s.length()];
        int[] bracketStack = new int[s.length()];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            strArray[i] = ch;

            if (ch == '(') {
                bracketStack[index++] = i;
            } else if (ch == ')') {
                if (index == 0) {
                    strArray[i] = ' ';
                } else {
                    index--;
                }
            }
        }

        for (int i = 0; i < index; i++) {
            strArray[bracketStack[i]] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : strArray) {
            if (ch != ' ') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

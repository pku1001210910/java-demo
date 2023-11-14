package top.moonstar.string;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "a#b#c", t = "a#b#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static String buildString(String str) {
        char[] arr = new char[str.length()];
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '#') {
                index = index == 0 ? 0 : index - 1;
            } else {
                arr[index] = ch;
                index++;
            }
        }

        return String.valueOf(arr, 0, index);
    }

    public static boolean backspaceCompare(String s, String t) {
        String str1 = buildString(s);
        String str2 = buildString(t);

        return str1.equals(str2);
    }
}
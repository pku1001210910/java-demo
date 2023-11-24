package top.moonstar.dp;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }

    public int numSquares(int n) {
        int[] min = new int[n+1];
        min[0] = 0;
        min[1] = 1;

        for(int i = 2; i <= n; i++) {
            min[i] = n;
            for(int j = 1; j * j <= i; j++ ) {
                min[i] = Math.min(min[i], 1 + min[i - j*j]);
            }
        }
        return min[n];
    }
}

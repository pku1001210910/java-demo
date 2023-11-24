package top.moonstar.dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[] { 1, 2, 5 }, 11));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] minCoins = new int[amount + 1];

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                break;
            }
            minCoins[coins[i]] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            minCoins[i] = minCoins[i] == 1 ? 1 : Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    break;
                }

                if (minCoins[i - coins[j]] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }
        return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
    }
}

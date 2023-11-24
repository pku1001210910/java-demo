package top.moonstar.dp;

public class BestTime {
    public int maxProfit(int[] prices) {
        int lowestPrices = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            lowestPrices = Math.min(lowestPrices, prices[i]);
            maxProfit = Math.max(prices[i] - lowestPrices, maxProfit);
        }
        return maxProfit;
    }
}

package top.moonstar.dp;

public class ClimbingStairs {

    public static void main(String[] args) {
        int[] cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new ClimbingStairs().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for(int i = 2; i < cost.length; i++) {
            minCost[i] = Math.min(minCost[i-1], minCost[i-2]) + cost[i];
        }

        return Math.min(minCost[cost.length - 1], minCost[cost.length - 2]);
    }
}

package _0000_classicalProblems.knapsack.knapsackcomplete;

import java.util.Arrays;

/**
 * Date: 2020/9/8 21:55
 * Content:
 */
public class KnapsackComplete_memo {
    int[][] memo;

    // 用 [0...index] 的物品，填充容积为 c 的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c < 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];
        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, bestValue(w, v, index, c - w[index]) + v[index]);
        memo[index][c] = res;
        return res;
    }

    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackComplete(int[] w, int[] v, int C) {
        int n = w.length;  // 类别的个数
        memo = new int[n][C + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);

        return bestValue(w, v, n - 1, C);
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {5, 11, 12};
        int C = 5;
        System.out.println("物品的总价值最大为：" + (new KnapsackComplete_memo()).knapsackComplete(w, v, C));
    }
}

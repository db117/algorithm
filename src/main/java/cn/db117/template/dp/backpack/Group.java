package cn.db117.template.dp.backpack;

/**
 * 分组背包
 * 给定 N 个物品组，和容量为 C 的背包。
 * <p>
 * 第 i 个物品组共有 S[i] 件物品，其中第 i 组的第 j 件物品的成本为 v[i][j]，价值为 w[i][j]。
 * <p>
 * 每组有若干个物品，同一组内的物品最多只能选一个。
 * <p>
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 *
 * @author zhangdb3
 * @date 2023/01/11
 */
public class Group {

    class Solution {
        public int maxValue(int N, int C, int[] S, int[][] V, int[][] W) {
            // 前 i 组物品，放入一个容量为 j 的背包可以获得的最大价值
            int[][] dp = new int[N + 1][C + 1];

            for (int i = 1; i < N; i++) {
                int s = S[i];
                int[] v = V[i];
                int[] w = W[i];
                for (int j = 0; j <= C; j++) {
                    // 防止后面
                    dp[i][j] = dp[i - 1][j];
                    // 遍历每一组
                    for (int k = 0; k < s; k++) {
                        if (j > v[k]) {
                            dp[i][j] = Math.max(dp[i - 1][j - v[k]] + w[k], dp[i][j]);
                        }
                    }
                }
            }
            return dp[N][C];
        }
    }

    // 1 维优化
    class Solution1 {
        public int maxValue(int N, int C, int[] S, int[][] V, int[][] W) {
            int[] dp = new int[C + 1];

            for (int i = 1; i < N; i++) {
                int s = S[i];
                int[] v = V[i];
                int[] w = W[i];
                for (int j = C; j >= 0; j--) {
                    // 遍历每一组
                    for (int k = 0; k < s; k++) {
                        if (j > v[k]) {
                            dp[j] = Math.max(dp[j - v[k]] + w[k], dp[j]);
                        }
                    }
                }
            }
            return dp[C];
        }
    }
}

package cn.db117.template.dp.backpack;

import cn.db117.leetcode.solution3.Solution_322;

/**
 * 完全背包
 * <p>
 * 有 N 件物品和一个容量是 C 的背包。每件物品无限量
 * <p>
 * 第 i 件物品的体积是 v[i] ，价值是 w[i]。
 *
 * @see Solution_322
 */
public class Full {

    // 常规解法
    class Solution {
        public int maxValue(int N, int C, int[] v, int[] w) {
            // 前 i件物品，放入一个容量为 j 的背包可以获得的最大价值
            int[][] dp = new int[N][C + 1];

            // 先预处理第一件物品
            for (int j = 0; j <= C; j++) {
                // 显然当只有一件物品的时候，在容量允许的情况下，能选多少件就选多少件
                int maxK = j / v[0];
                dp[0][j] = maxK * w[0];
            }

            // 处理剩余物品
            for (int i = 1; i < N; i++) {
                for (int j = 0; j <= C; j++) {
                    // 不考虑第 i 件物品的情况（选择 0 件物品 i）
                    int n = dp[i - 1][j];
                    // 考虑第 i 件物品的情况
                    int y = 0;
                    for (int k = 1; ; k++) {
                        if (j < v[i] * k) {
                            break;
                        }
                        y = Math.max(y, dp[i - 1][j - k * v[i]] + k * w[i]);
                    }
                    dp[i][j] = Math.max(n, y);
                }
            }
            return dp[N - 1][C];
        }
    }

    // 滚动数组
    class Solution1 {
        public int maxValue(int N, int C, int[] v, int[] w) {
            int[][] dp = new int[2][C + 1];

            // 先预处理第一件物品
            for (int j = 0; j <= C; j++) {
                // 显然当我们只有一件物品的时候，在容量允许的情况下，能选多少件就选多少件
                int maxK = j / v[0];
                dp[0][j] = maxK * w[0];
            }

            // 处理剩余物品
            for (int i = 1; i < N; i++) {
                for (int j = 0; j <= C; j++) {
                    // 不考虑第 i 件物品的情况（选择 0 件物品 i）
                    int n = dp[(i - 1) & 1][j];
                    // 考虑第 i 件物品的情况
                    int y = 0;
                    for (int k = 1; ; k++) {
                        if (j < v[i] * k) {
                            break;
                        }
                        y = Math.max(y, dp[(i - 1) & 1][j - k * v[i]] + k * w[i]);
                    }
                    dp[i & 1][j] = Math.max(n, y);
                }
            }
            return dp[(N - 1) & 1][C];
        }
    }


    // 一维数组优化
    class Solution2 {
        public int maxValue(int N, int C, int[] v, int[] w) {
            int[] dp = new int[C + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= C; j++) {
                    // 不考虑第 i 件物品的情况（选择 0 件物品 i）
                    int n = dp[j];
                    // 考虑第 i 件物品的情况
                    int y = j - v[i] >= 0 ? dp[j - v[i]] + w[i] : 0;
                    dp[j] = Math.max(n, y);
                }
            }
            return dp[C];
        }
    }
}

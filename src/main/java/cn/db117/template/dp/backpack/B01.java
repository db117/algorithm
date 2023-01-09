package cn.db117.template.dp.backpack;

/**
 * 01 背包
 * <p>
 * 有 N 件物品和一个容量是 C 的背包。每件物品有且只有一件。
 * <p>
 * 第 i 件物品的体积是 v[i] ，价值是 w[i]。
 *
 * @author zhangdb3
 * @date 2023/01/09
 */
public class B01 {
    /**
     *
     */

    // 滚动数组
    class Solution {
        public int dp(int N, int C, int[] v, int[] w) {
            int[][] dp = new int[2][C + 1];
            // 先处理「考虑第一件物品」的情况
            for (int i = 0; i < C + 1; i++) {
                dp[0][i] = i >= v[0] ? w[0] : 0;
            }
            // 再处理「考虑其余物品」的情况
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < C + 1; j++) {
                    // 不选该物品
                    int n = dp[(i - 1) & 1][j];
                    // 选择该物品
                    int y = j >= v[i] ? dp[(i - 1) & 1][j - v[i]] + w[i] : 0;
                    dp[i & 1][j] = Math.max(n, y);
                }
            }
            return dp[(N - 1) & 1][C];
        }
    }

    // 一维数组
    class Solution1 {
        public int dp(int N, int C, int[] v, int[] w) {
            int[] dp = new int[C + 1];
            for (int i = 0; i < N; i++) {
                for (int j = C; j >= v[i]; j--) {
                    // 不选该物品
                    int n = dp[j];
                    // 选择该物品
                    int y = dp[j - v[i]] + w[i];
                    dp[j] = Math.max(n, y);
                }
            }
            return dp[C];
        }
    }
}

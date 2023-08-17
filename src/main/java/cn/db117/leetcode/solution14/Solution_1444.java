

//给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1
// 次，得到 k 块披萨并送给别人。 
//
// 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平
//地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。 
//
// 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：pizza = ["A..","AAA","..."], k = 3
//输出：3 
//解释：上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
// 
//
// 示例 2： 
//
// 输入：pizza = ["A..","AA.","..."], k = 3
//输出：1
// 
//
// 示例 3： 
//
// 输入：pizza = ["A..","A..","..."], k = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows, cols <= 50 
// rows == pizza.length 
// cols == pizza[i].length 
// 1 <= k <= 10 
// pizza 只包含字符 'A' 和 '.' 。 
// 
//
// Related Topics 记忆化搜索 数组 动态规划 矩阵 👍 128 👎 0


package cn.db117.leetcode.solution14;

/**
 * 1444.切披萨的方案数.number-of-ways-of-cutting-a-pizza
 *
 * @author db117
 * @since 2023-08-17 10:43:10
 **/

public class Solution_1444 {
    public static void main(String[] args) {
        Solution solution = new Solution_1444().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] pizza;

        int[][][] dp;
        int m, n;
        int mod = (int) (1e9 + 7);

        public int ways(String[] pizza, int k) {
            this.pizza = pizza;
            m = pizza.length;
            n = pizza[0].length();
            dp = new int[m][n][k];

            return Math.max(0, dfs(0, 0, k - 1));
        }

        // 从(x,y)开始切割k次
        private int dfs(int x, int y, int limit) {
            if (limit == 0) {
                // 校验是否有苹果
                if (hasApple(x, y, m - 1, n - 1)) {
                    return 1;
                }
                return Integer.MIN_VALUE;// 没有苹果,不合法
            }
            if (dp[x][y][limit] != 0) {
                return dp[x][y][limit];
            }
            int ans = 0;
            // 横切
            for (int i = x + 1; i < m; i++) {
                if (hasApple(x, y, i - 1, n - 1)) {
                    int dfs = dfs(i, y, limit - 1);
                    if (dfs == Integer.MIN_VALUE) {
                        continue;
                    }
                    ans += dfs;
                    ans %= mod;
                }
            }

            // 竖切
            for (int i = y + 1; i < n; i++) {
                if (hasApple(x, y, m - 1, i - 1)) {
                    int dfs = dfs(x, i, limit - 1);
                    if (dfs == Integer.MIN_VALUE) {
                        continue;
                    }
                    ans += dfs;
                    ans %= mod;
                }
            }
            return dp[x][y][limit] = ans;
        }

        private boolean hasApple(int x1, int y1, int x2, int y2) {
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (pizza[i].charAt(j) == 'A') {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
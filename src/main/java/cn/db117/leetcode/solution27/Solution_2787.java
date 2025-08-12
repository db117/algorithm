

//给你两个 正 整数 n 和 x 。 
//
// 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满
//足 n = n1ˣ + n2ˣ + ... + nkˣ 。 
//
// 由于答案可能非常大，请你将它对 10⁹ + 7 取余后返回。 
//
// 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 2³ + 3³ + 5³ 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10, x = 2
//输出：1
//解释：我们可以将 n 表示为：n = 3² + 1² = 10 。
//这是唯一将 10 表达成不同整数 2 次方之和的方案。
// 
//
// 示例 2： 
//
// 输入：n = 4, x = 1
//输出：2
//解释：我们可以将 n 按以下方案表示：
//- n = 4¹ = 4 。
//- n = 3¹ + 1¹ = 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 300 
// 1 <= x <= 5 
// 
//
// Related Topics 动态规划 👍 54 👎 0


package cn.db117.leetcode.solution27;

/**
 * 2787.将一个数字表示成幂的和的方案数.ways-to-express-an-integer-as-sum-of-powers
 *
 * @author db117
 * @since 2025-08-12 19:17:24
 **/

public class Solution_2787 {
    public static void main(String[] args) {
        Solution solution = new Solution_2787().new Solution();
        // 10
        //			2
        System.out.println(solution.numberOfWays(10, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) 1e9 + 7;

        public int numberOfWays(int n, int x) {
            // 前 i 个数字选择和为 j 的方案数
            int[][] dp = new int[n + 1][n + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                long k = (int) Math.pow(i, x);
                for (int j = 0; j <= n; j++) {
                    // 不选当前数字
                    dp[i][j] = dp[i - 1][j];
                    if (j >= k) {
                        // 选当前数字
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - (int) k]) % mod;
                    }
                }
            }

            return dp[n][n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
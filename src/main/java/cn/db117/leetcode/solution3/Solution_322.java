

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2254 👎 0


package cn.db117.leetcode.solution3;

import java.util.Arrays;

/**
 * 322.零钱兑换.coin-change
 *
 * @author db117
 * @since 2023-01-09 11:25:10
 **/

public class Solution_322 {
    public static void main(String[] args) {
        Solution solution = new Solution_322().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int inf = Integer.MAX_VALUE / 2;

        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            // 0 代表没有选银币
            int[] dp = new int[amount + 1];
            // 标记无效
            Arrays.fill(dp, 1, amount + 1, inf);

            for (int i = 1; i <= n; i++) {
                int coin = coins[i - 1];
                for (int j = coin; j <= amount; j++) {
                    // 不考虑第 i 件物品的情况（选择 0 件物品 i）
                    int no = dp[j];
                    // 考虑第 i 件物品的情况
                    int yes = dp[j - coin] + 1;
                    dp[j] = Math.min(no, yes);
                }
            }
            return dp[amount] == inf ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
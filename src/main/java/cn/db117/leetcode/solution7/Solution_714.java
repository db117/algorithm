

//给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出：8
//解释：能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8 
//
// 示例 2： 
//
// 
//输入：prices = [1,3,7,5,10,3], fee = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 992 👎 0


package cn.db117.leetcode.solution7;

import java.util.Arrays;

/**
 * 714.买卖股票的最佳时机含手续费.best-time-to-buy-and-sell-stock-with-transaction-fee
 *
 * @author db117
 * @since 2023-10-06 21:05:09
 **/

public class Solution_714 {
    public static void main(String[] args) {
        Solution solution = new Solution_714().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] prices;
        int fee;
        int[][] memo;

        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            this.prices = prices;
            this.fee = fee;
            this.memo = new int[n][2];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            return dfs(n - 1, 0);
        }

        private int dfs(int index, int status) {
            if (index < 0) {
                if (status == 1) {
                    // 持有股票,非法状态
                    return Integer.MIN_VALUE / 2;// 防止溢出
                }
                return 0;
            }
            if (memo[index][status] != -1) {
                return memo[index][status];
            }

            int ans;
            if (status == 0) {
                // 没有持有
                ans = Math.max(
                        // 不买
                        dfs(index - 1, 0),
                        // 买
                        dfs(index - 1, 1) + prices[index] - fee
                );
            } else {
                // 持有
                ans = Math.max(
                        // 不卖
                        dfs(index - 1, 1),
                        // 卖
                        dfs(index - 1, 0) - prices[index]
                );
            }

            memo[index][status] = ans;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
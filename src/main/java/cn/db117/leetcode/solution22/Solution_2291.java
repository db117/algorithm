

//给你两个下标从 0 开始的数组 present 和 future ，present[i] 和 future[i] 分别代表第 i 支股票现在和将来的价格。每
//支股票你最多购买 一次 ，你的预算为 budget 。 
//
// 求最大的收益。 
//
// 
//
// 示例 1： 
//
// 
//输入：present = [5,4,6,2,3], future = [8,5,4,3,5], budget = 10
//输出：6
//解释：你可以选择购买第 0,3,4 支股票获得最大收益：6 。总开销为：5 + 2 + 3 = 10 , 总收益是: 8 + 3 + 5 - 10 = 6 
//。
// 
//
// 示例 2： 
//
// 
//输入：present = [2,2,5], future = [3,4,10], budget = 6
//输出：5
//解释：你可以选择购买第 2 支股票获得最大收益：5 。总开销为：5 , 总收益是: 10 - 5 = 5 。
// 
//
// 示例 3： 
//
// 
//输入：present = [3,3,12], future = [0,3,15], budget = 10
//输出：0
//解释：你无法购买唯一一支正收益股票 2 ，因此你的收益是 0 。
// 
//
// 
//
// 提示： 
//
// 
// n == present.length == future.length 
// 1 <= n <= 1000 
// 0 <= present[i], future[i] <= 100 
// 0 <= budget <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 10 👎 0


package cn.db117.leetcode.solution22;

import java.util.Arrays;

/**
 * 2291.最大股票收益.maximum-profit-from-trading-stocks
 *
 * @author db117
 * @since 2024-03-19 21:24:20
 **/

public class Solution_2291 {
    public static void main(String[] args) {
        Solution solution = new Solution_2291().new Solution();
        //[5,4,6,2,3]
        //			[8,5,4,3,5]
        //			10
        System.out.println(solution.maximumProfit(new int[]{
                5, 4, 6, 2, 3
        }, new int[]{
                8, 5, 4, 3, 5
        }, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] present;
        int[] future;
        int n;
        int[][] memo;

        public int maximumProfit(int[] present, int[] future, int budget) {
            this.present = present;
            this.future = future;
            this.n = present.length;
            this.memo = new int[n][budget + 1];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            return dfs(0, budget);
        }

        private int dfs(int index, int budget) {
            if (index == n) {
                return 0;
            }
            if (memo[index][budget] != -1) {
                return memo[index][budget];
            }
            int ans = 0;
            // 不买
            ans = Math.max(ans, dfs(index + 1, budget));
            // 买
            if (budget >= present[index] && future[index] > present[index]) {
                // 买了之后的收益
                ans = Math.max(ans, dfs(index + 1, budget - present[index]) + future[index] - present[index]);
            }
            return memo[index][budget] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
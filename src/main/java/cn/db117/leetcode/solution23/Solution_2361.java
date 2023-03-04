

//城市中的火车有两条路线，分别是常规路线和特快路线。两条路线经过 相同 的 n + 1 个车站，车站编号从 0 到 n。初始时，你位于车站 0 的常规路线。 
//
//
// 给你两个 下标从 1 开始 、长度均为 n 的两个整数数组 regular 和 express ，其中 regular[i] 表示乘坐常规路线从车站 i 
//- 1 到车站 i 的费用，express[i] 表示乘坐特快路线从车站 i - 1 到车站 i 的费用。 
//
// 另外给你一个整数 expressCost，表示从常规路线转换到特快路线的费用。 
//
// 注意： 
//
// 
// 从特快路线转换回常规路线没有费用。 
// 每次 从常规路线转换到特快路线，你都需要支付 expressCost 的费用。 
// 留在特快路线上没有额外费用。 
// 
//
// 返回 下标从 1 开始 、长度为 n 的数组 costs，其中 costs[i] 是从车站 0 到车站 i 的最少费用。 
//
// 注意：每个车站都可以从任意一条路线 到达 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：regular = [1,6,9,5], express = [5,2,3,10], expressCost = 8
//输出：[1,7,14,19]
//解释：上图展示了从车站 0 到车站 4 的最少费用方法。
//- 乘坐常规路线从车站 0 到车站 1，费用是 1。
//- 乘坐特快路线从车站 1 到车站 2，费用是 8 + 2 = 10。
//- 乘坐特快路线从车站 2 到车站 3，费用是 3。
//- 乘坐特快路线从车站 3 到车站 4，费用是 5。
//总费用是 1 + 10 + 3 + 5 + 19。
//注意到达其他车站的最少费用方法可以选择不同的路线。
// 
//
// 示例 2： 
// 
// 
//输入：regular = [11,5,13], express = [7,10,6], expressCost = 3
//输出：[10,15,24]
//解释：上图展示了从车站 0 到车站 3 的最少费用方法。
//- 乘坐特快路线从车站 0 到车站 1，费用是 3 + 7 = 10。
//- 乘坐常规路线从车站 1 到车站 2，费用是 5。
//- 乘坐特快路线从车站 2 到车站 3，费用是 3 + 6 = 9。
//总费用是 10 + 5 + 9 = 24。
//注意转换回特快路线时需要再次支付 expressCost 的费用。
// 
//
// 
//
// 提示： 
//
// 
// n == regular.length == express.length 
// 1 <= n <= 10⁵ 
// 1 <= regular[i], express[i], expressCost <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 2 👎 0


package cn.db117.leetcode.solution23;

import java.util.Arrays;

/**
 * 2361.乘坐火车路线的最少费用.minimum-costs-using-the-train-line
 *
 * @author db117
 * @since 2023-02-27 15:39:17
 **/

public class Solution_2361 {
    public static void main(String[] args) {
        Solution solution = new Solution_2361().new Solution();
        // regular =
        //[1,6,9,5]
        //express =
        //[5,2,3,10]
        //expressCost =
        //8
        System.out.println(Arrays.toString(solution.minimumCosts(new int[]{1, 6, 9, 5}, new int[]{5, 2, 3, 10}, 8)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
            int n = regular.length;
            long[] ans = new long[n];
            long[][] dp = new long[n][2];// [普通车，快车]

            // 初始化第一个
            dp[0][0] = regular[0];
            dp[0][1] = express[0] + expressCost;
            ans[0] = Math.min(dp[0][0], dp[0][1]);
            for (int i = 1; i < n; i++) {
                // 到普通车有两条路,从普通路过来和从特快路过来
                dp[i][0] = Math.min(dp[i - 1][0] + regular[i], dp[i - 1][1] + Math.min(express[i], regular[i]));
                // 到快车有两条路,直接从当前普通站到当前快车站，从上一个快车站到这个
                dp[i][1] = Math.min(dp[i - 1][0] + express[i] + expressCost, dp[i - 1][1] + express[i]);

                ans[i] = Math.min(dp[i][0], dp[i][1]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
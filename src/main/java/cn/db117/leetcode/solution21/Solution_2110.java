

//给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。 
//
// 一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。 
//
// 请你返回 平滑下降阶段 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：prices = [3,2,1,4]
//输出：7
//解释：总共有 7 个平滑下降阶段：
//[3], [2], [1], [4], [3,2], [2,1] 和 [3,2,1]
//注意，仅一天按照定义也是平滑下降阶段。
// 
//
// 示例 2： 
//
// 输入：prices = [8,6,7,7]
//输出：4
//解释：总共有 4 个连续平滑下降阶段：[8], [6], [7] 和 [7]
//由于 8 - 6 ≠ 1 ，所以 [8,6] 不是平滑下降阶段。
// 
//
// 示例 3： 
//
// 输入：prices = [1]
//输出：1
//解释：总共有 1 个平滑下降阶段：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 1 <= prices[i] <= 10⁵ 
// 
// Related Topics 数组 数学 动态规划 👍 4 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2110.股票平滑下跌阶段的数目.number-of-smooth-descent-periods-of-a-stock
 *
 * @author db117
 * @since 2021-12-22 15:59:33
 **/

public class Solution_2110 {
    public static void main(String[] args) {
        Solution solution = new Solution_2110().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long getDescentPeriods(int[] prices) {
            long ans = 0;

            int index = 0;
            while (index < prices.length) {
                // 找连续平滑下降阶段最长
                int right = index + 1;
                while (right < prices.length && prices[right - 1] - 1 == prices[right]) {
                    right++;
                }
                // 从 1 累加到 n
                ans += helper(right - index);
                index = right;
            }
            return ans;
        }

        private long helper(int n) {
            long ans = 0;
            for (int i = 0; i <= n; i++) {
                ans += i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
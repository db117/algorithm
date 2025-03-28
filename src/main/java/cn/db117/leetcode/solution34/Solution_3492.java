

//给你一个正整数 n，表示船上的一个 n x n 的货物甲板。甲板上的每个单元格可以装载一个重量 恰好 为 w 的集装箱。 
//
// 然而，如果将所有集装箱装载到甲板上，其总重量不能超过船的最大承载重量 maxWeight。 
//
// 请返回可以装载到船上的 最大 集装箱数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 2, w = 3, maxWeight = 15 
// 
//
// 输出： 4 
//
// 解释： 
//
// 甲板有 4 个单元格，每个集装箱的重量为 3。将所有集装箱装载后，总重量为 12，未超过 maxWeight。 
//
// 示例 2： 
//
// 
// 输入： n = 3, w = 5, maxWeight = 20 
// 
//
// 输出： 4 
//
// 解释： 
//
// 甲板有 9 个单元格，每个集装箱的重量为 5。可以装载的最大集装箱数量为 4，此时总重量不超过 maxWeight。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 1 <= w <= 1000 
// 1 <= maxWeight <= 10⁹ 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution34;

/**
 * 3492.船上可以装载的最大集装箱数量.maximum-containers-on-a-ship
 *
 * @author db117
 * @since 2025-03-24 10:12:32
 **/

public class Solution_3492 {
    public static void main(String[] args) {
        Solution solution = new Solution_3492().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxContainers(int n, int w, int maxWeight) {
            return Math.min(maxWeight / w, n * n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置
//。 
//
// 给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 10⁹ + 
//7 取余 的结果。 
//
// 如果所执行移动的顺序不完全相同，则认为两种方法不同。 
//
// 注意：数轴包含负整数。 
//
// 
//
// 示例 1： 
//
// 输入：startPos = 1, endPos = 2, k = 3
//输出：3
//解释：存在 3 种从 1 到 2 且恰好移动 3 步的方法：
//- 1 -> 2 -> 3 -> 2.
//- 1 -> 2 -> 1 -> 2.
//- 1 -> 0 -> 1 -> 2.
//可以证明不存在其他方法，所以返回 3 。 
//
// 示例 2： 
//
// 输入：startPos = 2, endPos = 5, k = 10
//输出：0
//解释：不存在从 2 到 5 且恰好移动 10 步的方法。 
//
// 
//
// 提示： 
//
// 
// 1 <= startPos, endPos, k <= 1000 
// 
//
// 👍 20 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2400.恰好移动 k 步到达某一位置的方法数目.number-of-ways-to-reach-a-position-after-exactly-k-steps
 *
 * @author db117
 * @since 2022-09-06 15:58:29
 **/

public class Solution_2400 {
    public static void main(String[] args) {
        Solution solution = new Solution_2400().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = 1000000007;

        public int numberOfWays(int startPos, int endPos, int k) {
            long[] dp = new long[4005];
            dp[startPos + 1000] = 1;
            for (int i = 0; i < k; i++) {
                long[] old = dp;
                dp = new long[4005];
                for (int j = 1; j < dp.length - 1; j++) {
                    dp[j] += old[j - 1] + old[j + 1];
                    dp[j] %= mod;
                }
            }
            return (int) (dp[endPos + 1000] % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
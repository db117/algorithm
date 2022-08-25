

//如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。 
//
// 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 20
//输出：19
//解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
//解释：1 到 5 所有整数都是特殊整数。
// 
//
// 示例 3： 
//
// 
//输入：n = 135
//输出：110
//解释：从 1 到 135 总共有 110 个整数是特殊整数。
//不特殊的部分数字为：22 ，114 和 131 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁹ 
// 
//
// Related Topics 数学 动态规划 👍 28 👎 0


package cn.db117.leetcode.solution23;

import java.util.Arrays;

/**
 * 2376.统计特殊整数.count-special-integers
 *
 * @author db117
 * @since 2022-08-25 16:22:03
 **/

public class Solution_2376 {
    public static void main(String[] args) {
        Solution solution = new Solution_2376().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars;
        int[][] dp;

        public int countSpecialNumbers(int n) {
            // 数位 DP
            chars = Integer.toString(n).toCharArray();
            dp = new int[chars.length][1 << 10];
            for (int[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            // 初始
            // 第一个数字开始,没有选择数字,有最大数字限制,当前还没有选数字
            return f(0, 0, true, false);
        }

        /**
         * 从左往右选第 i 个数字时,前面状态为 mask 时合法的方案数
         *
         * @param i       当前第几位数字
         * @param mask    记录已经选择的数字(bit 位标记)
         * @param isLimit 是否有限制(前面的数字已经选到最大值了,那么后面的数字的最大值会有限制)
         *                比如 最大数为 5678
         *                当前面已经选了 56 了,那么第三个数字最多只能选到 7
         * @param hasNum  前面是否已经选择了数字(处理 0000010 这种情况)
         * @return 当前可以选择的数字数量
         */
        private int f(int i, int mask, boolean isLimit, boolean hasNum) {
            if (i == chars.length) {
                // 走完了,如果选了数字则为 1,没有选就为 0
                return hasNum ? 1 : 0;
            }

            // 缓存
            // 降低时间复杂度
            if (!isLimit /*有限制时还是要算一下的*/ &&
                    hasNum /*没有选择数字没有意义*/ &&
                    dp[i][mask] != -1) {
                return dp[i][mask];
            }

            int ans = 0;
            if (!hasNum) {
                // 前面没有选数字,而且当前为没有限制可以跳过当前位数
                // 比如 000010  在 i<4 时都可以在这算上
                ans = f(i + 1, mask, false, false);
            }

            for (int k = hasNum ? 0 : 1/*前面没有选数字,不能选 0*/,
                 end = isLimit ? chars[i] - '0' : 9/*有限制最多只能选择到 s[i]*/;
                 k <= end; k++) {
                if ((mask >> k & 1) == 0) {
                    ans += f(i + 1, // 选择下一位
                            mask | 1 << k,  // 标记当前为已经选择
                            isLimit && k == end,// 确定下一个数字选择是否需要限制
                            true// 当前已经选择了数字
                    );
                }
            }

            if (!isLimit && hasNum) {
                // 缓存
                // 只有当没有限制的情况下才能复用
                dp[i][mask] = ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
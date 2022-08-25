

//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 动态规划 👍 456 👎 0


package cn.db117.leetcode.solution2;

import java.util.Arrays;

/**
 * 233.数字 1 的个数.number-of-digit-one
 *
 * @author db117
 * @see cn.db117.template.dp.NumberBitDP
 * @since 2022-08-25 18:47:44
 **/

public class Solution_233 {
    public static void main(String[] args) {
        Solution solution = new Solution_233().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            chars = Integer.toString(n).toCharArray();
            dp = new int[chars.length][chars.length];
            for (int[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            // 初始
            // 第一个数字开始,没有选择数字 1,有最大数字限制
            return f(0, 0, true);
        }

        char[] chars;
        int[][] dp;

        /**
         * 从左往右选第 i 个数字时,前面状态为 mask 时合法的方案数
         *
         * @param i       当前第几位数字
         * @param mask    一共选了多少个 1
         * @param isLimit 是否有限制(前面的数字已经选到最大值了,那么后面的数字的最大值会有限制)
         *                比如 最大数为 5678
         *                当前面已经选了 56 了,那么第三个数字最多只能选到 7
         * @return 当前可以选择的数字数量
         */
        private int f(int i, int mask, boolean isLimit) {
            if (i == chars.length) {
                // 走完了
                return mask;
            }

            // 缓存
            // 降低时间复杂度
            if (!isLimit /*有限制时还是要算一下的*/ &&
                    dp[i][mask] != -1) {
                return dp[i][mask];
            }

            int ans = 0;

            for (int k = 0 /*前面没有选数字,不能选 0*/,
                 end = isLimit ? chars[i] - '0' : 9/*有限制最多只能选择到 s[i]*/;
                 k <= end; k++) {

                ans += f(i + 1, // 选择下一位
                        mask + (k == 1 ? 1 : 0),  // 标记当前为已经选择
                        isLimit && k == end// 确定下一个数字选择是否需要限制
                );

            }

            if (!isLimit) {
                // 缓存
                // 只有当没有限制的情况下才能复用
                dp[i][mask] = ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
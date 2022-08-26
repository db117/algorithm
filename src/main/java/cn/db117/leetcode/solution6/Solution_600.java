

//给定一个正整数 n ，返回范围在 [0, n] 都非负整数中，其二进制表示不包含 连续的 1 的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 5
//输出: 5
//解释: 
//下面是带有相应二进制表示的非负整数<= 5：
//0 : 0
//1 : 1
//2 : 10
//3 : 11
//4 : 100
//5 : 101
//其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。 
//
// 示例 2: 
//
// 
//输入: n = 1
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: n = 2
//输出: 3
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 动态规划 👍 291 👎 0


package cn.db117.leetcode.solution6;

import java.util.Arrays;

/**
 * 600.不含连续1的非负整数.non-negative-integers-without-consecutive-ones
 *
 * @author db117
 * @see cn.db117.template.dp.NumberBitDP
 * @since 2022-08-26 10:58:00
 **/

public class Solution_600 {
    public static void main(String[] args) {
        Solution solution = new Solution_600().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findIntegers(int n) {
            // 数位 DP
            chars = Integer.toString(n, 2).toCharArray();
            dp = new int[chars.length][2];
            for (int[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            // 初始
            // 第一个数字开始,没有选择数字,有最大数字限制,当前还没有选数字
            return f(0, 0, true);
        }

        char[] chars;
        int[][] dp;

        /**
         * 从左往右选第 i 个数字时,前面状态为 mask 时合法的方案数
         *
         * @param i       当前第几位数字
         * @param mask    前面一位选择的数字
         * @param isLimit 是否有限制(前面的数字已经选到最大值了,那么后面的数字的最大值会有限制)
         *                比如 最大数为 5678
         *                当前面已经选了 56 了,那么第三个数字最多只能选到 7
         * @return 当前可以选择的数字数量
         */
        private int f(int i, int mask, boolean isLimit) {
            if (i == chars.length) {
                // 走完了,如果选了数字则为 1,没有选就为 0
                return 1;
            }

            // 缓存
            // 降低时间复杂度
            if (!isLimit &&
                    dp[i][mask] != -1) {
                return dp[i][mask];
            }

            // 当前位最多能取到的位置
            int up = isLimit ? chars[i] - '0' : 1;
            int ans = 0;


            // 填 0
            // 什么情况下都可以填 0,需要确定一下是否能填 1
            // 当当前位有限制而且当前位只能填 0 时会限制下一位的选择
            ans = f(i + 1, 0, isLimit && up == 0);

            if (mask == 0 && up == 1) {
                // 填 1
                // 当前一位选择了 0,而且当前位置可以选到 1 时
                // 当前位如果限制选择了,则下一位还需要限制
                ans += f(i + 1, 1, isLimit);
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
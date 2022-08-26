

//给定一个在 0 到 9 之间的整数 d，和两个正整数 low 和 high 分别作为上下界。返回 d 在 low 和 high 之间的整数中出现的次数，包括
//边界 low 和 high。 
//
// 
//
// 示例 1： 
//
// 输入：d = 1, low = 1, high = 13
//输出：6
//解释： 
//数字 d=1 在 1,10,11,12,13 中出现 6 次。注意 d=1 在数字 11 中出现两次。
// 
//
// 示例 2： 
//
// 输入：d = 3, low = 100, high = 250
//输出：35
//解释：
//数字 d=3 在 103,113,123,130,131,...,238,239,243 出现 35 次。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= d <= 9 
// 1 <= low <= high <= 2×10^8 
// 
//
// Related Topics 数学 动态规划 👍 24 👎 0


package cn.db117.leetcode.solution10;

import java.util.Arrays;

/**
 * 1067.范围内的数字计数.digit-count-in-range
 *
 * @author db117
 * @see cn.db117.template.dp.NumberBitDP
 * @since 2022-08-26 15:39:29
 **/

public class Solution_1067 {
    public static void main(String[] args) {
        Solution solution = new Solution_1067().new Solution();
        System.out.println(solution.digitsCount(1, 1, 13));
        System.out.println(solution.digitsCount(3, 100, 250));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int digitsCount(int d, int low, int high) {
            // 数位 DP
            // 转换为 ([1,high] 含 d 的数量)  减去( [1,low-1] 含 d 的数量)
            this.d = d;

            int h = countSpecialNumbers(high);
            int l = countSpecialNumbers(low - 1);
            return h - l;
        }

        char[] chars;
        int[][] dp;
        int d;

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
         * 从左往右选第 i 个数字时,前面状态为 count 时合法的方案数
         *
         * @param i       当前第几位数字
         * @param count   记录已经选择的数字的次数
         * @param isLimit 是否有限制(前面的数字已经选到最大值了,那么后面的数字的最大值会有限制)
         *                比如 最大数为 5678
         *                当前面已经选了 56 了,那么第三个数字最多只能选到 7
         * @param hasNum  前面是否已经选择了数字(处理 0000010 这种情况)
         * @return 当前可以选择的数字数量
         */
        private int f(int i, int count, boolean isLimit, boolean hasNum) {
            if (i == chars.length) {
                // 走完了,如果选了数字则为 1,没有选就为 0
                return count;
            }

            // 缓存
            // 降低时间复杂度
            if (!isLimit /*有限制时还是要算一下的*/ &&
                    hasNum /*没有选择数字没有意义*/ &&
                    dp[i][count] != -1) {
                return dp[i][count];
            }

            int ans = 0;
            if (!hasNum) {
                // 前面没有选数字,而且当前为没有限制可以跳过当前位数
                // 比如 000010  在 i<4 时都可以在这算上
                ans = f(i + 1, count, false, false);
            }

            // 有限制最多只能选择到 s[i]
            int end = isLimit ? chars[i] - '0' : 9;
            // 前面没有选数字,不能选 0
            int start = hasNum ? 0 : 1;
            for (int k = start; k <= end; k++) {
                ans += f(i + 1, // 选择下一位
                        count + (k == d ? 1 : 0),  // 标记当前为已经选择
                        isLimit && k == end,// 确定下一个数字选择是否需要限制
                        true// 当前已经选择了数字
                );

            }

            if (!isLimit && hasNum) {
                // 缓存
                // 只有当没有限制的情况下才能复用
                dp[i][count] = ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
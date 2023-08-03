package cn.db117.template.dp;

import cn.db117.leetcode.solution10.Solution_1012;
import cn.db117.leetcode.solution10.Solution_1067;
import cn.db117.leetcode.solution2.Solution_233;
import cn.db117.leetcode.solution23.Solution_2376;
import cn.db117.leetcode.solution6.Solution_600;
import cn.db117.leetcode.solution9.Solution_902;

import java.util.Arrays;

/**
 * 数位 DP
 *
 * @author db117
 * @see Solution_233
 * @see Solution_600
 * @see Solution_902
 * @see Solution_1012
 * @see Solution_1067
 * @see Solution_2376
 * @see cn.db117.leetcode.solution28.Solution_2801
 * @since 2022/8/25 16:55
 **/
public class NumberBitDP {
    class Solution {
        char[] chars;
        long[][] dp;

        public int countSpecialNumbers(int n) {
            // 数位 DP
            chars = Integer.toString(n).toCharArray();
            dp = new long[chars.length][1 << 10];
            for (long[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            // 初始
            // 第一个数字开始,没有选择数字,有最大数字限制,当前还没有选数字
            return (int) f(0, 0, true, false);
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
        private long f(int i, int mask, boolean isLimit, boolean hasNum) {
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

            long ans = 0;
            if (!hasNum) {
                // 前面没有选数字,而且当前为没有限制可以跳过当前位数
                // 比如 000010  在 i<4 时都可以在这算上
                ans = f(i + 1, mask, false, false);
            }

            // 有限制最多只能选择到 s[i]
            int end = isLimit ? chars[i] - '0' : 9;
            // 前面没有选数字,不能选 0
            int start = hasNum ? 0 : 1;
            for (int k = start; k <= end; k++) {
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
}

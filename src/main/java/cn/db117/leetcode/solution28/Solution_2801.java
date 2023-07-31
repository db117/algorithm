

//给你两个正整数 low 和 high ，都用字符串表示，请你统计闭区间 [low, high] 内的 步进数字 数目。 
//
// 如果一个整数相邻数位之间差的绝对值都 恰好 是 1 ，那么这个数字被称为 步进数字 。 
//
// 请你返回一个整数，表示闭区间 [low, high] 之间步进数字的数目。 
//
// 由于答案可能很大，请你将它对 10⁹ + 7 取余 后返回。 
//
// 注意：步进数字不能有前导 0 。 
//
// 
//
// 示例 1： 
//
// 输入：low = "1", high = "11"
//输出：10
//解释：区间 [1,11] 内的步进数字为 1 ，2 ，3 ，4 ，5 ，6 ，7 ，8 ，9 和 10 。总共有 10 个步进数字。所以输出为 10 。 
//
// 示例 2： 
//
// 输入：low = "90", high = "101"
//输出：2
//解释：区间 [90,101] 内的步进数字为 98 和 101 。总共有 2 个步进数字。所以输出为 2 。 
//
// 
//
// 提示： 
//
// 
// 1 <= int(low) <= int(high) < 10¹⁰⁰ 
// 1 <= low.length, high.length <= 100 
// low 和 high 只包含数字。 
// low 和 high 都不含前导 0 。 
// 
//
// 👍 9 👎 0


package cn.db117.leetcode.solution28;

import java.util.Arrays;

/**
 * 2801.统计范围内的步进数字数目.count-stepping-numbers-in-range
 *
 * @author db117
 * @since 2023-07-31 10:44:54
 **/

public class Solution_2801 {
    public static void main(String[] args) {
        Solution solution = new Solution_2801().new Solution();
//        System.out.println(solution.countSteppingNumbers("0", "1000000000000000000"));
        System.out.println(solution.countSteppingNumbers("1", "11"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) (1e9 + 7);

        public int countSteppingNumbers(String low, String high) {
            chars = low.toCharArray();
            dp = new long[chars.length][10];
            for (long[] ints : dp) {
                Arrays.fill(ints, -1);
            }

            long lowCount = f(0, 0, true, false);

            chars = high.toCharArray();
            dp = new long[chars.length][10];
            for (long[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            long highCount = f(0, 0, true, false);

            if (check(low)) {
                // 低位是步进数字,闭区间要包含
                lowCount--;
            }
            return (int) ((highCount - lowCount + mod) % mod);// 防止负数

        }

        /**
         * 检查是否为步进数字
         */
        private boolean check(String s) {
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (Math.abs(chars[i] - chars[i - 1]) != 1) {
                    return false;
                }
            }
            return true;
        }

        char[] chars;
        long[][] dp;


        /**
         * 从左往右选第 i 个数字时,前面数字为 pre 时合法的方案数
         *
         * @param i       当前第几位数字
         * @param pre     记录已经选择的数字
         * @param isLimit 是否有限制(前面的数字已经选到最大值了,那么后面的数字的最大值会有限制)
         *                比如 最大数为 5678
         *                当前面已经选了 56 了,那么第三个数字最多只能选到 7
         * @param hasNum  前面是否已经选择了数字(处理 0000010 这种情况)
         * @return 当前可以选择的数字数量
         */
        private long f(int i, int pre, boolean isLimit, boolean hasNum) {
            if (i == chars.length) {
                // 走完了,如果选了数字则为 1,没有选就为 0
                return hasNum ? 1 : 0;
            }

            // 缓存
            // 降低时间复杂度
            if (!isLimit /*有限制时还是要算一下的*/ &&
                    hasNum /*没有选择数字没有意义*/ &&
                    dp[i][pre] != -1) {
                return dp[i][pre];
            }

            long ans = 0;
            if (!hasNum) {
                // 前面没有选数字,而且当前为没有限制可以跳过当前位数
                // 比如 000010  在 i<4 时都可以在这算上
                ans = f(i + 1, pre, false, false);
            }

            // 有限制最多只能选择到 s[i]
            int end = isLimit ? chars[i] - '0' : 9;
            // 前面没有选数字,不能选 0
            int start = hasNum ? 0 : 1;
            for (int k = start; k <= end; k++) {
                if (!hasNum || Math.abs(pre - k) == 1) {// 第一个数字可以都选,后面的数字必须满足相邻
                    ans += f(i + 1, // 选择下一位
                            k,  // 标记当前为已经选择
                            isLimit && k == end,// 确定下一个数字选择是否需要限制
                            true// 当前已经选择了数字
                    );
                }
            }
            ans %= mod;

            if (!isLimit && hasNum) {
                // 缓存
                // 只有当没有限制的情况下才能复用
                dp[i][pre] = ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
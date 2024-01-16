

//给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数： 
//
// 
// num1 <= x <= num2 
// min_sum <= digit_sum(x) <= max_sum. 
// 
//
// 请你返回好整数的数目。答案可能很大，请返回答案对 10⁹ + 7 取余后的结果。 
//
// 注意，digit_sum(x) 表示 x 各位数字之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1", num2 = "12", min_num = 1, max_num = 8
//输出：11
//解释：总共有 11 个整数的数位和在 1 到 8 之间，分别是 1,2,3,4,5,6,7,8,10,11 和 12 。所以我们返回 11 。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1", num2 = "5", min_num = 1, max_num = 5
//输出：5
//解释：数位和在 1 到 5 之间的 5 个整数分别为 1,2,3,4 和 5 。所以我们返回 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1 <= num2 <= 10²² 
// 1 <= min_sum <= max_sum <= 400 
// 
//
// Related Topics 数学 字符串 动态规划 👍 47 👎 0


package cn.db117.leetcode.solution27;

import java.util.Arrays;

/**
 * 2719.统计整数数目.count-of-integers
 *
 * @author db117
 * @since 2024-01-16 10:48:02
 **/

public class Solution_2719 {
    public static void main(String[] args) {
        Solution solution = new Solution_2719().new Solution();
        // "1"
        //			"12"
        //			1
        //			8
        System.out.println(solution.count("1", "12", 1, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MOD = (int) (1e9 + 7);
        int min_sum;
        int max_sum;

        public int count(String num1, String num2, int min_sum, int max_sum) {
            this.min_sum = min_sum;
            this.max_sum = max_sum;
            // 0 - num1 的数量
            long count1 = helper(num1);
            // 0 - num2 的数量
            long count2 = helper(num2);
            long ans = (count2 - count1 + MOD) % MOD;

            // 单独判断 num1 是否符合(前面没有算num1)
            int sum = 0;
            for (char c : num1.toCharArray()) {
                sum += c - '0';
            }
            if (sum >= min_sum && sum <= max_sum) {
                ans++;
            }
            return (int) (ans % MOD);
        }

        private long helper(String num1) {
            char[] chars = num1.toCharArray();
            long[][] dp = new long[chars.length][max_sum + 1];
            for (long[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            return f(0, 0, true, false, chars, dp);
        }

        /**
         * 从左往右选第 i 个数字时,前面状态为 sum 时合法的方案数
         *
         * @param i       当前第几位数字
         * @param sum     当前数字和
         * @param isLimit 是否有限制(前面的数字已经选到最大值了,那么后面的数字的最大值会有限制)
         *                比如 最大数为 5678
         *                当前面已经选了 56 了,那么第三个数字最多只能选到 7
         * @param hasNum  不需要了,前面全是 0 不影响计数
         * @return 当前可以选择的数字数量
         */
        private long f(int i, int sum, boolean isLimit, boolean hasNum, char[] chars, long[][] dp) {
            if (sum > max_sum) {
                return 0;
            }
            if (i == chars.length) {
                return sum < min_sum ? 0 : 1;
            }

            // 缓存
            // 降低时间复杂度
            if (!isLimit /*有限制时还是要算一下的*/ &&
                    dp[i][sum] != -1) {
                return dp[i][sum];
            }

            long ans = 0;

            // 有限制最多只能选择到 s[i]
            int end = isLimit ? chars[i] - '0' : 9;
            int start = 0;
            for (int k = start; k <= end; k++) {

                ans += f(i + 1, // 选择下一位
                        sum + k,  // 加上当前位
                        isLimit && k == end,// 确定下一个数字选择是否需要限制
                        true,// 当前已经选择了数字
                        chars, dp
                ) % MOD;

            }

            if (!isLimit) {
                // 缓存
                // 只有当没有限制的情况下才能复用
                dp[i][sum] = ans;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
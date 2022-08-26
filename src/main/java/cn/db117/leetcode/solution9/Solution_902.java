

//给定一个按 非递减顺序 排列的数字数组
// digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果
// digits = ['1','3','5']，我们可以写数字，如
// '13', '551', 和 '1351315'。 
//
// 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = ["1","3","5","7"], n = 100
//输出：20
//解释：
//可写出的 20 个数字是：
//1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
// 
//
// 示例 2： 
//
// 
//输入：digits = ["1","4","9"], n = 1000000000
//输出：29523
//解释：
//我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
//81 个四位数字，243 个五位数字，729 个六位数字，
//2187 个七位数字，6561 个八位数字和 19683 个九位数字。
//总共，可以使用D中的数字写出 29523 个整数。 
//
// 示例 3: 
//
// 
//输入：digits = ["7"], n = 8
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= digits.length <= 9 
// digits[i].length == 1 
// digits[i] 是从 '1' 到 '9' 的数 
// digits 中的所有值都 不同 
// digits 按 非递减顺序 排列 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数组 数学 二分查找 动态规划 👍 104 👎 0


package cn.db117.leetcode.solution9;

import cn.db117.template.dp.NumberBitDP;

import java.util.Arrays;

/**
 * 902.最大为 N 的数字组合.numbers-at-most-n-given-digit-set
 *
 * @author db117
 * @see NumberBitDP
 * @since 2022-08-26 11:22:14
 **/

public class Solution_902 {
    public static void main(String[] args) {
        Solution solution = new Solution_902().new Solution();
//        System.out.println(solution.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"1", "4", "9"}, 1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] digits;

        public int atMostNGivenDigitSet(String[] digits, int n) {
            // 数位 DP
            chars = Integer.toString(n).toCharArray();
            this.digits = digits;

            dp = new int[chars.length];
            Arrays.fill(dp, -1);

            // 初始
            // 第一个数字开始,没有选择数字,有最大数字限制,当前还没有选数字
            return f(0, true, false);
        }

        char[] chars;
        int[] dp;

        /**
         * 从左往右选第 i 个数字时,前面状态为 mask 时合法的方案数
         *
         * @param i       当前第几位数字
         * @param isLimit 是否有限制(前面的数字已经选到最大值了,那么后面的数字的最大值会有限制)
         *                比如 最大数为 5678
         *                当前面已经选了 56 了,那么第三个数字最多只能选到 7
         * @param hasNum  前面是否已经选择了数字(处理 0000010 这种情况)
         * @return 当前可以选择的数字数量
         */
        private int f(int i, boolean isLimit, boolean hasNum) {
            if (i == chars.length) {
                // 走完了,如果选了数字则为 1,没有选就为 0
                return hasNum ? 1 : 0;
            }

            // 缓存
            // 降低时间复杂度
            if (!isLimit /*有限制时还是要算一下的*/ &&
                    hasNum /*没有选择数字没有意义*/ &&
                    dp[i] != -1) {
                return dp[i];
            }

            int ans = 0;

            // 前面没有选数字,而且当前为没有限制可以跳过当前位数
            // 比如 000010  在 i<4 时都可以在这算上
            if (!hasNum) {
                ans = f(i + 1, false, false);
            }

            // 最大能到的数字
            char max = isLimit ? chars[i] : '9';
            for (String digit : digits) {
                if (digit.charAt(0) > max) {
                    // 有限制,就不能操过当为
                    break;
                }
                ans += f(i + 1, isLimit && digit.charAt(0) == max/*到了能到的最大值,后面的数字就有限制*/, true);
            }

            if (!isLimit && hasNum) {
                // 缓存
                // 只有当没有限制的情况下才能复用
                dp[i] = ans;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
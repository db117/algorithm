

//某个程序本来应该输出一个整数数组。但是这个程序忘记输出空格了以致输出了一个数字字符串，我们所知道的信息只有：数组中所有整数都在 [1, k] 之间，且数组中
//的数字都没有前导 0 。 
//
// 给你字符串 s 和整数 k 。可能会有多种不同的数组恢复结果。 
//
// 按照上述程序，请你返回所有可能输出字符串 s 的数组方案数。 
//
// 由于数组方案数可能会很大，请你返回它对 10^9 + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：s = "1000", k = 10000
//输出：1
//解释：唯一一种可能的数组方案是 [1000]
// 
//
// 示例 2： 
//
// 输入：s = "1000", k = 10
//输出：0
//解释：不存在任何数组方案满足所有整数都 >= 1 且 <= 10 同时输出结果为 s 。
// 
//
// 示例 3： 
//
// 输入：s = "1317", k = 2000
//输出：8
//解释：可行的数组方案为 [1317]，[131,7]，[13,17]，[1,317]，[13,1,7]，[1,31,7]，[1,3,17]，[1,3,1,7
//]
// 
//
// 示例 4： 
//
// 输入：s = "2020", k = 30
//输出：1
//解释：唯一可能的数组方案是 [20,20] 。 [2020] 不是可行的数组方案，原因是 2020 > 30 。 [2,020] 也不是可行的数组方案，因为
// 020 含有前导 0 。
// 
//
// 示例 5： 
//
// 输入：s = "1234567890", k = 90
//输出：34
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5. 
// s 只包含数字且不包含前导 0 。 
// 1 <= k <= 10^9. 
// 
//
// Related Topics 字符串 动态规划 👍 51 👎 0


package cn.db117.leetcode.solution14;

import java.util.Arrays;

/**
 * 1416.恢复数组.restore-the-array
 *
 * @author db117
 * @since 2023-04-19 14:03:02
 **/

public class Solution_1416 {
    public static void main(String[] args) {
        Solution solution = new Solution_1416().new Solution();
        // 411743991
        System.out.println(solution.numberOfArrays("600342244431311113256628376226052681059918526204", 703));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String s;
        int k;
        long[] memo;
        static int mod = (int) (1e9 + 7);

        public int numberOfArrays(String s, int k) {
            if (s.charAt(0) == '0') {
                return 0;
            }
            this.s = s;
            this.k = k;
            int n = s.length();
            memo = new long[n];
            Arrays.fill(memo, -1);
            return (int) dfs(n - 1);
        }

        private long dfs(int end) {
            if (end < 0) {
                // 都走完了，算一种可能性
                return 1;
            }
            if (memo[end] != -1) {
                return memo[end];
            }

            long ans = 0;
            for (int i = end; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    continue;
                }
                if (end - i + 1 > 12) {
                    // 肯定超过 k 了
                    break;
                }
                // 当前区间的数字
                long cur = Long.parseLong(s.substring(i, end + 1));
                if (cur <= k) {
                    // 选择当前数字的情况下，前面有多少总可能
                    ans += dfs(i - 1);
                } else {
                    break;
                }
            }
            ans %= mod;
            memo[end] = ans;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
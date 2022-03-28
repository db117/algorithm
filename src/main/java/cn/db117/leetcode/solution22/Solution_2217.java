

//给你一个整数数组 queries 和一个 正 整数 intLength ，请你返回一个数组 answer ，其中 answer[i] 是长度为 
//intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1 。 
//
// 回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：queries = [1,2,3,4,5,90], intLength = 3
//输出：[101,111,121,131,141,999]
//解释：
//长度为 3 的最小回文数依次是：
//101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 201, ...
//第 90 个长度为 3 的回文数是 999 。
// 
//
// 示例 2： 
//
// 
//输入：queries = [2,4,6], intLength = 4
//输出：[1111,1331,1551]
//解释：
//长度为 4 的前 6 个回文数是：
//1001, 1111, 1221, 1331, 1441 和 1551 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 5 * 10⁴ 
// 1 <= queries[i] <= 10⁹ 
// 1 <= intLength <= 15 
// 
// Related Topics 数学 👍 13 👎 0


package cn.db117.leetcode.solution22;

/**
 * 2217.找到指定长度的回文数.find-palindrome-with-fixed-length
 *
 * @author db117
 * @since 2022-03-28 15:44:26
 **/

public class Solution_2217 {
    public static void main(String[] args) {
        Solution solution = new Solution_2217().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long[] kthPalindrome(int[] queries, int intLength) {
            // 只考虑前一半
            int start = 1;// 开始的数字
            for (int i = 1; i < (intLength + 1) / 2; i++) {
                start *= 10;
            }

            long[] ans = new long[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = help(start + queries[i] - 1, intLength);
            }

            return ans;
        }

        /**
         * 从前一半拼出一个完整的数字
         *
         * @param num 数字
         * @param len 总长度
         */
        private long help(int num, int len) {
            String s = Integer.toString(num);
            StringBuilder b = new StringBuilder(s);
            if (len % 2 == 0) {
                String l = s + b.reverse();
                if (l.length() != len) {
                    // 防止 num 溢出
                    return -1;
                }
                return Long.parseLong(l);
            }

            String l = s + b.delete(b.length() - 1, b.length()).reverse();
            if (l.length() != len) {
                return -1;
            }
            return Long.parseLong(l);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
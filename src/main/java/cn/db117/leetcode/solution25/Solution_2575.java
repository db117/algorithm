

//给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。 
//
// word 的 可整除数组 div 是一个长度为 n 的整数数组，并满足： 
//
// 
// 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1 
// 否则，div[i] = 0 
// 
//
// 返回 word 的可整除数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "998244353", m = 3
//输出：[1,1,0,0,0,1,1,0,0]
//解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
// 
//
// 示例 2： 
//
// 
//输入：word = "1010", m = 10
//输出：[0,1,0,1]
//解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// word.length == n 
// word 由数字 0 到 9 组成 
// 1 <= m <= 10⁹ 
// 
//
// 👍 6 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2575.找出字符串的可整除数组.find-the-divisibility-array-of-a-string
 *
 * @author db117
 * @since 2023-02-27 10:40:19
 **/

public class Solution_2575 {
    public static void main(String[] args) {
        Solution solution = new Solution_2575().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] divisibilityArray(String word, int m) {
            int n = word.length();
            int[] ans = new int[n];

            long cur = 0;
            char[] chars = word.toCharArray();
            // 取模不影响一个数字能否被除
            for (int i = 0; i < chars.length; i++) {
                cur *= 10;
                cur += chars[i] - '0';
                if (cur % m == 0) {
                    // 可以被除，则前面的数字可以不考虑了
                    ans[i] = 1;
                    cur = 0;
                } else {
                    // 不能被除，则取模
                    ans[i] = 0;
                    cur %= m;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
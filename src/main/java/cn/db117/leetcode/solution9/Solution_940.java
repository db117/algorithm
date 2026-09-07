

//给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。 
//
// 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：7
//解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
// 
//
// 示例 2： 
//
// 
//输入：s = "aba"
//输出：6
//解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
// 
//
// 示例 3： 
//
// 
//输入：s = "aaa"
//输出：3
//解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
//
// 
//
// Related Topics 字符串 动态规划 👍 385 👎 0


package cn.db117.leetcode.solution9;

/**
 * 940.不同的子序列 II.distinct-subsequences-ii
 *
 * @author db117
 * @since 2026-09-07 18:53:23
 **/

public class Solution_940 {
    public static void main(String[] args) {
        Solution solution = new Solution_940().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = 1000000007;

        public int distinctSubseqII(String s) {
            int n = s.length();
            // dp[i][j] 表示以j字符结尾的子序列个数
            int[][] dp = new int[n + 7][26];
            for (int i = 0; i < n; i++) {
                // 前面的字符个数全部继承过来
                dp[i + 1] = dp[i].clone();
                // 前面的字符个数之和
                long sum = 0;
                for (int i1 : dp[i]) {
                    sum += i1;
                }
                // 当前字符个数为前面字符个数之和 + 1
                // 只算结尾的，前面的所有子序列+当前字符会生成全新的子序列。然后再加上自己
                dp[i + 1][s.charAt(i) - 'a'] = Math.toIntExact((1 + sum) % MOD);
            }
            // 最后全部加起来
            long sum = 0;
            for (int i1 : dp[n]) {
                sum += i1;
            }
            return (int) (sum % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
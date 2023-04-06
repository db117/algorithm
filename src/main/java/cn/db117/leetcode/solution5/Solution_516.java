

//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 992 👎 0


package cn.db117.leetcode.solution5;

import java.util.Arrays;

/**
 * 516.最长回文子序列.longest-palindromic-subsequence
 *
 * @author db117
 * @since 2023-04-04 23:52:36
 **/

public class Solution_516 {
    public static void main(String[] args) {
        Solution solution = new Solution_516().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        char[] chars;

        public int longestPalindromeSubseq(String s) {
            // 区间 dp
            int n = s.length();
            chars = s.toCharArray();
            memo = new int[n + 1][n + 1];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }

            return dfs(0, n - 1);
        }

        private int dfs(int i, int j) {
            if (i > j) {
                // 空串
                return 0;
            }
            if (i == j) {
                // 只有一个字符
                return 1;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int cur;
            if (chars[i] == chars[j]) {
                // 两边字符都选
                cur = dfs(i + 1, j - 1) + 2;
            } else {
                // 两边的字符串不一致
                // 枚举两边不选
                cur = Math.max(dfs(i + 1, j), dfs(i, j - 1));
            }

            return memo[i][j] = cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
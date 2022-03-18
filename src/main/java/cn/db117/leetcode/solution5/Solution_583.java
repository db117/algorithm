

//给定两个单词 word1 和 word2 ，返回使得 word1 和 word2 相同所需的最小步数。 
//
// 每步 可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例 1： 
//
// 
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
// 
//
// 示例 2: 
//
// 
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 和 word2 只包含小写英文字母 
// 
// Related Topics 字符串 动态规划 👍 390 👎 0


package cn.db117.leetcode.solution5;

/**
 * 583.两个字符串的删除操作.delete-operation-for-two-strings
 *
 * @author db117
 * @since 2022-03-18 14:36:41
 **/

public class Solution_583 {
    public static void main(String[] args) {
        Solution solution = new Solution_583().new Solution();
        System.out.println(solution.minDistance("sea", "eat"));
        System.out.println(solution.minDistance("leetcode", "etco"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            int len1 = chars1.length;
            int len2 = chars2.length;
            int[][] dp = new int[len1 + 1][len2 + 1];

            // 最长公共子序列
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (chars1[i - 1] == chars2[j - 1]) {
                        // 相同 lcs+1
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        // 不同这选择一个字符删除
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }

            // 减去最长公共子序列长度即可
            return len1 + len2 - 2 * dp[len1][len2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
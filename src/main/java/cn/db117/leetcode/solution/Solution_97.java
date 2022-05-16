

//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 注意：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它? 
// Related Topics 字符串 动态规划 👍 677 👎 0


package cn.db117.leetcode.solution;

/**
 * 97.交错字符串.interleaving-string
 *
 * @author db117
 * @since 2022-04-22 17:57:25
 **/

public class Solution_97 {
    public static void main(String[] args) {
        Solution solution = new Solution_97().new Solution();

        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(solution.isInterleave("", "", ""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }

            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            char[] chars3 = s3.toCharArray();

            // s1 前多少个字符串 和 s2 前多少个字符串是否能拼成 s3 前多少个字符串
            boolean[][] dp = new boolean[chars1.length + 1][chars2.length + 1];
            // 初始化数据
            dp[0][0] = true;
            for (int i = 0; i < chars1.length; i++) {
                dp[i + 1][0] = dp[i][0] && chars1[i] == chars3[i];
            }
            for (int i = 0; i < chars2.length; i++) {
                dp[0][i + 1] = dp[0][i] && chars2[i] == chars3[i];
            }

            for (int i = 1; i <= chars1.length; i++) {
                for (int j = 1; j <= chars2.length; j++) {
                    // 可以从 s1 拿
                    if (dp[i - 1][j]) {
                        if (chars1[i - 1] == chars3[i - 1 + j]) {
                            dp[i][j] = true;
                        }
                    }

                    // 可以从 s2 拿
                    if (dp[i][j - 1]) {
                        if (chars2[j - 1] == chars3[i - 1 + j]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
            return dp[chars1.length][chars2.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 259 👎 0


package cn.db117.leetcode.solution7;

/**
 * 712.两个字符串的最小ASCII删除和.minimum-ascii-delete-sum-for-two-strings
 *
 * @author db117
 * @since 2022-03-18 14:25:11
 **/

public class Solution_712 {
    public static void main(String[] args) {
        Solution solution = new Solution_712().new Solution();

        System.out.println(solution.minimumDeleteSum("sea", "eat"));
        System.out.println(solution.minimumDeleteSum("delete", "leet"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            // s1 [0, i-1] 和 s2 [0,j-1] 最小和
            int[][] dp = new int[chars1.length + 1][chars2.length + 1];

            // base case
            // 另一个字符串为空是的和
            for (int i = 1; i <= chars1.length; i++) {
                dp[i][0] = dp[i - 1][0] + chars1[i - 1];
            }
            for (int j = 1; j <= chars2.length; j++) {
                dp[0][j] = dp[0][j - 1] + chars2[j - 1];
            }


            for (int i = 1; i <= chars1.length; i++) {
                for (int j = 1; j <= chars2.length; j++) {
                    if (chars1[i - 1] == chars2[j - 1]) {
                        // 两个字符串相等,直接取前面的
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 保留 s1,删除 s2  dp[i][j - 1] + chars2[j - 1]
                        // 保留 s2,删除 s1  dp[i - 1][j] + chars1[i - 1]
                        // 去最小的
                        dp[i][j] = Math.min(dp[i][j - 1] + chars2[j - 1],
                                dp[i - 1][j] + chars1[i - 1]);
                    }
                }
            }
            return dp[chars1.length][chars2.length];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
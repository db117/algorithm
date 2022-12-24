

//给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。换言之，请你找到 s 和 t 串中 
//恰好 只有一个字符不同的子字符串对的数目。 
//
// 比方说， "computer" 和 "computation" 加粗部分只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。 
//
// 请你返回满足上述条件的不同子字符串对数目。 
//
// 一个 子字符串 是一个字符串中连续的字符。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba", t = "baba"
//输出：6
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//
//示例 2：
//
// 
//输入：s = "ab", t = "bb"
//输出：3
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("ab", "bb")
//("ab", "bb")
//("ab", "bb")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//
//示例 3：
//
// 
//输入：s = "a", t = "a"
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：s = "abe", t = "bbc"
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 100 
// s 和 t 都只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 动态规划 👍 50 👎 0


package cn.db117.leetcode.solution16;

/**
 * 1638.统计只差一个字符的子串数目.count-substrings-that-differ-by-one-character
 *
 * @author db117
 * @since 2022-12-22 11:11:27
 **/

public class Solution_1638 {
    public static void main(String[] args) {
        Solution solution = new Solution_1638().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s, String t) {
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            int m = s.length();
            int n = t.length();
            // 以 i,j 结尾最长公共后缀
            int[][] pre = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (sChars[i - 1] == tChars[j - 1]) {
                        pre[i][j] = pre[i - 1][j - 1] + 1;
                    } else {
                        pre[i][j] = 0;
                    }

                }
            }
            // 以 i,j 结尾符合题意
            int[][] dp = new int[m + 1][n + 1];
            int ans = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (sChars[i - 1] == tChars[j - 1]) {
                        // 相同 则以当前字符结尾的 符合题意的字符串的数据等于前一个
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 不相同则直接是前面连续相同的数量
                        dp[i][j] = pre[i - 1][j - 1] + 1;
                    }
                    ans += dp[i][j];
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
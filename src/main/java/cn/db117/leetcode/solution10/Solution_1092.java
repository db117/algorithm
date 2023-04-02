

//给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。 
//
// （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列） 
//
// 
//
// 示例： 
//
// 输入：str1 = "abac", str2 = "cab"
//输出："cabac"
//解释：
//str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。 
//str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
//最终我们给出的答案是满足上述属性的最短字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 和 str2 都由小写英文字母组成。 
// 
//
// Related Topics 字符串 动态规划 👍 191 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1092.最短公共超序列.shortest-common-supersequence
 *
 * @author db117
 * @since 2023-03-28 16:34:31
 **/

public class Solution_1092 {
    public static void main(String[] args) {
        Solution solution = new Solution_1092().new Solution();
        System.out.println(solution.shortestCommonSupersequence("abac", "cab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int m = str1.length();
            int n = str2.length();
            char[] s = str1.toCharArray();
            char[] t = str2.toCharArray();
            // f[i+1][j+1] 表示 s 的前 i 个字母和 t 的前 j 个字母的最短公共超序列的长度
            int[][] f = new int[m + 1][n + 1];
            // 初始化
            for (int i = 0; i <= m; i++) {
                f[i][0] = i;
            }
            for (int i = 0; i <= n; i++) {
                f[0][i] = i;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s[i - 1] == t[j - 1]) {// 相等
                        f[i][j] = f[i - 1][j - 1] + 1;
                    } else {// 不相等找前面最短的
                        f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                    }
                }
            }
            int ansLength = f[m][n];
            char[] ans = new char[ansLength];
            int i = m - 1, j = n - 1, k = ansLength - 1;
            while (true) {
                if (i < 0) {
                    // s 结束了
                    System.arraycopy(t, 0, ans, 0, j + 1);
                    break;
                }
                if (j < 0) {
                    // t 结束了
                    System.arraycopy(s, 0, ans, 0, i + 1);
                    break;
                }
                // 两个字符相等
                if (s[i] == t[j]) {
                    ans[k--] = s[i--];
                    j--;
                    continue;
                }

                // 找短的那个
                if (f[i + 1][j + 1] == f[i][j + 1] + 1) {// s 比较短
                    ans[k--] = s[i--];
                } else {
                    ans[k--] = t[j--];
                }
            }
            return new String(ans);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
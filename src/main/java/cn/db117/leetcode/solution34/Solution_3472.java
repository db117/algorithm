

//给你一个字符串 s 和一个整数 k。 
//
// 在一次操作中，你可以将任意位置的字符替换为字母表中相邻的字符（字母表是循环的，因此 'z' 的下一个字母是 'a'）。例如，将 'a' 替换为下一个字母结
//果是 'b'，将 'a' 替换为上一个字母结果是 'z'；同样，将 'z' 替换为下一个字母结果是 'a'，替换为上一个字母结果是 'y'。 
//
// 返回在进行 最多 k 次操作后，s 的 最长回文子序列 的长度。 
//
// 子序列 是一个 非空 字符串，可以通过删除原字符串中的某些字符（或不删除任何字符）并保持剩余字符的相对顺序得到。 
//
// 回文 是正着读和反着读都相同的字符串。 
//
// 
//
// 示例 1： 
//
// 
// 输入: s = "abced", k = 2 
// 
//
// 输出: 3 
//
// 解释: 
//
// 
// 将 s[1] 替换为下一个字母，得到 "acced"。 
// 将 s[4] 替换为上一个字母，得到 "accec"。 
// 
//
// 子序列 "ccc" 形成一个长度为 3 的回文，这是最长的回文子序列。 
//
// 示例 2： 
//
// 
// 输入: s = "aaazzz", k = 4 
// 
//
// 输出: 6 
//
// 解释: 
//
// 
// 将 s[0] 替换为上一个字母，得到 "zaazzz"。 
// 将 s[4] 替换为下一个字母，得到 "zaazaz"。 
// 将 s[3] 替换为下一个字母，得到 "zaaaaz"。 
// 
//
// 整个字符串形成一个长度为 6 的回文。 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 200 
// 1 <= k <= 200 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 字符串 动态规划 👍 5 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;

/**
 * 3472.至多 K 次操作后的最长回文子序列.longest-palindromic-subsequence-after-at-most-k-operations
 *
 * @author db117
 * @since  2025-03-07 10:07:19
 **/

  public class Solution_3472{
      public static void main(String[] args) {
           Solution solution = new Solution_3472().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          char[] chars;
          int[][][] memo;


          public int longestPalindromicSubsequence(String s, int k) {
              chars=s.toCharArray();
              int n=chars.length;
              memo = new int[chars.length][chars.length][k + 1];
              for (int i = 0; i < n; i++) {
                  for (int j = 0; j < n; j++) {
                      Arrays.fill(memo[i][j], -1);
                  }
              }

              return dfs(0, chars.length - 1, k);
          }

          private int dfs(int i, int j, int k) {
              if (i > j) {
                  return 0;
              }
              if (i == j) {
                  return 1;
              }
              if (memo[i][j][k] != -1) {
                  return memo[i][j][k];
              }
              // 刚刚好
              if (chars[i] == chars[j]) {
                  return dfs(i + 1, j - 1, k) + 2;
              }

              // 不要左边
              int ans = dfs(i + 1, j, k);
              // 不要右边
              ans = Math.max(ans, dfs(i, j - 1, k));

              // 替换
              if (chars[i] > chars[j]) {
                  int diff = Math.min(chars[i] - chars[j], chars[j] + 26 - chars[i]);
                  if (diff <= k) {
                      ans = Math.max(ans, dfs(i + 1, j - 1, k - diff) + 2);
                  }
              }else {
                  int diff = Math.min(chars[j] - chars[i], chars[i] + 26 - chars[j]);
                  if (diff <= k) {
                      ans = Math.max(ans, dfs(i + 1, j - 1, k - diff) + 2);
                  }
              }



              return memo[i][j][k]=ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }
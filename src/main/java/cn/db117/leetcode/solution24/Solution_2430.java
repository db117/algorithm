

//给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以： 
//
// 
// 删除 整个字符串 s ，或者 
// 对于满足 1 <= i <= s.length / 2 的任意 i ，如果 s 中的 前 i 个字母和接下来的 i 个字母 相等 ，删除 前 i 个字母。
// 
// 
//
// 例如，如果 s = "ababc" ，那么在一步操作中，你可以删除 s 的前两个字母得到 "abc" ，因为 s 的前两个字母和接下来的两个字母都等于 
//"ab" 。 
//
// 返回删除 s 所需的最大操作数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcabcdabc"
//输出：2
//解释：
//- 删除前 3 个字母（"abc"），因为它们和接下来 3 个字母相等。现在，s = "abcdabc"。
//- 删除全部字母。
//一共用了 2 步操作，所以返回 2 。可以证明 2 是所需的最大操作数。
//注意，在第二步操作中无法再次删除 "abc" ，因为 "abc" 的下一次出现并不是位于接下来的 3 个字母。
// 
//
// 示例 2： 
//
// 
//输入：s = "aaabaab"
//输出：4
//解释：
//- 删除第一个字母（"a"），因为它和接下来的字母相等。现在，s = "aabaab"。
//- 删除前 3 个字母（"aab"），因为它们和接下来 3 个字母相等。现在，s = "aab"。 
//- 删除第一个字母（"a"），因为它和接下来的字母相等。现在，s = "ab"。
//- 删除全部字母。
//一共用了 4 步操作，所以返回 4 。可以证明 4 是所需的最大操作数。
// 
//
// 示例 3： 
//
// 
//输入：s = "aaaaa"
//输出：5
//解释：在每一步操作中，都可以仅删除 s 的第一个字母。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 4000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 字符串匹配 哈希函数 滚动哈希 👍 29 👎 0


package cn.db117.leetcode.solution24;

import java.util.Arrays;

/**
 * 2430.对字母串可执行的最大删除数.maximum-deletions-on-a-string
 *
 * @author db117
 * @since 2022-10-11 15:03:40
 **/

public class Solution_2430 {
    public static void main(String[] args) {
        Solution solution = new Solution_2430().new Solution();
        System.out.println(solution.deleteString("aaabaab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteString(String s) {
            // 当所有字符一样时
            char[] chars = s.toCharArray();
            int n = chars.length;
            if (checkAllEq(chars)) {
                return n;
            }

            // 预处理子串的最长公共前缀
            // lcp[i][j] s[i..] 和 s[j..]的最长公共前缀
            int[][] lcp = new int[n + 1][n + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j > i; j--) {
                    if (chars[i] == chars[j]) {
                        lcp[i][j] = lcp[i + 1][j + 1] + 1;
                    }
                }
            }

            // 最大删除数 如可以删除 s[i,j] 则 dp[i] = max(dp[i],dp[j]+1)
            int[] dp = new int[n + 1];
            // 每一个字符串都可以一次性删掉
            Arrays.fill(dp, 1);
            for (int i = n - 1; i >= 0; i--) {
                // 一个个试
                for (int j = i + 1; j * 2 - i <= n; j++) {
                    // 如果 s[i,j] = s[j,2*j-i] 则可以在 i 处删除 s[i,j)
                    if (j - i <= lcp[i][j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[0];
        }

        private boolean checkAllEq(char[] chars) {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != chars[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给出一个字符串 s 和一个整数 k，若这个字符串是一个「k 回文 」，则返回 true 。 
//
// 如果可以通过从字符串中删去最多 k 个字符将其转换为回文，那么这个字符串就是一个「k 回文 」。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdeca", k = 2
//输出：true
//解释：删去字符 “b” 和 “e”。
// 
//
// 示例 2: 
//
// 
//输入：s = "abbababa", k = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 中只含有小写英文字母 
// 1 <= k <= s.length 
// 
//
// Related Topics 字符串 动态规划 👍 53 👎 0


package cn.db117.leetcode.solution12;

import java.util.Arrays;

/**
 * 1216.验证回文字符串 III.valid-palindrome-iii
 *
 * @author db117
 * @since 2023-11-08 13:59:07
 **/

public class Solution_1216 {
    public static void main(String[] args) {
        Solution solution = new Solution_1216().new Solution();

        // "fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd"
        //			216
        System.out.println(solution.isValidPalindrome("fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd", 216));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[] chars;
        int[][] memo;

        public boolean isValidPalindrome(String s, int k) {
            chars = s.toCharArray();
            int n = chars.length;
            memo = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }

            return dfs(0, n - 1) <= k;
        }

        /**
         * 删除使得字符串成为回文的个数
         */
        private int dfs(int left, int right) {
            if (left >= right) {
                return 0;
            }
            if (memo[left][right] != -1) {
                return memo[left][right];
            }

            if (chars[left] == chars[right]) {
                // 相等,继续
                return dfs(left + 1, right - 1);
            }

            // 删掉一个
            int ans = Math.min(dfs(left + 1, right), dfs(left, right - 1));

            return memo[left][right] = ans + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
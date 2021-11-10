//给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
//
// 子字符串 是字符串中一个连续（非空）的字符序列。 
//
// 注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "aba"
//输出：6
//解释：
//所有子字符串是："a"、"ab"、"aba"、"b"、"ba" 和 "a" 。
//- "b" 中有 0 个元音
//- "a"、"ab"、"ba" 和 "a" 每个都有 1 个元音
//- "aba" 中有 2 个元音
//因此，元音总数 = 0 + 1 + 1 + 1 + 1 + 2 = 6 。
// 
//
// 示例 2： 
//
// 
//输入：word = "abc"
//输出：3
//解释：
//所有子字符串是："a"、"ab"、"abc"、"b"、"bc" 和 "c" 。
//- "a"、"ab" 和 "abc" 每个都有 1 个元音
//- "b"、"bc" 和 "c" 每个都有 0 个元音
//因此，元音总数 = 1 + 1 + 1 + 0 + 0 + 0 = 3 。 
//
// 示例 3： 
//
// 
//输入：word = "ltcd"
//输出：0
//解释："ltcd" 的子字符串均不含元音。 
//
// 示例 4： 
//
// 
//输入：word = "noosabasboosa"
//输出：237
//解释：所有子字符串中共有 237 个元音。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 10⁵ 
// word 由小写英文字母组成 
// 
// 👍 5 👎 0


package cn.db117.leetcode.solution20;

/**
 * 2063.所有子字符串中的元音.vowels-of-all-substrings
 *
 * @author db117
 * @since 2021-11-09 18:55:14
 **/

public class Solution_2063 {
    public static void main(String[] args) {
        Solution solution = new Solution_2063().new Solution();
        System.out.println(solution.countVowels("aba"));
        System.out.println(solution.countVowels("abc"));
        System.out.println(solution.countVowels("ltcd"));
        System.out.println(solution.countVowels("noosabasboosa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countVowels(String word) {
            long ans = 0;
            char[] chars = word.toCharArray();
            // 动态规划
            // 记录以每一位结尾的子串数量
            long[] dp = new long[chars.length + 1];
            for (int i = 1; i <= chars.length; i++) {
                if (check(chars[i - 1])) {
                    // 当前为元音则，以当前字符为结尾，前面有多少个字符都符合
                    dp[i] = dp[i - 1] + i;
                } else {
                    // 简单的加到以前面字符串后面
                    dp[i] = dp[i - 1];
                }
            }


            for (long l : dp) {
                ans += l;
            }
            return ans;
        }

        public boolean check(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
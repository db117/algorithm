

//给你一个由小写英文字母组成的回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的 字典序最小 ，且 不是 回文
//串。 
//
// 请你返回结果字符串。如果无法做到，则返回一个 空串 。 
//
// 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符严格小于 b 中的
//对应字符。例如，"abcc” 字典序比 "abcd" 小，因为不同的第一个位置是在第四个字符，显然 'c' 比 'd' 小。 
//
// 示例 1： 
//
// 
//输入：palindrome = "abccba"
//输出："aaccba"
//解释：存在多种方法可以使 "abccba" 不是回文，例如 "zbccba", "aaccba", 和 "abacba" 。
//在所有方法中，"aaccba" 的字典序最小。 
//
// 示例 2： 
//
// 
//输入：palindrome = "a"
//输出：""
//解释：不存在替换一个字符使 "a" 变成非回文的方法，所以返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= palindrome.length <= 1000 
// palindrome 只包含小写英文字母。 
// 
//
// Related Topics 贪心 字符串 👍 94 👎 0


package cn.db117.leetcode.solution13;

/**
 * 1328.破坏回文串.break-a-palindrome
 *
 * @author db117
 * @since 2025-03-05 19:13:47
 **/

public class Solution_1328 {
    public static void main(String[] args) {
        Solution solution = new Solution_1328().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String breakPalindrome(String palindrome) {
            int n = palindrome.length();
            if (n == 1) {
                return "";
            }
            char[] chars = palindrome.toCharArray();
            // 对于前半段找到第一个不是 a 的字符，然后替换成 a
            for (int i = 1; i <= n / 2; i++) {
                if (chars[i - 1] != 'a') {
                    chars[i - 1] = 'a';
                    return String.valueOf(chars);
                }
            }
            // 到这了，说明前面能换的全都是 a。把最后一个换成 b 就是可以的
            chars[n - 1] = 'b';
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
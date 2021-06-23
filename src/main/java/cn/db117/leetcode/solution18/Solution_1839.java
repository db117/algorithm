// 当一个字符串满足如下条件时，我们称它是 美丽的 ：
//
// 
// 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。 
// 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推） 
// 
//
// 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 
//不是美丽的 。 
//
// 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。 
//
// 子字符串 是字符串中一个连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
//输出：13
//解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。 
//
// 示例 2： 
//
// 
//输入：word = "aeeeiiiioooauuuaeiou"
//输出：5
//解释：最长子字符串是 "aeiou" ，长度为 5 。
// 
//
// 示例 3： 
//
// 
//输入：word = "a"
//输出：0
//解释：没有美丽子字符串，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 5 * 105 
// word 只包含字符 'a'，'e'，'i'，'o' 和 'u' 。 
// 
// Related Topics 双指针 字符串 
// 👍 12 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1839.所有元音按顺序排布的最长子字符串.longest-substring-of-all-vowels-in-order
 *
 * @author db117
 * @since 2021-06-23 15:30:14
 **/

public class Solution_1839 {
    public static void main(String[] args) {
        Solution solution = new Solution_1839().new Solution();
        System.out.println(solution.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(solution.longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        System.out.println(solution.longestBeautifulSubstring("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestBeautifulSubstring(String word) {
            char[] chars = word.toCharArray();
            if (chars.length < 5) {
                return 0;
            }
            // aeiou

            // 双指针
            int left = 0, right;
            int max = 0;

            // 找到第一个a
            while (left < chars.length && chars[left] != 'a') {
                left++;
            }
            if (left > chars.length - 5) {
                // 肯定不够 5 个字符
                return 0;
            }
            right = left + 1;
            char pre = 'a';
            int count = 1;

            while (right < chars.length) {
                if (chars[right] == pre) {
                    // 相同字符,跳过
                    right++;
                    continue;
                }
                if (chars[right] < pre) {
                    if (count == 5) {
                        // 字符数量够了,
                        // 当前最长的
                        max = Math.max(max, right - left);
                    }

                    // 从下一个a开始
                    left = right;
                    while (left < chars.length && chars[left] != 'a') {
                        left++;
                    }
                    if (left > chars.length - 5) {
                        // 肯定不够 5 个字符
                        return max;
                    }
                    // 重置区间信息
                    right = left + 1;
                    pre = 'a';
                    count = 1;
                    continue;
                }

                // 当前区间多了一个字符
                count++;
                pre = chars[right];
                right++;
            }

            if (count == 5) {
                // 最后一个区间
                max = Math.max(max, right - left);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
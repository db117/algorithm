


//给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。 
//
// 字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 w
//ords.length 。 
//
// 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
//输出：true
//解释：
//s 可以由 "i"、"love" 和 "leetcode" 相连得到。
// 
//
// 示例 2： 
//
// 
//输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
//输出：false
//解释：
//数组的前缀相连无法得到 s 。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// 1 <= s.length <= 1000 
// words[i] 和 s 仅由小写英文字母组成 
// 
// 👍 3 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1961.检查字符串是否为数组前缀.check-if-string-is-a-prefix-of-array
 *
 * @author db117
 * @since 2021-08-09 15:29:54
 **/

public class Solution_1961 {
    public static void main(String[] args) {
        Solution solution = new Solution_1961().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPrefixString(String s, String[] words) {
            StringBuilder b = new StringBuilder();
            for (String word : words) {
                b.append(word);
                if (b.length() > s.length()) {
                    return false;
                }
                if (b.toString().equals(s)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
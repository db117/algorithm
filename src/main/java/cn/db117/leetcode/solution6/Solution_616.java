

//给你一个字符串 s 和一个字符串列表 words ，你需要将在字符串列表中出现过的 s 的子串添加加粗闭合标签 <b> 和 </b> 。 
//
// 如果两个子串有重叠部分，你需要把它们一起用一对闭合标签包围起来。同理，如果两个子字符串连续被加粗，那么你也需要把它们合起来用一对加粗标签包围。 
//
// 返回添加加粗标签后的字符串 s 。 
//
// 
//
// 示例 1： 
//
// 
//输入： s = "abcxyz123", words = ["abc","123"]
//输出："<b>abc</b>xyz<b>123</b>"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaabbcc", words = ["aaa","aab","bc"]
//输出："<b>aaabbc</b>c"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 0 <= words.length <= 100 
// 1 <= words[i].length <= 1000 
// s 和 words[i] 由英文字母和数字组成 
// words 中的所有值 互不相同 
// 
//
// 
//
// 注：此题与「758 - 字符串中的加粗单词」相同 - https://leetcode-cn.com/problems/bold-words-in-
//string 
//
// 
//
// Related Topics 字典树 数组 哈希表 字符串 字符串匹配 👍 101 👎 0


package cn.db117.leetcode.solution6;

/**
 * 616.给字符串添加加粗标签.add-bold-tag-in-string
 *
 * @author db117
 * @since 2023-09-18 15:11:29
 **/

public class Solution_616 {
    public static void main(String[] args) {
        Solution solution = new Solution_616().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBoldTag(String s, String[] words) {
            int n = s.length();
            boolean[] bold = new boolean[n];
            char[] chars = s.toCharArray();
            // 标记每个字符是否需要加粗
            for (String word : words) {
                int start = s.indexOf(word);
                while (start != -1) {
                    for (int i = start; i < start + word.length(); i++) {
                        bold[i] = true;
                    }
                    start = s.indexOf(word, start + 1);
                }
            }

            // 拼接
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                // 前面没有字符或者前面的字符不需要加粗
                if (bold[i] && (i == 0 || !bold[i - 1])) {
                    ans.append("<b>");
                }
                ans.append(chars[i]);
                if (bold[i] && (i == n - 1 || !bold[i + 1])) {
                    ans.append("</b>");
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
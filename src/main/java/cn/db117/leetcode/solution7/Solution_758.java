

//给定一个关键词集合 words 和一个字符串 s，将所有 s 中出现的关键词 words[i] 加粗。所有在标签 <b> 和 <b> 中的字母都会加粗。 
//
// 加粗后返回 s 。返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["ab","bc"], s = "aabcd"
//输出: "a<b>abc</b>d"
//解释: 注意返回 "a<b>a<b>b</b>c</b>d" 会使用更多的标签，因此是错误的。
// 
//
// 示例 2: 
//
// 
//输入: words = ["ab","cb"], s = "aabcd"
//输出: "a<b>ab</b>cd"
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 500 
// 0 <= words.length <= 50 
// 1 <= words[i].length <= 10 
// s 和 words[i] 由小写英文字母组成 
// 
//
// 
//
// 注：此题与「616 - 给字符串添加加粗标签」相同 - https://leetcode-cn.com/problems/add-bold-tag-in-
//string/ 
//
// Related Topics 字典树 数组 哈希表 字符串 字符串匹配 👍 49 👎 0


package cn.db117.leetcode.solution7;

/**
 * 758.字符串中的加粗单词.bold-words-in-string
 *
 * @author db117
 * @since 2023-09-18 15:08:33
 **/

public class Solution_758 {
    public static void main(String[] args) {
        Solution solution = new Solution_758().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String boldWords(String[] words, String s) {
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
//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 排序 双指针 
// 👍 148 👎 0


package cn.db117.leetcode.solution5;

import java.util.ArrayList;
import java.util.List;

/**
 * 524.通过删除字母匹配到字典里最长单词.longest-word-in-dictionary-through-deleting
 *
 * @author db117
 * @since 2021-06-08 15:11:41
 **/

public class Solution_524 {
    public static void main(String[] args) {
        Solution solution = new Solution_524().new Solution();
        List<String> list = new ArrayList<>(List.of("ale", "apple", "monkey", "plea"));

        System.out.println(solution.findLongestWord("abpcplea", list));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            // 安装字符串长度,字典序排列
            dictionary.sort((o1, o2) -> {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            });

            char[] chars = s.toCharArray();

            for (String dict : dictionary) {
                // 找到就返回
                if (helper(chars, dict)) {
                    return dict;
                }
            }

            return "";
        }

        private boolean helper(char[] chars, String dict) {
            if (chars.length < dict.length()) {
                return false;
            }
            char[] dicts = dict.toCharArray();
            int i1 = 0, i2 = 0;

            while (i1 < chars.length) {

                if (chars[i1] == dicts[i2]) {
                    i2++;
                }
                i1++;

                if (i2 == dicts.length) {
                    // 字典字符用完了
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
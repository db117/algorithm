//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 546 👎 0


package cn.db117.leetcode.solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438.找到字符串中所有字母异位词.find-all-anagrams-in-a-string
 *
 * @author db117
 * @since 2021-06-25 17:55:42
 **/

public class Solution_438 {
    public static void main(String[] args) {
        Solution solution = new Solution_438().new Solution();
//        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
//        System.out.println(solution.findAnagrams("abab", "ab"));
//        System.out.println(solution.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
        System.out.println(solution.findAnagrams("ab", "ba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if (s.length() < p.length()) {
                return ans;
            }
            int pLen = p.length();
            // 窗口
            int[] window = new int[26];
            // 当前窗口
            int[] cur = new int[26];
            char[] pChars = p.toCharArray();
            for (char c : pChars) {
                window[c - 'a']++;
            }

            // 初始窗口
            char[] chars = s.toCharArray();
            for (int i = 0; i < pLen; i++) {
                cur[chars[i] - 'a']++;
            }

            // 判断窗口是否相等
            for (int i = pLen; i <= chars.length; i++) {
                if (Arrays.equals(window, cur)) {
                    // 相等
                    ans.add(i - pLen);
                }

                if (i == chars.length) {
                    break;
                }
                // 删除一个
                cur[chars[i - pLen] - 'a']--;
                // 添加一个
                cur[chars[i] - 'a']++;
            }

            return ans;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
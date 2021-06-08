// 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 357 👎 0


package cn.db117.leetcode.solution5;

import java.util.Arrays;

/**
 * 567.字符串的排列.permutation-in-string
 *
 * @author db117
 * @since 2021-06-08 14:39:08
 **/

public class Solution_567 {
    public static void main(String[] args) {
        Solution solution = new Solution_567().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("ab", "a"));
        System.out.println(solution.checkInclusion("ab", "ba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) {
                return false;
            }
            int[] count = new int[26];
            int left = 0, right = s1.length();

            // 统计 s1 的各个字符数量
            for (char c : s1.toCharArray()) {
                count[c - 'a']++;
            }

            // 窗口大小下,字符数量一致则符合题意
            // [left,right)

            char[] chars = s2.toCharArray();
            // 初始字符数量
            int[] cur = new int[26];
            for (int i = 0; i < right; i++) {
                cur[chars[i] - 'a']++;
            }

            while (right <= s2.length()) {
                if (Arrays.equals(count, cur)) {
                    // 字符数量一致,则符合题意
                    return true;
                }
                if (right == s2.length()) {
                    // 到头了还没有找到
                    return false;
                }
                cur[chars[left] - 'a']--;
                cur[chars[right] - 'a']++;

                left++;
                right++;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
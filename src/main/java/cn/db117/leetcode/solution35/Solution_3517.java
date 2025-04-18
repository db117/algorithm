

//给你一个 回文 字符串 s。 
//
// 返回 s 的按字典序排列的 最小 回文排列。 
//
// 如果一个字符串从前往后和从后往前读都相同，那么这个字符串是一个 回文 字符串。 
//
// 排列 是字符串中所有字符的重排。 如果字符串 
//a 按字典序小于字符串 
//b，则表示在第一个不同的位置，
//a 中的字符比 
//b 中的对应字符在字母表中更靠前。
// 如果在前 
//min(a.length, b.length) 个字符中没有区别，则较短的字符串按字典序更小。
//
// 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "z" 
// 
//
// 输出： "z" 
//
// 解释： 
//
// 仅由一个字符组成的字符串已经是按字典序最小的回文。 
//
// 示例 2： 
//
// 
// 输入： s = "babab" 
// 
//
// 输出： "abbba" 
//
// 解释： 
//
// 通过重排 "babab" → "abbba"，可以得到按字典序最小的回文。 
//
// 示例 3： 
//
// 
// 输入： s = "daccad" 
// 
//
// 输出： "acddca" 
//
// 解释： 
//
// 通过重排 "daccad" → "acddca"，可以得到按字典序最小的回文。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成。 
// 保证 s 是回文字符串。 
// 
//
// Related Topics 字符串 计数排序 排序 👍 1 👎 0


package cn.db117.leetcode.solution35;

/**
 * 3517.最小回文排列 I.smallest-palindromic-rearrangement-i
 *
 * @author db117
 * @since 2025-04-18 16:02:58
 **/

public class Solution_3517 {
    public static void main(String[] args) {
        Solution solution = new Solution_3517().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestPalindrome(String s) {
            int n = s.length();
            // 统计每个字母出现的次数
            int[] cut = new int[26];
            char[] chars = s.toCharArray();
            if (chars.length == 1) {
                return s;
            }
            for (char c : chars) {
                cut[c - 'a']++;
            }
            // 找到中间的那个字符
            char mid = '0';
            for (int i = 0; i < 26; i++) {
                if (cut[i] % 2 == 1) {
                    mid = (char) (i + 'a');
                    break;
                }
            }

            char[] res = new char[n];
            int z = 0;
            for (int i = 0; i < cut.length; i++) {
                if (cut[i] == 0) {
                    continue;
                }
                // 从下往大开始填
                for (int j = 0; j < cut[i] / 2; j++) {
                    res[z] = (char) (i + 'a');
                    z++;
                }
            }
            // 补充剩下一半
            for (int i = 0; i < n / 2; i++) {
                res[n - i - 1] = res[i];
            }

            // 中间那个字符
            if ((n % 2) == 1) {
                res[z] = mid;
            }

            return new String(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abab"
//输出："bab"
//解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 
//"bab"。
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："tcode"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 4 * 10⁵ 
// s 仅含有小写英文字符。 
// 
//
// Related Topics 双指针 字符串 👍 76 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1163.按字典序排在最后的子串.last-substring-in-lexicographical-order
 *
 * @author db117
 * @since 2023-04-23 13:53:31
 **/

public class Solution_1163 {
    public static void main(String[] args) {
        Solution solution = new Solution_1163().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String lastSubstring(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            // 答案肯定是直接捅到末尾的
            // 两个指针，一个保存结果前缀  一个从前到后和结果比较
            int left = 0, len = 0, right = 1;
            while (right + len < n) {
                if (chars[left + len] == chars[right + len]) {
                    len++;
                    continue;
                }
                if (chars[left] < chars[right + len]) {
                    // 后面有任意一个字符比答案的第一个字符大，则不需要继续比较了
                    left = right + len;
                    right = left + 1;
                    len = 0;
                    continue;
                }
                if (chars[left + len] < chars[right + len]) {
                    // 出现更大的了
                    left = right;
                    right = left + 1;
                    len = 0;
                    continue;
                }
                if (chars[left + len] > chars[right + len]) {
                    // 当前字符串太小了，后面继续比较
                    right++;
                    len = 0;
                }
            }
            return s.substring(left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
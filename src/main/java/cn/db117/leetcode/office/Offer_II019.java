


//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// 
//
// 
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
//
// Related Topics 贪心 双指针 字符串 👍 43 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer II 019.最多删除一个字符得到回文.RQku0D
 *
 * @author db117
 * @since 2022-07-21 18:58:05
 **/

public class Offer_II019 {
    public static void main(String[] args) {
        Solution solution = new Offer_II019().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = chars.length - 1;

            while (left < right) {
                if (chars[left] != chars[right]) {
                    break;
                }
                left++;
                right--;
            }

            // 删掉左边
            if (check(chars, left + 1, right)) {
                return true;
            }
            // 删掉右边
            return check(chars, left, right - 1);

        }

        public boolean check(char[] chars, int left, int right) {
            while (left < right) {
                if (chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
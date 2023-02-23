

//给你一个下标从 0 开始、仅由小写英文字母组成的字符串 s 。在一步操作中，你可以将 s 中的任一字符更改为其他任何字符。 
//
// 如果你能在 恰 执行一到两步操作后使 s 变成一个回文，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "abcdba"
//输出: true
//解释: 能让 s 变成回文，且只用了一步操作的方案如下:
//- 将 s[2] 变成 'd' ，得到 s = "abddba" 。
//执行一步操作让 s 变成一个回文，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入: s = "aa"
//输出: true
//解释: 能让 s 变成回文，且只用了两步操作的方案如下:
//- 将 s[0] 变成 'b' ，得到 s = "ba" 。
//- 将 s[1] 变成 'b' ，得到s = "bb" 。
//执行两步操作让 s 变成一个回文，所以返回 true 。 
// 
//
// 示例 3： 
//
// 
//输入: s = "abcdef"
//输出: false
//解释: 不存在能在两步操作以内将 s 变成回文的办法，所以返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 双指针 字符串 👍 0 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2330.有效的回文 IV.valid-palindrome-iv
 *
 * @author db117
 * @since 2023-02-23 14:38:42
 **/

public class Solution_2330 {
    public static void main(String[] args) {
        Solution solution = new Solution_2330().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean makePalindrome(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = chars.length - 1;

            int count = 0;
            while (left < right) {
                if (chars[left] != chars[right]) {
                    // 需要修改字符
                    count++;
                    if (count > 2) {
                        return false;
                    }
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//给你一个由数字组成的字符串 s 。重复执行以下操作，直到字符串恰好包含 两个 数字： 
//
// 
// 从第一个数字开始，对于 s 中的每一对连续数字，计算这两个数字的和 模 10。 
// 用计算得到的新数字依次替换 s 的每一个字符，并保持原本的顺序。 
// 
//
// 如果 s 最后剩下的两个数字 相同 ，返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "3902" 
// 
//
// 输出： true 
//
// 解释： 
//
// 
// 一开始，s = "3902" 
// 第一次操作： 
// 
// (s[0] + s[1]) % 10 = (3 + 9) % 10 = 2 
// (s[1] + s[2]) % 10 = (9 + 0) % 10 = 9 
// (s[2] + s[3]) % 10 = (0 + 2) % 10 = 2 
// s 变为 "292" 
// 
// 第二次操作： 
// 
// (s[0] + s[1]) % 10 = (2 + 9) % 10 = 1 
// (s[1] + s[2]) % 10 = (9 + 2) % 10 = 1 
// s 变为 "11" 
// 
// 由于 "11" 中的数字相同，输出为 true。 
// 
//
// 示例 2： 
//
// 
// 输入： s = "34789" 
// 
//
// 输出： false 
//
// 解释： 
//
// 
// 一开始，s = "34789"。 
// 第一次操作后，s = "7157"。 
// 第二次操作后，s = "862"。 
// 第三次操作后，s = "48"。 
// 由于 '4' != '8'，输出为 false。 
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 100 
// s 仅由数字组成。 
// 
//
// Related Topics 数学 字符串 组合数学 数论 模拟 👍 13 👎 0


package cn.db117.leetcode.solution34;

/**
 * 3461.判断操作后字符串中的数字是否相等 I.check-if-digits-are-equal-in-string-after-operations-i
 *
 * @author db117
 * @since 2025-10-23 19:22:57
 **/

public class Solution_3461 {
    public static void main(String[] args) {
        Solution solution = new Solution_3461().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasSameDigits(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            for (int i = n - 2; i >= 1; i--) {
                for (int j = 0; j <= i; j++) {
                    // 模拟
                    int sum = chars[j] - '0' + chars[j + 1] - '0';
                    int mod = sum % 10;
                    chars[j] = (char) ('0' + mod);
                }
            }

            return chars[0] == chars[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
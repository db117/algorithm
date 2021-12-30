

//一个括号字符串是只由 '(' 和 ')' 组成的 非空 字符串。如果一个字符串满足下面 任意 一个条件，那么它就是有效的： 
//
// 
// 字符串为 (). 
// 它可以表示为 AB（A 与 B 连接），其中A 和 B 都是有效括号字符串。 
// 它可以表示为 (A) ，其中 A 是一个有效括号字符串。 
// 
//
// 给你一个括号字符串 s 和一个字符串 locked ，两者长度都为 n 。locked 是一个二进制字符串，只包含 '0' 和 '1' 。对于 
//locked 中 每一个 下标 i ： 
//
// 
// 如果 locked[i] 是 '1' ，你 不能 改变 s[i] 。 
// 如果 locked[i] 是 '0' ，你 可以 将 s[i] 变为 '(' 或者 ')' 。 
// 
//
// 如果你可以将 s 变为有效括号字符串，请你返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：s = "))()))", locked = "010100"
//输出：true
//解释：locked[1] == '1' 和 locked[3] == '1' ，所以我们无法改变 s[1] 或者 s[3] 。
//我们可以将 s[0] 和 s[4] 变为 '(' ，不改变 s[2] 和 s[5] ，使 s 变为有效字符串。 
//
// 示例 2： 
//
// 
//输入：s = "()()", locked = "0000"
//输出：true
//解释：我们不需要做任何改变，因为 s 已经是有效字符串了。
// 
//
// 示例 3： 
//
// 
//输入：s = ")", locked = "0"
//输出：false
//解释：locked 允许改变 s[0] 。
//但无论将 s[0] 变为 '(' 或者 ')' 都无法使 s 变为有效字符串。
// 
//
// 
//
// 提示： 
//
// 
// n == s.length == locked.length 
// 1 <= n <= 10⁵ 
// s[i] 要么是 '(' 要么是 ')' 。 
// locked[i] 要么是 '0' 要么是 '1' 。 
// 
// Related Topics 栈 贪心 字符串 👍 13 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2116.判断一个括号字符串是否有效.check-if-a-parentheses-string-can-be-valid
 *
 * @author db117
 * @since 2022-01-04 16:29:08
 **/

public class Solution_2116 {
    public static void main(String[] args) {
        Solution solution = new Solution_2116().new Solution();

        System.out.println(solution.canBeValid("()))(()(()()()()(((())())((()((())", "1100000000000010000100001000001101")); // true
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canBeValid(String s, String locked) {
            if (s.length() % 2 == 1) {
                return false;
            }
            char[] chars = s.toCharArray();
            char[] lockedC = locked.toCharArray();
            // 左括号 + 可变 >= 右括号
            // 右括号 + 可变 >= 左括号
            int left = 0, right = 0, changeable = 0;


            // 两次遍历
            for (int i = 0; i < lockedC.length; i++) {
                if (lockedC[i] == '0') {
                    changeable++;
                    continue;
                }

                if (chars[i] == '(') {
                    left++;
                } else {
                    right++;
                }
                // 左括号 + 可变 >= 右括号
                if (left + changeable < right) {
                    return false;
                }
            }


            changeable = 0;
            left = 0;
            right = 0;
            for (int i = lockedC.length - 1; i >= 0; i--) {
                if (lockedC[i] == '0') {
                    changeable++;
                    continue;
                }

                if (chars[i] == '(') {
                    left++;
                } else {
                    right++;
                }

                // 右括号 + 可变 >= 左括号
                if (right + changeable < left) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
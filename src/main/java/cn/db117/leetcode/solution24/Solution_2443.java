

//给你一个 非负 整数 num 。如果存在某个 非负 整数 k 满足 k + reverse(k) = num ，则返回 true ；否则，返回 false 
//。 
//
// reverse(k) 表示 k 反转每个数位后得到的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 443
//输出：true
//解释：172 + 271 = 443 ，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：num = 63
//输出：false
//解释：63 不能表示为非负整数及其反转后数字之和，返回 false 。
// 
//
// 示例 3： 
//
// 
//输入：num = 181
//输出：true
//解释：140 + 041 = 181 ，所以返回 true 。注意，反转后的数字可能包含前导零。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 10⁵ 
// 
//
// Related Topics 数学 枚举 👍 6 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2443.反转之后的数字和.sum-of-number-and-its-reverse
 *
 * @author db117
 * @since 2022-10-18 16:08:32
 **/

public class Solution_2443 {
    public static void main(String[] args) {
        Solution solution = new Solution_2443().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean sumOfNumberAndReverse(int num) {
            if (num == 0) {
                return true;
            }
            for (int i = 1; i <= num; i++) {
                String s = Integer.toString(i);
                String re = new StringBuilder(s).reverse().toString();
                if (i + Integer.parseInt(re) == num) {
                    return true;
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
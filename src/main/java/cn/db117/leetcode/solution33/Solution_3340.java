

//给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 平衡字符串。 
//
// 如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
// 输入：num = "1234" 
// 
//
// 输出：false 
//
// 解释： 
//
// 
// 偶数下标处的数字之和为 1 + 3 = 4，奇数下标处的数字之和为 2 + 4 = 6。 
// 由于 4 不等于 6，num 不是平衡字符串。 
// 
//
// 示例 2： 
//
// 
// 输入：num = "24123" 
// 
//
// 输出：true 
//
// 解释： 
//
// 
// 偶数下标处的数字之和为 2 + 1 + 3 = 6，奇数下标处的数字之和为 4 + 2 = 6。 
// 由于两者相等，num 是平衡字符串。 
// 
//
// 
//
// 提示： 
//
// 
// 2 <= num.length <= 100 
// num 仅由数字 0 - 9 组成。 
// 
//
// Related Topics 字符串 👍 2 👎 0


package cn.db117.leetcode.solution33;

/**
 * 3340.检查平衡字符串.check-balanced-string
 *
 * @author db117
 * @since 2024-11-05 10:15:10
 **/

public class Solution_3340 {
    public static void main(String[] args) {
        Solution solution = new Solution_3340().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBalanced(String num) {
            // 简单模拟
            int a = 0;
            int b = 0;
            char[] chars = num.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    a += chars[i] - '0';
                } else {
                    b += chars[i] - '0';
                }
            }
            return a == b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
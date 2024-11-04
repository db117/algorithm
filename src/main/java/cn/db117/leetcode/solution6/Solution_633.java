

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 
//输入：c = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
//
// Related Topics 数学 双指针 二分查找 👍 484 👎 0


package cn.db117.leetcode.solution6;

/**
 * 633.平方数之和.sum-of-square-numbers
 *
 * @author db117
 * @since 2024-11-04 19:19:07
 **/

public class Solution_633 {
    public static void main(String[] args) {
        Solution solution = new Solution_633().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            // 枚举
            for (int i = 0; i * i <= c / 2; i++) {
                // 直接取平方根
                int k = (int) Math.sqrt(c - i * i);
                if (i * i + k * k == c) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
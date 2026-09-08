

//给你一个整数 n。 
//
// 返回将所有从 [1, n]（包含两端）范围内的整数以 标准 数字格式书写时所用到的 逗号总数。 
//
// 在 标准 格式中： 
//
// 
// 从右边开始，每 三位 数字后插入一个逗号。 
// 位数 少于四位 的数字不包含逗号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 1002 
// 
//
// 输出： 3 
//
// 解释： 
//
// 数字 "1,000"、"1,001" 和 "1,002" 每个都包含一个逗号，总计 3 个逗号。 
//
//
// 示例 2： 
//
// 
// 输入： n = 998 
// 
//
// 输出： 0 
//
// 解释： 
//
// 从 1 到 998 的所有数字位数都少于四位，因此没有使用逗号。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 数学 👍 8 👎 0


package cn.db117.leetcode.solution38;

/**
 * 3870.统计范围内的逗号.count-commas-in-range
 *
 * @author db117
 * @since 2026-09-08 10:46:53
 **/

public class Solution_3870 {
    public static void main(String[] args) {
        Solution solution = new Solution_3870().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCommas(int n) {
            // 不可以有 2 个逗号，小于 1000都没有
            if (n < 1000) {
                return 0;
            }
            return n - 999;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
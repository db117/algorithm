

//给你一个整数 n。 
//
// 斐波那契数列 以 0 和 1 开始，之后的每个数都是前两个数之和。它的前几项为 0, 1, 1, 2, 3, 5, 8, 13, ...。 
//
// 如果 n 可以表示为斐波那契数列中 连续三项之和，则返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 16 
// 
//
// 输出： true 
//
// 解释： 
//
// 连续三项 3、5 和 8 的和为 3 + 5 + 8 = 16。 
//
//
// 示例 2： 
//
// 
// 输入： n = 8 
// 
//
// 输出： false 
//
// 解释： 
//
// 虽然 1 + 2 + 5 = 8，但这三项在斐波那契数列中并不连续。不存在连续三项的和等于 8。 
//
//
// 示例 3： 
//
// 
// 输入： n = 2 
// 
//
// 输出： true 
//
// 解释： 
//
// 斐波那契数列的前三项之和为 0 + 1 + 1 = 2。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution40;

/**
 * 4078.连续三项斐波那契数之和.three-fibonacci-sum
 *
 * @author db117
 * @since 2026-10-18 10:13:47
 **/

public class Solution_4078 {
    public static void main(String[] args) {
        Solution solution = new Solution_4078().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean threeFibonacciSum(int n) {
            long a = 0, b = 1;
            while (true) {
                long c = a + b;

                long sum = a + b + c;
                if (n == sum) {
                    return true;
                }
                if (n < sum) {
                    return false;
                }
                a = b;
                b = c;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
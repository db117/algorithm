// 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
//
// 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。 
//
// 
//
// 示例 1： 
//
// 输入：n = 12
//输出：true
//解释：12 = 31 + 32
// 
//
// 示例 2： 
//
// 输入：n = 91
//输出：true
//解释：91 = 30 + 32 + 34
// 
//
// 示例 3： 
//
// 输入：n = 21
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 107 
// 
// Related Topics 递归 数学 回溯算法 
// 👍 22 👎 0


package cn.db117.leetcode.solution17;

/**
 * 1780.判断一个数字是否可以表示成三的幂的和.check-if-number-is-a-sum-of-powers-of-three
 *
 * @author db117
 * @since 2021-05-27 16:25:49
 **/

public class Solution_1780 {
    public static void main(String[] args) {
        Solution solution = new Solution_1780().new Solution();

        System.out.println(solution.checkPowersOfThree(12));
        System.out.println(solution.checkPowersOfThree(91));
        System.out.println(solution.checkPowersOfThree(21));
        System.out.println(solution.checkPowersOfThree(100000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPowersOfThree(int n) {
            if (n == 1) {
                return true;
            }
            if (n % 3 == 0) {
                // 如果符合则,除以3也符合
                return checkPowersOfThree(n / 3);
            }

            if (n % 3 == 1) {
                return checkPowersOfThree((n - 1) / 3);
            }

            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
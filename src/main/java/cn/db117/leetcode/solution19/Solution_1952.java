


//给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。 
//
// 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：false
//解释：2 只有两个除数：1 和 2 。 
//
// 示例 2： 
//
// 输入：n = 4
//输出：true
//解释：4 有三个除数：1、2 和 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// 👍 1 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1952.三除数.three-divisors
 *
 * @author db117
 * @since 2021-08-02 14:44:03
 **/

public class Solution_1952 {
    public static void main(String[] args) {
        Solution solution = new Solution_1952().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isThree(int n) {
            // 又是脑筋急转弯
            // 每一个数字都有 1 和 自身两个正除数，只有中间多一个就不行
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    count++;
                }
                if (count > 3) {
                    return false;
                }
            }
            return count == 3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
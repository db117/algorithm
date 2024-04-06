

//给你一个三位数整数 n 。 
//
// 如果经过以下修改得到的数字 恰好 包含数字 1 到 9 各一次且不包含任何 0 ，那么我们称数字 n 是 迷人的 ： 
//
// 
// 将 n 与数字 2 * n 和 3 * n 连接 。 
// 
//
// 如果 n 是迷人的，返回 true，否则返回 false 。 
//
// 连接 两个数字表示把它们首尾相接连在一起。比方说 121 和 371 连接得到 121371 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 192
//输出：true
//解释：我们将数字 n = 192 ，2 * n = 384 和 3 * n = 576 连接，得到 192384576 。这个数字包含 1 到 9 恰好各一
//次。
// 
//
// 示例 2： 
//
// 输入：n = 100
//输出：false
//解释：我们将数字 n = 100 ，2 * n = 200 和 3 * n = 300 连接，得到 100200300 。这个数字不符合上述条件。
// 
//
// 
//
// 提示： 
//
// 
// 100 <= n <= 999 
// 
//
// Related Topics 哈希表 数学 👍 7 👎 0


package cn.db117.leetcode.solution27;

/**
 * 2729.判断一个数是否迷人.check-if-the-number-is-fascinating
 *
 * @author db117
 * @since 2024-04-06 20:11:36
 **/

public class Solution_2729 {
    public static void main(String[] args) {
        Solution solution = new Solution_2729().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isFascinating(int n) {
            String s = n + "" + n * 2 + n * 3;
            if (s.length() != 9) {
                return false;
            }
            for (int i = 1; i <= 9; i++) {
                if (!s.contains(i + "")) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
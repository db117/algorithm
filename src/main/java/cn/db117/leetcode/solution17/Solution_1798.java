

//给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i] 。如果你从这些硬币中选出一部分硬币，它们的
//和为 x ，那么称，你可以 构造 出 x 。 
//
// 请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。 
//
// 你可能有多个相同值的硬币。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1,3]
//输出：2
//解释：你可以得到以下这些值：
//- 0：什么都不取 []
//- 1：取 [1]
//从 0 开始，你可以构造出 2 个连续整数。 
//
// 示例 2： 
//
// 
//输入：coins = [1,1,1,4]
//输出：8
//解释：你可以得到以下这些值：
//- 0：什么都不取 []
//- 1：取 [1]
//- 2：取 [1,1]
//- 3：取 [1,1,1]
//- 4：取 [4]
//- 5：取 [4,1]
//- 6：取 [4,1,1]
//- 7：取 [4,1,1,1]
//从 0 开始，你可以构造出 8 个连续整数。 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,10,3,1]
//输出：20 
//
// 
//
// 提示： 
//
// 
// coins.length == n 
// 1 <= n <= 4 * 10⁴ 
// 1 <= coins[i] <= 4 * 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 171 👎 0


package cn.db117.leetcode.solution17;

import java.util.Arrays;

/**
 * 1798.你能构造出连续值的最大数目.maximum-number-of-consecutive-values-you-can-make
 *
 * @author db117
 * @since 2023-02-04 20:51:12
 **/

public class Solution_1798 {
    public static void main(String[] args) {
        Solution solution = new Solution_1798().new Solution();
        System.out.println(solution.getMaximumConsecutive(new int[]{1, 89, 8, 1, 47, 34, 99, 1, 1, 1, 55, 89,
                1, 52, 36, 1, 62, 1, 1, 1, 4, 27, 1, 45, 1, 1, 48, 1, 94, 1, 63}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaximumConsecutive(int[] coins) {

            int cur = 0;
            Arrays.sort(coins);

            for (int coin : coins) {
                if (coin > cur + 1) {
                    // 接不上了
                    break;
                }
                // 能接上,前面有的数字和当前数字可能拼出来
                cur += coin;
            }
            return cur + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
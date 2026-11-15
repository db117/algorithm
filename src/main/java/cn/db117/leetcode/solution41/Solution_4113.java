

//Alice 和 Bob 正在用一个整数数组 nums 玩游戏。Alice 先手。 
//
// 每个回合，当前玩家可以取走并移除 最左边的一个元素 ，或者在至少还剩两个元素时，取走并移除 最左边的两个元素。 
//
// 本回合取走的元素之 和 决定接下来由谁行动： 
//
// 
// 如果该总和能被 3 整除，则接下来由另一位玩家行动。 
// 否则，当前玩家继续行动。 
// 
//
// 一位玩家的 得分 是其取走的所有元素的值之和。 
//
// 两位玩家都采用最优策略，各自力求 最大化 自己的得分。 
//
// 当所有元素都被取走时，游戏结束。 
//
// 返回 Alice 的得分 减去 Bob 的得分。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [3,6,4] 
// 
//
// 输出： 5 
//
// 解释： 
//
// 一种最优的回合序列如下： 
//
// 
// Alice 取走最左边的两个元素。它们的总和为 3 + 6 = 9，能被 3 整除，因此接下来由 Bob 行动。此时 Alice 的得分为 9，剩余数组为
// [4]。 
// Bob 取走唯一剩余的元素。他的得分为 4，游戏结束。 
// 
//
// Alice 的得分减去 Bob 的得分为 9 - 4 = 5，因此答案为 5。 
//
//
// 示例 2： 
//
// 
// 输入： nums = [6,1,2,1,2] 
// 
//
// 输出： 12 
//
// 解释： 
//
// 一种最优的回合序列如下： 
//
// 
// Alice 取走最左边的两个元素。它们的总和为 6 + 1 = 7，不能被 3 整除，因此 Alice 继续行动。此时她的得分为 7，剩余数组为 [2, 
//1, 2]。 
// Alice 取走最左边的一个元素。它的值为 2，不能被 3 整除，因此 Alice 继续行动。此时她的得分为 7 + 2 = 9，剩余数组为 [1, 2]
//。 
// Alice 取走剩余的两个元素。此时她的得分为 9 + 1 + 2 = 12，游戏结束。 
// 
//
// Bob 没有取走任何元素，因此他的得分为 0。Alice 的得分减去 Bob 的得分为 12 - 0 = 12，因此答案为 12。 
//
//
// 示例 3： 
//
// 
// 输入： nums = [3,3,4,5] 
// 
//
// 输出： -3 
//
// 解释： 
//
// 一种最优的回合序列如下： 
//
// 
// Alice 取走最左边的两个元素。它们的总和为 3 + 3 = 6，能被 3 整除，因此接下来由 Bob 行动。此时 Alice 的得分为 6，剩余数组为
// [4, 5]。 
// Bob 取走剩余的两个元素。他的得分为 4 + 5 = 9，游戏结束。 
// 
//
// Alice 的得分减去 Bob 的得分为 6 - 9 = -3，因此答案为 -3。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution41;

/**
 * 4113.整除和博弈.game-of-divisible-sums
 *
 * @author db117
 * @since 2026-11-15 15:41:33
 **/

public class Solution_4113 {
    public static void main(String[] args) {
        Solution solution = new Solution_4113().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxDifference(int[] nums) {
            int n = nums.length;
            long ans = 0;
            long[] memo = new long[n];
            boolean[] visited = new boolean[n];


            return dfs(0, nums, memo, visited);
        }

        long dfs(int i, int[] nums, long[] memo, boolean[] visited) {
            int n = nums.length;
            if (i == n) {
                return 0;
            }
            if (visited[i]) {
                return memo[i];
            }
            long ans = Long.MIN_VALUE;
            // 选一个
            int d = 1;
            if (nums[i] % 3 == 0) {
                d = -1;
            }
            ans = Math.max(ans, nums[i] + dfs(i + 1, nums, memo, visited) * d);

            // 选2个
            if (i < n - 1) {
                long two = nums[i] + nums[i + 1];
                d = 1;
                if (two % 3 == 0) {
                    d = -1;
                }
                ans = Math.max(ans, two + dfs(i + 2, nums, memo, visited) * d);
            }
            visited[i] = true;
            return memo[i] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
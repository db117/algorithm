

//一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。 
//
// 
// 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。 
// 
//
// 给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。 
//
// 
// 
//
// 一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4
//] 的一个子序列（加粗元素），但是 [2,4,2] 不是。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,5,3]
//输出：7
//解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,6,7,8]
//输出：8
//解释：最优子序列为 [8] ，交替和为 8 。
// 
//
// 示例 3： 
//
// 输入：nums = [6,2,1,2,4,5]
//输出：10
//解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 95 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1911.最大子序列交替和.maximum-alternating-subsequence-sum
 *
 * @author db117
 * @since 2023-07-11 10:37:08
 **/

public class Solution_1911 {
    public static void main(String[] args) {
        Solution solution = new Solution_1911().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        long[][] memo;

        public long maxAlternatingSum(int[] nums) {
            // 记忆化搜索
            this.nums = nums;
            this.memo = new long[nums.length][2];
            return Math.max(dfs(nums.length - 1, false), dfs(nums.length - 1, true));
        }

        private long dfs(int i, boolean paired) {
            if (memo[i][paired ? 1 : 0] != 0) {
                return memo[i][paired ? 1 : 0];
            }
            if (i == 0) {
                // 如果后面已经配对了,则返回0 否则返回第一个数
                return paired ? 0 : nums[0];
            }
            long ans = 0;
            // 选
            int num = paired ? -nums[i] : nums[i];// 如果后面已经配对了(当前数字是奇数),则减去当前数,否则加上当前数
            ans = Math.max(ans, dfs(i - 1, !paired) + num);
            // 不选
            ans = Math.max(ans, dfs(i - 1, paired));

            return memo[i][paired ? 1 : 0] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
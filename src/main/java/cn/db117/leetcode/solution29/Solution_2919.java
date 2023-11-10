

//给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和一个整数 k 。 
//
// 你可以执行下述 递增 运算 任意 次（可以是 0 次）： 
//
// 
// 从范围 [0, n - 1] 中选择一个下标 i ，并将 nums[i] 的值加 1 。 
// 
//
// 如果数组中任何长度 大于或等于 3 的子数组，其 最大 元素都大于或等于 k ，则认为数组是一个 美丽数组 。 
//
// 以整数形式返回使数组变为 美丽数组 需要执行的 最小 递增运算数。 
//
// 子数组是数组中的一个连续 非空 元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,0,0,2], k = 4
//输出：3
//解释：可以执行下述递增运算，使 nums 变为美丽数组：
//选择下标 i = 1 ，并且将 nums[1] 的值加 1 -> [2,4,0,0,2] 。
//选择下标 i = 4 ，并且将 nums[4] 的值加 1 -> [2,4,0,0,3] 。
//选择下标 i = 4 ，并且将 nums[4] 的值加 1 -> [2,4,0,0,4] 。
//长度大于或等于 3 的子数组为 [2,4,0], [4,0,0], [0,0,4], [2,4,0,0], [4,0,0,4], [2,4,0,0,4] 。
//
//在所有子数组中，最大元素都等于 k = 4 ，所以 nums 现在是美丽数组。
//可以证明无法用少于 3 次递增运算使 nums 变为美丽数组。
//因此，答案为 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,3,3], k = 5
//输出：2
//解释：可以执行下述递增运算，使 nums 变为美丽数组：
//选择下标 i = 2 ，并且将 nums[2] 的值加 1 -> [0,1,4,3] 。
//选择下标 i = 2 ，并且将 nums[2] 的值加 1 -> [0,1,5,3] 。
//长度大于或等于 3 的子数组为 [0,1,5]、[1,5,3]、[0,1,5,3] 。
//在所有子数组中，最大元素都等于 k = 5 ，所以 nums 现在是美丽数组。
//可以证明无法用少于 2 次递增运算使 nums 变为美丽数组。 
//因此，答案为 2 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,2], k = 1
//输出：0
//解释：在这个示例中，只有一个长度大于或等于 3 的子数组 [1,1,2] 。
//其最大元素 2 已经大于 k = 1 ，所以无需执行任何增量运算。
//因此，答案为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n == nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁹ 
// 
//
// Related Topics 数组 动态规划 👍 30 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;

/**
 * 2919.使数组变美的最小增量运算数.minimum-increment-operations-to-make-array-beautiful
 *
 * @author db117
 * @since 2023-11-10 17:44:24
 **/

public class Solution_2919 {
    public static void main(String[] args) {
        Solution solution = new Solution_2919().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int k;
        long[][] memo;

        public long minIncrementOperations(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
            int n = nums.length;
            memo = new long[n][4];
            for (long[] longs : memo) {
                Arrays.fill(longs, -1);
            }

            long ans = Long.MAX_VALUE;
            ans = Math.min(ans, dfs(n - 1, 1));
            ans = Math.min(ans, dfs(n - 2, 2));
            ans = Math.min(ans, dfs(n - 3, 3));


            return ans;
        }

        // 当前位置,当前位置最近大于 k 的距离
        private long dfs(int i, int j) {
            if (i < 0) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }

            long ans = Long.MAX_VALUE;

            // 当前位置
            if (nums[i] < k) {
                ans = Math.min(ans, dfs(i - 1, 1) + k - nums[i]);
            } else {
                ans = Math.min(ans, dfs(i - 1, 1));
            }


            if (j == 2) {
                // 加在当前位置或者下一个位置
                ans = Math.min(ans, dfs(i - 1, 3));
            }

            if (j == 1) {
                // 加在当前位置或者下一个位置或下下个位置
                ans = Math.min(ans, dfs(i - 1, 2));
                ans = Math.min(ans, dfs(i - 2, 3));
            }


            return memo[i][j] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
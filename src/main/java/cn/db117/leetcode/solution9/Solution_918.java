

//给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。 
//
// 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个
//元素是 nums[(i - 1 + n) % n] 。 
//
// 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不
//存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
// Related Topics 队列 数组 分治 动态规划 单调队列 👍 316 👎 0


package cn.db117.leetcode.solution9;

/**
 * 918.环形子数组的最大和.maximum-sum-circular-subarray
 *
 * @author db117
 * @since 2022-03-03 16:04:38
 **/

public class Solution_918 {
    public static void main(String[] args) {
        Solution solution = new Solution_918().new Solution();
        // 3
        System.out.println(solution.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int maxSum = nums[0], minSum = nums[0];
            // 当前最大最小值
            int sum = 0, curMax = 0, curMin = 0;
            // 当结果为跨边界时,说明存在一段和为负的区间
            // 跨边界的数组的最大和 = 数组的和 - 非区间的最小和(为负数)

            for (int num : nums) {
                sum += num;
                // 53.最大子数组和.maximum-subarray
                curMax = Math.max(num, curMax + num);
                curMin = Math.min(num, curMin + num);
                maxSum = Math.max(curMax, maxSum);
                minSum = Math.min(curMin, minSum);
            }

            if (maxSum <= 0) {
                // 当所有值都为负数时
                return maxSum;
            }
            return Math.max(sum - minSum, maxSum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
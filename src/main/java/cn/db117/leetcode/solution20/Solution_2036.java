

//子数组是以0下标开始的数组的连续非空子序列，从 i 到 j（0 <= i <= j < nums.length）的 子数组交替和 被定义为 nums[i] 
//- nums[i+1] + nums[i+2] - ... +/- nums[j] 。 
//
// 给定一个以0下标开始的整数数组nums，返回它所有可能的交替子数组和的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,-1,1,2]
//输出：5
//解释：
//子数组 [3,-1,1]有最大的交替子数组和3 - (-1) + 1 = 5.
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2]
//输出：2
//解释：
//子数组 [2], [2,2,2]和 [2,2,2,2,2]有相同的最大交替子数组和为2
//[2]: 2.
//[2,2,2]: 2 - 2 + 2 = 2.
//[2,2,2,2,2]: 2 - 2 + 2 - 2 + 2 = 2.
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
//解释：
//仅有一个非空子数组，为 [1]，它的交替子数组和为 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 4 👎 0


package cn.db117.leetcode.solution20;

/**
 * 2036.最大交替子数组和.maximum-alternating-subarray-sum
 *
 * @author db117
 * @since 2022-12-20 10:44:58
 **/

public class Solution_2036 {
    public static void main(String[] args) {
        Solution solution = new Solution_2036().new Solution();
        System.out.println(solution.maximumAlternatingSubarraySum(new int[]{5, 100}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumAlternatingSubarraySum(int[] nums) {
            // 以 i 结尾
            // [0] 正的结尾
            // [1] 负的结尾
            long[][] dp = new long[nums.length + 7][2];
            long ans = nums[0];

            dp[0][0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 数组第一个必须为正
                dp[i][0] = Math.max(nums[i], dp[i - 1][1] + nums[i]);
                // 当前为负,前面必须有值
                dp[i][1] = dp[i - 1][0] - nums[i];

                ans = Math.max(dp[i][0], ans);
                ans = Math.max(dp[i][1], ans);

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
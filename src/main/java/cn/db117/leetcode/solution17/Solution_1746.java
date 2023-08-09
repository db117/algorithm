

//你有一个整数数组 nums。你只能将一个元素 nums[i] 替换为 nums[i] * nums[i]。 
//
// 返回替换后的最大子数组和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,-1,-4,-3]
//输出：17
//解释：你可以把-4替换为16(-4*(-4))，使nums = [2,-1,16,-3]. 现在，最大子数组和为 2 + -1 + 16 = 17. 
//
// 示例 2： 
//
// 
//输入：nums = [1,-1,1,1,-1,-1,1]
//输出：4
//解释：你可以把第一个-1替换为1，使 nums = [1,1,1,1,-1,-1,1]. 现在，最大子数组和为 1 + 1 + 1 + 1 = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 27 👎 0


package cn.db117.leetcode.solution17;

/**
 * 1746.经过一次操作后的最大子数组和.maximum-subarray-sum-after-one-operation
 *
 * @author db117
 * @since 2023-08-09 17:32:38
 **/

public class Solution_1746 {
    public static void main(String[] args) {
        Solution solution = new Solution_1746().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumAfterOperation(int[] nums) {
            int n = nums.length;
            int before = nums[0];// 没有操作的最大值
            int after = nums[0] * nums[0];// 有操作的最大值
            int ans = Math.max(before, after);

            for (int i = 1; i < n; i++) {
                before = Math.max(before, 0);// 前面的和小于0则不要
                after = Math.max(after + nums[i], before + nums[i] * nums[i]);// 两种情况,选择最大的
                before += nums[i];
                ans = Math.max(ans, after);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
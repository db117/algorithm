

//给你一个下标从 0 开始的整数数组 nums ，请你找出一个下标从 0 开始的整数数组 answer ，其中： 
//
// 
// answer.length == nums.length 
// answer[i] = |leftSum[i] - rightSum[i]| 
// 
//
// 其中： 
//
// 
// leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。 
// rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。 
// 
//
// 返回数组 answer 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [10,4,8,3]
//输出：[15,1,11,22]
//解释：数组 leftSum 为 [0,10,14,22] 且数组 rightSum 为 [15,11,3,0] 。
//数组 answer 为 [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22] 。
// 
//
// 示例 2： 
//
// 输入：nums = [1]
//输出：[0]
//解释：数组 leftSum 为 [0] 且数组 rightSum 为 [0] 。
//数组 answer 为 [|0 - 0|] = [0] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 👍 6 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2574.左右元素和的差值.left-and-right-sum-differences
 *
 * @author db117
 * @since 2023-02-27 10:36:29
 **/

public class Solution_2574 {
    public static void main(String[] args) {
        Solution solution = new Solution_2574().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] leftRigthDifference(int[] nums) {
            int[] leftSum = new int[nums.length + 1];
            int[] rightSum = new int[nums.length + 1];
            // 前缀和 后缀和
            for (int i = 0; i < nums.length; i++) {
                leftSum[i + 1] = leftSum[i] + nums[i];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                rightSum[i] = rightSum[i + 1] + nums[i];
            }

            int[] ans = new int[nums.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = Math.abs(leftSum[i] - rightSum[i + 1]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
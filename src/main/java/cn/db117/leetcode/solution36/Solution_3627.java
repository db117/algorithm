

//给你一个整数数组 nums，其长度可以被 3 整除。 
//
// 你需要通过多次操作将数组清空。在每一步操作中，你可以从数组中选择任意三个元素，计算它们的 中位数 ，并将这三个元素从数组中移除。 
//
// 奇数长度数组的 中位数 定义为数组按非递减顺序排序后位于中间的元素。 
//
// 返回通过所有操作得到的 中位数之和的最大值 。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [2,1,3,2,1,3] 
// 
//
// 输出： 5 
//
// 解释： 
//
// 
// 第一步，选择下标为 2、4 和 5 的元素，它们的中位数是 3。移除这些元素后，nums 变为 [2, 1, 2]。 
// 第二步，选择下标为 0、1 和 2 的元素，它们的中位数是 2。移除这些元素后，nums 变为空数组。 
// 
//
// 因此，中位数之和为 3 + 2 = 5。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,1,10,10,10,10] 
// 
//
// 输出： 20 
//
// 解释： 
//
// 
// 第一步，选择下标为 0、2 和 3 的元素，它们的中位数是 10。移除这些元素后，nums 变为 [1, 10, 10]。 
// 第二步，选择下标为 0、1 和 2 的元素，它们的中位数是 10。移除这些元素后，nums 变为空数组。 
// 
//
// 因此，中位数之和为 10 + 10 = 20。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// nums.length % 3 == 0 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution36;

import java.util.Arrays;

/**
 * 3627.中位数之和的最大值.maximum-median-sum-of-subsequences-of-size-3
 *
 * @author db117
 * @since 2025-08-11 17:45:34
 **/

public class Solution_3627 {
    public static void main(String[] args) {
        Solution solution = new Solution_3627().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumMedianSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            long ans = 0;
            int k = n / 3;
            // 两个两个一组，取小的
            for (int i = n - 1; i >= 0; i = i - 2) {
                ans += nums[i - 1];
                k--;
                if (k == 0) {
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
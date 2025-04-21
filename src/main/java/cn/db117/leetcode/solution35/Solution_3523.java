

//给你一个整数数组 nums。在一次操作中，你可以选择一个子数组，并将其替换为一个等于该子数组 最大值 的单个元素。 
//
// 返回经过零次或多次操作后，数组仍为 非递减 的情况下，数组 可能的最大长度。 
//
// 子数组 是数组中一个连续、非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [4,2,5,3,5] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 实现最大长度的一种方法是： 
//
// 
// 将子数组 nums[1..2] = [2, 5] 替换为 5 → [4, 5, 3, 5]。 
// 将子数组 nums[2..3] = [3, 5] 替换为 5 → [4, 5, 5]。 
// 
//
// 最终数组 [4, 5, 5] 是非递减的，长度为 3。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,3] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 无需任何操作，因为数组 [1,2,3] 已经是非递减的。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 1 <= nums[i] <= 2 * 10⁵ 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution35;

/**
 * 3523.非递减数组的最大长度.make-array-non-decreasing
 *
 * @author db117
 * @since 2025-04-21 10:22:07
 **/

public class Solution_3523 {
    public static void main(String[] args) {
        Solution solution = new Solution_3523().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumPossibleSize(int[] nums) {
            // 把比前面小的数字都过滤掉，剩下的数字都是非递减的
            int n = nums.length;
            int pre = nums[0];
            int ans = 0;
            for (int num : nums) {
                if (num >= pre) {
                    ans++;
                    pre = num;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
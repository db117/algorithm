

//给你一个长度为 n 的整数数组 nums 。 
//
// 考虑 nums 中进行 按位与（bitwise AND）运算得到的值 最大 的 非空 子数组。 
//
// 
// 换句话说，令 k 是 nums 任意 子数组执行按位与运算所能得到的最大值。那么，只需要考虑那些执行一次按位与运算后等于 k 的子数组。 
// 
//
// 返回满足要求的 最长 子数组的长度。 
//
// 数组的按位与就是对数组中的所有数字进行按位与运算。 
//
// 子数组 是数组中的一个连续元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,3,2,2]
//输出：2
//解释：
//子数组按位与运算的最大值是 3 。
//能得到此结果的最长子数组是 [3,3]，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：1
//解释：
//子数组按位与运算的最大值是 4 。 
//能得到此结果的最长子数组是 [4]，所以返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 位运算 脑筋急转弯 数组 👍 7 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2419.按位与最大的最长子数组.longest-subarray-with-maximum-bitwise-and
 *
 * @author db117
 * @since 2022-09-27 17:31:28
 **/

public class Solution_2419 {
    public static void main(String[] args) {
        Solution solution = new Solution_2419().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            // 脑筋急转弯

            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            int ans = 1;

            int left = 0, right = 0;
            while (right < nums.length && left < nums.length) {
                while (left < nums.length && nums[left] != max) {
                    left++;
                }
                right = left;
                while (right < nums.length && nums[right] == max) {
                    right++;
                }
                ans = Math.max(ans, right - left);
                left = right;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
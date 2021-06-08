// 给定一个正整数数组 nums。
//
// 找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 说明: 
//
// 
// 0 < nums.length <= 50000 
// 0 < nums[i] < 1000 
// 0 <= k < 10^6 
// 
// Related Topics 数组 双指针 
// 👍 251 👎 0


package cn.db117.leetcode.solution7;

/**
 * 713.乘积小于K的子数组.subarray-product-less-than-k
 *
 * @author db117
 * @since 2021-06-08 15:35:01
 **/

public class Solution_713 {
    public static void main(String[] args) {
        Solution solution = new Solution_713().new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{
                10, 5, 2, 6
        }, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k < 2) {
                return 0;
            }
            long sum = 1;
            int left = 0, ans = 0;

            for (int right = 0; right < nums.length; right++) {
                // 固定右边界,寻找最小的左边界
                sum *= nums[right];

                // 最小右边界
                while (sum >= k) {
                    // left 最大为 right+1
                    sum /= nums[left];
                    left++;
                }

                // 1 ->   1
                // 12,2 -> 12,2
                // 1,2,3 -> 123,23,3
                ans += right - left + 1;

            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
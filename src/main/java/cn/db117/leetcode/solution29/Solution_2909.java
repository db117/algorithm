

//给你一个下标从 0 开始的整数数组 nums 。 
//
// 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ： 
//
// 
// i < j < k 
// nums[i] < nums[j] 且 nums[k] < nums[j] 
// 
//
// 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [8,6,1,5,3]
//输出：9
//解释：三元组 (2, 3, 4) 是一个元素和等于 9 的山形三元组，因为： 
//- 2 < 3 < 4
//- nums[2] < nums[3] 且 nums[4] < nums[3]
//这个三元组的元素和等于 nums[2] + nums[3] + nums[4] = 9 。可以证明不存在元素和小于 9 的山形三元组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,4,8,7,10,2]
//输出：13
//解释：三元组 (1, 3, 5) 是一个元素和等于 13 的山形三元组，因为： 
//- 1 < 3 < 5 
//- nums[1] < nums[3] 且 nums[5] < nums[3]
//这个三元组的元素和等于 nums[1] + nums[3] + nums[5] = 13 。可以证明不存在元素和小于 13 的山形三元组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [6,5,4,3,4,5]
//输出：-1
//解释：可以证明 nums 中不存在山形三元组。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁸ 
// 
//
// Related Topics 数组 👍 12 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2909.元素和最小的山形三元组 II.minimum-sum-of-mountain-triplets-ii
 *
 * @author db117
 * @since 2023-11-08 14:23:21
 **/

public class Solution_2909 {
    public static void main(String[] args) {
        Solution solution = new Solution_2909().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSum(int[] nums) {
            int n = nums.length;

            int[] left = new int[n];
            int[] right = new int[n];

            // 找到左边最小的和右边最小的
            int min = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                if (num > min) {
                    left[i] = min;
                } else {
                    left[i] = -1;
                }
                min = Math.min(min, num);
            }


            min = nums[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                int num = nums[i];

                if (num > min) {
                    right[i] = min;
                } else {
                    right[i] = -1;
                }
                min = Math.min(min, num);
            }


            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (left[i] != -1 && right[i] != -1) {
                    // 找到左右都有的
                    ans = Math.min(ans, left[i] + num + right[i]);
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
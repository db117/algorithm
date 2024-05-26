

//给定一个长度为 n 的整数数组和一个目标值 target ，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的
//三元组 i, j, k 个数（0 <= i < j < k < n）。 
//
// 
//
// 示例 1： 
//
// 
//输入: nums = [-2,0,1,3], target = 2
//输出: 2 
//解释: 因为一共有两个三元组满足累加和小于 2:
//     [-2,0,1]
//     [-2,0,3]
// 
//
// 示例 2： 
//
// 
//输入: nums = [], target = 0
//输出: 0 
//
// 示例 3： 
//
// 
//输入: nums = [0], target = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// n == nums.length 
// 0 <= n <= 3500 
// -100 <= nums[i] <= 100 
// -100 <= target <= 100 
// 
//
// Related Topics 数组 双指针 二分查找 排序 👍 148 👎 0


package cn.db117.leetcode.solution2;

import java.util.Arrays;

/**
 * 259.较小的三数之和.3sum-smaller
 *
 * @author db117
 * @since 2024-05-22 13:57:21
 **/

public class Solution_259 {
    public static void main(String[] args) {
        Solution solution = new Solution_259().new Solution();
        // [-2,0,1,3]
        //			2
        System.out.println(solution.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            int n = nums.length;
            int ans = 0;
            // 排序
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // 找小于等于 target - nums[i] - nums[j] 的最大索引
                    int k = bs(nums, target - nums[i] - nums[j]);
                    if (k <= j) {
                        continue;
                    }
                    // 三数之和小于 target
                    ans += k - j;
                }
            }
            return ans;
        }

        // 找小于 target 的最大索引
        private int bs(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] < target) {
                    // 可能是最大值
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
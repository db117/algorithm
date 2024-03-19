

//给你一个 长度为 n 的整型数组 nums 和一个数值 k ，返回 第 k 小的子数组和。 
//
// 子数组 是指数组中一个 非空 且不间断的子序列。 子数组和 则指子数组中所有元素的和。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,1,3], k = 4
//输出: 3
//解释: [2,1,3] 的子数组为：
//- [2] 和为 2
//- [1] 和为 1
//- [3] 和为 3
//- [2,1] 和为 3
//- [1,3] 和为 4
//- [2,1,3] 和为 6 
//最小子数组和的升序排序为 1, 2, 3, 3, 4, 6。 第 4 小的子数组和为 3 。
// 
//
//示例 2：
//
// 
//输入：nums = [3,3,5,5], k = 7
//输出：10
//解释：[3,3,5,5] 的子数组为：
//- [3] 和为 3
//- [3] 和为 3
//- [5] 和为 5
//- [5] 和为 5
//- [3,3] 和为 6
//- [3,5] 和为 8
//- [5,5] 和为 10
//- [3,3,5], 和为 11
//- [3,5,5] 和为 13
//- [3,3,5,5] 和为 16
//最小子数组和的升序排序为 3, 3, 5, 5, 6, 8, 10, 11, 13, 16。第 7 小的子数组和为 10 。
// 
//
// 
//
// 提示: 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 10⁴ 
// 1 <= nums[i] <= 5 * 10⁴ 
// 1 <= k <= n * (n + 1) / 2 
// 
//
// Related Topics 数组 二分查找 滑动窗口 👍 21 👎 0


package cn.db117.leetcode.solution19;

import java.util.Arrays;

/**
 * 1918.第 K 小的子数组和·.kth-smallest-subarray-sum
 *
 * @author db117
 * @since 2024-03-19 21:39:09
 **/

public class Solution_1918 {
    public static void main(String[] args) {
        Solution solution = new Solution_1918().new Solution();
        // [2,1,3]
        //			4
        System.out.println(solution.kthSmallestSubarraySum(new int[]{
                2, 1, 3
        }, 4));

        // [3,3,5,5]
        //			7
//        System.out.println(solution.kthSmallestSubarraySum(new int[]{
//                3, 3, 5, 5
//        }, 7));

        // [1,3,2]
        //			6
        // 6
//        System.out.println(solution.kthSmallestSubarraySum(new int[]{
//                1, 3, 2
//        }, 6));

        // [2,9,2,10,7]
        //			1
        // 2
        System.out.println(solution.kthSmallestSubarraySum(new int[]{
                2, 9, 2, 10, 7
        }, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallestSubarraySum(int[] nums, int k) {
            int left = 0, right = Arrays.stream(nums).sum() + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int check = check(nums, mid);
                if (check < k) {
                    left = mid + 1;
                } else {
                    // 不能是 mid-1,因为 mid 可能是结果
                    right = mid;
                }
            }
            return right;
        }

        private int check(int[] nums, int mid) {
            // 滑动窗口,求和
            int left = 0, sum = 0, res = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum > mid) {
                    sum -= nums[left];
                    left++;
                }
                res += right - left + 1;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
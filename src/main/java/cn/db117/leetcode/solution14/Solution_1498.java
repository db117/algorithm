//给你一个整数数组 nums 和一个整数 target 。
//
// 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。 
//
// 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,5,6,7], target = 9
//输出：4
//解释：有 4 个子序列满足该条件。
//[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
// 
//
// 示例 2： 
//
// 输入：nums = [3,3,6,8], target = 10
//输出：6
//解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6] 
//
// 示例 3： 
//
// 输入：nums = [2,3,3,4,6,7], target = 12
//输出：61
//解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
//有效序列总数为（63 - 2 = 61）
// 
//
// 示例 4： 
//
// 输入：nums = [5,2,4,1,7,6,8], target = 16
//输出：127
//解释：所有非空子序列都满足条件 (2^7 - 1) = 127 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 1 <= target <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 61 👎 0


package cn.db117.leetcode.solution14;

import java.util.Arrays;

/**
 * 1498.满足条件的子序列数目.number-of-subsequences-that-satisfy-the-given-sum-condition
 *
 * @author db117
 * @since 2021-07-19 11:40:10
 **/

public class Solution_1498 {
    public static void main(String[] args) {
        Solution solution = new Solution_1498().new Solution();
        System.out.println(solution.numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(solution.numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(solution.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
        System.out.println(solution.numSubseq(new int[]{5, 2, 4, 1, 7, 6, 8}, 16));
        System.out.println(solution.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14,
                11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
        // 272187084
        System.out.println(solution.numSubseq(new int[]{6, 10, 12, 3, 29, 21, 12, 25, 17, 19, 16, 1, 2, 24, 9, 17, 25,
                22, 12, 22, 26, 24, 24, 11, 3, 7, 24, 5, 15, 30, 23, 5, 20, 10, 19, 20, 9, 27, 11, 4, 23, 4, 4, 12, 22,
                27, 16, 11, 26, 10, 23, 26, 16, 21, 24, 21, 17, 13, 21, 9, 16, 17, 27}, 26));// 963594139
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubseq(int[] nums, int target) {
            int mod = 1_000_000_007;

            // 提前计算 2 的 n 次方，防止溢出
            long[] tmp = new long[nums.length];
            tmp[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                tmp[i] = (tmp[i - 1] << 1) % mod;
            }
            Arrays.sort(nums);

            long ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] * 2 > target) {
                    break;
                }
                // 找到肯的最大值
                int bs = bs(nums, target - nums[i]);
                // 区间类有 2 pow N 种可能
                ans += tmp[bs - i] % 1_000_000_007;
            }
            return (int) (ans % 1_000_000_007);
        }

        private int bs(int[] arr, int target) {
            int left = 0, right = arr.length - 1;

            while (left < right) {
                // 找小于等于，取右区间
                int mid = left + (right - left + 1) / 2;

                if (arr[mid] <= target) {
                    left = mid;
                } else {
                    // 取的右边，移动右边界
                    right = mid - 1;
                }
            }

            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
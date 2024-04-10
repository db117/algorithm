

//给你一个整数数组 nums 和一个 非负 整数 k 。一次操作中，你可以选择任一元素 加 1 或者减 1 。 
//
// 请你返回将 nums 中位数 变为 k 所需要的 最少 操作次数。 
//
// 一个数组的中位数指的是数组按非递减顺序排序后最中间的元素。如果数组长度为偶数，我们选择中间两个数的较大值为中位数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,5,6,8,5], k = 4 
// 
//
// 输出：2 
//
// 解释：我们将 nums[1] 和 nums[4] 减 1 得到 [2, 4, 6, 8, 4] 。现在数组的中位数等于 k 。 
//
// 示例 2： 
//
// 
// 输入：nums = [2,5,6,8,5], k = 7 
// 
//
// 输出：3 
//
// 解释：我们将 nums[1] 增加 1 两次，并且将 nums[2] 增加 1 一次，得到 [2, 7, 7, 8, 5] 。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,2,3,4,5,6], k = 4 
// 
//
// 输出：0 
//
// 解释：数组中位数已经等于 k 了。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 贪心 数组 排序 👍 4 👎 0


package cn.db117.leetcode.solution31;

import java.util.Arrays;

/**
 * 3107.使数组中位数等于 K 的最少操作数.minimum-operations-to-make-median-of-array-equal-to-k
 *
 * @author db117
 * @since 2024-04-10 16:30:55
 **/

public class Solution_3107 {
    public static void main(String[] args) {
        Solution solution = new Solution_3107().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minOperationsToMakeMedianK(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            // 中位数
            int mid = n / 2;
            if (nums[mid] == k) {
                return 0;
            }

            long ans = 0;
            if (nums[mid] < k) {
                // 把从中位数的右边的数变成 k
                for (int i = mid; i < n; i++) {
                    if (nums[i] < k) {
                        ans += k - nums[i];
                    } else {
                        break;
                    }
                }
            } else {
                // 把从中位数的左边的数变成 k
                for (int i = mid; i >= 0; i--) {
                    if (nums[i] > k) {
                        ans += nums[i] - k;
                    } else {
                        break;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
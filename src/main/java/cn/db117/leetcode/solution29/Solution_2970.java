

//给你一个下标从 0 开始的 正 整数数组 nums 。 
//
// 如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。比方说，[5, 3, 4, 6, 7] 
//中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。 
//
// 请你返回 nums 中 移除递增 子数组的总数目。 
//
// 注意 ，剩余元素为空的数组也视为是递增的。 
//
// 子数组 指的是一个数组中一段连续的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：10
//解释：10 个移除递增子数组分别为：[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] 和 
//[1,2,3,4]。移除任意一个子数组后，剩余元素都是递增的。注意，空数组不是移除递增子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [6,5,7,8]
//输出：7
//解释：7 个移除递增子数组分别为：[5], [6], [5,7], [6,5], [5,7,8], [6,5,7] 和 [6,5,7,8] 。
//nums 中只有这 7 个移除递增子数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [8,7,6,6]
//输出：3
//解释：3 个移除递增子数组分别为：[8,7,6], [7,6,6] 和 [8,7,6,6] 。注意 [8,7] 不是移除递增子数组因为移除 [8,7] 后 
//nums 变为 [6,6] ，它不是严格递增的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 1 <= nums[i] <= 50 
// 
//
// Related Topics 数组 双指针 二分查找 枚举 👍 5 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2970.统计移除递增子数组的数目 I.count-the-number-of-incremovable-subarrays-i
 *
 * @author db117
 * @since 2024-04-16 11:44:51
 **/

public class Solution_2970 {
    public static void main(String[] args) {
        Solution solution = new Solution_2970().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int incremovableSubarrayCount(int[] nums) {
            int n = nums.length;

            // 找左边递增的最后一个位置
            int leftEnd = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] <= nums[i - 1]) {
                    break;
                }
                leftEnd = i;
            }
            // 特判全是递增
            if (leftEnd == n - 1) {
                return n * (n + 1) / 2;// 等差数列求和 1+2+3+...+n=n*(n+1)/2
            }
            // 可以移除的子数组个数 = [[0-leftEnd+1],n]
            int ans = leftEnd + 2;
            // 从右边往左边找
            for (int i = n - 1; i >= 0; i--) {
                if (i != n - 1 && nums[i] >= nums[i + 1]) {
                    break;
                }
                // 保证移除中间的后数组是有序的
                while (leftEnd >= 0 && nums[leftEnd] >= nums[i]) {
                    leftEnd--;
                }
                // 可以移除的子数组个数 = [[0-leftEnd+1],j]
                ans += leftEnd + 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
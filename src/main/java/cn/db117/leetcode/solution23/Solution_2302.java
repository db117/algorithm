

//一个数组的 分数 定义为数组之和 乘以 数组的长度。 
//
// 
// 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。 
// 
//
// 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。 
//
// 子数组 是数组中的一个连续元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3,5], k = 10
//输出：6
//解释：
//有 6 个子数组的分数小于 10 ：
//- [2] 分数为 2 * 1 = 2 。
//- [1] 分数为 1 * 1 = 1 。
//- [4] 分数为 4 * 1 = 4 。
//- [3] 分数为 3 * 1 = 3 。 
//- [5] 分数为 5 * 1 = 5 。
//- [2,1] 分数为 (2 + 1) * 2 = 6 。
//注意，子数组 [1,4] 和 [4,3,5] 不符合要求，因为它们的分数分别为 10 和 36，但我们要求子数组的分数严格小于 10 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1], k = 5
//输出：5
//解释：
//除了 [1,1,1] 以外每个子数组分数都小于 5 。
//[1,1,1] 分数为 (1 + 1 + 1) * 3 = 9 ，大于 5 。
//所以总共有 5 个子数组得分小于 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 1 <= k <= 10¹⁵ 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 69 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2302.统计得分小于 K 的子数组数目.count-subarrays-with-score-less-than-k
 *
 * @author db117
 * @since 2025-04-28 10:26:37
 **/

public class Solution_2302 {
    public static void main(String[] args) {
        Solution solution = new Solution_2302().new Solution();
        // [2,1,4,3,5]
        //			10
        System.out.println(solution.countSubarrays(new int[]{2, 1, 4, 3, 5}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countSubarrays(int[] nums, long k) {
            int n = nums.length;
            // 滑动窗口
            long count = 0;
            int left = 0;
            long sum = 0;
            // 枚举右边界
            for (int right = 0; right < n; right++) {
                sum += nums[right];
                while (sum * (right - left + 1) >= k) {
                    // 滑动左边界
                    sum -= nums[left];
                    left++;
                }
                // 固定右边界，左边满足的数量
                count += right - left + 1;
            }


            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
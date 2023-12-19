

//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 你可以对数组执行 至多 k 次操作： 
//
// 
// 从数组中选择一个下标 i ，将 nums[i] 增加 或者 减少 1 。 
// 
//
// 最终数组的频率分数定义为数组中众数的 频率 。 
//
// 请你返回你可以得到的 最大 频率分数。 
//
// 众数指的是数组中出现次数最多的数。一个元素的频率指的是数组中这个元素的出现次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,6,4], k = 3
//输出：3
//解释：我们可以对数组执行以下操作：
//- 选择 i = 0 ，将 nums[0] 增加 1 。得到数组 [2,2,6,4] 。
//- 选择 i = 3 ，将 nums[3] 减少 1 ，得到数组 [2,2,6,3] 。
//- 选择 i = 3 ，将 nums[3] 减少 1 ，得到数组 [2,2,6,2] 。
//元素 2 是最终数组中的众数，出现了 3 次，所以频率分数为 3 。
//3 是所有可行方案里的最大频率分数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,4,4,2,4], k = 0
//输出：3
//解释：我们无法执行任何操作，所以得到的频率分数是原数组中众数的频率 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 0 <= k <= 10¹⁴ 
// 
//
// 👍 9 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;

/**
 * 2968.执行操作使频率分数最大.apply-operations-to-maximize-frequency-score
 *
 * @author db117
 * @since 2023-12-18 11:28:24
 **/

public class Solution_2968 {
    public static void main(String[] args) {
        Solution solution = new Solution_2968().new Solution();

        // [1,4,4,2,4]
        //			0
        System.out.println(solution.maxFrequencyScore(new int[]{
                1, 4, 4, 2, 4
        }, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxFrequencyScore(int[] nums, long k) {
            Arrays.sort(nums);
            int n = nums.length;
            int ans = 0;
            // 前缀和
            long[] pre = new long[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + nums[i];
            }
            // 相当于在一个窗口中,把窗口内的数都变成窗口内的中位数
            int left = 0;
            for (int right = 0; right < n; right++) {
                while (left < right && helper(pre, nums, left, right) > k) {
                    // 前面排完序后,中位数就是窗口内的中间数
                    // 当窗口内的数都变成中位数时,需要的代价大于 k 时就需要缩小区间了
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        public long helper(long[] pre, int[] nums, int l, int r) {
            // O(1) 时间算出窗口内的数变成中位数的代价
            // 中位数
            int mid = (l + r) / 2;
            long left = (long) nums[mid] * (mid - l) - (pre[mid] - pre[l]);
            long right = (pre[r + 1] - pre[mid + 1]) - (long) nums[mid] * (r - mid);
            return left + right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
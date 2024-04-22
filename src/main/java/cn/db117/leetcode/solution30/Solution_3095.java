

//给你一个 非负 整数数组 nums 和一个整数 k 。 
//
// 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。 
//
// 请你返回 nums 中 最短特别非空 子数组的长度，如果特别子数组不存在，那么返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3], k = 2 
// 
//
// 输出：1 
//
// 解释： 
//
// 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。 
//
// 示例 2： 
//
// 
// 输入：nums = [2,1,8], k = 10 
// 
//
// 输出：3 
//
// 解释： 
//
// 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,2], k = 0 
// 
//
// 输出：1 
//
// 解释： 
//
// 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 0 <= nums[i] <= 50 
// 0 <= k < 64 
// 
//
// Related Topics 位运算 数组 滑动窗口 👍 3 👎 0


package cn.db117.leetcode.solution30;

/**
 * 3095.或值至少 K 的最短子数组 I.shortest-subarray-with-or-at-least-k-i
 *
 * @author db117
 * @since 2024-04-22 15:06:32
 **/

public class Solution_3095 {
    public static void main(String[] args) {
        Solution solution = new Solution_3095().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int n = nums.length;
            // 双指针
            int left = 0, right = 0;
            int or = 0;
            // 统计每个bit的数量
            int[] count = new int[32];
            int ans = Integer.MAX_VALUE;

            while (right < n) {
                or |= nums[right];
                add(count, nums[right]);
                right++;

                // 找到最小的
                while (or >= k && left < right) {
                    ans = Math.min(ans, right - left);
                    remove(count, nums[left]);
                    for (int i = 0; i < 32; i++) {
                        if (count[i] == 0) {
                            // 没有这个bit了
                            or &= ~(1 << i);
                        }
                    }
                    left++;
                }
            }

            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        private void add(int[] count, int num) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }

        private void remove(int[] count, int num) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
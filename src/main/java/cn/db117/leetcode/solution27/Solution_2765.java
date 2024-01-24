

//给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ： 
//
// 
// m 大于 1 。 
// s1 = s0 + 1 。 
// 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - 
//s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)ᵐ 。 
// 
//
// 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。 
//
// 子数组是一个数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,3,4]
//输出：4
//解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6]
//输出：2
//解释：[4,5] 和 [5,6] 是仅有的两个交替子数组。它们长度都为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 枚举 👍 28 👎 0


package cn.db117.leetcode.solution27;

/**
 * 2765.最长交替子数组.longest-alternating-subarray
 *
 * @author db117
 * @since 2024-01-23 10:35:08
 **/

public class Solution_2765 {
    public static void main(String[] args) {
        Solution solution = new Solution_2765().new Solution();
        // [42,43,44,43,44,43,44,45,46]
        System.out.println(solution.alternatingSubarray(new int[]{
                42, 43, 44, 43, 44, 43, 44, 45, 46
        }));

        // [14,30,29,49,3,23,44,21,26,52]
        System.out.println(solution.alternatingSubarray(new int[]{
                14, 30, 29, 49, 3, 23, 44, 21, 26, 52
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int alternatingSubarray(int[] nums) {
            // 分组循环
            int n = nums.length;
            int ans = -1;
            int i = 0;
            while (i < n - 1) {
                int start = i;
                if (nums[i + 1] != nums[i] + 1) {
                    // 跳过
                    i++;
                    continue;
                }

                // 前 2 个已经符合
                i += 2;
                // 找到符合条件的
                while (i < n && nums[i] == nums[i - 2]) {
                    i++;
                }
                // 计算长度
                ans = Math.max(ans, i - start);
                i--;
            }
            return ans;
        }
    }

    // dp
    class Solution1 {
        public int alternatingSubarray(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n + 1][2];

            int ans = -1;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i - 1] == 1) {
                    // 递增
                    dp[i][0] = dp[i - 1][1] + 1;
                    ans = Math.max(ans, dp[i][0]);
                } else if (nums[i] - nums[i - 1] == -1) {
                    // 递减
                    if (dp[i - 1][0] > 0) {// 第一个只能是 递增
                        dp[i][1] = dp[i - 1][0] + 1;
                        ans = Math.max(ans, dp[i][1]);
                    }
                }
            }
            return ans == -1 ? -1 : ans + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
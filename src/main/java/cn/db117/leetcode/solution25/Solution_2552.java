

//给你一个长度为 n 下标从 0 开始的整数数组 nums ，它包含 1 到 n 的所有数字，请你返回上升四元组的数目。 
//
// 如果一个四元组 (i, j, k, l) 满足以下条件，我们称它是上升的： 
//
// 
// 0 <= i < j < k < l < n 且 
// nums[i] < nums[k] < nums[j] < nums[l] 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,2,4,5]
//输出：2
//解释：
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 3 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 4 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//没有其他的四元组，所以我们返回 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4]
//输出：0
//解释：只存在一个四元组 i = 0 ，j = 1 ，k = 2 ，l = 3 ，但是 nums[j] < nums[k] ，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 4 <= nums.length <= 4000 
// 1 <= nums[i] <= nums.length 
// nums 中所有数字 互不相同 ，nums 是一个排列。 
// 
//
// Related Topics 树状数组 数组 动态规划 枚举 前缀和 👍 69 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2552.统计上升四元组.count-increasing-quadruplets
 *
 * @author db117
 * @since 2024-09-10 11:02:02
 **/

public class Solution_2552 {
    public static void main(String[] args) {
        Solution solution = new Solution_2552().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countQuadruplets(int[] nums) {
            int n = nums.length;
            // 在 k 的右边比 x 大的个数
            int[][] greater = new int[n][n + 1];
            for (int k = n - 2; k >= 2; k--) {
                greater[k] = greater[k + 1].clone();
                for (int x = 1; x < nums[k + 1]; x++) {
                    greater[k][x]++;
                }
            }
            long ans = 0;
            // 在 j 的左边比 x 小的个数（j在循环里面就不用二维数组了）
            int[] less = new int[n + 1];
            for (int j = 1; j < n - 1; j++) {
                for (int x = nums[j - 1] + 1; x <= n; x++) {
                    // 凡是比前一个数字大的 x ，比 x 小的数量都 +1
                    less[x]++;
                }

                // 统计
                for (int k = j + 1; k < n - 1; k++) {
                    if (nums[k] < nums[j]) {
                        // j左边比nums[k] 小的数量  * k 的右边比 nums[j] 大的个数
                        ans += (long) less[nums[k]] * greater[k][nums[j]];
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
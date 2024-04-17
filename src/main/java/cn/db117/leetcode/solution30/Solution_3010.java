

//给你一个长度为 n 的整数数组 nums 。 
//
// 一个数组的 代价 是它的 第一个 元素。比方说，[1,2,3] 的代价是 1 ，[3,4,1] 的代价是 3 。 
//
// 你需要将 nums 分成 3 个 连续且没有交集 的子数组。 
//
// 请你返回这些子数组的 最小 代价 总和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,12]
//输出：6
//解释：最佳分割成 3 个子数组的方案是：[1] ，[2] 和 [3,12] ，总代价为 1 + 2 + 3 = 6 。
//其他得到 3 个子数组的方案是：
//- [1] ，[2,3] 和 [12] ，总代价是 1 + 2 + 12 = 15 。
//- [1,2] ，[3] 和 [12] ，总代价是 1 + 3 + 12 = 16 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,4,3]
//输出：12
//解释：最佳分割成 3 个子数组的方案是：[5] ，[4] 和 [3] ，总代价为 5 + 4 + 3 = 12 。
//12 是所有分割方案里的最小总代价。
// 
//
// 示例 3： 
//
// 
//输入：nums = [10,3,1,1]
//输出：12
//解释：最佳分割成 3 个子数组的方案是：[10,3] ，[1] 和 [1] ，总代价为 10 + 1 + 1 = 12 。
//12 是所有分割方案里的最小总代价。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 50 
// 1 <= nums[i] <= 50 
// 
//
// Related Topics 数组 枚举 排序 👍 3 👎 0


package cn.db117.leetcode.solution30;

/**
 * 3010.将数组分成最小总代价的子数组 I.divide-an-array-into-subarrays-with-minimum-cost-i
 *
 * @author db117
 * @since 2024-04-17 14:13:07
 **/

public class Solution_3010 {
    public static void main(String[] args) {
        Solution solution = new Solution_3010().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumCost(int[] nums) {
            // 找到处第一个数字外，最小的 2 个数字
            int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < one) {
                    two = one;
                    one = nums[i];
                } else if (nums[i] < two) {
                    two = nums[i];
                }
            }
            return nums[0] + one + two;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}